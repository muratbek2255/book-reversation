package com.example.bookreversation.dto.requests;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookRequest {
    private Integer id;

    private String title;

    private String author;

    private Integer year;

    private PersonRequest person;
}
