/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.Generic;

import java.util.List;

/**
 *
 * @author FRANCIS MCH
 * @param <T> any
 */
public interface CrudOperations<T> {

    T insert(T Object);

    T update(T Object);

    List<T> selectAll();

    T getById(int id);

    T getByName(String name);

    void delteById(int id);
}
