package com.riwiJava.repository;

import java.util.List;

public interface Nombre4CrudRepository {

    public boolean Nombre4(Nombre4 nombre);

    public List<Object> findAll();

    public boolean updateNombre4(Nombre4 nombre);

    public boolean deleteNombre4(Nombre4 nombre);

    public List<Object> getByField(String field, String search);
}



