package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
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
import edu.gatech.seclass.jobcompare6300.service.DatabaseService;
import edu.gatech.seclass.jobcompare6300.dao.CurrentJobDao;
import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class MainActivity extends AppCompatActivity {
    AppDatabase appDatabase;
    CurrentJobDao currentJobDao;
    Button addJobButton, deleteJobButton;
    TextView textView;
    private EditText current_jobtitle = findViewById(R.id.current_jobtitle);
    private EditText current_company = findViewById(R.id.current_company);
    private EditText current_city = findViewById(R.id.current_city);
    private EditText current_state = findViewById(R.id.current_state);
    private EditText current_COLInd = findViewById(R.id.current_col_index);
    private EditText current_salary = findViewById(R.id.current_salary);
    private EditText current_bonus = findViewById(R.id.current_bonus);
    private EditText current_stocks = findViewById(R.id.current_stocks);
    private EditText current_homefund = findViewById(R.id.current_homefund);
    private EditText current_holidays = findViewById(R.id.current_holidays);
    private EditText current_internetstipend = findViewById(R.id.current_internetstipend);
    private EditText offer_jobtitle = findViewById(R.id.offer_jobtitle);
    private EditText offer_company = findViewById(R.id.offer_company);
    private EditText offer_city = findViewById(R.id.offer_city);
    private EditText offer_state = findViewById(R.id.current_state);
    private EditText offer_COLInd = findViewById(R.id.offer_col_index);
    private EditText offer_salary = findViewById(R.id.offer_salary);
    private EditText offer_bonus = findViewById(R.id.offer_bonus);
    private EditText offer_stocks = findViewById(R.id.offer_stocks);
    private EditText offer_homefund = findViewById(R.id.offer_homefund);
    private EditText offer_holidays = findViewById(R.id.offer_holidays);
    private EditText offer_internetstipend = findViewById(R.id.offer_internetstipend);
    private CurrentJob currentJob;
    private JobOffer jobOffer;
    private WeightConfig weightConfig = new WeightConfig(1, 1, 1, 1, 1, 1, 1);
    private int jobOfferId = 2;
    private EditText weight_salary = findViewById(R.id.weight_salary);
    private EditText weight_bonus = findViewById(R.id.weight_bonus);
    private EditText weight_stocks = findViewById(R.id.weight_stocks);
    private EditText weight_homefund = findViewById(R.id.weight_homefund);
    private EditText weight_holidays = findViewById(R.id.weight_holidays);
    private EditText weight_internetstipend = findViewById(R.id.weight_internetstipend);
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
    public void currentJobButton(View view) {
        setContentView(R.layout.current_job_details);
        if (currentJob.id == null) {}
        else {
            current_jobtitle.setText(currentJob.title);
            current_company.setText(currentJob.company);
            current_city.setText(currentJob.city);
            current_state.setText(currentJob.state);
            current_COLInd.setText(currentJob.costOfLivingIndex);
            current_salary.setText((int) currentJob.yearlySalary);
            current_bonus.setText((int) currentJob.yearlyBonus);
            current_stocks.setText(currentJob.numberOfStock);
            current_homefund.setText((int) currentJob.homeBuyingFund);
            current_holidays.setText(currentJob.personalChoiceHolidays);
            current_internetstipend.setText((int) currentJob.monthlyInternetStipend);
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
        DatabaseService.saveCurrentJob(currentJob);
    }
    public void jobOfferButton(View view) {
        setContentView(R.layout.add_job_offer);
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
        DatabaseService.saveJobOffer(jobOffer);
    }

    public void cancelButton(View view) {
        setContentView(R.layout.activity_main);
    }
    public void editWeights(View view) {
        setContentView(R.layout.comparison_weights);
        weight_salary.setText(weightConfig.yearlySalaryWeight);
        weight_bonus.setText(weightConfig.yearlyBonusWeight);
        weight_stocks.setText(weightConfig.numberOfStockWeight);
        weight_homefund.setText(weightConfig.homeBuyingFundWeight);
        weight_holidays.setText(weightConfig.personalChoiceHolidaysWeight);
        weight_internetstipend.setText(weightConfig.monthlyInternetStipendWeight);
    }
    public void okWeights(View view) {
        weightConfig.yearlySalaryWeight = Integer.parseInt(offer_salary.getText().toString());
        weightConfig.yearlyBonusWeight = Integer.parseInt(offer_bonus.getText().toString());
        weightConfig.numberOfStockWeight = Integer.parseInt(offer_stocks.getText().toString());
        weightConfig.homeBuyingFundWeight = Integer.parseInt(offer_homefund.getText().toString());
        weightConfig.personalChoiceHolidaysWeight = Integer.parseInt(offer_holidays.getText().toString());
        weightConfig.monthlyInternetStipendWeight = Integer.parseInt(offer_internetstipend.getText().toString());
        DatabaseService.saveWeightConfig(weightConfig);
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