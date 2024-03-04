package edu.gatech.seclass.jobcompare6300.service;

public class DatabaseService {
    AppDatabase db = Room.databaseBuilder(getApplicationContext(), Application.class, "").build();

    private CurrentJobDao currentJobDao = db.currentJobDao();
    private JobOfferDao jobOfferDao = db.jobOfferDao();
    private WeightConfigDao weightConfigDao = db.weightConfigDao();

    public CurrentJob getCurrentJob() {
        currentJobDao.getCurrentJob()
    }
    public void saveCurrentJob(CurrentJob currentJob) {
        currentJobDao.save()
    }
    public List<JobOffer> getJobOffers() {

    }
    public void saveJobOffer() {

    }
    public WeightConfig getWeightConfig() {

    }
    public void saveWeightConfig() {

    }

}