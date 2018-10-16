package com.example.print.wallpaperapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_cartoon.*


/**
 * A simple [Fragment] subclass.
 *
 */
class Cartoon : Fragment() {

    companion object {
        fun newInstance(text: String): Cartoon {
            val fragment = Cartoon()
            val bundle = Bundle()
            bundle.putString("Text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartoon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = GridLayoutManager(context,2)
        list_cartoon.setHasFixedSize(true)
        list_cartoon.layoutManager = layoutManager
        list_cartoon.adapter = ImageAdapter(Photo.getCarToonPhotos(), this.context!!)

        }
}


