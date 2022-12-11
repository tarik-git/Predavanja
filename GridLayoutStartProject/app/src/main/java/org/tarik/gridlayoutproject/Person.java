package org.tarik.gridlayoutproject;

public class Person {

    private String avatarUrl;
    private String name;

    public Person(String avatarUrl, String name) {
        this.avatarUrl = avatarUrl;
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

