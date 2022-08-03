package com.example.homework132

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    val viewState: MutableLiveData<ViewState> = MutableLiveData()

    private fun currentViewState(): ViewState = viewState.value!!

    init {
        viewState.value = ViewState()
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.getDeliveryService().getItems()
            if (response.isSuccessful) {
                viewState.postValue(
                    currentViewState().copy(
                        isSuccessful = true,
                        itemData = response.body()
                    )
                )
            } else {
                viewState.postValue(
                    currentViewState().copy(
                        isSuccessful = true,
                        error = response.errorBody().toString()
                    )
                )
            }
        }
    }

    data class ViewState(
        val itemData: ItemModel? = null,
        val error: String? = null,
        val isSuccessful: Boolean? = null
    )
}