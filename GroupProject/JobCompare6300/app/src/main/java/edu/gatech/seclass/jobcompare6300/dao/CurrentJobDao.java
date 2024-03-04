package edu.gatech.seclass.jobcompare6300.dao;

import androidx.room.*;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

@Dao
public interface CurrentJobDao {
    @Insert
    void insert(CurrentJob currentJob);

    @Update
    void update(CurrentJob currentJob);

    @Delete
    void delete(CurrentJob currentJob);

    @Query("SELECT * FROM CURRENT_JOB LIMIT 1")
    CurrentJob getCurrentJob();
}