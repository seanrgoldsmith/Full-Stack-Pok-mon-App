package com.techelevator.model;

public class Pokemon {

    private int apiId;
    private String name;
    private String url;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "apiId=" + apiId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
