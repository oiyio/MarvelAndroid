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

    private val _repoDTOList = MutableLiveData<CharacterListDTO>()
    val repoDTOList: LiveData<CharacterListDTO>
        get() = _repoDTOList

    init {
        getRepoDTOList()
    }

    private fun getRepoDTOList() {
        viewModelScope.launch {
            try {
                _repoDTOList.value = repository.getRepoDTOList("oiyio")
                Log.d("omertest", "size :" + _repoDTOList.value!!.copyright)
            } catch (e: Exception) {
                Log.d("omertest", "Exception : $e")
            }
        }
    }
}
