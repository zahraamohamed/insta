package com.example.nested_recyclerview.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.nested_recyclerview.R
import com.example.nested_recyclerview.data.DataManager
import com.example.nested_recyclerview.data.Post
import com.example.nested_recyclerview.databinding.HeaderBinding
import com.example.nested_recyclerview.databinding.PostItemBinding

class PostAdapter ( val list:List<Post>,val context: Context) : RecyclerView.Adapter<BaseViewHolder<*>> (){

    override fun getItemViewType(position: Int): Int {
       return if(position==0){
          STORY_HOLDER
       }else{
           POST_HOLDER
       }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

    return when (viewType) {
            POST_HOLDER -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
                PostViewHolder(context, view)
            }
            STORY_HOLDER -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.header, parent, false)
                    ViewHolder(context, view)
            }
        else -> {
            return super.createViewHolder(parent,viewType)
        }
    }



    }


    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {

//
        val currenPost = list[position]
        when(holder)
    {
        is PostViewHolder -> {
        holder.binding.apply {
            Glide.with(context)
                .load(currenPost.imgPost).error(R.drawable.ic_error)
                .apply(RequestOptions.fitCenterTransform())
                .into(postImg)
            Glide.with(context)
                .load(currenPost.imgProfile).error(R.drawable.ic_error)
                .apply(RequestOptions.circleCropTransform())
                .into(profileImg)

            name.text = currenPost.name
            val likes = currenPost.like
            val times=currenPost.time
            like.text = "$likes Likes"
            time.text = "$times .see Translation"

            caption.text=currenPost.caption
        }


    }
        is ViewHolder ->{
            val adapter= StoryAdapter(DataManager._postList ,context)
            val layoutManger= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

            holder.binding.apply {
                       subHeader.layoutManager=layoutManger
                       subHeader.adapter=adapter}
    }
    }}






    override fun getItemCount()= list.size

                // classes holder

    class PostViewHolder(val context: Context, ItemView: View): BaseViewHolder<View>(ItemView) {
    val binding = PostItemBinding.bind(itemView)
}


   class ViewHolder(val context: Context, itemView: View): BaseViewHolder<View>(itemView) {
        val  binding = HeaderBinding.bind(itemView)


 }
    companion object {
        const val POST_HOLDER = 1
        const val STORY_HOLDER = 2
    }


}

abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView)



