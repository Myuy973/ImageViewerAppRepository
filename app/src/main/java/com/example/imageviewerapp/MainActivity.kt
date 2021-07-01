package com.example.imageviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    lateinit var colorsAdapter: ColorsAdapter
    private val colors: Array<Int> = arrayOf(
        R.color.black,
        R.color.purple_200,
        R.color.purple_500,
        R.color.purple_700,
        R.color.teal_200,
        R.color.teal_700
    )
    private val colorsName: Array<String> = arrayOf(
        "black",
        "purple_200",
        "purple_500",
        "purple_700",
        "teal_200",
        "teal_700"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorsAdapter = ColorsAdapter(this, colors, colorsName)
        findViewById<GridView>(R.id.gridView).apply {
            adapter = colorsAdapter
            setOnItemClickListener { parent, view, position, id ->
                changeActivity(view, position)
            }
        }
    }

    private fun changeActivity(view: View, position: Int) {

    }

}