package com.prilepskiy.presentation.detailScreen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.persistableBundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.prilepskiy.presentation.R
import com.prilepskiy.presentation.detailScreen.viewModel.DetailViewModel
import com.prilepskiy.presentation.uiComponent.TextComponent

@Composable
fun DetailScreen(user:Int,viewModel: DetailViewModel = hiltViewModel(),onPopBack: () -> Unit,){

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        IconButton(onClick = onPopBack, modifier = Modifier
            .align(Alignment.TopStart)
            .padding(horizontal = 10.dp, vertical = 50.dp)) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(R.string.description_pop_back))}
        TextComponent(modifier = Modifier
            .align(Alignment.Center)
            .padding(24.dp), text = "useridTest $user")
    }

}