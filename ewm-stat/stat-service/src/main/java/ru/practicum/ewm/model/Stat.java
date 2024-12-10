package ru.practicum.ewm.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(length = 50)
    String app;

    @Column(length = 300)
    String uri;

    @Column(length = 45)
    String ip;

    @CreationTimestamp
    @Column(name = "created")
    LocalDateTime timestamp;
}

