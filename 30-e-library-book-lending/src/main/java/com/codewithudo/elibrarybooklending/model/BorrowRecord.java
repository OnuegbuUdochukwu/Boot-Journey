package com.codewithudo.elibrarybooklending.model;

import java.time.LocalDateTime;

public class BorrowRecord {

    private Long id;

    private Book book;

    private String borrowerName;

    private LocalDateTime borrowedDate;
    private LocalDateTime returnedDate;
}
