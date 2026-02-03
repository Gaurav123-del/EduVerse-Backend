package com.eduverse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {

    @Id
    private String id;

    private String userId;
    private String name;
    private String studentClass;
    private String email;

    public Student() {}

    public Student(String userId, String name, String studentClass, String email) {
        this.userId = userId;
        this.name = name;
        this.studentClass = studentClass;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getEmail() {
        return email;
    }
}
