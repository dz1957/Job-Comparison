package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.gatech.seclass.jobcompare6300.activities.CompareJobsActivity;
import edu.gatech.seclass.jobcompare6300.activities.ComparisonWeightsActivity;
import edu.gatech.seclass.jobcompare6300.activities.job.CurrentJobActivity;
import edu.gatech.seclass.jobcompare6300.activities.job.JobOfferActivity;
import edu.gatech.seclass.jobcompare6300.database.JobRepository;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;
import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;
//import edu.gatech.seclass.jobcompare6300.service.DatabaseService;

//import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class MainActivity extends AppCompatActivity {

    private CurrentJob currentJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        JobRepository currentJobRepository = new JobRepository(this.getApplication());
        currentJobRepository.getCurrentJob().observe(this, job -> currentJob = job);

    }

    public void currentJobButton(View view) {
        Intent currentJobActivity = new Intent(MainActivity.this, CurrentJobActivity.class);
        startActivity(currentJobActivity);
    }

    public void jobOfferButton(View view) {

        Intent jobOfferActivity = new Intent(MainActivity.this, JobOfferActivity.class);
        startActivity(jobOfferActivity);
    }

    public void cancelButton(View view) {
        setContentView(R.layout.activity_main);
    }
    public void editWeights(View view) {

        Intent comparisonWeightsActivity = new Intent(MainActivity.this, ComparisonWeightsActivity.class);
        startActivity(comparisonWeightsActivity);
    }

    public void compareJobs(View view) {
        //setContentView(R.layout.compare_jobs);

        Intent compareJobsActivity = new Intent(MainActivity.this, CompareJobsActivity.class);
        startActivity(compareJobsActivity);
    }

    public float jobOfferScore(JobOffer jobOffer, WeightConfig weightConfig) {

        /*
        int netWeight = weightConfig.yearlySalaryWeight + weightConfig.yearlyBonusWeight + weightConfig.numberOfStockWeight
                + weightConfig.homeBuyingFundWeight + weightConfig.personalChoiceHolidaysWeight + weightConfig.monthlyInternetStipendWeight;
        float score = weightConfig.yearlySalaryWeight*(jobOffer.yearlySalary/(jobOffer.costOfLivingIndex/100))
        + weightConfig.yearlyBonusWeight*(jobOffer.yearlyBonus/(jobOffer.costOfLivingIndex/100))
        + jobOffer.numberOfStock/3
        + jobOffer.homeBuyingFund
        + jobOffer.personalChoiceHolidays * weightConfig.yearlySalaryWeight*(jobOffer.yearlySalary/(jobOffer.costOfLivingIndex/100))/260
        + jobOffer.monthlyInternetStipend*12;
        return score/netWeight;
        */
         return 0;
    }

    //  find and reference widgets with their ids from the layout XML file.
    // ...
}