package com.cmps312.bankingapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.ConfirmationNumber
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Payment
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route : String, val title : String, val icon: ImageVector){
    object Home : Screen(route = "home", title = "Home", icon = Icons.Outlined.Home)
    object AccountDetail : Screen(route = "accountDetail", title = "Account Detail", icon = Icons.Outlined.AccountBalance)
    object FundTransfer : Screen(route = "fundTransfer", title = "Fund Transfer", icon = Icons.Outlined.Payment)
    object Confirmation : Screen(route = "confirmation", title = "Confirmation", icon = Icons.Outlined.ConfirmationNumber)
}
