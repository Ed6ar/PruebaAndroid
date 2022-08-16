package com.vum.pruebaandroid.core

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.vum.pruebaandroid.ui.CountryScreen
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme
import com.vum.pruebaandroid.ui.viewModels.CountriesViewModel

class MainActivity : ComponentActivity() {

    private val countriesViewModel: CountriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countriesViewModel.initRequest()

        setContent {
            PruebaAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CountryScreen(countriesViewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()


    }
}