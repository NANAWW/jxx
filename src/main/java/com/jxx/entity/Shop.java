package com.jxx.entity;

public class Shop {
    private Integer id;

    private String name;

    private String gids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGids() {
        return gids;
    }

    public void setGids(String gids) {
        this.gids = gids == null ? null : gids.trim();
    }
}