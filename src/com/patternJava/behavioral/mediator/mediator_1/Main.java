package com.patternJava.behavioral.mediator.mediator_1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoomImpl();
        User user1 = new ChatUser("Alice", chatRoom);
        User user2 = new ChatUser("Bob", chatRoom);
        User user3 = new ChatUser("Charlie", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Hi, everyone!");
        user2.send("Hey, Alice!");
    }
}
interface ChatRoom {
    void sendMessage(String message, User user);
    
    void addUser(User user);
}

// Concrete mediator implementation
class ChatRoomImpl implements ChatRoom {
    private List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Send message to all users except the sender
            if (u != user) {
                u.receive(message);
            }
        }
    }
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague interface
interface User {
    void send(String message);
    void receive(String message);
}

// Concrete colleague implementation
class ChatUser implements User {
    private String name;
    private ChatRoom chatRoom;

    public ChatUser(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    @Override
    public void send(String message) {
        System.out.println("\n" + name + " sending message: " + message + "\n");
        chatRoom.sendMessage(message, this);
    }
    @Override
    public void receive(String message) {
        System.out.println(name + " received message: " + message);
    }
}