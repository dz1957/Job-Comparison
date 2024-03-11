package edu.gatech.seclass.jobcompare6300.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class CurrentJobRepository {

    private final CurrentJobDao currentJobDao;

    public CurrentJobRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        currentJobDao = db.getCurrentJobDao();
    }

    public LiveData<CurrentJob> getCurrentJob() {
        return currentJobDao.getCurrentJob();
    }

    public void insertCurrentJob(CurrentJob currentJob) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            currentJobDao.insert(currentJob);
        });
    }

}
