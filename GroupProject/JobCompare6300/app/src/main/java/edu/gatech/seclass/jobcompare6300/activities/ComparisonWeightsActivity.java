package edu.gatech.seclass.jobcompare6300.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.gatech.seclass.jobcompare6300.MainActivity;
import edu.gatech.seclass.jobcompare6300.R;

import edu.gatech.seclass.jobcompare6300.database.AppDatabase;
import edu.gatech.seclass.jobcompare6300.entity.*;
import edu.gatech.seclass.jobcompare6300.dao.*;

public class ComparisonWeightsActivity extends AppCompatActivity {
    protected EditText weightSalary;
    protected EditText weightBonus;
    protected EditText weightStocks;
    protected EditText weightHomeFund;
    protected EditText weightHolidays;
    protected EditText weightInternetStipend;
    AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_weights);

        // Initialize the EditText fields
        weightSalary = (EditText) findViewById(R.id.weight_salary);
        weightBonus = (EditText) findViewById(R.id.weight_bonus);
        weightStocks = (EditText) findViewById(R.id.weight_stocks);
        weightHomeFund = (EditText) findViewById(R.id.weight_homefund);
        weightHolidays = (EditText) findViewById(R.id.weight_holidays);
        weightInternetStipend = (EditText) findViewById(R.id.weight_internetstipend);

    }

    public void onClickOk(View view) {
        // Check if any weight is empty, and if so, set it to 1
        if (isAnyWeightEmpty()) {
            setDefaultWeights();
        }
        // Get the values from the EditText fields
        int salaryWeight = getWeightValue(weightSalary);
        int bonusWeight = getWeightValue(weightBonus);
        int stocksWeight = getWeightValue(weightStocks);
        int homeFundWeight = getWeightValue(weightHomeFund);
        int holidaysWeight = getWeightValue(weightHolidays);
        int internetStipendWeight = getWeightValue(weightInternetStipend);
        updateWeightsInDatabase(salaryWeight, bonusWeight, stocksWeight,
                homeFundWeight, holidaysWeight, internetStipendWeight);

    }

    public void onClickCancel(View view) {
        navigateToMainActivity();
    }

    protected void navigateToMainActivity() {
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
    private boolean isAnyWeightEmpty() {
        return weightSalary.getText().toString().isEmpty() ||
                weightBonus.getText().toString().isEmpty() ||
                weightStocks.getText().toString().isEmpty() ||
                weightHomeFund.getText().toString().isEmpty() ||
                weightHolidays.getText().toString().isEmpty() ||
                weightInternetStipend.getText().toString().isEmpty();
    }
    private void setDefaultWeights() {
        // Set any empty weight field to 1
        if (weightSalary.getText().toString().isEmpty()) {
            weightSalary.setText("1");
        }
        if (weightBonus.getText().toString().isEmpty()) {
            weightBonus.setText("1");
        }
        if (weightStocks.getText().toString().isEmpty()) {
            weightStocks.setText("1");
        }
        if (weightHomeFund.getText().toString().isEmpty()) {
            weightHomeFund.setText("1");
        }
        if (weightHolidays.getText().toString().isEmpty()) {
            weightHolidays.setText("1");
        }
        if (weightInternetStipend.getText().toString().isEmpty()) {
            weightInternetStipend.setText("1");
        }
    }

    private int getWeightValue(EditText editText) {
        String valueString = editText.getText().toString();
        if (valueString.isEmpty()) {
            return 1;
        } else {
            try {
                return Integer.parseInt(valueString);
            } catch (NumberFormatException e) {
                // Handle the case when the input cannot be parsed as a double
                return 1; // Return a default value in case of an error
            }
        }
    }

    private void updateWeightsInDatabase(int salaryWeight, int bonusWeight,
                                         int stocksWeight, int homeFundWeight,
                                         int holidaysWeight, int internetStipendWeight) {
        // Use the WeightConfigDao to update the weights in the database
        AppDatabase.databaseWriteExecutor.execute(() -> {
            WeightConfig existingWeightConfig = appDatabase.getWeightConfigDao().get();

            if (existingWeightConfig != null) {
                existingWeightConfig.setSalaryWeight(salaryWeight);
                existingWeightConfig.setBonusWeight(bonusWeight);
                existingWeightConfig.setStockWeight(stocksWeight);
                existingWeightConfig.setFundWeight(homeFundWeight);
                existingWeightConfig.setHolidaysWeight(holidaysWeight);
                existingWeightConfig.setStipendWeight(internetStipendWeight);

                appDatabase.getWeightConfigDao().update(existingWeightConfig);
            } else {
                WeightConfig newWeightConfig = new WeightConfig(1,1,1,1,1,1,1);
                newWeightConfig.setSalaryWeight(salaryWeight);
                newWeightConfig.setBonusWeight(bonusWeight);

                appDatabase.getWeightConfigDao().insert(newWeightConfig);
            }
        });
    }

}