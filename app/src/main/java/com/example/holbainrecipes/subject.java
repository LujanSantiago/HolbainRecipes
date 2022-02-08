package com.example.holbainrecipes;

public interface subject {
    void registerObserver(RepositoryObserver repositoryObserver);
    void removeObserver(RepositoryObserver repositoryObserver);
    void notifyObservers();
}
