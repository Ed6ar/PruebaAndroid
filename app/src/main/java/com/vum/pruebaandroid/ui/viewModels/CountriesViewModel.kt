package com.vum.pruebaandroid.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.vum.pruebaandroid.data.CountriesRequest
import com.vum.pruebaandroid.data.Country
import com.vum.pruebaandroid.data.RetrofitHelper
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.awaitResponse

private const val URL = "https://weepatient.com/API/"

class CountriesViewModel: ViewModel() {

    private val _countries = MutableStateFlow(listOf<Country>())
    val countries = _countries.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, throwable ->
        throwable.localizedMessage?.let { Log.e("Error", it) }
    }

    fun initRequest (){
        Log.e("calling","retrofit")

        val retrofitReference = RetrofitHelper.getRetrofit(URL)
        val wsReference = retrofitReference.create(CountriesRequest::class.java)

        viewModelScope.launch(handler) {
            val result = wsReference.getCountries(cadena = "").awaitResponse()
            _countries.value = getCountiesFromJson(result.body())
        }
    }

    private fun getCountiesFromJson(body: Any?): List<Country> {
        val fullBody = JSONObject(Gson().toJson(body))
        val dsRespuesta = fullBody.getJSONObject("dsRespuesta")
        val countries = dsRespuesta.getJSONArray("Paises")

        val countriesList = mutableListOf<Country>()
        for (index in 0 until countries.length()){
            val item = JSONObject(countries[index].toString())
            countriesList.add(
                Country(
                    idPais = item["idPais"] as String,
                    Pais = item["Pais"] as String
                )
            )
        }

        return countriesList
    }
}