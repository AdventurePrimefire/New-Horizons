package chatroom;

public abstract class ChatListener {
private ChatRoom room;
public ChatListener() {
    this.room = null;
}
public ChatListener(ChatRoom room){
    this.room = room;
}
/**
 * This method is called whenever the action is performed.
 */
public abstract void actionPerformed();

/**
 * Writes a message to the chat room.
 */
public abstract void message(Message message);
}
