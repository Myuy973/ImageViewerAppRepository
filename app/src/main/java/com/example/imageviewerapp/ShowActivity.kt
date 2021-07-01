package com.example.imageviewerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat

class ShowActivity : AppCompatActivity() {

    val VIEW_NAME_HEADER_IMAGE = "detail:Image"
    val VIEW_NAME_HEADER_TEXT = "detail:Text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val color = intent.getIntExtra("COLOR", 0)
        val colorName = intent.getStringExtra("COLOR_NAME") ?: "error"

        val imageView = findViewById<ImageView>(R.id.detailImage)
        val textView = findViewById<TextView>(R.id.detailText)

        ViewCompat.setTransitionName(imageView, VIEW_NAME_HEADER_IMAGE)
        ViewCompat.setTransitionName(textView, VIEW_NAME_HEADER_TEXT)
        imageView.setImageResource(color)
        textView.text = colorName

        findViewById<ConstraintLayout>(R.id.showConteiner).setOnClickListener {
            onBackPressed()
        }

    }

}