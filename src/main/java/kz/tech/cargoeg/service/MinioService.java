package kz.tech.cargoeg.service;

import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.MakeBucketArgs;
import io.minio.errors.MinioException;
import org.springframework.stereotype.Service;

import java.io.InputStream;

public interface MinioService {

    // Создание бакета
    public void createBucket(String bucketName);

    // Загрузка файла
    public void uploadFile(String bucketName, String objectName, String filePath);
    // Получение объекта
    public InputStream getFile(String bucketName, String objectName);
}
