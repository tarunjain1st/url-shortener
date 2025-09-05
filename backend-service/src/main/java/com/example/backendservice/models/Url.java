package com.example.backendservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "url_mapping")
public class Url extends BaseModel{
    private String shortUrl;
    private String originalUrl;
}
