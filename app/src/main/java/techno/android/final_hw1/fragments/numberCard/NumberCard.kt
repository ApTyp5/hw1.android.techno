package techno.android.final_hw1.fragments.numberCard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import techno.android.final_hw1.R
import techno.android.final_hw1.models.NumberItem


class NumberCard: Fragment() {

	companion object {
		const val numField = "number"
		const val colField = "color"
	}

	fun set(item: NumberItem): NumberCard {
		if (arguments == null) arguments = Bundle()
		with(arguments!!) {
			putInt(numField, item.number)
			putInt(colField, item.color)
		}
		return this
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?,
	): View? {
		return inflater.inflate(R.layout.number_card, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		arguments?.let {
			with(view.findViewById<TextView>(R.id.number_card)) {
				text = it.getInt(numField).toString()
				setTextColor(it.getInt(colField))
			}
		}
	}
}
