package com.riwiJava.repository;

import java.util.List;

public interface Nombre3CrudRepository {

    public boolean Nombre3(Nombre3 nombre);

    public List<Object> findAll();

    public boolean updateNombre3(Nombre3 nombre);

    public boolean deleteNombre3(Nombre3 nombre);

    public List<Object> getByField(String field, String search);
}

