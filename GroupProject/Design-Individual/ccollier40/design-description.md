
# Assignment 5 Design Description

### Requirements
>When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

The main menu is not represented as it will be part of the UI design. The underlying methods however, are represented in the diagram. (1) is satisfied by calling createCurrentJob or updateCurrentJob on the CurrentJob object, (2) is satisfied by calling createJobOffer on the jobOffer object, (3) is satisfied by calling setSettings on the comparisonSettings object, and (4) is satisfied by calling the getJobsInfo method on the Job object.

>When choosing to enter current job details, a user will:
>- Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
	> 	- Title
	>	- Company
	>	- Location (entered as city and state)
	>	- Cost of living in the location (expressed as an index)
	>	- Yearly salary 
	>	- Yearly bonus 
	>	- Number of stock option shares offered
	>	- Home Buying Program fund (one-time dollar amount up to 15% of Yearly Salary)
	>	- Personal Choice Holidays (A single overall number of days from 0 to 20)
	>	- Monthly Internet Stipend ($0 to $75 inclusive)
>- Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

The UI design will handle the creation of a webform for inputting data for the current job. A CurrentJob record can be created by calling the createCurrentJob method. If a CurrentJob record exists, the UI can call the getCurrentJob method to populate the existing data and then the updateCurrentJob method can be called when Saving to overwrite with the newly supplied data. Cancelling is not represented as that is a UI-only action.

The details of the current job are represented in the various fields of the Job object, which are inherited by the CurrentJob object. This is structured to allow future modifications in the event that the current job and job offers require differing information in the future.

>When choosing to enter job offers, a user will:
>- Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
>- Be able to either save the job offer details or cancel.
>- Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

The details of the job offer are represented in the various fields of the Job object, which are inherited by the JobOffer object. This is structured to allow future modifications in the event that the current job and job offers require differing information in the future. Cancelling is not represented as that is a UI only action. Saving will be satisfied by calling the createJobOffer method. Entering another job offer and returning to the main menu are UI only actions. Comparing the offer with the current job is satisfied by calling the getCurrentJob and getJobOffer methods.

>When adjusting the comparison settings, the user can assign integer weights to:
>- Yearly salary
>- Yearly bonus
>- Number of Stock Option Shares Offered
>- Home Buying Program Fund
>- Personal Choice Holidays
>- Monthly Internet Stipend 
> 
>If no weights are assigned, all factors are considered equal.

The details of the comparison settings are represented in the various fields of the comparisonSettings object. All fields will be defaulted to 1 to satisfy the factors being equal if nothing is entered.

>When choosing to compare job offers, a user will:
>- Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
>- Select two jobs to compare and trigger the comparison.
>- Be shown a table comparing the two jobs, displaying, for each job:
	>	- Title
	>	- Company
	>	- Location 
	>	- Yearly salary adjusted for cost of living
	>	- Yearly bonus adjusted for cost of living
	>	- Number of Stock Option Shares Offered
	>	- Home Buying Program fund (one-time up to 15% of Yearly Salary)
	>	- Personal Choice Holidays (A single overall number of days from 0 to 20) 
	>	- Monthly Internet Stipend ($0 to $75 inclusive monthly)
>- Be offered to perform another comparison or go back to the main menu.

The list of job offers will be rendered by the UI. The ranking is represented in the jobScore calculated field which is calculated with the getJobScore method that involves the job and the comparisonSettings object. The salary and bonus by costo of living are represented in the calculated fields salaryCOL and bonusCOL which will be calculated from the salary, bonus, and costOfLiving fields. These fields along with the others listed will be pulled by calling the getJobsInfo method which will return back a list of all job child objects.

The process of selecting and displaying two jobs will be handled by the UI through the use of the data returned by the getJobOffer and getCurrentJob methods. Returning to the main menu will also be a UI only action

>When ranking jobs, a job’s score is computed as the weighted average of:
>
>AYS + AYB + (CSO/3) + HBP + (PCH * AYS / 260) + (MIS*12)
>
>where:
>AYS = yearly salary adjusted for cost of living
>AYB = yearly bonus adjusted for cost of living
>CSO = Company shares offered (assuming a 3-year vesting schedule and a price-per-share of $1)
>HBP = Home Buying Program
>PCH = Personal Choice Holidays 
>MIS= Monthly Internet Stipend 
>
>For example, if the weights are 2 for the yearly salary, 2 for the yearly bonus, 2 for Internet Stipend, and 1 for all other factors, the score would be computed as:
>
>2/9 * AYS + 2/9 * AYB + 1/9 * (CSO/3) + 1/9 * HBP + 1/9 * (PCH * AYS / 260) + 2/9 * (MIS*12)

This requirement is the underlying logic behind the getJobScore method. It is not represented in the design as it will be a part of the implementation.

>The user interface must be intuitive and responsive.

This requirement will be handled by the UI design
