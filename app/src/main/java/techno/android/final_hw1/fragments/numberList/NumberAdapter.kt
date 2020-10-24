package techno.android.final_hw1.fragments.numberList

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import techno.android.final_hw1.models.NumberItem

class NumberAdapter(
    numItemCount: Int,
    private val onClickNumItem: OnClickNumItem,
    private val onClickAddItem: OnClickAddItem,
): RecyclerView.Adapter<NumberViewHolder>() {

    private val items = MutableList(numItemCount + 1) { it }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(parent, NumberItem(0), onClickAddItem, onClickNumItem)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val naturalPos = position + 1
        if (naturalPos == itemCount) {
            holder.resetButton().addMode()
        } else {
            holder.resetButton().setNumber(naturalPos).numberMode()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(): NumberAdapter {
        Log.d("adapter", "add item")
        val value = itemCount
        val pos = itemCount - 1
        items.add(value)
        notifyItemInserted(pos)
        return this
    }
}