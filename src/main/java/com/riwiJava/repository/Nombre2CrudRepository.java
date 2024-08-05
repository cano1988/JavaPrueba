package com.riwiJava.repository;

import java.util.List;

public interface Nombre2CrudRepository {

    public boolean Nombre2(Nombre2 nombre);

    public List<Object> findAll();

    public boolean updateNombre2(Nombre2 nombre);

    public boolean deleteNombre2(Nombre2 nombre);

    public List<Object> getByField(String field, String search);
}

