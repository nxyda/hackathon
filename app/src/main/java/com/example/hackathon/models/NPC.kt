package com.example.hackathon.models

import com.example.hackathon.actions.Action

data class NPC(
    val id: Int,
    val name: String,
    val job: String,
    val type: String,
     val relation: Relation,
     val actions: List<Action>,
    val gender: GenderEnum

)

