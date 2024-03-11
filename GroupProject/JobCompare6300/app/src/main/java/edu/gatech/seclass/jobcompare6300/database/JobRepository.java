package edu.gatech.seclass.jobcompare6300.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.dao.JobOfferDao;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;

public class JobRepository {

    private final CurrentJobDao currentJobDao;
    private final JobOfferDao jobOfferDao;

    public JobRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        currentJobDao = db.getCurrentJobDao();
        jobOfferDao = db.getJobOfferDao();
    }

    public LiveData<CurrentJob> getCurrentJob() {
        return currentJobDao.getCurrentJob();
    }

    public void insertCurrentJob(CurrentJob currentJob) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            currentJobDao.insert(currentJob);
        });
    }

    public void deleteCurrentJob(CurrentJob currentJob){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            currentJobDao.delete(currentJob);
        });
    }

    public LiveData<List<JobOffer>> getJobOfferList() {
        return jobOfferDao.getAll();
    }

    public void insertJobOffer(JobOffer jobOffer) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            jobOfferDao.insert(jobOffer);
        });
    }
    public void deleteJobOffer(JobOffer jobOffer){
        AppDatabase.databaseWriteExecutor.execute(() -> {
            jobOfferDao.delete(jobOffer);
        });
    }

}
