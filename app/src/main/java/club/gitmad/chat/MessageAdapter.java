package club.gitmad.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private List<Message> messages;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        TextView tvSender;

        ViewHolder(View view) {
            super(view);
            this.tvMessage = view.findViewById(R.id.tvMessage);
            this.tvSender = view.findViewById(R.id.tvSender);
        }

        private void setMessage(Message message) {
            tvMessage.setText(message.getMessage());
            tvSender.setText(message.getSender());
        }

    }

    MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_message, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setMessage(messages.get(position));
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
