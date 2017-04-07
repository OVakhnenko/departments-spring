package com.vakhnenko.departments.service;

import com.vakhnenko.departments.entity.Essence;

public interface Servize<T extends Essence> {
    void add(T o);
}
