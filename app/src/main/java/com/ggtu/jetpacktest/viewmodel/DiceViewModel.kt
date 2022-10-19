package com.ggtu.jetpacktest.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.ggtu.jetpacktest.R
import com.ggtu.jetpacktest.model.Dice

class DiceViewModel{
    private val dice = Dice()
    val diceDetailState = mutableStateOf(dice.side)

    fun roll() {
        dice.side = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceDetailState.value = dice.side
    }
}