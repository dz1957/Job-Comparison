package edu.gatech.seclass.jobcompare6300.dao;

import androidx.room.*;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.entity.JobOffer;

@Dao
public interface JobOfferDao {
    @Insert
    void insert(JobOffer jobOffer);

    @Update
    void update(JobOffer jobOffer);

    @Delete
    void delete(JobOffer jobOffer);

    @Query("SELECT * FROM JOB_OFFER")
    List<JobOffer> getAll();
}