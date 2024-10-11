package com.example.notifications.services;

import com.example.notifications.models.Notification;
import com.example.notifications.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification updateNotification(Long notificationId, Notification notification) {
        Notification existingNotification = notificationRepository.findById(notificationId).orElseThrow(() -> new RuntimeException("Notification not found"));
        // Atualize os campos necessários
        return notificationRepository.save(existingNotification);
    }

    public void deleteNotification(Long notificationId) {
        Notification existingNotification = notificationRepository.findById(notificationId).orElseThrow(() -> new RuntimeException("Notification not found"));
        notificationRepository.delete(existingNotification);
    }

    public List<Notification> getUserNotifications() {
        // Pegue o usuário autenticado e filtre as notificações dele
        return null;
    }

    public List<Notification> getNotificationsByType(Long typeId) {
        // Pegue o usuário autenticado e filtre as notificações pelo tipo
        return null;
    }
}