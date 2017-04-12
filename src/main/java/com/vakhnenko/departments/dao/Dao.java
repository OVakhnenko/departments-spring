package com.vakhnenko.departments.dao;

import com.vakhnenko.departments.entity.Essence;

public interface Dao<T extends Essence> {
    void save(T o);
}
