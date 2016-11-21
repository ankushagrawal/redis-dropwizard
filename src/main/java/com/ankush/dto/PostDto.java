package com.ankush.dto;

import javax.validation.constraints.NotNull;

public class PostDto {

    @NotNull
    private String key;

    private String value;
    private Integer expiry;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getExpiry() {
        return expiry;
    }

    public void setExpiry(Integer expiry) {
        this.expiry = expiry;
    }
}
