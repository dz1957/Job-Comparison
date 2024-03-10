package edu.gatech.seclass.jobcompare6300.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;


public abstract class Job {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String title;
    private String company;
    private String city;
    private String state;
    @ColumnInfo(name = "cost_of_living_index")
    private int costOfLivingIndex;
    @ColumnInfo(name = "yearly_salary")
    private float yearlySalary;
    @ColumnInfo(name = "yearly_bonus")
    private float yearlyBonus;
    @ColumnInfo(name = "number_of_stock")
    private int numberOfStock;
    @ColumnInfo(name = "home_buying_fund")
    private float homeBuyingFund;
    @ColumnInfo(name = "personal_choice_holidays")
    private int personalChoiceHolidays;
    @ColumnInfo(name = "monthly_internet_stipend")
    private float monthlyInternetStipend;

    public Job(String title, String company, String city, String state, int costOfLivingIndex, float yearlySalary, float yearlyBonus, int numberOfStock, float homeBuyingFund, int personalChoiceHolidays, float monthlyInternetStipend) {
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

    public Job() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCostOfLivingIndex() {
        return costOfLivingIndex;
    }

    public void setCostOfLivingIndex(int costOfLivingIndex) {
        this.costOfLivingIndex = costOfLivingIndex;
    }

    public float getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(float yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public float getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(float yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }

    public int getNumberOfStock() {
        return numberOfStock;
    }

    public void setNumberOfStock(int numberOfStock) {
        this.numberOfStock = numberOfStock;
    }

    public float getHomeBuyingFund() {
        return homeBuyingFund;
    }

    public void setHomeBuyingFund(float homeBuyingFund) {
        this.homeBuyingFund = homeBuyingFund;
    }

    public int getPersonalChoiceHolidays() {
        return personalChoiceHolidays;
    }

    public void setPersonalChoiceHolidays(int personalChoiceHolidays) {
        this.personalChoiceHolidays = personalChoiceHolidays;
    }

    public float getMonthlyInternetStipend() {
        return monthlyInternetStipend;
    }

    public void setMonthlyInternetStipend(float monthlyInternetStipend) {
        this.monthlyInternetStipend = monthlyInternetStipend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return costOfLivingIndex == job.costOfLivingIndex && Float.compare(job.yearlySalary, yearlySalary) == 0 && Float.compare(job.yearlyBonus, yearlyBonus) == 0 && numberOfStock == job.numberOfStock && Float.compare(job.homeBuyingFund, homeBuyingFund) == 0 && personalChoiceHolidays == job.personalChoiceHolidays && Float.compare(job.monthlyInternetStipend, monthlyInternetStipend) == 0 && Objects.equals(id, job.id) && Objects.equals(title, job.title) && Objects.equals(company, job.company) && Objects.equals(city, job.city) && Objects.equals(state, job.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, company, city, state, costOfLivingIndex, yearlySalary, yearlyBonus, numberOfStock, homeBuyingFund, personalChoiceHolidays, monthlyInternetStipend);
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", costOfLivingIndex=" + costOfLivingIndex +
                ", yearlySalary=" + yearlySalary +
                ", yearlyBonus=" + yearlyBonus +
                ", numberOfStock=" + numberOfStock +
                ", homeBuyingFund=" + homeBuyingFund +
                ", personalChoiceHolidays=" + personalChoiceHolidays +
                ", monthlyInternetStipend=" + monthlyInternetStipend +
                '}';
    }
}
