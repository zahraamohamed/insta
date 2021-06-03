package com.example.nested_recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.BaseAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nested_recyclerview.R
import com.example.nested_recyclerview.data.DataManager
import com.example.nested_recyclerview.databinding.ActivityMainBinding
import com.example.nested_recyclerview.util.CsvParse
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity :  Base<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {
        parsCsvFile()

        //adapter
        val  Adapter = PostAdapter(DataManager._postList,this)
        val layoutManger=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding?.parentRecycler!!.layoutManager=layoutManger
        binding?.parentRecycler!!.adapter=Adapter
    }


// function of class main
//parse csv file to get all values
    private fun parsCsvFile() {
    val inputStream: InputStream = assets.open("insta.csv")
    val buffer = BufferedReader(InputStreamReader(inputStream))
    val parser = CsvParse()
    buffer.forEachLine { it ->
        val currentPost = parser.parse(it)

        DataManager.addPost(currentPost)
    }


}
}