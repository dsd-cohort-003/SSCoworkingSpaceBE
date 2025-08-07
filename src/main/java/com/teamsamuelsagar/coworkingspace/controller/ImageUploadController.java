package com.teamsamuelsagar.coworkingspace.controller;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.net.URL;
import java.time.Duration;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageUploadController {

    private final S3Presigner presigner;
    private static final String BUCKET_NAME = "cohort-image-bucket";

    public ImageUploadController() {
        this.presigner = S3Presigner.builder()
            .region(Region.US_EAST_2) // your region here
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();
    }

    @GetMapping("/upload-url")
    public String getPresignedUploadUrl(@RequestParam String filename, @RequestParam String contentType) {
        // Very basic content-type check
        if (!contentType.equalsIgnoreCase("image/png") && !contentType.equalsIgnoreCase("image/jpeg")) {
            throw new IllegalArgumentException("Only PNG and JPEG files are allowed");
        }

        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key(filename)
                .contentType(contentType)
                .build();

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(15))
                .putObjectRequest(objectRequest)
                .build();

        URL presignedUrl = presigner.presignPutObject(presignRequest).url();

        return presignedUrl.toString();
    }
}

