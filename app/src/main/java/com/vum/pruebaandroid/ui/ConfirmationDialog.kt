package com.vum.pruebaandroid.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.vum.pruebaandroid.R
import com.vum.pruebaandroid.ui.theme.Blue
import com.vum.pruebaandroid.ui.theme.PruebaAndroidTheme
import com.vum.pruebaandroid.ui.theme.TextBlue

@Preview
@Composable
private fun ShowConfirmationDialog(){
    PruebaAndroidTheme {
        ConfirmationDialog(countryName = "MX"){}
    }
}

@Composable
fun ConfirmationDialog(countryName: String, onDismiss: () -> Unit){
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Card(
            modifier = Modifier.fillMaxSize(0.95F),
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.ClickCountry),
                    color = TextBlue,
                    fontSize = 15.sp,
                    fontFamily = FontFamily( Font(R.font.gothaprobol) )
                )
                Icon(
                    modifier = Modifier.size(60.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_emoji_people_24),
                    contentDescription = "Person icon",
                    tint = Blue
                )

                Text(
                    text = stringResource(id = R.string.YouHaveBeenClicked, countryName),
                    color = TextBlue,
                    fontSize = 15.sp,
                    fontFamily = FontFamily( Font(R.font.gothambookregular) ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}