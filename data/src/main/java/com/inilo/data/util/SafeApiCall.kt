package com.inilo.data.util

import com.inilo.data.model.ErrorResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketException

suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T?> {

    return withContext(Dispatchers.IO) {
        val response: Response<T>?
        try {

            response = apiToBeCalled()

            if (response.isSuccessful) {
                Resource.success(data = response.body())
            } else {
                try {
                    val moshi = Moshi.Builder()
                        .add(MessageAdapter())
                        .add(KotlinJsonAdapterFactory())
                        .build()

                    val adapter = moshi.adapter(ErrorResponse::class.java)
                    val responseError = adapter.fromJson(response.errorBody()?.string() ?: "")
                    println("Status Code: ${responseError?.statusCode}")

                    if (responseError?.message?.isNotEmpty() == true) {
                        val result = responseError.message.joinToString("\n")
                        Resource.error(message = result)
                    } else {
                        println("No messages found.")
                        Resource.error(message = "An error occurred")
                    }
                } catch (e: Exception) {
                    println("No messages found. " +e.localizedMessage)
                    Resource.error(message = "An error occurred")
                }
            }

        } catch (e: HttpException) {
            Resource.error(message =  "An error occurred")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.error("Please check your network connection")
        } catch (e: SocketException){
            e.printStackTrace()
            Resource.error("Please check your network connection")
        }catch (e: Exception) {
            e.printStackTrace()
            Resource.error(message =   e.message.toString())
        }
    }
}