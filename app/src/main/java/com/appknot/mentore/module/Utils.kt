package com.appknot.mentore

import com.google.gson.Gson


/**
 *
 * @author Ethan on 2022-01-26
 */

fun <T> Any.parse(modelType: Class<T>): T {
    val jsonStr = Gson().toJson(this)
    return Gson().fromJson(jsonStr, modelType)
}

fun <T> String.parse(modelType: Class<T>): T {
    return Gson().fromJson(this, modelType)
}