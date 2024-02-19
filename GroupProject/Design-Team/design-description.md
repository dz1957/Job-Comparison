1. When the app is started, the user is presented with the main menu, which allows the user to 
(1) enter or edit current job details, 
(2) enter job offers, 
(3) adjust the comparison settings, or 
(4) compare job offers (disabled if no job offers were entered yet).

This is not represented in my design, as it will be handled entirely within the GUI implementation.

2. When choosing to enter current job details, a user will: 
a. Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
i. Title
ii. Company
iii. Location (entered as city and state)
iv. Cost of living in the location (expressed as an index)
v. Yearly salary
vi. Yearly bonus
vii. Number of stock option shares offered
viii. Home Buying Program fund (one-time dollar amount up to 15% of Yearly
Salary)
ix. Personal Choice Holidays (A single overall number of days from 0 to 20)
x. Monthly Internet Stipend ($0 to $75 inclusive)
b. Be able to either save the job details or cancel and exit without saving, returning
in both cases to the main menu.

To realize entering the details of the current job, I added a constructor 'CurrentJob()' to the CurrentJob class. The values mentioned above will be entered by 'CurrentJob()' method, after 'save' button is clicked on the GUI. To realize editting the details of the current job, I added a 'update()' method to the CurrentJob class. The attributes to be editted and their values will be passed in as parameters and be updated by the 'update()' method.

3. When choosing to enter job offers, a user will:
a. Be shown a user interface to enter all the details of the offer, which are the same
ones listed above for the current job.
b. Be able to either save the job offer details or cancel.
c. Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the
offer (if they saved it) with the current job details (if present).

To realize entering the details of the job offer, I added a constructor 'JobOffer()' to the JobOffer class. The values mentioned above will be entered by 'JobOffer()' method, after 'save' button is clicked on the GUI. Other buttons will be handled entirely within the GUI implementation.


4. When adjusting the comparison settings, the user can assign integer weights to:
a. Yearly salary
b. Yearly bonus
a. Number of Stock Option Shares Offered
a. Home Buying Program Fund
c. Personal Choice Holidays
d. Monthly Internet Stipend
If no weights are assigned, all factors are considered equal.

To realize adjusting the comparison settings, I added a 'adjustWeight()' mehtod to WeightConfig class. The weights to be adjusted will be passed in as parameters and be updated by the 'update()' method.

5. When choosing to compare job offers, a user will:
a. Be shown a list of job offers, displayed as Title and Company, ranked from best
to worst (see below for details), and including the current job (if present), clearly
indicated.
b. Select two jobs to compare and trigger the comparison.
c. Be shown a table comparing the two jobs, displaying, for each job:
i. Title
ii. Company
iii. Location
iv. Yearly salary adjusted for cost of living
v. Yearly bonus adjusted for cost of living
vi. Number of Stock Option Shares Offered
vii. Home Buying Program fund (one-time up to 15% of Yearly Salary)
viii. Personal Choice Holidays (A single overall number of days from 0 to 20)
ix. Monthly Internet Stipend ($0 to $75 inclusive monthly)
d. Be offered to perform another comparison or go back to the main menu.

To show a list of job offers displayed as Title and Company, ranked from best to worst, I added the 'jobOffers' and 'currentJobs' attribute to the JobManagement class, a 'rankJobs()' method to the JobManagement class, which will sort the jobs. I also added 'Getters' to the Job class for displaying details for each job when comparing two jobs.   
To realize comparing two job offers or one job offer with the current job, I added 'compareJobs()' method to JobComparison class. And this method will compare two jobs based on both the input weights and the information of two jobs. The result will be handled within the GUI implementation.

6. When ranking jobs, a job’s score is computed as the weighted average of:
AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)
where:
AYS = yearly salary adjusted for cost of living
AYB = yearly bonus adjusted for cost of living
CSO = Company shares offered (assuming a 3-year vesting schedule and a
price-per-share of $1)
HBP = Home Buying Program
PCH = Personal Choice Holidays
MIS= Monthly Internet Stipend
For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for
Internet Stipend, and 1 for all other factors, the score would be computed as:
2/9 * AYS + 2/9 * AYB + 1/9 * (CSO/3) + 1/9 * HBP + 1/9 * (PCH * AYS / 260) + 2/9 * (MIS*12)

To compute the job's score, I adde a 'computeJobScore()' method to WeightConfig class, which will be called by the 'rankJobs()' method in the JobManagement class to sort the jobs.

7. The user interface must be intuitive and responsive.

This is not represented in my design, as it will be handled entirely within the GUI implementation.

8. For simplicity, you may assume there is a single system running the app (no
communication or saving between devices is necessary).

For simplicity, I left out database support layer and load balancing considerations.