package com.example.androidanimatedimages.ui

import android.content.Intent
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidanimatedimages.R
import kotlinx.android.synthetic.main.activity_real_life.*
import kotlinx.android.synthetic.main.activity_vector.*

class RealLife : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_life)

        image_real_life.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.real_life_terraria))

        image_real_life.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val gif = ContextCompat.getDrawable(this, R.drawable.real_life_terraria)
                image_real_life.setImageDrawable(gif)
                (gif as AnimatedImageDrawable).start()
            }
        }

        real_life_next.setOnClickListener {
            val intent = Intent(this, Triforce::class.java)
            startActivity(intent)
        }

        real_life_back.setOnClickListener {
            val intent = Intent(this, Vector::class.java)
            startActivity(intent)
        }
    }
}
