package com.example.notifications.controllers;

import com.example.notifications.models.NotificationType;
import com.example.notifications.services.NotificationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/type")
public class NotificationTypeController {

    @Autowired
    private NotificationTypeService typeService;

    @PostMapping("/create")
    public ResponseEntity<?> createNotificationType(@RequestBody NotificationType type) {
        typeService.createType(type);
        return ResponseEntity.ok(type);
    }

    @PostMapping("/update/{type_id}")
    public ResponseEntity<?> updateNotificationType(@PathVariable Long type_id, @RequestBody NotificationType type) {
        typeService.updateType(type_id, type);
        return ResponseEntity.ok(type);
    }

    @PostMapping("/delete/{type_id}")
    public ResponseEntity<?> deleteNotificationType(@PathVariable Long type_id) {
        typeService.deleteType(type_id);
        return ResponseEntity.ok("Type deleted successfully");
    }

    @GetMapping("/me")
    public ResponseEntity<?> getUserNotificationTypes() {
        return ResponseEntity.ok(typeService.getUserTypes());
    }
}