package com.example.basicretrofit

import retrofit2.Response
import retrofit2.http.GET

interface apiservice {
    @GET ("comments")
    suspend fun getComentarios () : Response <Array<comentarios>>
}