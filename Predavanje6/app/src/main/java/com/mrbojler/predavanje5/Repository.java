package com.mrbojler.predavanje5;

import com.mrbojler.predavanje5.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<Contact> getListOfContacts() {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact(
                "Richard",
                "+387 61 123 132",
                "https://xsgames.co/randomusers/assets/avatars/male/75.jpg",
                true
        ));
        list.add(new Contact(
                "John Doe",
                "00 383 12 12 12",
                "",
                true
        ));
        list.add(new Contact(
                "Isabelle",
                "+387 12 12 34",
                "",
                true
        ));
        list.add(new Contact(
                "Harry",
                "+44 12 12 34",
                "https://xsgames.co/randomusers/assets/avatars/male/2.jpg",
                false
        ));
        list.add(new Contact(
                "Jimmy",
                "+1 12 34 45 67",
                "",
                true
        ));
        list.add(new Contact(
                "Alex",
                "+1 234 1235 123",
                "",
                false
        ));
        list.add(new Contact(
                "Arthur",
                "+1 22 22 33",
                "",
                false
        ));
        list.add(new Contact(
                "George",
                "+1 23 45 65",
                "https://xsgames.co/randomusers/assets/avatars/male/22.jpg",
                true
        ));
        list.add(new Contact(
                "Annabelle",
                "+1 23 455 66",
                "https://xsgames.co/randomusers/assets/avatars/female/22.jpg",
                false
        ));
        list.add(new Contact(
                "Victoria",
                "00 385 12 12 34",
                "",
                true
        ));
        list.add(new Contact(
                "Emily",
                "+44 325 2345 234",
                "",
                false
        ));
        list.add(new Contact(
                "Stephanie",
                "+44 1 2 4 44 44",
                "",
                false
        ));
        list.add(new Contact(
                "Jessica",
                "00 387 12 12 39",
                "",
                true
        ));
        list.add(new Contact(
                "Emilio",
                "+1 12 34 45 67",
                "",
                true
        ));
        list.add(new Contact(
                "Ahmed",
                "+387 234 1235 123",
                "",
                false
        ));
        list.add(new Contact(
                "John",
                "+1 22 22 33",
                "https://xsgames.co/randomusers/assets/avatars/male/1.jpg",
                false
        ));
        list.add(new Contact(
                "Abraham",
                "+1 12 34 45 67",
                "",
                true
        ));
        list.add(new Contact(
                "Marie",
                "+387 234 1235 123",
                "",
                false
        ));
        list.add(new Contact(
                "Karla",
                "+1 22 22 33",
                "",
                false
        ));
        list.add(new Contact(
                "Sophie",
                "+1 22 22 33",
                "https://xsgames.co/randomusers/assets/avatars/female/7.jpg",
                true
        ));
        list.add(new Contact(
                "Selma",
                "+1 22 22 33",
                "https://xsgames.co/randomusers/assets/avatars/female/75.jpg",
                false
        ));
        return list;
    }

    public static List<Contact> getListOfFavoriteContacts() {
        List<Contact> favoriteList = new ArrayList<>();

        List<Contact> tempList = getListOfContacts();
        for (Contact contact : tempList) {
            if (contact.isFavorite()) {
                favoriteList.add(contact);
            }
        }

        return favoriteList;
    }

}
