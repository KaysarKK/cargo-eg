package kz.tech.cargoeg.service.impl;

import io.minio.*;
import kz.tech.cargoeg.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class MinioServiceImpl implements MinioService {

    @Autowired
    private MinioClient minioClient;

    // Создание бакета
    public void createBucket(String bucketName) {
        try {
            boolean found = minioClient.bucketExists(
                BucketExistsArgs.builder()
                        .bucket(bucketName)
                        .build()
            );
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                System.out.println("Bucket created: " + bucketName);
            } else {
                System.out.println("Bucket already exists: " + bucketName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Загрузка файла
    public void uploadFile(String bucketName, String objectName, String filePath) {
        try {
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket(bucketName)
                            .object(objectName)
                            .filename(filePath)
                            .build()
            );
            System.out.println("File uploaded successfully!");
        } catch (MinioException e) {
            System.out.println("Error while uploading file: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Получение объекта
    public InputStream getFile(String bucketName, String objectName) {
        try {
            return minioClient.getObject(GetObjectArgs.builder()
                    .bucket(bucketName) // Имя бакета
                    .object(objectName)    // Имя объекта в бакете
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

