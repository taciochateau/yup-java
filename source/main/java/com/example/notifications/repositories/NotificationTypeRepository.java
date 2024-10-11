package com.example.notifications.repositories;

import com.example.notifications.models.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {
    List<NotificationType> findByUserId(Long userId);
}