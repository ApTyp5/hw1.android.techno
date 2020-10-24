package techno.android.final_hw1.fragments.numberList

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import techno.android.final_hw1.models.NumberItem

class NumberAdapter(numItemCount: Int): RecyclerView.Adapter<NumberViewHolder>() {
    private val items = MutableList(numItemCount + 1) { it }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(parent, NumberItem(0))
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val naturalPos = position + 1
        if (naturalPos == itemCount) {
            holder.setNumber(naturalPos).addMode()
        } else {
            holder.setNumber(naturalPos).numberMode()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(): NumberAdapter {
        val value = itemCount
        val pos = itemCount
        items.add(value, pos)
        notifyItemInserted(pos)
        return this
    }
}