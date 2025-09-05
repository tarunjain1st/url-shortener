package com.example.backendservice.controllers;

import com.example.backendservice.dtos.UrlRequestDto;
import com.example.backendservice.dtos.UrlResponseDto;
import com.example.backendservice.exceptions.InvalidUrlException;
import com.example.backendservice.exceptions.UrlNotFoundException;
import com.example.backendservice.models.Url;
import com.example.backendservice.services.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private IUrlService urlService;

    @GetMapping("/{shortCode}")
    public ResponseEntity<UrlResponseDto> getUrl(@PathVariable String shortCode) throws UrlNotFoundException, InvalidUrlException {
        Url url = urlService.getUrl(shortCode);
        return new ResponseEntity<>(from(url), HttpStatus.OK);
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) throws InvalidUrlException {
        String url = urlService.generateShortUrl(urlRequestDto.getOriginalUrl());
        return new ResponseEntity<>(url, HttpStatus.OK);
    }

    private UrlResponseDto from(Url url) {
        UrlResponseDto urlResponseDto = new UrlResponseDto();
        urlResponseDto.setOriginalUrl(url.getOriginalUrl());
        urlResponseDto.setShortUrl(url.getShortUrl());
        return urlResponseDto;
    }
}
