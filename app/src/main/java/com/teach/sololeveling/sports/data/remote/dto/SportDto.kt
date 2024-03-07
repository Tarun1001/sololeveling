package com.teach.sololeveling.sports.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.teach.sololeveling.sports.domain.model.Sport

data class SportDto(
    @SerializedName("active")
    val active: Boolean,
    @SerializedName("description")
    val description: String,
    @SerializedName("group")
    val group: String,
    @SerializedName("has_outrights")
    val hasOutrights: Boolean,
    @SerializedName("key")
    val key: String,
    @SerializedName("title")
    val title: String
)
fun SportDto.toSportModel():Sport{
    return Sport(description=description,group=group,title=title)
}