package com.example.fcm;

import com.google.firebase.messaging.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FCMNotificationService {

    public void sendPushNotification(String fcmToken) throws FirebaseMessagingException {
        Message message = Message.builder()
                .putData("call", "incoming")
                .setToken(fcmToken)
                .build();

        String response = FirebaseMessaging.getInstance().send(message);

        System.out.println("Successfully sent message: " + response);
    }

}
