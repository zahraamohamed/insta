package com.example.nested_recyclerview.data

import java.io.PipedOutputStream

object DataManager {
    val _postList: MutableList<Post> = mutableListOf<Post>()
    private var _index = 0
    fun getPostList() : MutableList<Post> = _postList

    //Add items to list
    fun addPost(post: Post){
        _postList.add(post)
    }

    fun getCurrentPost(): Post = _postList[_index]

}