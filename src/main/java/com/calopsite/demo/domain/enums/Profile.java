package com.calopsite.demo.domain.enums;

public enum Profile {
    ADMIN("ROLE_ADMIN"),
    CLIENT("ROLE_USER");

    private String description;

    Profile(String description) {
        this.description = description;
    }
}
