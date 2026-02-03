package com.eduverse.service;

import com.eduverse.config.JwtUtil;
import com.eduverse.dto.LoginRequest;
import com.eduverse.dto.LoginResponse;
import com.eduverse.dto.SignupRequest;
import com.eduverse.model.Student;
import com.eduverse.model.Teacher;
import com.eduverse.model.User;
import com.eduverse.repository.StudentRepository;
import com.eduverse.repository.TeacherRepository;
import com.eduverse.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       StudentRepository studentRepository,
                       TeacherRepository teacherRepository,
                       JwtUtil jwtUtil,
                       BCryptPasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // ===================== LOGIN =====================
    public LoginResponse login(LoginRequest request) {

        if (request.getUserId() == null || request.getUserId().isEmpty()) {
            throw new RuntimeException("UserId is required");
        }

        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        User user = userRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Invalid userId"));

        if (!user.isActive()) {
            throw new RuntimeException("User account is inactive");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(
                user.getUserId(),
                user.getRole()
        );

        return new LoginResponse(token, user.getRole());
    }

    // ===================== SIGNUP =====================
    public String signup(SignupRequest request) {

        // 1. Validate basic fields
        if (request.getUserId() == null || request.getUserId().isEmpty()) {
            throw new RuntimeException("UserId is required");
        }

        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            throw new RuntimeException("Password is required");
        }

        if (request.getRole() == null ||
                (!request.getRole().equals("STUDENT") && !request.getRole().equals("TEACHER"))) {
            throw new RuntimeException("Role must be STUDENT or TEACHER");
        }

        // 2. Check if user already exists
        if (userRepository.findByUserId(request.getUserId()).isPresent()) {
            throw new RuntimeException("UserId already exists");
        }

        // 3. Encrypt password
        String encryptedPassword = passwordEncoder.encode(request.getPassword());

        // 4. Save user
        User user = new User();
        user.setUserId(request.getUserId());
        user.setPassword(encryptedPassword);
        user.setRole(request.getRole());
        user.setActive(true);

        userRepository.save(user);

        // 5. Save profile based on role
        if (request.getRole().equals("STUDENT")) {

            Student student = new Student(
                    request.getUserId(),
                    request.getName(),
                    request.getStudentClass(),
                    request.getEmail()
            );

            studentRepository.save(student);

        } else {

            Teacher teacher = new Teacher(
                    request.getUserId(),
                    request.getName(),
                    request.getSubject(),
                    request.getEmail(),
                    request.getExperience()
            );

            teacherRepository.save(teacher);
        }

        return "Signup successful";
    }
}
