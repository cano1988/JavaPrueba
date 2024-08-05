package com.riwiJava.repository;

import com.riwiJava.entity.Score;

import java.util.List;

public interface ScoreCrudRepository {

    public boolean createScore(Score score);

    public List<Object> findAll();

    public boolean updateScore(Score score);

    public boolean deleteScore(Score score);

    public List<Object> getByField(String field, String search);
}

