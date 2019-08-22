package com.example.androidanimatedimages.ui

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidanimatedimages.R
import kotlinx.android.synthetic.main.activity_real_life.*
import kotlinx.android.synthetic.main.activity_triforce.*
import kotlinx.android.synthetic.main.activity_vector.*

class Triforce : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triforce)

        image_triforce.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.triforce_animated))

        image_triforce.setOnClickListener {
            val frameDrawable = ContextCompat.getDrawable(this, R.drawable.triforce_animated)
            image_triforce.setImageDrawable(frameDrawable)
            (frameDrawable as AnimationDrawable).start()
        }

        triforce_next.setOnClickListener {
            val intent = Intent(this, Vector::class.java)
            startActivity(intent)
        }

        triforce_back.setOnClickListener {
            val intent = Intent(this, RealLife::class.java)
            startActivity(intent)
        }
    }
}
