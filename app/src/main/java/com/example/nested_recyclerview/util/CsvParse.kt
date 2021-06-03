package com.example.nested_recyclerview.util

import com.example.nested_recyclerview.data.Post

class CsvParse {

    //split values to be as a table
    fun parse(line : String) : Post {
        val tokens = line.split(",")
        return Post(
            time = tokens[Constant.ColumnIndex.TIME],
            name = tokens[Constant.ColumnIndex.NAME],
            like = tokens[Constant.ColumnIndex.LIKE],
            imgProfile = tokens[Constant.ColumnIndex.IMG_PROFILE],
            imgPost = tokens[Constant.ColumnIndex.IMG_POST],
            caption = tokens[Constant.ColumnIndex.CAPTION],

            )
    }
}