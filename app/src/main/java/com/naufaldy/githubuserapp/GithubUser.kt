package com.naufaldy.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    val username: String?,
    val name: String?,
    val photo: Int?
) :Parcelable
