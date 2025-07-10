package com.prilepskiy.treningfintech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.prilepskiy.treningfintech.ui.theme.TreningFinTechTheme
import com.prilepskiy.treningfintech.ui.screen.RootScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TreningFinTechTheme {
                RootScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}