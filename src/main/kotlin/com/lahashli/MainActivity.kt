package com.lahashli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.lahashli.ui.screens.HomeScreen
import com.lahashli.ui.theme.LahashLiTheme
import com.lahashli.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LahashLiTheme {
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}
