package com.example.shoplist.presentation

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.shoplist.R

@BindingAdapter("intToString")
fun bindIntToString(textView: TextView, number: Int) {
    textView.text = number.toString()

}

@BindingAdapter("errorInputName")
fun bindErrorInputName(textView: TextView, isError: Boolean){
    val message = if (isError) {
        textView.context.getString(R.string.error_input_name)
    } else {
        null
    }
    textView.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textView: TextView, isError: Boolean){
    val message = if (isError) {
        textView.context.getString(R.string.error_input_count)
    } else {
        null
    }
    textView.error = message
}