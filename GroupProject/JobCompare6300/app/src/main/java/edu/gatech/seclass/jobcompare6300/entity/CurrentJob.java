@Entity
public class CurrentJob {
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