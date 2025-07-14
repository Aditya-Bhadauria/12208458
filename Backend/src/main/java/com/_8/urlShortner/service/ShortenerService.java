package com._8.urlShortner.service;

import com._8.urlShortner.model.URL;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShortenerService {
    private final Map<String, URL> urlMap = new ConcurrentHashMap<>();
    private final LoggerService loggerService;

    public ShortenerService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public URL createShortUrl(String url, Long validityMinutes, String customShortcode) {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Please dont provide empty url");
        }

        String shortcode = (customShortcode != null && !customShortcode.isBlank())
                ? customShortcode
                : UUID.randomUUID().toString().substring(0, 6);

        if (urlMap.containsKey(shortcode)) {
            throw new IllegalArgumentException("Shortcode already has been used");
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expiry = (validityMinutes != null)
                ? now.plusMinutes(validityMinutes)
                : now.plusMinutes(30);

        URL mapping = new URL(url, shortcode, now, expiry);
        urlMap.put(shortcode, mapping);

        loggerService.log("UrlShortenerService", "INFO", "UrlShortenerService",
                "Created short URL: " + shortcode);
        return mapping;
    }

    public URL getUrlInfo(String shortcode) {
        URL mapping = urlMap.get(shortcode);
        if (mapping == null) {
            throw new IllegalArgumentException("Shortcode not found");
        }

        if (LocalDateTime.now().isAfter(mapping.getExpiryDate())) {
            urlMap.remove(shortcode);
            throw new IllegalStateException("Shortcode has already expired");
        }

        mapping.incrementClickCount();
        loggerService.log("UrlShortenerService", "INFO", "UrlShortenerService",
                "Accessed short URL: " + shortcode);
        return mapping;
    }
}
