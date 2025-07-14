package com._8.urlShortner.controller;

import com._8.urlShortner.model.URL;
import com._8.urlShortner.service.ShortenerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/shorturls")
public class UrlController {

    private final ShortenerService shortenerService;

    public UrlController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }


    @PostMapping
    public ResponseEntity<Object> createShortUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        String shortcode = request.get("shortcode");

        Long validity = null;
        if (request.containsKey("validity")) {
            validity = Long.parseLong(request.get("validity"));
        }

        var urlMapping = shortenerService.createShortUrl(originalUrl, validity, shortcode);


        String shortLink = "http://localhost:8080/shorturls/" + urlMapping.getShortcode();

        return ResponseEntity.ok(Map.of(
                "shortLink", shortLink,
                "expiry", urlMapping.getExpiryDate().toString()
        ));
    }


    @GetMapping("/{code}")
    public ResponseEntity<Object> getUrlInfo(@PathVariable String code) {
        var urlMapping = shortenerService.getUrlInfo(code);

        return ResponseEntity.ok(Map.of(
                "originalUrl", urlMapping.getOriginalUrl(),
                "shortcode", urlMapping.getShortcode(),
                "creationDate", urlMapping.getCreationDate().toString(),
                "expiryDate", urlMapping.getExpiryDate().toString(),
                "clickCount", urlMapping.getClickCount()
        ));
    }
}
