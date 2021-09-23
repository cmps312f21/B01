package com.cmps312.myapplication.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar() {
    var searchText by remember {
        mutableStateOf("")
    }

    Box() {
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colors.secondary)
            },
            trailingIcon = {
                if (searchText.isNotEmpty())
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = MaterialTheme.colors.secondary,
                        modifier = Modifier.clickable { searchText = "" }
                    )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary),
            textStyle = TextStyle(MaterialTheme.colors.secondary)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    SearchBar()
}