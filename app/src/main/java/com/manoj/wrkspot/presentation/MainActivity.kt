package com.manoj.wrkspot.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.manoj.wrkspot.presentation.theme.WrkspotTheme
import com.manoj.wrkspot.presentation.ui.CountryListScreen
import com.manoj.wrkspot.worker.NetworkStateManager
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WrkspotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CountryListScreen()
                }
            }
        }
        NetworkStateManager.getNetworkConnectivityStatus().observe(this) { isConnected ->
            showToast(isConnected)
        }
    }

    private fun showToast(isConnected: Boolean) {
        if (isConnected) {
            Toast.makeText(this, "Online", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "offline", Toast.LENGTH_LONG).show()
        }
    }
}
