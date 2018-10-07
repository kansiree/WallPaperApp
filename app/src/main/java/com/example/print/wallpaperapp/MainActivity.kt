package com.example.print.wallpaperapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        var mInterstitialAd : InterstitialAd?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var page = findViewById<ViewPager>(R.id.viewPage)
        SetupViewPage(page)
        TabLayout.setupWithViewPager(page)
        MobileAds.initialize(this,"ca-app-pub-8549639420372799/7602891881")
        val adRequest: AdRequest? = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd?.adUnitId = "ca-app-pub-8549639420372799/1967421820"
        mInterstitialAd?.loadAd(AdRequest.Builder().build())
        mInterstitialAd?.show()
    }

    fun SetupViewPage( viewPager: ViewPager){
        val viewPageAdapter =  ViewpagerAdapter(supportFragmentManager)
        viewPageAdapter.addFragment( Cartoon.newInstance("One"),"Cartoon")
        viewPageAdapter.addFragment(GallaryFragment.newInstance(""),"Gallery")
        viewPageAdapter.addFragment(FavoringFragment.newInstance(""),"Favoring")
        viewPager.adapter=viewPageAdapter
    }

    class ViewpagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

         var FragmentList:ArrayList<Fragment>? = ArrayList()
        var TitleList:ArrayList<String>? = ArrayList()

        override fun getItem(position: Int): Fragment? {

            return FragmentList?.get(position)
        }

        override fun getCount(): Int {
            return FragmentList!!.size
        }

        fun addFragment(fragment: Fragment , tile: String){

            FragmentList!!.add(fragment)
            TitleList!!.add(tile)
        }

         override fun getPageTitle(position: Int): CharSequence? {
            return TitleList!!.get(position)
        }
    }
}
