package com.epam.demojenkinsspringboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;

    private String firstname;
    private String lastname;
    private String password;
}
