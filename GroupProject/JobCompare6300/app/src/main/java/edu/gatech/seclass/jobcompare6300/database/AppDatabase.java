package edu.gatech.seclass.jobcompare6300.database;

@Database(entities = {CurrentJob.class, JobOffer.class, WeightConfig.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CurrentJobDao currentJobDao();
    public abstract JobOfferDao jobOfferDao();
    public abstract WeightConfigDao weightConfigDao();
}