package com.example.nested_recyclerview.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nested_recyclerview.data.Post

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView){
}