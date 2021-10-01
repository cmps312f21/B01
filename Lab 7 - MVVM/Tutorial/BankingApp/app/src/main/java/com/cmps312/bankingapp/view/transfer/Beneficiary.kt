package com.cmps312.bankingapp.view.transfer

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.viewmodel.BankingViewModel

//Todo add the params
@Composable
fun Beneficiary(onSelectedBeneficiary: () -> Unit) {
    val bankingViewModel =
        viewModel<BankingViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)
    //Todo declare the viewmodel
    val beneficiaries = bankingViewModel.beneficiaries

    LazyColumn {
        items(beneficiaries) { beneficiary ->
            BeneficiaryCard(beneficiary, onSelectedBeneficiary = {
                //Todo , add the beneficiary details to the newTransfer inside the view model

                bankingViewModel.newTransfer.apply {
                    beneficiaryName = beneficiary.name
                    beneficiaryAccountNo = beneficiary.accountNo
                }
                onSelectedBeneficiary()

            })
        }
    }
}

@Composable
fun BeneficiaryCard(beneficiary: Beneficiary, onSelectedBeneficiary: () -> Unit) {
    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onSelectedBeneficiary() }) {
        Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Outlined.Person, contentDescription = "Person Image")
            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Name : ${beneficiary.name}")
                Text(text = "AccountNo : ${beneficiary.accountNo}")
            }
        }
    }
}

