package edu.gatech.seclass.jobcompare6300.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.gatech.seclass.jobcompare6300.MainActivity;
import edu.gatech.seclass.jobcompare6300.R;

public class ComparisonWeightsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_weights);
    }

    public void onClickOk(View view) {

    }

    public void onClickCancel(View view) {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}