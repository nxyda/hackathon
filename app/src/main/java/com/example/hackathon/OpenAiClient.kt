package com.example.hackathon

import android.util.Log
import okhttp3.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.cdimascio.dotenv.Dotenv
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.concurrent.TimeUnit

object OpenAIClient {
    private val dotenv = Dotenv.configure()
        .directory("app")
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .load()

    private var API_KEY = R.string.api_key
    private const val BASE_URL = "https://api.openai.com/v1/responses"
    private val client = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS) // czas na połączenie
        .readTimeout(60, TimeUnit.SECONDS)    // czas na odczyt danych
        .writeTimeout(60, TimeUnit.SECONDS)   // czas na wysyłanie danych
        .build()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    // --- MODELS ---
    data class Message(val role: String, val content: String)
    data class ChatRequest(
        val model: String = "gpt-5-nano",
        val input: List<Message>,
        val instructions: String?,
        val text: TextRequest = TextRequest("high"),
        val reasoning: ReasoningRequest = ReasoningRequest("minimal")
    )
    data class ChatResponse(
        val id: String,
        val objectType: String?, // "object" w JSON
        val created_at: Long?,
        val status: String?,
        val model: String?,
        val output: List<OutputItem>?
    )

    data class OutputItem(
        val id: String?,
        val type: String?, // "message", "reasoning", itp.
        val role: String?, // "assistant", "user", etc.
        val content: List<ContentItem>?
    )

    data class ContentItem(
        val type: String?, // np. "output_text"
        val text: String?
    )



    // --- FUNKCJA WYŚLIANIA WIADOMOŚCI ---
    fun sendMessage(
        messages: List<Message>,
        instructions: String? = "",
        callback: (ChatResponse?) -> Unit
    ) {
        Log.d("NPC_DEBUG", "API_KEY = $API_KEY")

        val chatRequest = ChatRequest(
            model = "gpt-5-nano",
            input = messages,
            instructions = instructions

        )

        val jsonAdapter = moshi.adapter(ChatRequest::class.java)
        val json = jsonAdapter.toJson(chatRequest)
        val body = json.toRequestBody("application/json".toMediaType())
        Log.d("NPC_DEBUG", "JSON = $json")
        Log.d("NPC_DEBUG", "Hmm")
        Log.d("NPC_DEBUG", BASE_URL)
        val request =
        try {
        Request.Builder()
            .url(BASE_URL)
            .post(body)
            .addHeader("Authorization", "Bearer $API_KEY")
            .build()
        }
        catch (e: Exception){
            Log.e("NPC_DEBUG", e.message + "")
            callback(null) // od razu kończymy funkcję
            return
        }

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
                Log.e("NPC_DEBUG", "Nie działa")
                Log.e("NPC_DEBUG", e.message+"")
                callback(null)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d("NPC_DEBUG", "IDK" + response.code)
                if (!response.isSuccessful) {
                    callback(null)
                    return
                }
//                Log.d("NPC_DEBUG",response.body?.string() + "")
                response.body?.string()?.let { json ->
                    try {
                        val responseAdapter = moshi.adapter(ChatResponse::class.java)
                        val chatResponse = responseAdapter.fromJson(json)
                        callback(chatResponse)
                    } catch (e: Exception) {
                        Log.e("NPC_DEBUG", "JESON ERRor ${e.message}")
                        e.printStackTrace()
                        callback(null)
                    }
                } ?: callback(null)
            }
        })
    }

}

class TextRequest (
    val verbosity: String
)
class ReasoningRequest (
    val effort: String
)

