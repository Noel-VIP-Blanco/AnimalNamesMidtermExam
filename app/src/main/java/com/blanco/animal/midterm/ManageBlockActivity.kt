package com.blanco.animal.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blanco.animal.midterm.adapters.BlockedAnimalAdapter
import com.blanco.animal.midterm.data.AnimalRepository
import com.blanco.animal.midterm.databinding.ActivityManageBlockBinding
import com.blanco.animal.midterm.models.Animals

class ManageBlockActivity : AppCompatActivity() {
    private lateinit var binding : ActivityManageBlockBinding
    private lateinit var animalRepository: AnimalRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animalRepository = AnimalRepository()
        val animalsList = animalRepository.getAnimalsList()

        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val blockedAnimalIds = sharedPreferences.getStringSet("blocked_animals", emptySet()) ?: emptySet()

        val filteredAnimalsList = animalsList.map { animal ->
            animal.copy(isBlocked = animal.id.toString() in blockedAnimalIds)
        }.filter { it.isBlocked }

        val adapter = BlockedAnimalAdapter(filteredAnimalsList, ::unBlockAnimal)
        binding.blockedAnimalListRecyclerView.adapter = adapter
        binding.blockedAnimalListRecyclerView.layoutManager = LinearLayoutManager(this)


    }

    private fun unBlockAnimal(animal: Animals) {
        // Handle the item click here
        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val blockedAnimalIds = sharedPreferences.getStringSet("blocked_animals", emptySet())?.toMutableSet() ?: mutableSetOf()
        blockedAnimalIds.remove(animal.id.toString())

        // Save the modified set back to SharedPreferences
        sharedPreferences.edit().putStringSet("blocked_animals", blockedAnimalIds).apply()


    }
}