package com.example.backendservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "url_mapping")
@Table(indexes = {
        @Index(name = "idx_short_url", columnList = "shortUrl")
})
public class Url extends BaseModel{
    private String shortUrl;
    private String originalUrl;
}
