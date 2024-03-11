package edu.gatech.seclass.jobcompare6300.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    WeightConfig existingWeightConfig;
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

        appDatabase = AppDatabase.getInstance(this.getApplication());

        appDatabase.getWeightConfigDao().get().observe(this, config -> {
            existingWeightConfig = config;
            if (existingWeightConfig != null) {
                // If weights exist in the database, set EditText values accordingly
                weightSalary.setText(String.valueOf(existingWeightConfig.getSalaryWeight()));
                weightBonus.setText(String.valueOf(existingWeightConfig.getBonusWeight()));
                weightStocks.setText(String.valueOf(existingWeightConfig.getStockWeight()));
                weightHomeFund.setText(String.valueOf(existingWeightConfig.getFundWeight()));
                weightHolidays.setText(String.valueOf(existingWeightConfig.getHolidaysWeight()));
                weightInternetStipend.setText(String.valueOf(existingWeightConfig.getStipendWeight()));
            } else {
                // If no weights exist in the database, set default values of 1
                weightSalary.setText("1");
                weightBonus.setText("1");
                weightStocks.setText("1");
                weightHomeFund.setText("1");
                weightHolidays.setText("1");
                weightInternetStipend.setText("1");
            }
        });

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

        if (salaryWeight == -1 || bonusWeight == -1 || stocksWeight == -1 ||
                homeFundWeight == -1 || holidaysWeight == -1 || internetStipendWeight == -1) {
            // If any of the weights is not a valid integer, pause at the layout
            return;
        }

        updateWeightsInDatabase(salaryWeight, bonusWeight, stocksWeight,
                homeFundWeight, holidaysWeight, internetStipendWeight);

        navigateToMainActivity();
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
        String valueString = editText.getText().toString().trim();
        if (valueString.isEmpty()) {
            return 1;
        } else {
            try {
                int parsedValue = Integer.parseInt(valueString);

                // Check if the parsed value is positive
                if (parsedValue > 0) {
                    return parsedValue;
                } else {
                    editText.setError("Invalid Entry Text: Must be a positive Integer");
                    return -1; // Return -1 indicates an error
                }
            } catch (NumberFormatException e) {
                editText.setError("Invalid Entry Text: Must be Integer");
                return -1; // Return -1 indicates an error
            }
        }
    }

    private void updateWeightsInDatabase(int salaryWeight, int bonusWeight,
                                         int stocksWeight, int homeFundWeight,
                                         int holidaysWeight, int internetStipendWeight) {
        // Use the WeightConfigDao to update the weights in the database
        appDatabase.getWeightConfigDao().get().observe(this, config -> {
            existingWeightConfig = config;
            if (existingWeightConfig != null) {
                existingWeightConfig.setSalaryWeight(salaryWeight);
                existingWeightConfig.setBonusWeight(bonusWeight);
                existingWeightConfig.setStockWeight(stocksWeight);
                existingWeightConfig.setFundWeight(homeFundWeight);
                existingWeightConfig.setHolidaysWeight(holidaysWeight);
                existingWeightConfig.setStipendWeight(internetStipendWeight);

                AppDatabase.databaseWriteExecutor.execute(() -> {
                    appDatabase.getWeightConfigDao().update(existingWeightConfig);

                });
            }
            else {
                WeightConfig newWeightConfig = new WeightConfig(1,1,1,1,1,1,1);
                newWeightConfig.setSalaryWeight(salaryWeight);
                newWeightConfig.setBonusWeight(bonusWeight);
                AppDatabase.databaseWriteExecutor.execute(() -> {
                    appDatabase.getWeightConfigDao().insert(newWeightConfig);
                });
            }
        });

    }

}