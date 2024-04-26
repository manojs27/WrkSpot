package com.manoj.wrkspot.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.manoj.wrkspot.data.model.Country
import com.manoj.wrkspot.presentation.viewmodel.CountryViewModel

@Composable
fun CountryListScreen() {
    val viewModel: CountryViewModel = hiltViewModel()
    var searchQuery by remember { mutableStateOf(TextFieldValue()) }

    val users by viewModel.countryList.collectAsState(initial = emptyList())
    Column(modifier = Modifier.fillMaxSize()) {
        AppTopBar(
            text = "WrkSpot"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search TextField
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Country list
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(users.filter {
                    it.name.contains(
                        searchQuery.text, ignoreCase = true
                    )
                }) { country ->
                    CountryListItem(country = country)
                }
            }
        }
    }
}

@Composable
fun CountryListItem(country: Country) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                ImageFromURL(country.flag)
                Spacer(modifier = Modifier.padding(end = 20.dp))
                Text(text = country.name, modifier = Modifier.align(Alignment.Start))
            }
            Column(
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .weight(1f)
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Capital:" + country.capital,
                    modifier = Modifier.align(Alignment.End),
                    color = Color.Blue,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Currency:" + country.currency,
                    modifier = Modifier.align(Alignment.End),
                    color = Color.Blue,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Population:" + country.population,
                    modifier = Modifier.align(Alignment.End),
                    color = Color.Blue,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}