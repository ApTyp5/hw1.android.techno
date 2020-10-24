package techno.android.final_hw1.fragments.numberList

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import techno.android.final_hw1.R
import techno.android.final_hw1.models.NumberItem

typealias OnClickNumItem = (itemModel: NumberItem) -> Unit
typealias OnClickAddItem = () -> Unit

class NumberList : Fragment() {

    companion object {
        const val MIN_VALUE = 0
    }

    private var itemCount: Int = 10
        set(value) {
            field = if (value < MIN_VALUE) MIN_VALUE else value
        }
    private lateinit var listAdapter: NumberAdapter
    private lateinit var onClickNumItem: OnClickNumItem
    private lateinit var recycler: RecyclerView

    private /* lateinit */ var columnNum: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val orientation = resources.configuration.orientation
        columnNum = if (orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
    }

    fun initListAdapter(
        initItemCount: Int? = null,
        initOnClickNumItem: OnClickNumItem? = null
    ): NumberList {
        initItemCount?.let { itemCount = it }
        initOnClickNumItem?.let { onClickNumItem = it }
        listAdapter = NumberAdapter(itemCount, onClickNumItem, { addItem() })
        return this
    }

    fun set(initItemCount: Int): NumberList {
        itemCount = initItemCount
        return this
    }

    fun set(initOnClickNumItem: OnClickNumItem): NumberList {
        onClickNumItem = initOnClickNumItem
        return this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.number_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = view.findViewById(R.id.number_list)
        recycler.layoutManager = GridLayoutManager(view.context, columnNum)
        recycler.adapter = listAdapter
    }

    private fun addItem() {
        listAdapter.addItem()
        recycler.scrollToPosition(listAdapter.itemCount - 1)
    }
}
