package com.example.backendservice.services;

import com.example.backendservice.exceptions.InvalidUrlException;
import com.example.backendservice.exceptions.UrlNotFoundException;
import com.example.backendservice.models.Url;

public interface IUrlService {
    String generateShortUrl(String originalUrl) throws InvalidUrlException;
    Url getUrl(String shortUrl) throws UrlNotFoundException, InvalidUrlException;
}
