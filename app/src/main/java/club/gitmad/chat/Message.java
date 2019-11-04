package club.gitmad.chat;

import androidx.annotation.Nullable;

public class Message {
    private String id;
    private String message;
    private String sender;
    private long time;

    Message(String id, String message, String sender, long time) {
        this.id = id;
        this.message = message;
        this.sender = sender;
        this.time = time;
    }

    public Message() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof Message) && id.equals(((Message) obj).id);
    }
}
