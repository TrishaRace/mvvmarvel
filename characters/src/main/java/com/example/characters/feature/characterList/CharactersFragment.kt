package com.example.characters.feature.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.characters.models.view.CharacterView
import com.example.characters.R
import com.example.characters.databinding.FragmentCharactersBinding
import com.example.characters.feature.characterList.adapters.CharactersAdapter
import com.example.extensions.viewBinding
import org.koin.android.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private val binding by viewBinding<FragmentCharactersBinding>()
    private val characterViewModel by viewModel<CharactersViewModel>()
    private val charactersAdapter by lazy { CharactersAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_characters, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(characterViewModel) {
            characters.observe(viewLifecycleOwner,::handleCharacters)
            showLoading.observe(viewLifecycleOwner, ::showLoading)
            failure.observe(viewLifecycleOwner,::showError)
        }
        initView()
        getData()
    }

    private fun initView() {
        binding.characterList.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = charactersAdapter
        }
    }


    private fun getData() {
        characterViewModel.getCharacters()
    }

    private fun handleCharacters(charactersView: List<CharacterView>) {
        charactersView.let {
            val list = charactersAdapter.collection.toMutableList()
            list.addAll(it.toMutableList())
            charactersAdapter.collection = list
        }
    }

    private fun showLoading() = {}//TODO
    private fun showError() = {}//TODO

}