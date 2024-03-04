package edu.gatech.seclass.jobcompare6300.entity;

import androidx.room.*;

@Entity
public class WeightConfig {

    public WeightConfig(int id, int yearlySalaryWeight, int yearlyBonusWeight, int numberOfStockWeight, int homeBuyingFundWeight, int personalChoiceHolidaysWeight, int monthlyInternetStipendWeight) {
        this.id = id;
        this.yearlySalaryWeight = yearlySalaryWeight;
        this.yearlyBonusWeight = yearlyBonusWeight;
        this.numberOfStockWeight = numberOfStockWeight;
        this.homeBuyingFundWeight = homeBuyingFundWeight;
        this.personalChoiceHolidaysWeight = personalChoiceHolidaysWeight;
        this.monthlyInternetStipendWeight = monthlyInternetStipendWeight;
    }
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "yearly_salary_weight")
    public int yearlySalaryWeight;

    @ColumnInfo(name = "yearly_bonus_weight")
    public int yearlyBonusWeight;

    @ColumnInfo(name = "number_of_stock_weight")
    public int numberOfStockWeight;

    @ColumnInfo(name = "home_buying_fund_weight")
    public int homeBuyingFundWeight;

    @ColumnInfo(name = "personal_choice_holidays_weight")
    public int personalChoiceHolidaysWeight;

    @ColumnInfo(name = "monthly_internet_stipend_weight")
    public int monthlyInternetStipendWeight;


}