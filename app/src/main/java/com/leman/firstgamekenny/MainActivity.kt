package com.leman.firstgamekenny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score =0
    var imagesArray = ArrayList<ImageView>()
    var handler = Handler()
    var runnable = Runnable{}

//    imagesArray.add
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    imagesArray.add(imageView)
    imagesArray.add(imageView2)
    imagesArray.add(imageView3)
    imagesArray.add(imageView4)
    imagesArray.add(imageView5)
    imagesArray.add(imageView6)
    imagesArray.add(imageView7)
    imagesArray.add(imageView8)
    imagesArray.add(imageView9)
    hide()

        object : CountDownTimer(15500,1000){

            override fun onTick(p0: Long) {
                timeText.text = "Time: " +p0/1000
            }

            override fun onFinish() {


                timeText.text = "Time: 0"
                handler.removeCallbacks(runnable)

                for(image in imagesArray){

                    image.visibility = View.INVISIBLE
                }

                var alert = AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Game over!")
                alert.setMessage("Restart the game?")
x               alert.setPositiveButton("Yes") {dialog, which-> val intent = intent2
                    finish()
                    startActivity(intent)
                }

                alert.setNegativeButton("No") {dialog, which->

                    Toast.makeText(this@MainActivity,"Game Over",Toast.LENGTH_LONG).show()

                }
                alert.show()

            }

        }.start()

    }

    fun hide(){

        runnable = object :Runnable
        {
            override fun run() {
                for (image in imagesArray) {
                    image.visibility = View.INVISIBLE
                }

                val randomIndex =Random.nextInt(9)
                imagesArray[randomIndex].visibility = View.VISIBLE
                handler.postDelayed(runnable,500)
            }


        }
        handler.post(runnable)


    }

    fun increase(view: View){

        score++
        scoreText.text = "Score: $score"


    }

}
