package com.example.nested_recyclerview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nested_recyclerview.R
import com.example.nested_recyclerview.data.Post
import com.example.nested_recyclerview.databinding.HeaderBinding
import com.example.nested_recyclerview.databinding.StoryItemBinding

class StoryAdapter (val list:List<Post>, val context: Context)
    : RecyclerView.Adapter<StoryAdapter.StoryViewHolder> (){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {

            val view =  LayoutInflater.from(parent.context).inflate(R.layout.story_item,parent,false)
            return StoryViewHolder(view)
        }

        override fun getItemCount()= list.size






    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currenPost = list[position]

        holder.binding.apply {
                    nameStory.text=currenPost.name
                    Glide.with(context)
                        .load(currenPost.imgProfile).error(R.drawable.ic_error)
                        .apply(RequestOptions.circleCropTransform())
                        .into(storyImg)
                    Glide.with(context)
    }

}


      class StoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val  binding = StoryItemBinding.bind(itemView)

    }
    }
