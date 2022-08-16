package com.vum.pruebaandroid.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import com.vum.pruebaandroid.R
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme
import com.vum.pruebaandroid.ui.viewModels.CountriesViewModel

@Preview
@Composable
private fun ShowCountryScreenPreview() {
    PruebaAndroidTheme {
        val countriesViewModel = CountriesViewModel()
        CountryScreen(countriesViewModel)
    }
}

@Composable
fun CountryScreen(countriesViewModel: CountriesViewModel) {
    val countries by countriesViewModel.countries.collectAsState()
    var showDialog by remember { mutableStateOf<String?>(null) }
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.Countries),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        items(countries) { country ->
            CountryCard(country = country) { countryName ->
                showDialog = countryName
            }
        }
    }

    if (!showDialog.isNullOrEmpty()) {
        ConfirmationDialog(countryName = showDialog!!) {
            showDialog = null

            val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")

            val chooser = Intent.createChooser(mapIntent, "Launch Maps")
            startActivity(context, chooser, bundleOf())
        }
    }

}