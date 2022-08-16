package com.vum.pruebaandroid.data

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface CountriesRequest {

    @FormUrlEncoded
    @POST("api/Utilidades/Pais_GetPais")
    fun getCountries(@Field("cadena") cadena: String): Call<Any>

}