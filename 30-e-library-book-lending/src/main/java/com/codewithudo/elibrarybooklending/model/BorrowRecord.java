package com.codewithudo.elibrarybooklending.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowRecord {

    private Long id;

    private Book book;

    private String borrowerName;

    private LocalDateTime borrowedDate;
    private LocalDateTime returnedDate;
}
