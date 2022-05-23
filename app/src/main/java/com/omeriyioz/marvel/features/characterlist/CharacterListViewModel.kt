package com.omeriyioz.marvel.features.characterlist

import androidx.lifecycle.ViewModel
import com.omeriyioz.data.network.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    repository: MarvelRepository
) : ViewModel() {

    val getAllImages = repository.getCharacterListPaginated()
}
