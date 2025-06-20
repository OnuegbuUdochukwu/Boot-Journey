package com.codewithudo.contactbookapi.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Contact {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
