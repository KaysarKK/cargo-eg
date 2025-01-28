//package kz.tech.cargoeg.controller;
//
//import kz.tech.cargoeg.service.MinioService;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//
//import java.io.InputStream;
//
//@RestController
//@RequestMapping("/minio")
//public class MinioController {
//
//    @Autowired
//    private MinioService minioService;
//
//    @PostMapping("/bucket/{bucketName}")
//    public ResponseEntity<String> createBucket(@PathVariable String bucketName) {
//        minioService.createBucket(bucketName);
//        return ResponseEntity.ok("Bucket created: " + bucketName);
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(
//            @RequestParam String bucketName,
//            @RequestParam String objectName,
//            @RequestParam String filePath) {
//        minioService.uploadFile(bucketName, objectName, filePath);
//        return ResponseEntity.ok("File uploaded: " + objectName);
//    }
//
//    @GetMapping("/file")
//    public ResponseEntity<String> getFile(@RequestParam String bucketName, @RequestParam String objectName) {
//        try (InputStream stream = minioService.getFile(bucketName, objectName)) {
//            return ResponseEntity.ok("File fetched successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Error fetching file.");
//        }
//    }
//}
//
