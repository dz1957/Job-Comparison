package edu.gatech.seclass.jobcompare6300.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.MainActivity;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.activities.job.AbstractJobActivity;
import edu.gatech.seclass.jobcompare6300.entity.Job;

public class ComparisonScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_screen);
        EditText title1 = (EditText) findViewById(R.id.comp_title1);
        EditText title2 = (EditText) findViewById(R.id.comp_title2);
        EditText comp1 = (EditText) findViewById(R.id.comp_company1);
        EditText comp2 = (EditText) findViewById(R.id.comp_company2);
        EditText location1 = (EditText) findViewById(R.id.comp_location1);
        EditText location2 = (EditText) findViewById(R.id.comp_location2);
        EditText salary1 = (EditText) findViewById(R.id.comp_sal1);
        EditText salary2 = (EditText) findViewById(R.id.comp_sal2);
        EditText bonus1 = (EditText) findViewById(R.id.comp_bonus1);
        EditText bonus2 = (EditText) findViewById(R.id.comp_bonus2);
        EditText stock1 = (EditText) findViewById(R.id.comp_stock1);
        EditText stock2 = (EditText) findViewById(R.id.comp_stock2);
        EditText home1 = (EditText) findViewById(R.id.comp_home1);
        EditText home2 = (EditText) findViewById(R.id.comp_home2);
        EditText holidays1 = (EditText) findViewById(R.id.comp_hol1);
        EditText  holidays2 = (EditText) findViewById(R.id.comp_hol2);
        EditText internet1 = (EditText) findViewById(R.id.comp_int1);
        EditText internet2 = (EditText) findViewById(R.id.comp_int2);
        Job job1 = CompareJobsActivity.job1;
        Job job2 = CompareJobsActivity.job2;
        title1.setText(job1.getTitle());
        title2.setText(job2.getTitle());
        comp1.setText(job1.getCompany());
        comp2.setText(job2.getCompany());
        location1.setText(job1.getCity() + ", " + job1.getState());
        location2.setText(job2.getCity() + ", " + job2.getState());
        salary1.setText(Float.toString(job1.getYearlySalary() * 100 / job1.getCostOfLivingIndex()));
        salary2.setText(Float.toString(job2.getYearlySalary() * 100 / job2.getCostOfLivingIndex()));
        bonus1.setText(Float.toString(job1.getYearlyBonus() * 100 / job1.getCostOfLivingIndex()));
        bonus2.setText(Float.toString(job2.getYearlyBonus() * 100 / job2.getCostOfLivingIndex()));
        stock1.setText(Integer.toString(job1.getNumberOfStock()));
        stock2.setText(Integer.toString(job2.getNumberOfStock()));
        home1.setText(Float.toString(job1.getHomeBuyingFund()));
        home2.setText(Float.toString(job2.getHomeBuyingFund()));
        holidays1.setText(Integer.toString(job1.getPersonalChoiceHolidays()));
        holidays2.setText(Integer.toString(job2.getPersonalChoiceHolidays()));
        internet1.setText(Float.toString(job1.getMonthlyInternetStipend()));
        internet2.setText(Float.toString(job2.getMonthlyInternetStipend()));
    }

    public void onClickReturn(View view) {
        Intent compareJobsActivity = new Intent(this, CompareJobsActivity.class);
        startActivity(compareJobsActivity);
    }
}