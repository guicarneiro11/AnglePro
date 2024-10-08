package com.guicarneirodev.goniometro.presentation.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.guicarneirodev.goniometro.presentation.viewmodel.HomeScreenViewModel
import com.guicarneirodev.goniometro.presentation.ui.components.DraggableContent
import com.guicarneirodev.goniometro.presentation.ui.components.HomeBackground
import com.guicarneirodev.goniometro.presentation.ui.components.LoginButton
import com.guicarneirodev.goniometro.presentation.ui.components.RegisterButton
import com.guicarneirodev.goniometro.presentation.ui.components.WelcomeText

@Composable
fun HomeScreen(navController: NavController) {
    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val offsetY by homeScreenViewModel.offsetY.collectAsState()

    HomeBackground {
        DraggableContent(
            offsetY = offsetY,
            onDrag = { dragAmount -> homeScreenViewModel.updateOffsetY(dragAmount) },
            onDragEnd = { homeScreenViewModel.resetOffsetY() }
        ) {
            HomeContent(navController)
        }
    }
}

@Composable
fun HomeContent(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.Transparent, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
                .height(IntrinsicSize.Min),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            WelcomeText()
            Spacer(modifier = Modifier.height(225.dp))
            LoginButton(navController)
            Spacer(modifier = Modifier.height(16.dp))
            RegisterButton(navController)
        }
    }
}