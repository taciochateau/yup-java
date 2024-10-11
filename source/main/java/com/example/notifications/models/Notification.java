package com.example.notifications.models;

import javax.persistence.*;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private NotificationType type;

    private String title;
    private String description;
    private String body;
    private String image;

    // Getters e setters
}