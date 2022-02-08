package com.example.holbainrecipes;

public interface RepositoryObserver {
    void onUserDataChanged(String fullname, int age);
}
