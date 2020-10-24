package techno.android.final_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import techno.android.final_hw1.fragments.numberCard.NumberCard
import techno.android.final_hw1.fragments.numberList.NumberList
import techno.android.final_hw1.models.NumberItem

class MainActivity : AppCompatActivity() {
    // callbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = supportFragmentManager.findFragmentByTag(NUMBER_LIST) as NumberList?
        val card = supportFragmentManager.findFragmentByTag(NUMBER_CARD) as NumberCard?

        list?.set { itemModel -> showNumberCard(itemModel) }?.initListAdapter()

        if (list == null && card == null) {
            val newList = NumberList()
                .set(initItemCount = 100)
                .set(initOnClickNumItem = { itemModel -> showNumberCard(itemModel) })
                .initListAdapter()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_slot, newList, NUMBER_LIST)
                .commit()
        }
    }

    // internal
    private fun showNumberCard(item: NumberItem) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(getString(R.string.show_card_transaction_name))
            .replace(R.id.fragment_slot, NumberCard().set(item), NUMBER_CARD)
            .commit()
    }

    // support
    companion object {
        const val NUMBER_LIST = "main-activity-number-list"
        const val NUMBER_CARD = "main-activity-number-card"
    }
}
