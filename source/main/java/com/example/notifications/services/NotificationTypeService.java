package com.example.notifications.services;

import com.example.notifications.models.NotificationType;
import com.example.notifications.repositories.NotificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationTypeService {

    @Autowired
    private NotificationTypeRepository typeRepository;

    public NotificationType createType(NotificationType type) {
        return typeRepository.save(type);
    }

    public NotificationType updateType(Long typeId, NotificationType type) {
        NotificationType existingType = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Type not found"));
        // Atualize os campos necessários
        return typeRepository.save(existingType);
    }

    public void deleteType(Long typeId) {
        NotificationType existingType = typeRepository.findById(typeId).orElseThrow(() -> new RuntimeException("Type not found"));
        // Verificar se o tipo está em uso por notificações antes de deletar
        typeRepository.delete(existingType);
    }

    public List<NotificationType> getUserTypes() {
        // Pegue o usuário autenticado e filtre os tipos de notificações
        return null;
    }
}