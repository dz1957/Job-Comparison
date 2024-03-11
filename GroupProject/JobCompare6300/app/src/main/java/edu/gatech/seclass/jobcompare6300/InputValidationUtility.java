package edu.gatech.seclass.jobcompare6300;

public final class InputValidationUtility {

    private InputValidationUtility() {}

    public static boolean validatePersonalChoiceHoliday(String value) {
        float personalChoiceHoliday = Float.parseFloat(value);

        return 0 <= personalChoiceHoliday && personalChoiceHoliday <= 20;
    }

    public static boolean validateMonthlyInternetStipend(String value) {
        float internetStipend = Float.parseFloat(value);

        return 0 <= internetStipend && internetStipend <= 75;
    }

    public static boolean validateHomeBuyingFund(String salaryString, String value) {
        float salary = Float.parseFloat(salaryString);
        float homeBuyingFund = Float.parseFloat(value);
        return homeBuyingFund < 0.15 * salary;
    }
}
