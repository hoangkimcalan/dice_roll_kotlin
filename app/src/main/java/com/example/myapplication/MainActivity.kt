package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice(){
        val dice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dR = when(dice.diceRoll()){
            1-> R.drawable.perspective_dice_six_faces_one
            2-> R.drawable.perspective_dice_six_faces_two
            3-> R.drawable.perspective_dice_six_faces_three
            4-> R.drawable.perspective_dice_six_faces_four
            5-> R.drawable.perspective_dice_six_faces_five
            else -> R.drawable.dice_six
        }
        diceImage.setImageResource(dR)
    }
}

class Dice(private val numSides : Int){
    fun diceRoll() : Int{
        return (1..numSides).random()
    }
}