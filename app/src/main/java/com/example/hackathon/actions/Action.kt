package com.example.hackathon.actions

import com.example.hackathon.models.StatsModification

data class Action(
    val visibleName: String,
    val description: String, // For ai
    val nextActionChooser: (() -> ActionResult)? = null,
    val statsModification: StatsModification
)