package edu.gatech.seclass.jobcompare6300;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.entity.CurrentJob;

public class CurrentJobActivity extends AppCompatActivity {

    private CurrentJob currentJob;
    private EditText jobTitleWidget;
    private EditText companyWidget;
    private EditText cityWidget;
    private EditText stateWidget;
    private EditText costOfLivingWidget;
    private EditText salaryWidget;
    private EditText bonusWidget;
    private EditText numberOfStocksWidget;
    private EditText homeBuyingFundWidget;
    private EditText personalHolidaysWidget;
    private EditText internetStipendWidget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_job);

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

    @Override
    protected void onStart() {
        super.onStart();
        loadCurrentJob();
    }

    public void onClickOk(View view) throws ExecutionException, InterruptedException {
        boolean isValidInternetStipend = isValidInternetStipend();
        boolean isValidPersonalHoliday = isValidPersonalHoliday();
        boolean isValidHomeBuyingFund = isValidHomeBuyingFund();

        if (isValidInternetStipend && isValidPersonalHoliday && isValidHomeBuyingFund) {
            //Store in database
            getCurrentJobFromWidgets();
            if (currentJob.getId() == null) {
                CompletableFuture.runAsync(() -> {
                    Log.i("Insert current job {}", currentJob.toString());
                    AppDatabase.getInstance(this).getCurrentJobDao().insert(currentJob);
                }).get();
            } else {
                CompletableFuture.runAsync(() -> {
                    Log.i("Update current job {}", currentJob.toString());
                    AppDatabase.getInstance(this).getCurrentJobDao().update(currentJob);
                }).get();
            }

            navigateToMainActivity();
        }

    }

    public void onClickCancel(View view) {
        navigateToMainActivity();
    }

    public void navigateToMainActivity() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    private void loadCurrentJob() {
        currentJob = AppDatabase.getInstance(this).getCurrentJobDao().getCurrentJob().getValue();

        if (currentJob == null) {
            return;
        }
        jobTitleWidget.setText(currentJob.getTitle());
        companyWidget.setText(currentJob.getCompany());
        cityWidget.setText(currentJob.getCity());
        stateWidget.setText(currentJob.getState());
        costOfLivingWidget.setText(currentJob.getCostOfLivingIndex());
        salaryWidget.setText(Float.toString(currentJob.getYearlySalary()));
        bonusWidget.setText(Float.toString(currentJob.getYearlyBonus()));
        numberOfStocksWidget.setText(currentJob.getNumberOfStock());
        homeBuyingFundWidget.setText(Float.toString(currentJob.getHomeBuyingFund()));
        personalHolidaysWidget.setText(currentJob.getPersonalChoiceHolidays());
        internetStipendWidget.setText(Float.toString(currentJob.getMonthlyInternetStipend()));

    }

    private void getCurrentJobFromWidgets() {

        if (currentJob == null) {
            currentJob = new CurrentJob();
        }

        currentJob.setTitle(jobTitleWidget.getText().toString());
        currentJob.setCompany(companyWidget.getText().toString());
        currentJob.setCity(cityWidget.getText().toString());
        currentJob.setState(stateWidget.getText().toString());
        currentJob.setCostOfLivingIndex(Integer.parseInt(costOfLivingWidget.getText().toString()));
        currentJob.setYearlySalary(Float.parseFloat(salaryWidget.getText().toString()));
        currentJob.setYearlyBonus(Float.parseFloat(bonusWidget.getText().toString()));
        currentJob.setNumberOfStock(Integer.parseInt(numberOfStocksWidget.getText().toString()));
        currentJob.setHomeBuyingFund(Float.parseFloat(homeBuyingFundWidget.getText().toString()));
        currentJob.setPersonalChoiceHolidays(Integer.parseInt(personalHolidaysWidget.getText().toString()));
        currentJob.setMonthlyInternetStipend(Float.parseFloat(internetStipendWidget.getText().toString()));

    }

    private boolean isValidInternetStipend() {

        boolean isValidInternetStipend = InputValidationUtility.validateMonthlyInternetStipend(internetStipendWidget.getText().toString());

        if (!isValidInternetStipend) {
            internetStipendWidget.setError("Internet stipend should be between 0 and 75.");
        }

        return isValidInternetStipend;
    }

    private boolean isValidPersonalHoliday() {
        boolean isValidPersonalHoliday = InputValidationUtility.validatePersonalChoiceHoliday(personalHolidaysWidget.getText().toString());

        if (!isValidPersonalHoliday) {
            personalHolidaysWidget.setError("Value should be between 0 and 20.");
        }

        return isValidPersonalHoliday;
    }

    private boolean isValidHomeBuyingFund() {
        boolean isValidHomeBuyingFund = InputValidationUtility.validateHomeBuyingFund(salaryWidget.getText().toString(), personalHolidaysWidget.getText().toString());

        if (!isValidHomeBuyingFund) {
            personalHolidaysWidget.setError("Value should be less than 15% of yearly salary.");
        }

        return isValidHomeBuyingFund;
    }
}