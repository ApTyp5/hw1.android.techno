package techno.android.final_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import techno.android.final_hw1.fragments.numberCard.NumberCard
import techno.android.final_hw1.fragments.numberList.NumberList
import techno.android.final_hw1.models.NumberItem

class MainActivity: AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		if (savedInstanceState == null) {
			val list = NumberList()
				.set(initItemCount = 100)
				.set(initOnClickNumItem = {itemModel ->  showNumberCard(itemModel)})
				.initListAdapter()

			supportFragmentManager.beginTransaction()
				.replace(R.id.fragment_slot, list)
				.commit()
		}
	}

	private fun showNumberCard(item: NumberItem) {
		supportFragmentManager.beginTransaction()
			.addToBackStack(getString(R.string.show_card_transaction_name))
			.replace(R.id.fragment_slot, NumberCard().set(item))
			.commit()
	}
}
