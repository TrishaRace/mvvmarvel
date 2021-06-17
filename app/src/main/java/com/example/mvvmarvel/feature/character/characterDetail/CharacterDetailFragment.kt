package com.example.mvvmarvel.feature.character.characterDetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.characters.R
import com.example.characters.databinding.FragmentCharacterDetailBinding
import com.example.characters.models.view.CharacterView
import com.example.extensions.viewBinding
import com.example.platform.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class CharacterDetailFragment : BaseFragment(R.layout.fragment_character_detail) {

    private val binding by viewBinding<FragmentCharacterDetailBinding>()
    private val arguments by navArgs<CharacterDetailFragmentArgs>()
    private val characterDetailViewModel by viewModel<CharacterDetailViewModel>()


    private val character by lazy(LazyThreadSafetyMode.NONE) { arguments.character }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(characterDetailViewModel) {
            characterDetail.observe(viewLifecycleOwner, ::handleCharacter)
            showSpinner.observe(viewLifecycleOwner, ::showLoading)
            failure.observe(viewLifecycleOwner, ::showError)
        }
        characterDetailViewModel.getCharacterDetail(character.id)
    }

    private fun handleCharacter(characterDetail: CharacterView){
        with(binding) {
            with(image) {
                com.bumptech.glide.Glide.with(context.applicationContext)
                    .load(characterDetail.image)
                    .transition(com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade())
                    .into(this)
            }
            name.text = characterDetail.name
            info1.text = characterDetail.description
        }
    }
}

