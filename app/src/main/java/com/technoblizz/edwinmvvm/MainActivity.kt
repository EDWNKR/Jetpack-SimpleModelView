package com.technoblizz.edwinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var mViewModel : DzikirViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this)[DzikirViewModel::class.java]
        getValueFromViewModel()

        btn_count.setOnClickListener {
            setValueToViewModel()
        }

        txt_reset.setOnClickListener {
            resetValueToViewModel()
        }
    }

    fun getValueFromViewModel(){
        txt_value.text = mViewModel?.value.toString()
    }

    fun setValueToViewModel(){
        mViewModel?.value = mViewModel?.value?.plus(1)!!
        getValueFromViewModel()
    }

    fun resetValueToViewModel(){
        mViewModel?.value = 0
        getValueFromViewModel()
    }
}
