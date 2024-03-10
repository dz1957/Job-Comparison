package edu.gatech.seclass.jobcompare6300.model;

import java.util.Objects;

public class JobData {

    private Integer id;
    private String title;
    private String company;
    private String city;
    private String state;
    private int costOfLivingIndex;
    private float yearlySalary;
    private float yearlyBonus;
    private int numberOfStock;
    private float homeBuyingFund;
    private int personalChoiceHolidays;
    private float monthlyInternetStipend;

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
        JobData job = (JobData) o;
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
