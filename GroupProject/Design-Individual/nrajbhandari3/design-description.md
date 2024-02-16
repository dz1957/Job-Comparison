# **Requirement 1**

When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

***Explanation***
The design does not account for the UI design, but it accounts for the classes that stores all of the items listed in requirement 1.



# **Requirement 2**

When choosing to enter current job details, a user will:
1. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
    1. Title
    2. Company
    3. Location (entered as city and state)
    4. Cost of living in the location (expressed as an index)
    5. Yearly salary 
    6. Yearly bonus  
    7. Number of stock option shares offered
    8. Home Buying Program fund (one-time dollar amount up to 15% of Yearly Salary)
    9. Personal Choice Holidays (A single overall number of days from 0 to 20)
    10. Monthly Internet Stipend ($0 to $75 inclusive)
    11. Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

***Explanation***
The CurrentJob class allows the user to store the details entered in the current job screen. The CurrentJob class is a sub-type of the Job class that express all the bullet items as attribute. The common Job class is a parent for both the user's current job and any other job active job offers.


# **Requirement 3**
When choosing to enter job offers, a user will:
1. Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
2. Be able to either save the job offer details or cancel.
3. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

***Explanation***
Similar to requirement 2, the OfferredJob class stores all the attributes of the job entered by the user. The user can store as many job offers as needed.


# **Requirement 4**
When adjusting the comparison settings, the user can assign integer weights to:
1. Yearly salary
2. Yearly bonus
3. Number of Stock Option Shares Offered
4. Home Buying Program Fund
5. Personal Choice Holidays
6. Monthly Internet Stipend
If no weights are assigned, all factors are considered equal.

***Explanation***
The ComparisonSetting class stores the integer weights assigned by the user. This also has assocations with the JobComparison class. While the ranks are stored in the Job class, the association denotes that the comparison settings are used to rank all the user's current and offered jobs.

# **Requirement 5**
When choosing to compare job offers, a user will:
1. Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
2. Select two jobs to compare and trigger the comparison.
3. Be shown a table comparing the two jobs, displaying, for each job:
    1. Title
    2. Company
    3. Location 
    4. Yearly salary adjusted for cost of living
    5. Yearly bonus adjusted for cost of living
    6. Number of Stock Option Shares Offered
    7. Home Buying Program fund (one-time up to 15% of Yearly Salary)
    8. Personal Choice Holidays (A single overall number of days from 0 to 20) 
    9. Monthly Internet Stipend ($0 to $75 inclusive monthly)

Be offered to perform another comparison or go back to the main menu.


***Explanation***
The JobComparison class stores the two jobs the user is comparing. This class acts as a reference for the Job classes that the user selects.

The ranking for each job is calculated and stored in the Job class in the ranking attribute.

# **Requirement 6**

When ranking jobs, a job’s score is computed as the weighted average of:

AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)

where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
CSO = Company shares offered (assuming a 3-year vesting schedule and a price-per-share of $1)
HBP = Home Buying Program
PCH = Personal Choice Holidays 
MIS= Monthly Internet Stipend 

For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for Internet Stipend, and 1 for all other factors, the score would be computed as:


2/9 * AYS + 2/9 * AYB + 1/9 * (CSO/3) + 1/9 * HBP + 1/9 * (PCH * AYS / 260) + 2/9 * (MIS*12)


***Explanation***
The ranking for each job is computed and stored in the ranking attribute in the Job class.

# **Requirement 7**
The user interface must be intuitive and responsive.

***Explanation***
This requirement is not captured in the diagram, but it is implicit. It would be captured as part of any UX design document.

# **Requirement 8**
For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

***Explanation***
This requirement is not captured in the diagram. It would be a part of any system design.