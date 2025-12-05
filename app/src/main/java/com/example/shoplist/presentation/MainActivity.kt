package com.example.shoplist.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MainActivityTest", it.toString())
            if (count == 0) {
                viewModel.deleteShopItem(it[count])
                viewModel.changeEnableStateOfItem(it[count+1])
                count++

            }
        }

    }
}