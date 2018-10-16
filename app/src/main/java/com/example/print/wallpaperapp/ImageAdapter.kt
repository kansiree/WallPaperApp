package com.example.print.wallpaperapp

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.squareup.picasso.Picasso
import java.util.*

class ImageAdapter (val items : ArrayList<Photo>, val context: Context) : RecyclerView.Adapter<ImageAdapter.CardViewHolder>()
    {
        var  coutClick:Int=0
        var mInterstitialAd : InterstitialAd?=null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
            val holder = CardViewHolder(LayoutInflater.from(context).inflate(R.layout.card_image,parent,false))
            return holder
        }

        override fun getItemCount(): Int {
        return items.size
        }

        override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
            Picasso.get().load(items[position].picture)
                    .placeholder(R.drawable.ic_launcher_background).fit()
                    .tag(context).into(holder.imageView)

        }

        inner class CardViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
            var  imageView = itemView?.findViewById<ImageView>(R.id.iv_photo)

            init {
                itemView!!.setOnClickListener(this)
            }

            override fun onClick(view: View?) {
                coutClick++
                val position = adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    val Photo = items[position]
                    val intent:Intent = Intent(context,Main2Activity::class.java).apply {
                        putExtra(Main2Activity.EXTRA_PHOTO,Photo)
                    }

                    mInterstitialAd = InterstitialAd(context)
                    mInterstitialAd?.adUnitId = "ca-app-pub-8549639420372799/1967421820"
                    mInterstitialAd?.loadAd(AdRequest.Builder().build())
                    mInterstitialAd?.adListener = object :AdListener(){
                        override fun onAdLoaded() {
                            super.onAdLoaded()
                            if(coutClick==4){
                                coutClick=0
                                mInterstitialAd?.show()
                            }else{
                                context.startActivity(intent)

                            }
                        }

                        override fun onAdClosed() {
                            super.onAdClosed()
                            context.startActivity(intent)

                        }

                    }


                }

            }


    }
}