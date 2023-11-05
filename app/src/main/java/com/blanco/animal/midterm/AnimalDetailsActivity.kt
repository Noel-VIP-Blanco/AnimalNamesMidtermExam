package com.blanco.animal.midterm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blanco.animal.midterm.databinding.ActivityAnimalDetailsBinding

class AnimalDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAnimalDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.animalName.text =  intent.getStringExtra("NAME_PARAMS")
        binding.animalDetail.text =  intent.getStringExtra("DETAIL_PARAMS")

        binding.blockTheAnimalButton.setOnClickListener{
            val sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE)
            val blockedAnimalIds = sharedPreferences.getStringSet("blocked_animals", mutableSetOf())?.toMutableSet() ?: mutableSetOf()

            val animalId = intent.getStringExtra("ID_PARAMS")
            animalId?.let {
                blockedAnimalIds.add(it)
                val editor = sharedPreferences.edit()
                editor.putStringSet("blocked_animals", blockedAnimalIds)
                editor.apply()
            }

            val intent = Intent(this, AnimalNamesActivity::class.java)
            startActivity(intent)
        }

    }
}