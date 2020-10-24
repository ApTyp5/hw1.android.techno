package techno.android.final_hw1.fragments.numberList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import techno.android.final_hw1.R
import techno.android.final_hw1.models.NumberItem

class NumberViewHolder(parent: ViewGroup, private val itemModel: NumberItem):
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    ) {

    private val button = itemView.findViewById<Button>(R.id.number_list_item)

    fun addMode(): NumberViewHolder {
        return setAddIcon()
    }

    fun setNumber(number: Int): NumberViewHolder {
        itemModel.number = number
        return this
    }

    fun numberMode(): NumberViewHolder {
        updateButtonInfo()
        return this
    }

    private fun updateButtonInfo(): NumberViewHolder {
        button.text = itemModel.number.toString()
        button.setTextColor(itemModel.color)
        return this
    }

    private fun setAddIcon(): NumberViewHolder {
        clearButton()
        button.setBackgroundResource(R.drawable.ic_baseline_add_24)
        return this
    }

    private fun clearButton(): NumberViewHolder {
        button.text = ""
        button.setTextColor(0)
        button.background = null
        return this
    }
}