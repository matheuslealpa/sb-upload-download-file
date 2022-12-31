package com.example.core;

public interface StandardUploadFile<T extends AbstractEntity>{
    void save(T entity);
    void save(T entity, String fileDB);
}
