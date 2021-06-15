package com.example.characters.feature.characterList.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.characters.models.view.CharacterView
import com.example.characters.R
import com.example.characters.databinding.ItemViewCharacterBinding
import kotlin.properties.Delegates

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterListViewHolder>() {

    internal var collection: List<CharacterView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }
    internal var characterListener: (CharacterView, View) -> Unit =
        { _: CharacterView, _: View -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CharacterListViewHolder(LayoutInflater.from(parent.context).inflate( R.layout.item_view_character,parent,false))


    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(collection[position], characterListener)
    }

    inner class CharacterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemViewCharacterBinding.bind(itemView)

        fun bind(item: CharacterView, characterListener: (CharacterView, View) -> Unit) {
            binding.name.text = item.name
            with(binding.image) {
                Glide.with(context.applicationContext)
                    .load(item.resourceURI)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(this)
            }

        }
    }
}
