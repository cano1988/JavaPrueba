package com.riwiJava.repository;

import com.riwiJava.entity.Inscription;

import java.util.List;

public interface InscriptionCrudRepository {

    public boolean createInscription(Inscription inscription);

    public List<Object> findAll();

    public boolean updateInscription(Inscription inscription);

    public boolean deleteInscription(Inscription inscription);

    public List<Object> getByField(String field, String search);
}



