package edu.gatech.seclass.jobcompare6300.dao;

import androidx.room.*;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;

@Dao
public interface WeightConfigDao {
    @Insert
    void insert(WeightConfig weightConfig);

    @Update
    void update(WeightConfig weightConfig);

    @Delete
    void delete(WeightConfig weightConfig);

    @Query("SELECT * FROM weightconfig LIMIT 1")
    WeightConfig get();
}