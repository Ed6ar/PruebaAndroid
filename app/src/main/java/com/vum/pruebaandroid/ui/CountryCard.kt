package com.vum.pruebaandroid.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vum.pruebaandroid.R
import com.vum.pruebaandroid.data.Country
import com.vum.pruebaandroid.ui.theme.Blue
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme

@Preview
@Composable
private fun ShowCountryCardPreview(){
    PruebaAndroidTheme {
        CountryCard(country = Country(idPais = "MX", Pais = "México")){}
    }
}

@Composable
fun CountryCard(country: Country, onClick: (countryName: String) -> Unit) {
    var isSelected by rememberSaveable{ mutableStateOf(false) }

    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable {
                onClick(country.Pais)
                isSelected = true
            }
    ) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = country.Pais,
                color = MaterialTheme.colors.primary,
                fontFamily = FontFamily(Font(R.font.gothambookregular)),
                fontSize = 12.sp,
            )

            if(isSelected){
                Icon(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Country selected",
                    modifier = Modifier.size(40.dp),
                    tint = Blue
                )
            }
        }
    }
}