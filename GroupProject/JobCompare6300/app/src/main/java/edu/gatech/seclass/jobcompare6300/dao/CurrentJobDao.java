package edu.gatech.seclass.jobcompare6300.dao;
import room;
@Dao
public interface CurrentJobDao {
    @Insert
    void insert(CurrentJob currentJob);

    @Update
    void update(CurrentJob currentJob);

    @Delete
    void delete(CurrentJob currentJob);

    @Query("SELECT * FROM CURRENT_JOB")
    List<CurrentJob> getCurrentJob();
}