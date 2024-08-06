package com.riwiJava.repository;

import com.riwiJava.entity.Inscription;
import com.riwiJava.entity.Student;

import java.util.List;

public interface InscriptionCrudRepository {

    public boolean createInscription(Inscription inscription);

    public List<Inscription> findAll();

    public boolean updateInscription(Inscription inscription);

    public boolean deleteInscription(Inscription inscription);

    public List<Inscription> getByField(String field, String search);

    boolean deleteInscription(Student student);
}



