package techno.android.final_hw1.models

import android.graphics.Color

class NumberItem(initNumber: Int) {
    private var color: Int = 0
        private set(number) {
            field = if (number % 2 == 0) Color.RED else Color.BLUE
        }
    var number: Int = initNumber
        set(value) {
            color = value
            field = value
        }

}