package com.tafa.amicodeparina.controllers.dto;

import java.time.LocalDateTime;

import com.tafa.amicodeparina.models.User;

public class SearchDto {
    private Long id;
    private String input;
    private String search;
    private LocalDateTime date;
    private Boolean result;
    private User user;

    public SearchDto() {

    }

    public SearchDto(Long id, String input, String search, LocalDateTime date, Boolean result, User user) {
        super();
        this.input = input;
        this.search = search;
        this.date = date;
        this.result = result;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
