package com.codewithudo.attendancetrackerapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    private Integer id;
    private String studentName;
    private String date;
    private String status;  // e.g. "Present" or "Absent"

}
