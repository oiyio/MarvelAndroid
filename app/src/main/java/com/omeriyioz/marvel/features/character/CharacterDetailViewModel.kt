package com.omeriyioz.marvel.features.character

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
class CharacterDetailViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _characterListDTO = MutableLiveData<CharacterListDTO>()
    val characterListDTO: LiveData<CharacterListDTO>
        get() = _characterListDTO

    fun getCharacter(id: String?) {
        viewModelScope.launch {
            try {
                _characterListDTO.value = repository.getCharacter(id!!)
                Log.d("omertest", "size :" + _characterListDTO.value!!.copyright)
            } catch (e: Exception) {
                Log.d("omertest", "Exception : $e")
            }
        }
    }
}
