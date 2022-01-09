package com.danielg07.rickandmorty.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielg07.rickandmorty.network.Result
import com.danielg07.rickandmorty.network.RickAndMortyApi
import kotlinx.coroutines.launch
import java.lang.Exception



class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<String>()
    private val _items = MutableLiveData<List<Result>>()

    val status: LiveData<String> = _status
    val items : LiveData<List<Result>> = _items

    init {
        getItems()
    }

    private fun getItems(){
        viewModelScope.launch {
            try {
                _items.value = RickAndMortyApi.retrofitService.getCharacter().results
                Log.i("RIcKChido","Success: Items properties retireved")

            }catch (e: Exception){
                Log.e("Rick", "Failure: ${e.message}")

            }
        }
    }
}