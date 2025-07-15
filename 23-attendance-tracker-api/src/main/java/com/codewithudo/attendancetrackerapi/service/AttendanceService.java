package com.codewithudo.attendancetrackerapi.service;

import com.codewithudo.attendancetrackerapi.model.Attendance;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    private final List<Attendance> attendances = new ArrayList<>();
    private int nextId = 1;

    // Add a new attendance record
    public boolean addAttendance(Attendance attendance) {
        attendance.setId(nextId++);
        attendances.add(attendance);
        return true;
    }

    // Get all attendance records
    public List<Attendance> getAllAttendances() {
        return attendances;
    }

    // Get a specific attendance record by ID
    public Attendance getAttendanceById(int id) {
        for (Attendance attendance : attendances) {
            if (attendance.getId().equals(id)) {
                return attendance;
            }
        }
        return null;
    }

    // Update an existing attendance record by ID
    public boolean updateAttendance(int id, Attendance updatedAttendance) {
        for (Attendance attendance : attendances) {
            if (attendance.getId().equals(id)) {
                attendance.setStudentName(updatedAttendance.getStudentName());
                attendance.setDate(updatedAttendance.getDate());
                attendance.setStatus(updatedAttendance.getStatus());
                return true;
            }
        }
        return false;
    }

    // Delete an attendance record by ID
    public boolean deleteAttendance(int id) {
        return attendances.removeIf(attendance -> attendance.getId().equals(id));
    }
}
