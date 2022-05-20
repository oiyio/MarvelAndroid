package com.omeriyioz.marvel.features.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.omeriyioz.marvel.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.fragment_compose_view, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {

                CharacterListScreen() {
                    val bundle = bundleOf("id" to it)
                    findNavController().navigate(R.id.action_character_list_to_character_detail, bundle)
                }
            }
        }
    }

}
