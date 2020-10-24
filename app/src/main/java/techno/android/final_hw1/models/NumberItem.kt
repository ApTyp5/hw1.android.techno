package techno.android.final_hw1.models

import android.graphics.Color


class NumberItem(initNumber: Int) {

    var color: Int = 0
        private set(number) {
            field = if (number % 2 == 0) Color.RED else Color.YELLOW
        }

    var number: Int = 0
        set(value) {
            color = value
            field = value
        }

    init {
        number = initNumber
    }
}
