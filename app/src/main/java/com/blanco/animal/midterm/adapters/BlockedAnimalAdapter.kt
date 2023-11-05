package com.blanco.animal.midterm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blanco.animal.midterm.databinding.BlockedAnimalItemBinding
import com.blanco.animal.midterm.models.Animals

class BlockedAnimalAdapter (private var animals : List<Animals>, private val unblockAnimal: (Animals) -> Unit): RecyclerView.Adapter<BlockedAnimalAdapter.BlockAnimalViewHolder>(){

    inner class BlockAnimalViewHolder(
        private val binding: BlockedAnimalItemBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animals) {
            with(binding) {
                animalName.text = animal.name

                unblockButton.setOnClickListener{
                    unblockAnimal(animal)
                }

            }

        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BlockAnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BlockedAnimalItemBinding.inflate(
            inflater,
            parent,
            false,
        )
        return BlockAnimalViewHolder(binding)
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(
        holder: BlockAnimalViewHolder,
        position: Int,
    ) {
        holder.bind(animals[position])
    }
}