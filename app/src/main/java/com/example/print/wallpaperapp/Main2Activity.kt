package com.example.print.wallpaperapp

import android.app.AlertDialog
import android.app.WallpaperManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*



class Main2Activity : AppCompatActivity() {
    val PIC_CROP:Int = 1
    private lateinit var photo :Photo
    companion object {
        const val EXTRA_PHOTO = "Main2Activity.EXTRA_PHOTO"
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        photo=intent.getParcelableExtra(Main2Activity.EXTRA_PHOTO)

        FloatingButtonHide()
        fab.setOnClickListener {
            if(set_wallpaper.visibility== View.VISIBLE)
            {
                FloatingButtonHide()
            }
            else if (set_wallpaper.visibility== View.GONE)
            {
                FloatingButtonShow()
            }
        }

        set_wallpaper.setOnClickListener{
            val wallpaperManage : WallpaperManager = WallpaperManager.getInstance(this)

            var builder = AlertDialog.Builder(this@Main2Activity)
            builder.setTitle("")
            builder.setMessage("คุณยืนยันจะใช้รูปนี้เป็นพื้นหลังใช่ไหม ")
            builder.setPositiveButton("ใช่"){_,_ ->
                wallpaperManage.setResource(photo.picture)
                Toast.makeText(this,"Set Success ", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("ไม่"){_,_ ->
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()

        }

        like_image.setOnClickListener{

            if(containImage(Photo.listLike,photo.picture)){
                Toast.makeText(this,"did like image",Toast.LENGTH_LONG).show()
                Photo.listLike.remove(photo)

            }else{
                Toast.makeText(this,"like image",Toast.LENGTH_LONG).show()
                Photo.listLike.add(photo)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Picasso.get().load(photo.picture)
                .placeholder(photo.picture)
                .fit()
                .priority(Picasso.Priority.HIGH)
                .into(show_image)
    }

    fun  FloatingButtonShow(){
        set_wallpaper.show()
        like_image.show()
    }

    fun FloatingButtonHide(){
        set_wallpaper.hide()
        like_image.hide()
    }

    fun containImage (list: ArrayList<Photo>,image : Int): Boolean{
        for (item in list){
            if(item.picture==image){
                println("found ")
                return true
            }
        }
        return false
    }
}
