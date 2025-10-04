package com.example.hackathon.models


data class StatsModification(
    var health: Int = 0,
    var education: EducationEnum? = null,
    var career: String? = null,
    var income: Int = 0,
    var happiness: Int = 0,
    var retiring: Int = 0,
    var successPoint: Int = 0,
    var live: String? = null
)
