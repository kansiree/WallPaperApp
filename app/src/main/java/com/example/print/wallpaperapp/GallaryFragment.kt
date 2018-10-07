package com.example.print.wallpaperapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gallary.*

/**
 * A simple [Fragment] subclass.
 *
 */
class GallaryFragment : Fragment() {

    companion object {
        fun newInstance(text: String): GallaryFragment {
            val fragment = GallaryFragment()
            val bundle = Bundle()
            bundle.putString("Text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        list_gallery.layoutManager = GridLayoutManager(context,2)
        list_gallery.adapter = ImageAdapter(Photo.getGalleryPhoto(), context!!)
    }


}
