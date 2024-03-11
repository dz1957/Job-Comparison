package edu.gatech.seclass.jobcompare6300.activities.job;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.R;

public class JobOfferActivity extends AbstractJobActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_offer);
    }

    public void onClickOk(View view) throws ExecutionException, InterruptedException {
    }
}