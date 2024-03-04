package edu.gatech.seclass.jobcompare6300.database;

import androidx.room.*;

import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.dao.JobOfferDao;
import edu.gatech.seclass.jobcompare6300.dao.WeightConfigDao;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;
import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;

@Database(entities = {CurrentJob.class, JobOffer.class, WeightConfig.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CurrentJobDao currentJobDao();
    public abstract JobOfferDao jobOfferDao();
    public abstract WeightConfigDao weightConfigDao();
}