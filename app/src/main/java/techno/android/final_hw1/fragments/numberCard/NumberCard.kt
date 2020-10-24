package techno.android.final_hw1.fragments.numberCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import techno.android.final_hw1.R
import techno.android.final_hw1.models.NumberItem


class NumberCard: Fragment() {
	// public
	fun set(item: NumberItem): NumberCard {
		arguments = Bundle().apply {
			putInt(NUMBER, item.number)
			putInt(COLOR, item.color)
		}
		return this
	}

	// callbacks
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		savedInstanceState?.let {
			arguments = Bundle().apply {
				putInt(NUMBER, it.getInt(NUMBER))
				putInt(COLOR, it.getInt(COLOR))
			}
		}
	}

	override fun onSaveInstanceState(outState: Bundle) {
		super.onSaveInstanceState(outState)
		arguments?.let {
			outState.putInt(NUMBER, it.getInt(NUMBER))
			outState.putInt(COLOR, it.getInt(COLOR))
		}
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
				text = it.getInt(NUMBER).toString()
				setTextColor(it.getInt(COLOR))
			}
		}
	}

	// support
	companion object {
		const val NUMBER = "number-card-number"
		const val COLOR = "number-card-color"
	}
}
