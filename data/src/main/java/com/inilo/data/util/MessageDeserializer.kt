package com.inilo.data.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson


class MessageAdapter {
    @FromJson
    fun fromJson(json: Any): List<String> {
        return when (json) {
            is String -> listOf(json)
            is List<*> -> json.filterIsInstance<String>()
            else -> throw JsonDataException("Unexpected type for 'message'")
        }
    }

    @ToJson
    fun toJson(writer: JsonWriter, value: List<String>?) {
        writer.beginArray()
        value?.forEach { writer.value(it) }
        writer.endArray()
    }
}