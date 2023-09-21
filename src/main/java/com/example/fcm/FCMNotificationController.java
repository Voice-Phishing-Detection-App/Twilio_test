package com.example.fcm;

import com.example.user.UserRepository;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class FCMNotificationController {

    @Autowired
    private FCMNotificationService fcmNotificationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/trigger")
    public ResponseEntity<?> trigger(@RequestBody IncomingDto incomingDto) throws FirebaseMessagingException {
        String fcmToken = userRepository.findByPhoneNumber(incomingDto.getPhoneNumber()).orElseThrow().getFcmToken();
        System.out.println("fcmToken = " + fcmToken);
        fcmNotificationService.sendPushNotification(fcmToken);
        return new ResponseEntity(HttpStatus.OK);
    }

}
