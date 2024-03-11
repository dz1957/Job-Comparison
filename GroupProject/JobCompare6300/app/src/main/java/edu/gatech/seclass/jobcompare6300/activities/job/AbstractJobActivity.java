package edu.gatech.seclass.jobcompare6300.activities.job;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

import edu.gatech.seclass.jobcompare6300.InputValidationUtility;
import edu.gatech.seclass.jobcompare6300.MainActivity;
import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.entity.Job;


public abstract class AbstractJobActivity extends AppCompatActivity {

    protected EditText jobTitleWidget;
    protected EditText companyWidget;
    protected EditText cityWidget;
    protected EditText stateWidget;
    protected EditText costOfLivingWidget;
    protected EditText salaryWidget;
    protected EditText bonusWidget;
    protected EditText numberOfStocksWidget;
    protected EditText homeBuyingFundWidget;
    protected EditText personalHolidaysWidget;
    protected EditText internetStipendWidget;

    public abstract void onClickOk(View view) throws ExecutionException, InterruptedException;
    public void onClickCancel(View view) {
        navigateToMainActivity();
    }
    protected void getJobFromWidgets(Job job) {
        job.setTitle(jobTitleWidget.getText().toString());
        job.setCompany(companyWidget.getText().toString());
        job.setCity(cityWidget.getText().toString());
        job.setState(stateWidget.getText().toString());
        job.setCostOfLivingIndex(Integer.parseInt(costOfLivingWidget.getText().toString()));
        job.setYearlySalary(Float.parseFloat(salaryWidget.getText().toString()));
        job.setYearlyBonus(Float.parseFloat(bonusWidget.getText().toString()));
        job.setNumberOfStock(Integer.parseInt(numberOfStocksWidget.getText().toString()));
        job.setHomeBuyingFund(Float.parseFloat(homeBuyingFundWidget.getText().toString()));
        job.setPersonalChoiceHolidays(Integer.parseInt(personalHolidaysWidget.getText().toString()));
        job.setMonthlyInternetStipend(Float.parseFloat(internetStipendWidget.getText().toString()));

    }

    protected void loadWidgetsFromJob(Job job) {
        jobTitleWidget.setText(job.getTitle());
        companyWidget.setText(job.getCompany());
        cityWidget.setText(job.getCity());
        stateWidget.setText(job.getState());
        costOfLivingWidget.setText(Integer.toString(job.getCostOfLivingIndex()));
        salaryWidget.setText(Float.toString(job.getYearlySalary()));
        bonusWidget.setText(Float.toString(job.getYearlyBonus()));
        numberOfStocksWidget.setText(Integer.toString(job.getNumberOfStock()));
        homeBuyingFundWidget.setText(Float.toString(job.getHomeBuyingFund()));
        personalHolidaysWidget.setText(Integer.toString(job.getPersonalChoiceHolidays()));
        internetStipendWidget.setText(Float.toString(job.getMonthlyInternetStipend()));
    }

    protected void navigateToMainActivity() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }

    protected boolean isValidInternetStipend() {

        boolean isValidInternetStipend = InputValidationUtility.validateMonthlyInternetStipend(internetStipendWidget.getText().toString());

        if (!isValidInternetStipend) {
            internetStipendWidget.setError("Internet stipend should be between 0 and 75.");
        }

        return isValidInternetStipend;
    }

    protected boolean isValidPersonalHoliday() {
        boolean isValidPersonalHoliday = InputValidationUtility.validatePersonalChoiceHoliday(personalHolidaysWidget.getText().toString());

        if (!isValidPersonalHoliday) {
            personalHolidaysWidget.setError("Value should be between 0 and 20.");
        }

        return isValidPersonalHoliday;
    }

    protected boolean isValidHomeBuyingFund() {
        boolean isValidHomeBuyingFund = InputValidationUtility.validateHomeBuyingFund(salaryWidget.getText().toString(), homeBuyingFundWidget.getText().toString());

        if (!isValidHomeBuyingFund) {
            homeBuyingFundWidget.setError("Value should be less than 15% of yearly salary.");
        }

        return isValidHomeBuyingFund;
    }
}
