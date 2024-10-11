package com.example.notifications.models;

import javax.persistence.*;

@Entity
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String name;

    // Getters e setters
}