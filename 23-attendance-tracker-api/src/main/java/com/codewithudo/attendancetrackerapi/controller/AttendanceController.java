package com.codewithudo.attendancetrackerapi.controller;

import com.codewithudo.attendancetrackerapi.model.Attendance;
import com.codewithudo.attendancetrackerapi.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Get all attendance records
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        return new ResponseEntity<>(attendanceService.getAllAttendances(), HttpStatus.OK);
    }

    // Get an attendance record by ID
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable int id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        if (attendance != null) {
            return new ResponseEntity<>(attendance, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a new attendance record
    @PostMapping
    public ResponseEntity<String> addAttendance(@RequestBody Attendance attendance) {
        boolean added = attendanceService.addAttendance(attendance);
        if (added) {
            return new ResponseEntity<>("Attendance record added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add attendance record", HttpStatus.BAD_REQUEST);
    }

    // Update an attendance record by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAttendance(@PathVariable int id, @RequestBody Attendance attendance) {
        boolean updated = attendanceService.updateAttendance(id, attendance);
        if (updated) {
            return new ResponseEntity<>("Attendance record updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Attendance record not found", HttpStatus.NOT_FOUND);
    }

    // Delete an attendance record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable int id) {
        boolean deleted = attendanceService.deleteAttendance(id);
        if (deleted) {
            return new ResponseEntity<>("Attendance record deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Attendance record not found", HttpStatus.NOT_FOUND);
    }
}
