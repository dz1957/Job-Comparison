package edu.gatech.seclass.jobcompare6300.entity;

import androidx.room.*;
@Entity
public class JobOffer {

    public JobOffer(int id, String title, String company, String city, String state, int costOfLivingIndex, float yearlySalary, float yearlyBonus, int numberOfStock, float homeBuyingFund, int personalChoiceHolidays, float monthlyInternetStipend) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.city = city;
        this.state = state;
        this.costOfLivingIndex = costOfLivingIndex;
        this.yearlySalary = yearlySalary;
        this.yearlyBonus = yearlyBonus;
        this.numberOfStock = numberOfStock;
        this.homeBuyingFund = homeBuyingFund;
        this.personalChoiceHolidays = personalChoiceHolidays;
        this.monthlyInternetStipend = monthlyInternetStipend;
    }

    @PrimaryKey
    public int id;

    public String title;

    public String company;

    public String city;

    public String state;

    @ColumnInfo(name = "cost_of_living_index")
    public int costOfLivingIndex;

    @ColumnInfo(name = "yearly_salary")
    public float yearlySalary;

    @ColumnInfo(name = "yearly_bonus")
    public float yearlyBonus;

    @ColumnInfo(name = "number_of_stock")
    public int numberOfStock;

    @ColumnInfo(name = "home_buying_fund")
    public float homeBuyingFund;

    @ColumnInfo(name = "personal_choice_holidays")
    public int personalChoiceHolidays;

    @ColumnInfo(name = "monthly_internet_stipend")
    public float monthlyInternetStipend;


}