package chatroom;

public abstract class ChatRoom {
/**
 * Adds a the listener to the chatroom so it can get messages.
 */
public abstract void addChatListener(ChatListener listener);
/**
 * 
 * @return the decoder the chatroom is using.
 */
//public abstract Decoder getDecoder();
//public abstract ChatBox getChatBox(ChatListener listener);
}
