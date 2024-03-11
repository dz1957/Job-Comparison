package edu.gatech.seclass.jobcompare6300.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.MainActivity;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.activities.job.AbstractJobActivity;
import edu.gatech.seclass.jobcompare6300.entity.Job;

public class CompareJobsActivity extends AppCompatActivity {
    private ArrayList<TextView> numTextArray;
    private ArrayList<TextView> titleCompanyTextArray;
    private ArrayList<CheckBox> checkboxArray;
    private ArrayList<Job> jobArray;
    public static Job job1;
    public static Job job2;
    private boolean compareValid = false;
    private Button Compare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_jobs);
        numTextArray.add(findViewById(R.id.num_1));
        numTextArray.add(findViewById(R.id.num_2));
        numTextArray.add(findViewById(R.id.num_3));
        numTextArray.add(findViewById(R.id.num_4));
        numTextArray.add(findViewById(R.id.num_5));
        numTextArray.add(findViewById(R.id.num_6));
        numTextArray.add(findViewById(R.id.num_7));
        numTextArray.add(findViewById(R.id.num_8));
        numTextArray.add(findViewById(R.id.num_9));
        numTextArray.add(findViewById(R.id.num_10));
        titleCompanyTextArray.add(findViewById(R.id.comp_1));
        titleCompanyTextArray.add(findViewById(R.id.comp_2));
        titleCompanyTextArray.add(findViewById(R.id.comp_3));
        titleCompanyTextArray.add(findViewById(R.id.comp_4));
        titleCompanyTextArray.add(findViewById(R.id.comp_5));
        titleCompanyTextArray.add(findViewById(R.id.comp_6));
        titleCompanyTextArray.add(findViewById(R.id.comp_7));
        titleCompanyTextArray.add(findViewById(R.id.comp_8));
        titleCompanyTextArray.add(findViewById(R.id.comp_9));
        titleCompanyTextArray.add(findViewById(R.id.comp_10));
        checkboxArray.add(findViewById(R.id.comp_box1));
        checkboxArray.add(findViewById(R.id.comp_box2));
        checkboxArray.add(findViewById(R.id.comp_box3));
        checkboxArray.add(findViewById(R.id.comp_box4));
        checkboxArray.add(findViewById(R.id.comp_box5));
        checkboxArray.add(findViewById(R.id.comp_box6));
        checkboxArray.add(findViewById(R.id.comp_box7));
        checkboxArray.add(findViewById(R.id.comp_box8));
        checkboxArray.add(findViewById(R.id.comp_box9));
        checkboxArray.add(findViewById(R.id.comp_box10));
        Compare = findViewById(R.id.compare_compare);
        Compare.setBackgroundColor(Color.GRAY);
    }

    public void onClickCompare(View view) {
        if (compareValid) {
            boolean first = true;
            for (int i = 0; i <= 10; i++) {
                if (checkboxArray.get(i).isChecked()) {
                    if (first) {
                        job1 = jobArray.get(i);
                    } else {
                        job2 = jobArray.get(i);
                    }
                }
                Intent ComparisonScreenActivity = new Intent(this, ComparisonScreenActivity.class);
                startActivity(ComparisonScreenActivity);
        } } else {
            Compare.setError("Two Jobs must be selected to compare");
        }
    }

    public void checkboxCounter(View view) {
        int countBoxes = 0;
        for (CheckBox i : checkboxArray) {
            if (i.isChecked()) {
                countBoxes++;
            }
        }
        if (countBoxes == 2) {
            Compare.setBackgroundColor(Color.GREEN);
            compareValid = true;
        } else {
            Compare.setBackgroundColor(Color.GRAY);
            compareValid = false;
        }
    }
    public void onClickReturn(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}