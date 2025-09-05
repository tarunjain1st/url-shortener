package com.example.backendservice.services;

import com.example.backendservice.exceptions.InvalidUrlException;
import com.example.backendservice.exceptions.UrlNotFoundException;
import com.example.backendservice.models.Status;
import com.example.backendservice.models.Url;
import com.example.backendservice.repos.UrlRepository;
import com.example.backendservice.utils.UrlGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UrlShortenerService implements IUrlService{

    @Autowired
    private UrlRepository urlRepository;

    public String generateShortUrl(String originalUrl) throws InvalidUrlException {
        if (originalUrl == null || originalUrl.isEmpty()) {
            throw new InvalidUrlException("Please provide a url !");
        }
        String shortUrl = UrlGeneratorUtil.generateUrl();
        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        url.setCreatedAt(new Date());
        url.setStatus(Status.ACTIVE);
        urlRepository.save(url);
        return shortUrl;
    }

    public Url getUrl(String shortUrl) throws UrlNotFoundException, InvalidUrlException {
        if (shortUrl == null || shortUrl.isEmpty()) {
            throw new InvalidUrlException("Please provide a url !");
        }
        Optional<Url> urlOptional = urlRepository.findUrlByShortUrl(shortUrl);
        if(urlOptional.isEmpty()) {
            throw new UrlNotFoundException("Url Not Found !");
        }
        return urlOptional.get();
    }
}
