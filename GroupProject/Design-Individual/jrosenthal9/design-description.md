1) When the app is started, the user is presented with the main menu, which allows the user to (1) enter or edit current job details, (2) enter job offers, (3) adjust the comparison settings, or (4) compare job offers (disabled if no job offers were entered yet).  

To realize this requirement, I added a Main Menu class that will be the first point the user interacts with. This class has 4 operations, “Enter or Edit Current Job Details(),” “Enter Job Offer(),” “Adjust Comparison Settings(),” and “Compare Job Offers().” The Main Menu class reads the values of the “Job” classes and determines whether Job Offers have been entered yet to enable or disable the “Compare Job Offers” operation.

2) When choosing to enter current job details, a user will:
Be shown a user interface to enter (if it is the first time) or edit all the details of their current job, which consist of:
	Title
	Company
	Location (entered as city and state)
	Cost of living in the location (expressed as an index)
	Yearly salary 
	Yearly bonus 
	Number of stock option shares offered
	Home Buying Program fund (one-time dollar amount up to 15% of Yearly Salary)
	Personal Choice Holidays (A single overall number of days from 0 to 20)
	Monthly Internet Stipend ($0 to $75 inclusive)
Be able to either save the job details or cancel and exit without saving, returning in both cases to the main menu.

To realize this requirement I added a "Enter or Edit Current Job Details" class that is called by the "Enter or Edit Current Job Details()" Operation in the Main Menu class. I also created a Job class that contains all of the information that would be stored about a job, so an object can be created with the class attributes and operations. The Enter or Edit Current Job Details class pulls data from the Job class to determine if a Current Job already exists and should be edited or if the User is entering a current job for the first time. The operation "Enter/Edit Details()" will allow the user to fill out all of the editable fields for the Job class in an editable UI. Then the "Save Job Details()" operation will save the fields to a new job class or the existing job class if it already exists, then return the user to the Main Menu. The Cancel and Exit Without Saving() operation will discard all information in the fields and return to the Main Menu without changing any Job class objects.

3) When choosing to enter job offers, a user will:
	Be shown a user interface to enter all the details of the offer, which are the same ones listed above for the current job.
	Be able to either save the job offer details or cancel.
	Be able to (1) enter another offer, (2) return to the main menu, or (3) compare the offer (if they saved it) with the current job details (if present).

To realize this requirement I added an Enter Job Offers class (called by the Enter Job Offers() operation in the Main Menu) that has an editable UI showing all of the job details the user would change. There are then the Save Job Offer Details() and Cancel() Operations that are accessible from this screen, if the user selects Cancel() they will be returned to the Main Menu without changing any Job objects, but if the user selects Save Job Offer Details() they will create a new Job object with these attributes and be taken to a screen to select either the Enter Another Offer() operation to open a fresh detail input UI, the Return to Main Menu() operation to return to the Main Menu, or a Compare the Offer() operation to go to the Compare Job Offers class which will be covered later in the design description. The Compare the Offer() operation automatically pulls in the latest added Job object as well as the Job object with the Current Job boolean as True.

4) When adjusting the comparison settings, the user can assign integer weights to:
	Yearly salary
	Yearly bonus
	Number of Stock Option Shares Offered
	Home Buying Program Fund
	Personal Choice Holidays
	Monthly Internet Stipend

To realize this requirement, I created two classes: Adjust Comparison Settings (called from the Adjust Comparison Settings() in the Main Menu) and Comparison Settings. Comparison Settings has 6 attributes, all of which are the weight values the user can assign. Adjust Comparison Settings pulls in the existing Comparison Settings object to populate a UI, and then lets the user change the weight values. The two operations under Adjust Comparison Settings are Enter Comparison Weights() which saves the values currently set in the UI to the Comparison Settings object, and Return to Main Menu() which returns the user to the Main Menu.

5) When choosing to compare job offers, a user will:
	Be shown a list of job offers, displayed as Title and Company, ranked from best to worst (see below for details), and including the current job (if present), clearly indicated.
	Select two jobs to compare and trigger the comparison.
	Be shown a table comparing the two jobs, displaying, for each job:
		Title
		Company
		Location 
		Yearly salary adjusted for cost of living
		Yearly bonus adjusted for cost of living
		Number of Stock Option Shares Offered
		Home Buying Program fund (one-time up to 15% of Yearly Salary)
		Personal Choice Holidays (A single overall number of days from 0 to 20) 
		Monthly Internet Stipend ($0 to $75 inclusive monthly)

	Be offered to perform another comparison or go back to the main menu.

To realize this requirement, I created a Compare Job Offers class that is called from the Compare Job Offers() operation in the Main Menu. Compare Job Offers shows a UI at the top with the Job objects Title and Company ranked from best to worst, with the current Job object highlighted. This class has two operations, Select Two Jobs to Compare() and Return to Main Menu(). Select Two Jobs to Compare() allows the user to pick two Job objects by Title and Company to trigger a comparison which populates a new UI with a table to compare the two jobs. Below this table is a button labeled "Perform Another Comparison" that calls the Select Two Jobs to Compare() operation again, and a button to go back to the Main Menu that calls the Return to Main Menu() operation.

7) When ranking jobs, a job’s score is computed as the weighted average of:

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


To realize this requirement, the Job class has an operation Calculate Job Score() that pulls in the Comparison Settings object if it has been created, and if it hasn't been then it calculates with all weights set to 0. This Calculate Job Score() operation is called every time the Job object is saved as well as every time the Comparison Settings object is saved all Job objects have the Calculate Job Score() operation called. The Calculate Job Score() operation follows the equation above to calculate the score for each job.

7) The user interface must be intuitive and responsive.

This requirement does not directly affect the design but having the Calculate Job Score() operation of the Job class run automatically will keep the application intuitive, as well as clearly labeling the UI and having consistent operations in each class to return to the Main Menu.

8) For simplicity, you may assume there is a single system running the app (no communication or saving between devices is necessary).

This requirement allows all of the information to be easily accessible by any other class, so no special communication guidelines are included in the UML diagram.