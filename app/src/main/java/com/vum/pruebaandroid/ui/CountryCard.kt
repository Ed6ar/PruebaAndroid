package com.vum.pruebaandroid.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vum.pruebaandroid.data.Country
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme

@Preview
@Composable
private fun ShowCountryCardPreview(){
    PruebaAndroidTheme {
        CountryCard(country = Country(idPais = "MX", Pais = "México"))
    }
}

@Composable
fun CountryCard(country: Country) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable {
                //TODO
            }
    ) {
        Text(
            text = country.Pais,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            color = MaterialTheme.colors.primary,
            fontSize = 12.sp,
        )
    }
}