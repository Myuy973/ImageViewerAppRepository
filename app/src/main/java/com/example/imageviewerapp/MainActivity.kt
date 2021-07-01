package com.example.imageviewerapp

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.util.Pair as UtilPair

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
        val intent = Intent(this, ShowActivity::class.java)
        intent.putExtra("COLOR", colors[position])
        intent.putExtra("COLOR_NAME", colorsName[position])
        val pair1 = UtilPair.create(view.findViewById<View>(R.id.detailImage),
                ShowActivity().VIEW_NAME_HEADER_IMAGE)
        val pair2 = UtilPair.create(view.findViewById<View>(R.id.detailText),
                ShowActivity().VIEW_NAME_HEADER_TEXT)
        @SuppressWarnings("unchecked")
        val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                this as Activity,
                pair1,
                pair2)
        ActivityCompat.startActivity(this, intent, activityOptions.toBundle())

    }

}