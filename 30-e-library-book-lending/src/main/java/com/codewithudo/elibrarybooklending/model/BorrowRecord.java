package com.codewithudo.elibrarybooklending.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class BorrowRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;


    private String borrowerName;

    private LocalDateTime borrowedDate;
    private LocalDateTime returnedDate;
}
