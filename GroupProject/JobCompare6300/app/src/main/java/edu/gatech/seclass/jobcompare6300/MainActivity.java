package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;
import edu.gatech.seclass.jobcompare6300.entity.JobOffer;
import edu.gatech.seclass.jobcompare6300.entity.WeightConfig;
//import edu.gatech.seclass.jobcompare6300.service.DatabaseService;
import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
//import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class MainActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    CurrentJobDao currentJobDao;
    Button addJobButton, deleteJobButton;
    TextView textView;
    private EditText current_jobtitle;
    private EditText current_company;
    private EditText current_city;
    private EditText current_state;
    private EditText current_COLInd;
    private EditText current_salary;
    private EditText current_bonus;
    private EditText current_stocks;
    private EditText current_homefund;
    private EditText current_holidays;
    private EditText current_internetstipend;
    private EditText offer_jobtitle;
    private EditText offer_company;
    private EditText offer_city ;
    private EditText offer_state;
    private EditText offer_COLInd;
    private EditText offer_salary;
    private EditText offer_bonus;
    private EditText offer_stocks;
    private EditText offer_homefund;
    private EditText offer_holidays;
    private EditText offer_internetstipend;
    private CurrentJob currentJob;
    private JobOffer jobOffer;
    private WeightConfig weightConfig = new WeightConfig(1, 1, 1, 1, 1, 1, 1);
    private int jobOfferId = 2;
    private EditText weight_salary;
    private EditText weight_bonus;
    private EditText weight_stocks;
    private EditText weight_homefund;
    private EditText weight_holidays;
    private EditText weight_internetstipend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase =Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "app_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        currentJobDao = appDatabase.getCurrentJobDao();
        textView = findViewById(R.id.textView);
        updateView();


        //addJobButton = findViewById(R.id.addJobButton);
        //addJobButton.setOnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View view) {
               // CurrentJob job1 = new CurrentJob(123, "SDE", "Amazon",
              //          "Seattle", "WA", 123,
               // 123, 123, 1, 1,
               // 1, 1);
               // currentJobDao.insert(job1);
                //updateView();
           // }
        //}
        //);
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
    public void currentJobButton(View view) {
        setContentView(R.layout.current_job_details);
        current_jobtitle = findViewById(R.id.current_jobtitle);
        current_company = findViewById(R.id.current_company);
        current_city = findViewById(R.id.current_city);
        current_state = findViewById(R.id.current_state);
        current_COLInd = findViewById(R.id.current_col_index);
        current_salary = findViewById(R.id.current_salary);
        current_bonus = findViewById(R.id.current_bonus);
        current_stocks = findViewById(R.id.current_stocks);
        current_homefund = findViewById(R.id.current_homefund);
        current_holidays = findViewById(R.id.current_holidays);
        current_internetstipend = findViewById(R.id.current_internetstipend);
        if (currentJob == null) {}
        else {
            current_jobtitle.setText(currentJob.title);
            current_company.setText(currentJob.company);
            current_city.setText(currentJob.city);
            current_state.setText(currentJob.state);
            current_COLInd.setText(String.valueOf(currentJob.costOfLivingIndex));
            current_salary.setText(String.valueOf(currentJob.yearlySalary));
            current_bonus.setText(String.valueOf(currentJob.yearlyBonus));
            current_stocks.setText(String.valueOf(currentJob.numberOfStock));
            current_homefund.setText(String.valueOf(currentJob.homeBuyingFund));
            current_holidays.setText(String.valueOf(currentJob.personalChoiceHolidays));
            current_internetstipend.setText(String.valueOf(currentJob.monthlyInternetStipend));
        }
    }
    public void okCurrentJob(View view) {
        currentJob = new CurrentJob(1,
        current_jobtitle.getText().toString(),
        current_company.getText().toString(),
        current_city.getText().toString(),
        current_state.getText().toString(),
        Integer.parseInt(current_COLInd.getText().toString()),
        Integer.parseInt(current_salary.getText().toString()),
        Integer.parseInt(current_bonus.getText().toString()),
        Integer.parseInt(current_stocks.getText().toString()),
        Integer.parseInt(current_homefund.getText().toString()),
        Integer.parseInt(current_holidays.getText().toString()),
        Integer.parseInt(current_internetstipend.getText().toString()));
        //DatabaseService.saveCurrentJob(currentJob);
        setContentView(R.layout.activity_main);
    }
    public void jobOfferButton(View view) {

        setContentView(R.layout.add_job_offer);
        offer_jobtitle = findViewById(R.id.offer_jobtitle);
        offer_company = findViewById(R.id.offer_company);
        offer_city = findViewById(R.id.offer_city);
        offer_state = findViewById(R.id.offer_state);
        offer_COLInd = findViewById(R.id.offer_col_index);
        offer_salary = findViewById(R.id.offer_salary);
        offer_bonus = findViewById(R.id.offer_bonus);
        offer_stocks = findViewById(R.id.offer_stocks);
        offer_homefund = findViewById(R.id.offer_homefund);
        offer_holidays = findViewById(R.id.offer_holidays);
        offer_internetstipend = findViewById(R.id.offer_internetstipend);
    }
    public void okJobOffer(View view) {
        jobOffer = new JobOffer(jobOfferId,
        offer_jobtitle.getText().toString(),
        offer_company.getText().toString(),
        offer_city.getText().toString(),
        offer_state.getText().toString(),
        Integer.parseInt(offer_COLInd.getText().toString()),
        Integer.parseInt(offer_salary.getText().toString()),
        Integer.parseInt(offer_bonus.getText().toString()),
        Integer.parseInt(offer_stocks.getText().toString()),
        Integer.parseInt(offer_homefund.getText().toString()),
        Integer.parseInt(offer_holidays.getText().toString()),
        Integer.parseInt(offer_internetstipend.getText().toString()));
        jobOfferId +=1;
        //DatabaseService.saveJobOffer(jobOffer);
        setContentView(R.layout.activity_main);
    }

    public void cancelButton(View view) {
        setContentView(R.layout.activity_main);
    }
    public void editWeights(View view) {
        setContentView(R.layout.comparison_weights);
        weight_salary = findViewById(R.id.weight_salary);
        weight_bonus = findViewById(R.id.weight_bonus);
        weight_stocks = findViewById(R.id.weight_stocks);
        weight_homefund = findViewById(R.id.weight_homefund);
        weight_holidays = findViewById(R.id.weight_holidays);
        weight_internetstipend = findViewById(R.id.weight_internetstipend);
        weight_salary.setText(String.valueOf(weightConfig.yearlySalaryWeight));
        weight_bonus.setText(String.valueOf(weightConfig.yearlyBonusWeight));
        weight_stocks.setText(String.valueOf(weightConfig.numberOfStockWeight));
        weight_homefund.setText(String.valueOf(weightConfig.homeBuyingFundWeight));
        weight_holidays.setText(String.valueOf(weightConfig.personalChoiceHolidaysWeight));
        weight_internetstipend.setText(String.valueOf(weightConfig.monthlyInternetStipendWeight));
    }
    public void okWeights(View view) {
        weightConfig.yearlySalaryWeight = Integer.parseInt(offer_salary.getText().toString());
        weightConfig.yearlyBonusWeight = Integer.parseInt(offer_bonus.getText().toString());
        weightConfig.numberOfStockWeight = Integer.parseInt(offer_stocks.getText().toString());
        weightConfig.homeBuyingFundWeight = Integer.parseInt(offer_homefund.getText().toString());
        weightConfig.personalChoiceHolidaysWeight = Integer.parseInt(offer_holidays.getText().toString());
        weightConfig.monthlyInternetStipendWeight = Integer.parseInt(offer_internetstipend.getText().toString());
        //DatabaseService.saveWeightConfig(weightConfig);
    }
    public void compareJobs(View view) {
        setContentView(R.layout.compare_jobs);
    }

    public float jobOfferScore(JobOffer jobOffer, WeightConfig weightConfig) {
        int netWeight = weightConfig.yearlySalaryWeight + weightConfig.yearlyBonusWeight + weightConfig.numberOfStockWeight
                + weightConfig.homeBuyingFundWeight + weightConfig.personalChoiceHolidaysWeight + weightConfig.monthlyInternetStipendWeight;
        float score = weightConfig.yearlySalaryWeight*(jobOffer.yearlySalary/(jobOffer.costOfLivingIndex/100))
        + weightConfig.yearlyBonusWeight*(jobOffer.yearlyBonus/(jobOffer.costOfLivingIndex/100))
        + jobOffer.numberOfStock/3
        + jobOffer.homeBuyingFund
        + jobOffer.personalChoiceHolidays * weightConfig.yearlySalaryWeight*(jobOffer.yearlySalary/(jobOffer.costOfLivingIndex/100))/260
        + jobOffer.monthlyInternetStipend*12;
        return score/netWeight;
    }

    //  find and reference widgets with their ids from the layout XML file.
    // ...
}