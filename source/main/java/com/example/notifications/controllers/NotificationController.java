package com.example.notifications.controllers;

import com.example.notifications.models.Notification;
import com.example.notifications.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<?> createNotification(@RequestBody Notification notification) {
        notificationService.createNotification(notification);
        return ResponseEntity.ok(notification);
    }

    @PostMapping("/update/{news_id}")
    public ResponseEntity<?> updateNotification(@PathVariable Long news_id, @RequestBody Notification notification) {
        notificationService.updateNotification(news_id, notification);
        return ResponseEntity.ok(notification);
    }

    @PostMapping("/delete/{news_id}")
    public ResponseEntity<?> deleteNotification(@PathVariable Long news_id) {
        notificationService.deleteNotification(news_id);
        return ResponseEntity.ok("Notification deleted successfully");
    }

    @GetMapping("/me")
    public ResponseEntity<?> getNotificationsByUser() {
        return ResponseEntity.ok(notificationService.getUserNotifications());
    }

    @GetMapping("/type/{type_id}")
    public ResponseEntity<?> getNotificationsByType(@PathVariable Long type_id) {
        return ResponseEntity.ok(notificationService.getNotificationsByType(type_id));
    }
}