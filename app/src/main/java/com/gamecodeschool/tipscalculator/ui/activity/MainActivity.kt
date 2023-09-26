package com.gamecodeschool.tipscalculator.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamecodeschool.tipscalculator.R
import com.gamecodeschool.tipscalculator.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val stringIntTextField = binding.mainActivityCostOfService.text.toString()
        val cost = stringIntTextField.toDouble()
        val tipPercentage = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.amazing_butoon -> 0.20
            R.id.good_butoon -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.switchOption.isChecked
        if (roundUp) {
            tip=kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }


}