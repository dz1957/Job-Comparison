//package edu.gatech.seclass.jobcompare6300.service;
//
//import android.app.Application;
//
//import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
//import edu.gatech.seclass.jobcompare6300.dao.JobOfferDao;
//import edu.gatech.seclass.jobcompare6300.dao.WeightConfigDao;
//import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
//import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
//import edu.gatech.seclass.jobcompare6300.entity.JobOffer;
//import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;
//
//import androidx.room.*;
//
//import java.util.List;
//
//public class DatabaseService {
//    AppDatabase db = Room.databaseBuilder(getApplicationContext(), Application.class, "app_db").build();
//
//    private CurrentJobDao currentJobDao = db.getCurrentJobDao();
//    private JobOfferDao jobOfferDao = db.getJobOfferDao();
//    private WeightConfigDao weightConfigDao = db.getWeightConfigDao();
//
//    public CurrentJob getCurrentJob() {
//        CurrentJob currentJob = currentJobDao.getCurrentJob();
//        if(currentJob.company == null){
//            return null;
//        } else {
//            return currentJob;
//        }
//    }
//    public void saveCurrentJob(CurrentJob currentJob) {
//        if(getCurrentJob() == null){
//            currentJobDao.insert(currentJob);
//        } else {
//            currentJobDao.update(currentJob);
//        }
//    }
//    public List<JobOffer> getJobOffers() {
//        return jobOfferDao.getAll();
//    }
//    public void saveJobOffer(JobOffer jobOffer) {
//        jobOfferDao.insert(jobOffer);
//    }
//    public WeightConfig getWeightConfig() {
//        return weightConfigDao.get();
//    }
//    public void saveWeightConfig(WeightConfig weightConfig) {
//        weightConfigDao.update(weightConfig);
//    }
//
//}
