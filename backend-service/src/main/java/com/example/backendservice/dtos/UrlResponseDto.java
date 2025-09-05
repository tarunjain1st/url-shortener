package com.example.backendservice.dtos;

import com.example.backendservice.models.Url;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlResponseDto {
    private String shortUrl;
    private String originalUrl;
}
