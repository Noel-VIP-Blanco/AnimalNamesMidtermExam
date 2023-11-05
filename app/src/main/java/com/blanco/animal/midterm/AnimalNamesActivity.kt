package com.blanco.animal.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.blanco.animal.midterm.adapters.AnimalAdapter
import com.blanco.animal.midterm.data.AnimalRepository
import com.blanco.animal.midterm.databinding.ActivityAnimalNamesBinding
import com.blanco.animal.midterm.models.Animals

class AnimalNamesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAnimalNamesBinding
    private lateinit var animalRepository: AnimalRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalNamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animalRepository = AnimalRepository()
        val animalsList = animalRepository.getAnimalsList()

        val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
        val blockedAnimalIds = sharedPreferences.getStringSet("blocked_animals", emptySet()) ?: emptySet()

        val filteredAnimalsList = animalsList.map { animal ->
            animal.copy(isBlocked = animal.id.toString() in blockedAnimalIds)
        }.filter { !it.isBlocked }



        val adapter = AnimalAdapter(filteredAnimalsList, ::onItemClick)
        binding.animalListRecyclerView.adapter = adapter
        binding.animalListRecyclerView.layoutManager = LinearLayoutManager(this)

        binding.goToBlockButton.setOnClickListener{
            val intent = Intent(this, ManageBlockActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onItemClick(item: Animals) {
        // Handle the item click here
        val intent = Intent(this, AnimalDetailsActivity::class.java).apply {
            putExtra("ID_PARAMS", item.id.toString())
            putExtra("NAME_PARAMS", item.name)
            putExtra("DETAIL_PARAMS", item.details)
        }
        startActivity(intent)
    }
}