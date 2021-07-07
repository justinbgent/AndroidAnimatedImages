package com.example.androidanimatedimages.ui

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidanimatedimages.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //vectorSelected helps save other images glory from being taken
    var vectorSelected = true
    var play = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_vector.setOnClickListener {
            vectorSelected = true
            image.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play_to_pause_avd))
            image.setOnClickListener {
                //if(vectorSelected) determines if the drawableVector is selected.
                //This prevents other images from being replaced by the
                //drawableVector when clicked on.
                if (vectorSelected){
                    //below helps select which drawableVector to show when being clicked.
                    if (!play){
                        animateVector(R.drawable.play_to_pause_avd)
                        play = true
                    }else{
                        animateVector(R.drawable.pause_to_play_avd)
                        play = false
                    }
                }
            }

        }

        btn_real_life.setOnClickListener {
            vectorSelected = false

            //displays gif if build version is correct
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                val gif = ContextCompat.getDrawable(this, R.drawable.real_life_terraria)
                image.setImageDrawable(gif)
                (gif as AnimatedImageDrawable).start()
            }
        }

        btn_triforce.setOnClickListener {
            vectorSelected = false

            //displays through many .png files that are managed by xml file, looks like a .gif
            val frameDrawable = ContextCompat.getDrawable(this, R.drawable.triforce_animated)
            image.setImageDrawable(frameDrawable)
            (frameDrawable as AnimationDrawable).start()
        }
    }

    //reduces code to write
    fun animateVector(id: Int){
        val vectorDrawable = ContextCompat.getDrawable(this, id)
        image.setImageDrawable(vectorDrawable)
        (vectorDrawable as Animatable).start()
    }
}
