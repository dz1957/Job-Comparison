package edu.gatech.seclass.jobcompare6300.entity;

import androidx.room.*;
@Entity
public class JobOffer extends Job {

    public JobOffer(String title, String company, String city, String state, int costOfLivingIndex, float yearlySalary, float yearlyBonus, int numberOfStock, float homeBuyingFund, int personalChoiceHolidays, float monthlyInternetStipend) {
        super(title, company, city, state, costOfLivingIndex, yearlySalary, yearlyBonus, numberOfStock, homeBuyingFund, personalChoiceHolidays, monthlyInternetStipend);
    }

    public JobOffer() {
        super();
    }
}