package com.example.androidanimatedimages.ui

import android.content.Intent
import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidanimatedimages.R
import kotlinx.android.synthetic.main.activity_vector.*

class Vector : AppCompatActivity() {

    var play = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector)

        image_vector.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play_to_pause_avd))

        image_vector.setOnClickListener {
            if (!play){
                animateVector(R.drawable.play_to_pause_avd)
                play = true
            }else{
                animateVector(R.drawable.pause_to_play_avd)
                play = false
            }
        }

        vector_next.setOnClickListener {
            val intent = Intent(this, RealLife::class.java)
            startActivity(intent)
        }

        vector_back.setOnClickListener {
            val intent = Intent(this, Triforce::class.java)
            startActivity(intent)
        }
    }

    fun animateVector(id: Int){
        val vectorDrawable = ContextCompat.getDrawable(this, id)
        image_vector.setImageDrawable(vectorDrawable)
        (vectorDrawable as Animatable).start()
    }
}
