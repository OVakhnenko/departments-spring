package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Essence;

import java.util.List;

public interface Dao<T extends Essence> {

    void save(T o);

    void remove(int id);

    T getEssenceById(int id);

    List<T> list();

    List<T> fillDemoData();
}
