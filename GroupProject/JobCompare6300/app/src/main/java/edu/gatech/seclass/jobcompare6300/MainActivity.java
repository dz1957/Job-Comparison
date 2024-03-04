package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class MainActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    CurrentJobDao currentJobDao;
    Button addJobButton, deleteJobButton;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase =Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_db")
                .allowMainThreadQueries()
                .build();
        currentJobDao = appDatabase.getCurrentJobDao();

        textView = findViewById(R.id.textView);
        updateView();

        addJobButton = findViewById(R.id.addJobButton);
        addJobButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                CurrentJob job1 = new CurrentJob(123, "SDE", "Amazon",
                        "Seattle", "WA", 123,
                123, 123, 1, 1,
                1, 1);
                currentJobDao.insert(job1);
                updateView();
            }
        }
        );
    }
    void updateView(){
        CurrentJob currentJob= currentJobDao.getCurrentJob();
        int jobId;
        if (currentJob != null) {
            jobId = currentJob.id;
        } else {
            // Handle the case when currentJob is null
            jobId = -1;
        }
        String jobId_String = String.valueOf(jobId);
        textView.setText(jobId_String);
    }

}