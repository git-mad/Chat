package club.gitmad.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_message.view.*

class MessageAdapter(private val messages: MutableList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindMessage(message: Message) {
            containerView.tvMessage.text = message.message
            containerView.tvSender.text = message.sender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_message, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMessage(messages[position])
    }

    override fun getItemCount() = messages.size
}
