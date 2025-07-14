package com._8.urlShortner.model;

import java.time.LocalDateTime;

public class URL {
    private String originalUrl;
    private String shortcode;
    private LocalDateTime creationDate;
    private LocalDateTime expiryDate;
    private int clickCount;

    public URL(String originalUrl, String shortcode, LocalDateTime creationDate, LocalDateTime expiryDate) {
        this.originalUrl = originalUrl;
        this.shortcode = shortcode;
        this.creationDate = creationDate;
        this.expiryDate = expiryDate;
        this.clickCount = 0;
    }


    public String getOriginalUrl() { return originalUrl; }
    public String getShortcode() { return shortcode; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public LocalDateTime getExpiryDate() { return expiryDate; }
    public int getClickCount() { return clickCount; }

    public void incrementClickCount() {
        this.clickCount++;
    }
}