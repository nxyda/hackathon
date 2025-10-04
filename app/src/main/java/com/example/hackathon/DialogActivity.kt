package com.example.hackathon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hackathon.models.Action
import com.example.hackathon.models.NPCModel
import com.example.hackathon.models.Relation
import com.example.hackathon.models.RelationTrait
import com.example.hackathon.ui.theme.HackathonTheme

class DialogActivity : ComponentActivity() {
    val exampleNPC = NPCModel(
        id = -1,
        name = "Zosia",
        job = "Bankier",

        type = "Friend",
        relation = Relation(romantic = 30, friendship = 60, trait = RelationTrait.SHY),
        actions = listOf(
            Action("Chciałbym wziąć kredyt", "friendship+5"),
            Action("Chciałbym założyć lokate", "friendship+5"),
            Action("Zainwestowałbym w obligacje", "friendship+5"),
        ),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            HackathonTheme {
                var npcText by remember { mutableStateOf("Witaj podróżniku!") }
                val npc = exampleNPC
                NpcDialogScreen(
                    npcName = npc.name,
                    npcImage = R.drawable.jpg, // daj swój obrazek w drawable
                    dialogOptions = npc.actions,
                    onOptionSelected = { option ->
                        Log.d("NPC_DEBUG","Niceee")
                        getResponse(npc, option) { newText ->
                            npcText = newText
                        }
                    },

                    currentText = npcText
                )

            }
        }
    }
}

private fun DialogActivity.getResponse(
    npc: NPCModel,
    option: Action,
    callback: (String) -> Unit
) {
    val history = mutableListOf(
        OpenAIClient.Message("system", "Jestem Piotr i jestem klientem banku"),
        OpenAIClient.Message("user", "Mówię: ${option.name}"),
    )

    OpenAIClient.sendMessage(
        messages = history,
        instructions = "Jesteś ${npc.name} właśnie rozmawiasz z osobą która przyszła do ciebie coś i masz się wcielić w role ${npc.job} o usposobieniu ${npc.relation.trait} zinterpretuj to według siebie, udawaj człowieka odpowiadaj tylko jak człowiek. Użytkownik wyśle ci swoją wiadomosć w formacie Mówie: {Zdanie na które muze odpowiedzieć}. Nie zdaradzaj że jesteś ai, nie zadawaj pytań. Aboslutnie nie zadawaj żadnych pytań. Odpowiedz twierdzaco pozytywnie, nie precyzuj niczego, konwersacja kończy się po twojej wypowiedzi, zostanie wyświetlona jako dialog z npc w grze, nie podpisuj się"
    ) { response ->
        val reply = response?.output?.lastOrNull()?.content?.firstOrNull()?.text ?: "Hmm..."
        history.add(OpenAIClient.Message("assistant", reply))

        runOnUiThread {
            callback(reply)
        }
    }
}

@Composable
fun NpcDialogScreen(
    npcName: String,
    npcImage: Int,
    dialogOptions: List<Action>,
    onOptionSelected: (Action) -> Unit,
    currentText: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // NPC obrazek + przyciski dookoła
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = npcImage),
                contentDescription = npcName,
                modifier = Modifier
//                    .size(150.dp)
                    .align(Alignment.TopCenter)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 20.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { onOptionSelected(dialogOptions[0]) }) {
                        Text(dialogOptions[0].name)
                    }
                    if (dialogOptions.size > 1) {
                        Button(onClick = { onOptionSelected(dialogOptions[1]) }) {
                            Text(dialogOptions[1].name)
                        }
                    }
                }
                if (dialogOptions.size > 2) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = { onOptionSelected(dialogOptions[2]) }) {
                            Text(dialogOptions[2].name)
                        }
                        if (dialogOptions.size > 3) {
                            Button(onClick = { onOptionSelected(dialogOptions[3]) }) {
                                Text(dialogOptions[3].name)
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Tekst NPC
        Text(
            text = currentText,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HackathonTheme {
        var npcText by remember { mutableStateOf("Witaj podróżniku!") }

        NpcDialogScreen(
            npcName = "Strażnik",
            npcImage = R.drawable.jpg, // daj swój obrazek w drawable
            dialogOptions = listOf(),
            onOptionSelected = { option ->
                npcText = "NPC odpowiada na: $option"
            },
            currentText = npcText
        )
    }
}