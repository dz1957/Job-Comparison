package edu.gatech.seclass.jobcompare6300.entity;

import androidx.room.*;

import java.util.Objects;

@Entity
public class CurrentJob {

    public CurrentJob(Integer id, String title, String company, String city, String state, int costOfLivingIndex, float yearlySalary, float yearlyBonus, int numberOfStock, float homeBuyingFund, int personalChoiceHolidays, float monthlyInternetStipend) {
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

    public CurrentJob() {

    }

    @PrimaryKey(autoGenerate = true)
    public Integer id;

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
        CurrentJob that = (CurrentJob) o;
        return costOfLivingIndex == that.costOfLivingIndex && Float.compare(that.yearlySalary, yearlySalary) == 0 && Float.compare(that.yearlyBonus, yearlyBonus) == 0 && numberOfStock == that.numberOfStock && Float.compare(that.homeBuyingFund, homeBuyingFund) == 0 && personalChoiceHolidays == that.personalChoiceHolidays && Float.compare(that.monthlyInternetStipend, monthlyInternetStipend) == 0 && Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(company, that.company) && Objects.equals(city, that.city) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, company, city, state, costOfLivingIndex, yearlySalary, yearlyBonus, numberOfStock, homeBuyingFund, personalChoiceHolidays, monthlyInternetStipend);
    }

    @Override
    public String toString() {
        return "CurrentJob{" +
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