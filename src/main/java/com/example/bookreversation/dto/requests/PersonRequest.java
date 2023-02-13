package com.example.bookreversation.dto.requests;

import lombok.*;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
public class PersonRequest {
    private Integer id;

    private String firstName;

    private String lastName;

    private Date dateBirthday;
}
