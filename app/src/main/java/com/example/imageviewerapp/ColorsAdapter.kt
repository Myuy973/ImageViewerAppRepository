package com.example.imageviewerapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ColorsAdapter(
    private val context: Context,
    private val colors: Array<Int>,
    private val colorsName: Array<String>
): BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (view == null) {
            view = layoutInflater!!.inflate(R.layout.grid_item_layout, null)
        }

        imageView = view!!.findViewById(R.id.detailImage)
        textView = view!!.findViewById(R.id.detailText)
        imageView.setImageResource(colors[position])
        textView.text = colorsName[position]
        return view

    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return colors.size
    }
}