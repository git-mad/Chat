package club.gitmad.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 123

    private var userId = ""
    private var userName = ""

    private lateinit var messageAdapter: MessageAdapter
    private var messages: MutableList<Message> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signIn()

        messageAdapter = MessageAdapter(messages)
        rvMessages.adapter = messageAdapter

        Firebase.firestore.collection("messages")
                .addSnapshotListener(EventListener { queryDocumentSnapshots, e ->
                    if (e != null) {
                        Log.e("MainActivity", "Firebase Cloud Firestore - Initial listener", e)
                        return@EventListener
                    }

                    queryDocumentSnapshots?.forEach {
                        val newMessage = it.toObject<Message>()
                        if (!messages.contains(newMessage)) {
                            messages.add(newMessage)
                        }
                    }

                    messages.sortWith { o1, o2 -> o1.time.compareTo(o2.time) }

                    messageAdapter.notifyDataSetChanged()
                    rvMessages.smoothScrollToPosition(messages.size)
                })

        btnSend.setOnClickListener {
            // TODO 1. Get the text of etMessage

            // TODO 2. Create a Message object
            val message = Message(userId, userName)

            // TODO 3. Write to the FirebaseFirestore collection called "messages"
            // https://firebase.google.com/docs/firestore/manage-data/add-data#add_a_document
        }
    }

    private fun signIn() {
        // TODO: If user is logged in, set the userId and userName. Else, log in.
        // https://firebase.google.com/docs/auth/android/firebaseui#kotlin+ktx
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) {
                // TODO: Get the userId and userName and save them to the fields
                // https://firebase.google.com/docs/auth/android/firebaseui#kotlin+ktx_1
            }
        }
    }
}
