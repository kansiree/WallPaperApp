package com.example.print.wallpaperapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(val picture : Int): Parcelable{
    companion object {
          var listLike : ArrayList<Photo> = ArrayList()

        fun getCarToonPhotos(): ArrayList<Photo>{
            return arrayListOf(Photo(R.drawable.arena),
                    Photo(R.drawable.arduin_2),Photo(R.drawable.ardin),
                    Photo(R.drawable.astrid))
        }
        fun getGalleryPhoto() : ArrayList<Photo>{
            return arrayListOf(Photo(R.drawable.grakk),
                    Photo(R.drawable.joker),Photo(R.drawable.lllumia))
        }
        fun getLikePhoto(): ArrayList<Photo>{
           return listLike
        }
    }
}

