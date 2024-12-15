package com.anugrah.housebooking.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.anugrah.housebooking.Adapter.ItemsAdapter
import com.anugrah.housebooking.databinding.ActivityMainBinding
import com.anugrah.housebooking.Model.ItemsDomain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()



        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun initList() {
        val items = arrayListOf(
            ItemsDomain(
                "Apartment",
                "Royal Apartment",
                "LosAngles LA",
                "item_1",
                1500,
                2,
                3,
                350,
                true,
                4.5,
                "This 2 bed / 1 bath home boasts an enormous open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, cerowned by stunning coffered ceilings."
            ),
            ItemsDomain(
                "House",
                "House with Great View",
                "NewYork NY",
                "item_2",
                800,
                1,
                2,
                500,
                false,
                4.9,
                "This 2 bed / 1 bath home boasts an enormous open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, cerowned by stunning coffered ceilings."
            ),
            ItemsDomain(
                "Villa",
                "Royal Villa",
                "LosAngles LA",
                "item_3",
                999,
                2,
                1,
                400,
                true,
                4.7,
                "This 2 bed / 1 bath home boasts an enormous open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, cerowned by stunning coffered ceilings."
            ),
            ItemsDomain(
                "House",
                "Beauty House",
                "NewYork NY",
                "item_4",
                1750,
                3,
                2,
                1100,
                true,
                4.3,
                "This 2 bed / 1 bath home boasts an enormous open-living plan, accented by striking architectural features and high-end finishes. Feel inspired by open sight lines that embrace the outdoors, cerowned by stunning coffered ceilings."
            )
        )

        binding.recommendedView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recommendedView.adapter = ItemsAdapter(items)
        binding.navigationBar.setItemSelected(0, true)
    }
}