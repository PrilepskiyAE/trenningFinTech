package com.prilepskiy.presentation.detailScreen.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.prilepskiy.domain.model.UiUserModel
import com.prilepskiy.presentation.R
import com.prilepskiy.presentation.detailScreen.viewModel.DetailIntent
import com.prilepskiy.presentation.detailScreen.viewModel.DetailViewModel
import com.prilepskiy.presentation.uiComponent.ErrorMessageComponent
import com.prilepskiy.presentation.uiComponent.LoadingComponent
import com.prilepskiy.presentation.uiComponent.TextComponent


@Composable
fun DetailScreen(user: Int, viewModel: DetailViewModel = hiltViewModel(), onPopBack: () -> Unit) {
    val state = viewModel.viewState
    val context = LocalContext.current
    LaunchedEffect(user) {
        viewModel.onIntent(DetailIntent.GetUser(user))
    }

    if (state.isLoading) {
        LoadingComponent()
    } else if (!state.error.isNullOrEmpty()) {
        ErrorMessageComponent(textError = state.error) {
            onPopBack.invoke()
        }
    } else {
        DetailScreen(
            state.userModel,
            onPopBack,
            openTelephony = {
                val phone = it
                val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
                startActivity(context, intent, null)
            },
            openEmail = {
                val mailto = "mailto:$it"
                val intent = Intent(Intent.ACTION_SENDTO, mailto.toUri())
                startActivity(context, intent, null)
            },
            openMap = { lang, long ->

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    "http://maps.google.com/maps?saddr=$lang,$long".toUri()
                )
                startActivity(context, intent, null)
            }
        )
    }


}

@Composable
private fun DetailScreen(
    user: UiUserModel,
    onPopBack: () -> Unit,
    openTelephony: (String) -> Unit,
    openEmail: (String) -> Unit,
    openMap: (String, String) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        IconButton(
            onClick = onPopBack, modifier = Modifier
                .align(Alignment.TopStart)
                .padding(horizontal = 10.dp, vertical = 50.dp)
        ) {
            Icon(
                Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.description_pop_back)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(250.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.large)
                    .build(),
                contentDescription = "AVATAR",
            )
            Card {
                TextComponent(
                    modifier = Modifier.fillMaxWidth().padding(8.dp).align(Alignment.CenterHorizontally),
                    text = "User name ${user.title} ${user.first}  ${user.last}"
                )

                TextComponent(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                        .padding(8.dp), text = "Address ${user.city} ${user.country}"
                )

                TextComponent(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                        .padding(8.dp), text = user.streetName
                )
                TextComponent(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                        .padding(8.dp), text = "gender ${user.gender}"
                )

                TextComponent(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                        .padding(8.dp), text = "age ${user.dobAge}"
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp), onClick = {
                    openTelephony(user.phone)
                }) { Text(text = "Phone number ${user.phone}") }

            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp), onClick = {
                    openEmail(user.email)
                }) { Text(text = "Email ${user.email}") }

            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp), onClick = {
                    openMap(user.latitude, user.longitude)
                }) { Text(text = "Coord ${user.latitude}, ${user.longitude}") }


        }

    }
}