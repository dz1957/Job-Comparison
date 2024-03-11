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

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getSalaryWeight() {
        return yearlySalaryWeight;
    }

    public void setSalaryWeight(int yearlySalaryWeight) {
        this.yearlySalaryWeight = yearlySalaryWeight;
    }
    public Integer getBonusWeight() {
        return yearlyBonusWeight;
    }

    public void setBonusWeight(int yearlyBonusWeight) {
        this.yearlyBonusWeight = yearlyBonusWeight;
    }
    public Integer getStockWeight() {
        return numberOfStockWeight;
    }

    public void setStockWeight(int numberOfStockWeight) {
        this.numberOfStockWeight = numberOfStockWeight;
    }
    public Integer getFundWeight() {
        return homeBuyingFundWeight;
    }

    public void setFundWeight(int homeBuyingFundWeight) {
        this.homeBuyingFundWeight = homeBuyingFundWeight;
    }
    public Integer getHolidaysWeight() {
        return personalChoiceHolidaysWeight;
    }

    public void setHolidaysWeight(int personalChoiceHolidaysWeight) {
        this.personalChoiceHolidaysWeight = personalChoiceHolidaysWeight;
    }

    public Integer getStipendWeight() {
        return monthlyInternetStipendWeight;
    }

    public void setStipendWeight(int monthlyInternetStipendWeight) {
        this.monthlyInternetStipendWeight = monthlyInternetStipendWeight;
    }
}