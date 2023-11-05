package com.blanco.animal.midterm.data

import com.blanco.animal.midterm.models.Animals

class AnimalRepository{

    fun getAnimalsList(): List<Animals> {
        // Retrieve animalsList from SharedPreferences or any other data source
        // For example, you can read the animals data from a JSON file, a database, or an API.
        // For demonstration purposes, returning a sample list.
        // Replace this with the logic to fetch animals from your desired data source.
        return listOf(
            Animals(1, "Ant", "Ant details", true),
            Animals(2, "Bat", "Bat details", true),
            Animals(3, "Cat", "Cat details", false),
            Animals(4, "Dog", "Dog details", false),
            Animals(5, "Elephant", "Elephant details", false),
            Animals(6, "Fox", "Fox details", false),
            Animals(7, "Giraffe", "Giraffe details", false),
            Animals(8, "Horse", "Horse details", false),
            Animals(9, "Iguana", "Iguana details", false),
            Animals(10, "Jaguar", "Jaguar details", false),
            Animals(11, "Kangaroo", "Kangaroo details", false),
            Animals(12, "Lion", "Lion details", false),
            Animals(13, "Monkey", "Monkey details", false),
            Animals(14, "Newt", "Newt details", false),
            Animals(15, "Ostrich", "Ostrich details", false),
            Animals(16, "Penguin", "Penguin details", false),
            Animals(17, "Quokka", "Quokka details", false),
            Animals(18, "Raccoon", "Raccoon details", false),
            Animals(19, "Sloth", "Sloth details", false),
            Animals(20, "Tiger", "Tiger details", false),
            Animals(21, "Uakari", "Uakari details", false),
            Animals(22, "Vulture", "Vulture details", false),
            Animals(23, "Walrus", "Walrus details", false),
            Animals(24, "X-ray Tetra", "X-ray Tetra details", false),
            Animals(25, "Yak", "Yak details", false),
            Animals(26, "Zebra", "Zebra details", false)
        )
    }

}