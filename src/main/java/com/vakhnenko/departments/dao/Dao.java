package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Essence;

import java.util.List;

public interface Dao<T extends Essence> {

    void save(T o);

    List<T> list();

    List<T> fillDemoData();
}
