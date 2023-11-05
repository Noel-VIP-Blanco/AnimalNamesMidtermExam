package com.blanco.animal.midterm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blanco.animal.midterm.databinding.AnimalItemBinding
import com.blanco.animal.midterm.models.Animals

class AnimalAdapter(private val animals : List<Animals>, private val onItemClick: (Animals) -> Unit) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(
        private val binding: AnimalItemBinding,
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(animal: Animals) {
            with(binding) {
               animalName.text = animal.name
            }

            // Set a click listener for the entire row
            binding.root.setOnClickListener {
                onItemClick(animal)
            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnimalItemBinding.inflate(
            inflater,
            parent,
            false,
        )
        return AnimalViewHolder(binding)
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(
        holder: AnimalViewHolder,
        position: Int,
    ) {
        holder.bind(animals[position])
    }
}