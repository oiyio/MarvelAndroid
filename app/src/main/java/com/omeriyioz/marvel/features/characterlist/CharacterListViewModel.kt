package com.omeriyioz.marvel.features.characterlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omeriyioz.data.network.MarvelRepository
import com.omeriyioz.data.network.models.CharacterListDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _characterListDTO = MutableLiveData<CharacterListDTO>()
    val characterListDTO: LiveData<CharacterListDTO>
        get() = _characterListDTO

    init {
        getCharacterList()
    }

    private fun getCharacterList() {

        viewModelScope.launch {
            try {
                _characterListDTO.value = repository.getCharacterList()
                Log.d("omertest", "size :" + _characterListDTO.value!!.status)
            } catch (exception: Exception) {
                Log.d("omertest", "characterList - exception ${exception.message}")
            }
        }
    }
}
