package com.example.nested_recyclerview.ui

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.nested_recyclerview.R


abstract class Base<VB : ViewBinding> : AppCompatActivity() {
    //initial variable for log fun

    //initial binding inflater
    abstract val bindingInflater: (LayoutInflater) -> VB
    private var _binding: ViewBinding? = null
    protected val binding
        get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        val bar: ActionBar? = actionBar
        bar?.setBackgroundDrawable(ColorDrawable(Color.WHITE))


        setup()

    }
//add menu to action bar look like instagram
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }



    //basic function in this project
    protected abstract fun setup()
}