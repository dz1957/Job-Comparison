package edu.gatech.seclass.jobcompare6300.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("SELECT * FROM currentjob LIMIT 1")
    LiveData<CurrentJob> getCurrentJob();

    @Query("SELECT COUNT(id) FROM CurrentJob")
    LiveData<Integer> getRowCount();

}