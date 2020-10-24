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

typealias OnClickItem = (itemModel: NumberItem) -> Unit

class NumberList: Fragment() {
	private var itemCount: Int = 10
		set(value) { field = if (value < 0) 0 else value }
	private var listAdapter: NumberAdapter = NumberAdapter(itemCount)
	private lateinit var onClickItem: OnClickItem
	private lateinit var recycler: RecyclerView

	private /* lateinit */ var columnNum: Int = 0

	init {
	    Log.d("number list", "created!")
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		val orientation = resources.configuration.orientation
		columnNum = if (orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
		Log.d("number list", "attached!")
	}

	fun set(initItemCount: Int): NumberList {
		itemCount = initItemCount
		listAdapter =  NumberAdapter(itemCount)
		return this
	}

	fun set(initOnClickItem: OnClickItem): NumberList {
		onClickItem = initOnClickItem
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

	fun addItem() {
		listAdapter.addItem()
		recycler.scrollToPosition(listAdapter.itemCount - 1)
	}
}