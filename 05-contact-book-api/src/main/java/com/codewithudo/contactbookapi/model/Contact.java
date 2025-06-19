package com.codewithudo.contactbookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Contact {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
