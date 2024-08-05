package com.riwiJava.repository;

import java.util.List;

public interface Nombre1CrudRepository {  //Reemplazar Nombre uno por la entidad

    public boolean createNombreEntity1(Nombre1 nombre);

    public List<Entity> findAll();

    public boolean updateNombre1(Nombre1 nombre);

    public boolean deleteNombre1(Nombre1 nombre);

    public List<Entity> getByField(String field, String search);
}

