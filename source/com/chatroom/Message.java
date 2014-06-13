package chatroom;

public class Message<T> {
private ChatListener sender;
private ChatRoom[] recevers;
private T message;
private boolean sent;

public Message(T message, ChatListener sender) {
    this.message = message;
}

public Message(T message, ChatListener sender, ChatRoom... recevers) {
    this.message = message;
    this.sender = sender;
    this.recevers = recevers;
}
/**
 * 
 * @return the message.
 */
public T getMessage() {
    return this.message;
}
/**
 * 
 */
public String toString(){
    String out = sender.toString()+"{";
    out += this.message + "}";
    return out;
}
}
