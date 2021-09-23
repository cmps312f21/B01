package com.cmps312.bankingapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route : String, val title : String, val icon: ImageVector){
    object Home : Screen(route = "home", title = "Home", icon = Icons.Outlined.Home)
    object AccountDetail : Screen(route = "accountDetail", title = "Account Detail", icon = Icons.Outlined.Home)
    object FundTransfer : Screen(route = "fundTransfer", title = "Fund Transfer", icon = Icons.Outlined.Home)
    object Confirmation : Screen(route = "confirmation", title = "Confirmation", icon = Icons.Outlined.Home)
}
