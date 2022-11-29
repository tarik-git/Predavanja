package com.mrbojler.predavanje5.model;

public class Contact {
    private String name;
    private String number;
    private String imageUrl;
    private boolean isFavorite;

    public Contact() {
    }

    public Contact(String name, String number, String imageUrl, boolean isFavorite) {
        this.name = name;
        this.number = number;
        this.imageUrl = imageUrl;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
