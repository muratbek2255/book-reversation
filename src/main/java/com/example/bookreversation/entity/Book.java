package com.example.bookreversation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books", schema = "book_kg")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 150, message = "Название должно быть от 2 до 150 символов длиной")
    private String title;

    @NotEmpty(message = "Автор не должно быть пустым")
    @Size(min = 2, max = 80, message = "Автор должно быть от 2 до 100 символов длиной")
    @Column(name = "author")
    private String author;

    @Column(name = "year")
    private Integer year;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_person_id")
    private Person person;

    @Column(name = "taken_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takenAt;

    @Transient
    private boolean expired;
}
