package edu.gatech.seclass.jobcompare6300.activities.job;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.database.CurrentJobRepository;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;


public class CurrentJobActivity extends AbstractJobActivity {

    private CurrentJob currentJob;
    private CurrentJobRepository currentJobRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        //TODO: Convert to view model.
        currentJobRepository = new CurrentJobRepository(this.getApplication());
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentJobRepository.getCurrentJob().observe(this, job -> {
            currentJob = job;
            //Log.i(this.getClass().getName(), "Current job loaded from database: " + currentJob.toString());
            initializeAndLoadWidgets();
            loadWidgetsFromJob(currentJob);
        });
    }

    public void onClickOk(View view) throws ExecutionException, InterruptedException {
        boolean isValidInternetStipend = isValidInternetStipend();
        boolean isValidPersonalHoliday = isValidPersonalHoliday();
        boolean isValidHomeBuyingFund = isValidHomeBuyingFund();

        if (isValidInternetStipend && isValidPersonalHoliday && isValidHomeBuyingFund) {
            //Store in database
            getCurrentJobFromWidgets();
            currentJobRepository.insertCurrentJob(currentJob);
            navigateToMainActivity();
        }

    }
    private void getCurrentJobFromWidgets() {

        if (currentJob == null) {
            currentJob = new CurrentJob();
        }

        getJobFromWidgets(currentJob);
    }


}