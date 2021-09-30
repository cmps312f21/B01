package com.cmps312.bankingapp.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import com.cmps312.bankingapp.model.Transfer
import com.cmps312.bankingapp.repository.BankingRepository

class BankingViewModel(appContext: Application) : AndroidViewModel(appContext) {

    val bankingRepository = BankingRepository(appContext)

    val account by lazy { bankingRepository.getAccounts() }
    val beneficiaries by lazy { bankingRepository.getBeneficiaries() }

    //mutable list
    val transfers = mutableStateListOf<Transfer>(*bankingRepository.getTransfer().toTypedArray())

    //object
    lateinit var selectedTransfer : Transfer

    fun addTransfer(newTransfer: Transfer){
        transfers.add(newTransfer)
    }
}
