package com.omeriyioz.marvel.features.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.omeriyioz.marvel.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_compose_view) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_compose_view, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

                val id = arguments?.getString("id")

                CharacterDetailScreen(id)
            }
        }
    }
}