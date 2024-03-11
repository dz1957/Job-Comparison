package edu.gatech.seclass.jobcompare6300.activities.job;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;
import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.database.JobRepository;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;

public class JobOfferActivity extends AbstractJobActivity {

    private JobRepository jobRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);
        initializeAndLoadWidgets();

        jobRepository = JobRepository.getInstance(this.getApplication());

//        jobRepository.getJobOfferList().observe(this, jobOffers -> {
//            if (jobOffers != null && !jobOffers.isEmpty()) {
//                JobOffer firstJobOffer = jobOffers.get(0);
//                jobRepository.deleteJobOffer(firstJobOffer);
//            } else {
//                Log.i("JobOfferActivity", "JobOffers list is empty");
//            }
//
//        });
//        jobRepository.getCurrentJob().observe(this, currentJob -> {
//            if (currentJob != null) {
//                CurrentJob currentJob1 = currentJob;
//                jobRepository.deleteCurrentJob(currentJob1);
//            } else {
//                Log.i("CurrentJobActivity", "CurrentJob is null");
//            }
//
//        });

    }

    public void onClickOk(View view) {
        boolean isValidInternetStipend = isValidInternetStipend();
        boolean isValidPersonalHoliday = isValidPersonalHoliday();
        boolean isValidHomeBuyingFund = isValidHomeBuyingFund();

        if (isValidInternetStipend && isValidPersonalHoliday && isValidHomeBuyingFund) {
            //Store in database
            JobOffer job = new JobOffer();
            getJobFromWidgets(job);
            jobRepository.insertJobOffer(job);
            navigateToMainActivity(true);
        }

    }

    protected void initializeAndLoadWidgets() {
        jobTitleWidget = (EditText) findViewById(R.id.offer_jobtitle);
        companyWidget = (EditText) findViewById(R.id.offer_company);
        cityWidget = (EditText) findViewById(R.id.offer_city);
        stateWidget = (EditText) findViewById(R.id.offer_state);
        costOfLivingWidget = (EditText) findViewById(R.id.offer_col_index);
        salaryWidget = (EditText) findViewById(R.id.offer_salary);
        bonusWidget = (EditText) findViewById(R.id.offer_bonus);
        numberOfStocksWidget = (EditText) findViewById(R.id.offer_stocks);
        homeBuyingFundWidget = (EditText) findViewById(R.id.offer_homefund);
        personalHolidaysWidget = (EditText) findViewById(R.id.offer_holidays);
        internetStipendWidget = (EditText) findViewById(R.id.offer_internetstipend);
    }
}