package techno.android.final_hw1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import techno.android.final_hw1.fragments.numberCard.NumberCard
import techno.android.final_hw1.fragments.numberList.NumberList
import techno.android.final_hw1.models.NumberItem


class MainActivity: AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		Log.d("main on create", "start SUPER START")
		super.onCreate(savedInstanceState)
		Log.d("main on create", "after super")
		setContentView(R.layout.activity_main)
		Log.d("main on create", "savedInstanceState: $savedInstanceState")
		if (savedInstanceState == null) {
			Log.d("main on create", "in if")
			val fragment = NumberList()
//			val fragment = NumberCard().set(NumberItem(13))
			supportFragmentManager.beginTransaction()
				.replace(R.id.fragment_slot, fragment)
				.commit()
		}
	}
}
