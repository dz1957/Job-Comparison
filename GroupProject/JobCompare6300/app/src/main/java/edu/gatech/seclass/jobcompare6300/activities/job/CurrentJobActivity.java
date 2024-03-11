package edu.gatech.seclass.jobcompare6300.activities.job;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.database.JobRepository;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;


public class CurrentJobActivity extends AbstractJobActivity {

    private CurrentJob currentJob;
    private JobRepository currentJobRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

        //TODO: Convert to view model.
        currentJobRepository = new JobRepository(this.getApplication());
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentJobRepository.getCurrentJob().observe(this, job -> {
            currentJob = job;
            initializeAndLoadWidgets();

            if (job != null) {
                Log.i(this.getClass().getName(), "Current job loaded from database: " + currentJob.toString());
                loadWidgetsFromJob(currentJob);
            }

        });
    }

    public void onClickOk(View view) {
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

    protected void initializeAndLoadWidgets() {
        jobTitleWidget = (EditText) findViewById(R.id.current_jobtitle);
        companyWidget = (EditText) findViewById(R.id.current_company);
        cityWidget = (EditText) findViewById(R.id.current_city);
        stateWidget = (EditText) findViewById(R.id.current_state);
        costOfLivingWidget = (EditText) findViewById(R.id.current_col_index);
        salaryWidget = (EditText) findViewById(R.id.current_salary);
        bonusWidget = (EditText) findViewById(R.id.current_bonus);
        numberOfStocksWidget = (EditText) findViewById(R.id.current_stocks);
        homeBuyingFundWidget = (EditText) findViewById(R.id.current_homefund);
        personalHolidaysWidget = (EditText) findViewById(R.id.current_holidays);
        internetStipendWidget = (EditText) findViewById(R.id.current_internetstipend);
    }
    private void getCurrentJobFromWidgets() {

        if (currentJob == null) {
            currentJob = new CurrentJob();
        }

        getJobFromWidgets(currentJob);
    }


}