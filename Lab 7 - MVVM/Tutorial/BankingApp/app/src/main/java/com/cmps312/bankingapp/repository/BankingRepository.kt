package com.cmps312.bankingapp.repository

import android.content.Context
import com.cmps312.bankingapp.model.Account
import com.cmps312.bankingapp.model.Beneficiary
import com.cmps312.bankingapp.model.Transfer
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class BankingRepository(private val context: Context) {

    fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

    fun getTransfer() = Json.decodeFromString<List<Transfer>>(readData("transfers.json"))
    fun getBeneficiaries() =
        Json.decodeFromString<List<Beneficiary>>(readData("beneficiaries.json"))
    fun getAccounts() =
        Json.decodeFromString<List<Account>>(readData("accounts.json"))
}