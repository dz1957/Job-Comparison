package edu.gatech.seclass.jobcompare6300.database;

import android.content.Context;
import android.util.Log;

import androidx.room.*;

import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.dao.JobOfferDao;
import edu.gatech.seclass.jobcompare6300.dao.WeightConfigDao;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;
import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;

@Database(entities = {CurrentJob.class, JobOffer.class, WeightConfig.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CurrentJobDao getCurrentJobDao();
    public abstract JobOfferDao getJobOfferDao();
    public abstract WeightConfigDao getWeightConfigDao();

    private static final String DB_NAME = "job_compare_db";
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME).fallbackToDestructiveMigration().build();
        }
        Log.i(AppDatabase.class.getName(), "AppDatabase instantiated.");
        return instance;
    }

}