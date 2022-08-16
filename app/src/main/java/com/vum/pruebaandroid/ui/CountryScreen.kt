package com.vum.pruebaandroid.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme

@Preview
@Composable
private fun ShowCountryScreenPreview(){
    PruebaAndroidTheme {
        CountryScreen()
    }
}

@Composable
fun CountryScreen(){
    Text(text = "TODO")
}