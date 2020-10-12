package club.gitmad.chat

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.android.synthetic.main.activity_main.*

import java.lang.reflect.Array
import java.util.ArrayList
import java.util.Collections
import java.util.Comparator
import java.util.HashSet
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var messageAdapter: MessageAdapter
    private var messages: MutableList<Message> = mutableListOf()

    private var currMessage: Message = Message()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageAdapter = MessageAdapter(messages)
        rvMessages.adapter = messageAdapter

        FirebaseFirestore.getInstance().collection("messages")
                .addSnapshotListener(EventListener { queryDocumentSnapshots, e ->
                    if (e != null) {
                        Log.e("MainActivity", "Firebase Cloud Firestore - Initial listener", e)
                        return@EventListener
                    }

                    queryDocumentSnapshots?.forEach {
                        val newMessage = it.toObject(Message::class.java)
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
            // You only need to set the message!

            // TODO 3. Write to the FirebaseFirestore collection called "messages"
            // https://firebase.google.com/docs/firestore/manage-data/add-data#add_a_document
        }
    }

    companion object {
        val userId = UUID.randomUUID().toString()
    }
}
