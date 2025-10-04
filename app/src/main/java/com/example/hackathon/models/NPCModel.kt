package com.example.hackathon.models

data class NPCModel(
    val id: Int,
    val name: String,
    val job: String,
    val type: String,
    val relation: Relation,
    val actions: List<Action>
)

data class Relation (
    val romantic: Int,
    val friendship: Int,
    val trait: RelationTrait
)

enum class RelationTrait {
    KIND,           // przyjacielski, łatwo łapie więzi
    AGGRESSIVE,     // szybko się wkurza, chętniej walczy
    SHY,            // ciężko budować relację, ale potem lojalny
    AMBITIOUS,      // skupiony na sobie, trudny w romantyzmie
    LOYAL,          // stabilny w przyjaźni i romansie
    CHAOTIC,        // zachowuje się losowo, trudny do przewidzenia
    GREEDY,         // relacje zależne od korzyści
    WISE            // doradza, stabilizuje innych NPC
}

data class Action(
    val name: String,
    val effect: String
)
