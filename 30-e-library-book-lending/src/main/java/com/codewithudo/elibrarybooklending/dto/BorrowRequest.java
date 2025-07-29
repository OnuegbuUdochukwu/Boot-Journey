package com.codewithudo.elibrarybooklending.dto;

import lombok.Data;

@Data
public class BorrowRequest {
    private Long bookId;
    private String borrowerName;
}
