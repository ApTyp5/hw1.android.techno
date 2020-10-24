package techno.android.final_hw1.fragments.numberList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import techno.android.final_hw1.R
import techno.android.final_hw1.models.NumberItem

class NumberViewHolder(
    parent: ViewGroup,
    private val itemModel: NumberItem,
    private val onClickClickAddItem: OnClickAddItem,
    private val onClickNumNumItem: OnClickNumItem,
) :
    RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    ) {

    private val button = itemView.findViewById<Button>(R.id.number_list_item)

    // public
    fun addMode(): NumberViewHolder {
        button.setOnClickListener { onClickClickAddItem() }
        return setAddIcon()
    }

    fun setNumber(number: Int): NumberViewHolder {
        itemModel.number = number
        return this
    }

    fun numberMode(): NumberViewHolder {
        updateButtonInfo()
        button.setOnClickListener { onClickNumNumItem(itemModel) }
        return this
    }

    fun resetButton(): NumberViewHolder {
        with(button) {
            text = ""
            setTextColor(0)
            setBackgroundResource(0)
            setOnClickListener(null)
        }
        return this
    }

    // private
    private fun updateButtonInfo(): NumberViewHolder {
        with(button) {
            text = itemModel.number.toString()
            setTextColor(itemModel.color)
            setBackgroundColor(context.getColor(R.color.grey))
        }
        return this
    }

    private fun setAddIcon(): NumberViewHolder {
        with(button) {
            setBackgroundResource(R.drawable.ic_baseline_add_24)
        }
        return this
    }
}