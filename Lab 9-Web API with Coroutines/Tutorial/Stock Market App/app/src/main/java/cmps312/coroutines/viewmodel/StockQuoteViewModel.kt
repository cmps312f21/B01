package cmps312.coroutines.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cmps312.coroutines.model.StockQuote
import cmps312.coroutines.webapi.SimulatedStockQuoteService
import kotlinx.coroutines.launch

enum class JobState {
    RUNNING,
    SUCCESS,
    CANCELLED
}

class StockQuoteViewModel : ViewModel() {
    private val stockQuoteService = SimulatedStockQuoteService()

    var companyList = mutableStateListOf<String>()
    var selectedCompany by mutableStateOf("")

    var jobStatusGetStockQuote by mutableStateOf(JobState.SUCCESS)
    var stockQuote by mutableStateOf(StockQuote())
    var errorMessage by mutableStateOf("")

    // Auto initialize the companies list
    init {
        // ToDo: Implement this method
        throw NotImplementedError("Implement this method.")
    }

    fun getStockQuote() {
        // ToDo: Implement this method
        throw NotImplementedError("Implement this method.")
    }

    suspend fun getCompanies() {
        // ToDo: Implement this method
        throw NotImplementedError("Implement this method.")
    }
}