package com.example.bookreversation.dto.requests;


import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JoinRequest {
    private Integer id;

    private String title;

    private String author;

    private Integer year;

    private String firstName;

    private String lastName;

    private Date dateBirthday;
}
