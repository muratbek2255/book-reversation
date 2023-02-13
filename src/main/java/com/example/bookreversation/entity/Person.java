package com.example.bookreversation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons", schema = "book_kg")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 70, message = "Имя должно быть от 2 до 100 символов длиной")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Фамилия не должно быть пустым")
    @Size(min = 2, max = 80, message = "Фамилия должно быть от 2 до 100 символов длиной")
    private String lastName;

    @Column(name = "date_birthday")
    private Date dateBirthday;

    @OneToMany(mappedBy = "person")
    List<Book> books;
}
