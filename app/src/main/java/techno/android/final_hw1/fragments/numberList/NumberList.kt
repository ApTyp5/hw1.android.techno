package techno.android.final_hw1.fragments.numberList

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
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

    private var itemCount: Int = DEFAULT_ITEM_COUNT
        set(value) {
            field = if (value < MIN_VALUE) MIN_VALUE else value
        }
    private lateinit var listAdapter: NumberAdapter
    private lateinit var onClickNumItem: OnClickNumItem
    private lateinit var recycler: RecyclerView
    private /* lateinit */ var columnNum: Int = 0

    // public
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

    // callbacks
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val orientation = resources.configuration.orientation
        columnNum = if (orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
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
        recycler = view.findViewById<RecyclerView>(R.id.number_list).apply {
            layoutManager = GridLayoutManager(view.context, columnNum)
            adapter = listAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let {
            itemCount = it.getInt(ITEM_COUNT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ITEM_COUNT, itemCount)
    }

    // internal
    private fun addItem() {
        listAdapter.addItem()
        itemCount = listAdapter.getRealItemCount()
        recycler.scrollToPosition(listAdapter.getRealItemCount())
    }

    // support
    companion object {
        const val MIN_VALUE = 0
        const val DEFAULT_ITEM_COUNT = 10
        const val ITEM_COUNT = "number-list-item-count"
    }
}
