package model;

/**
 * Created by Vardan on 03.07.2017.
 */
public class Message {
    private long id;
    private long fromUserId;
    private long toUserId;
    private String timeStamp;
    private String description;

    public Message() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (fromUserId != message.fromUserId) return false;
        if (toUserId != message.toUserId) return false;
        if (timeStamp != null ? !timeStamp.equals(message.timeStamp) : message.timeStamp != null) return false;
        return description != null ? description.equals(message.description) : message.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (fromUserId ^ (fromUserId >>> 32));
        result = 31 * result + (int) (toUserId ^ (toUserId >>> 32));
        result = 31 * result + (timeStamp != null ? timeStamp.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", timeStamp='" + timeStamp + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
