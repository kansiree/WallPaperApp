package com.example.print.wallpaperapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favoring.*

class FavoringFragment : Fragment() {

    companion object {
        fun newInstance(text: String): FavoringFragment {
            val fragment = FavoringFragment()
            val bundle = Bundle()
            bundle.putString("Text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoring, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = GridLayoutManager(context,2)
        like_list.setHasFixedSize(true)
        like_list.layoutManager = layoutManager
        like_list.adapter = ImageAdapter(Photo.getLikePhoto(), this.context!!)

    }


}
