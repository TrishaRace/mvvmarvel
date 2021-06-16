package com.example.characters.feature.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.R
import com.example.characters.databinding.FragmentCharactersBinding
import com.example.characters.feature.characterList.adapters.CharactersAdapter
import com.example.characters.models.view.CharacterView
import com.example.exception.Failure
import com.example.extensions.viewBinding
import com.example.mvvmarvel.MainActivity
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
            showSpinner.observe(viewLifecycleOwner,::showLoading )
            failure.observe(viewLifecycleOwner,::showError)
        }
        initView()
        getData()
        charactersAdapter.characterListener = {characterView, view ->

            (activity as MainActivity).replaceFragment(FragmentB.newInstance(), "fragmentB")
        }
    }

    private fun initView() {
        binding.characterList.apply {
            layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false )
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

    private fun showLoading(showLoading :Boolean) = {}//TODO
    private fun showError(failure: Failure) = {}//TODO

}