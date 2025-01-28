//package kz.tech.cargoeg.controller;
//
//import kz.tech.cargoeg.util.JwtUtil;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/auth")
//public class UserController {
//
//    private final JwtUtil jwtUtil;
//
//    public UserController(JwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> user) {
//        String username = user.get("username");
//        String password = user.get("password");
//
//        // Simulated username and password validation
//        if ("admin".equals(username) && "password".equals(password)) {
//            String token = jwtUtil.generateToken(username);
//            return ResponseEntity.ok(Map.of("token", token));
//        }
//
//        return ResponseEntity.status(401).body("Invalid credentials");
//    }
//}
//
