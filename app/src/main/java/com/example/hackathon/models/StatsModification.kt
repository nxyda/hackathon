package com.example.hackathon.models


data class StatsModification(
    var cost: Int = 0,
    var healthChange: Int = 0,
    var education: EducationEnum? = null,
    var income: Int = 0,
    var happiness: Int = 0,
    var live: String? = null,
    var npc: NPC? = null,
    var relationChange: Int = 0,
    var friendshipChange: Int = 0
)
