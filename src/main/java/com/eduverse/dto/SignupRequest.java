package com.eduverse.dto;

public class SignupRequest {

    private String userId;
    private String password;
    private String role;   // STUDENT or TEACHER

    // common fields
    private String name;
    private String email;

    // student-specific
    private String studentClass;

    // teacher-specific
    private String subject;
    private int experience;

    public SignupRequest() {}

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getSubject() {
        return subject;
    }

    public int getExperience() {
        return experience;
    }
}
