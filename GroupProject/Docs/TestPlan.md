# Test Plan

**Author**: Chad Collier ccollier40

## 1 Testing Strategy

### 1.1 Overall strategy

The testing strategy the team will pursue will involve unit, integration, and regression testing. Unit testing will provide a baseline to ensure the applications logic succeeds and fails as expected for a given set of inputs. Integration testing will be peformed in a more manual fashion, with a tester proceeding through the apprication workflow to ensure that each action is implemented correctly and that data is succesfully stored and returned. Regression testing will be performed whenever an update is made to the system to ensure the changes have not broken any functionality. The team will nomianate a member to be in charge of the testing effort, but the testing work may be delegated depending on availability considerations. 

### 1.2 Test Selection

Selecting tests for unit testing will be done using white box techniques by defining test cases across the input spectrum. These tests will include positive and negative scenarios, as well as edge cases that may expose gaps in th eimplemented logic. Integration testing and regression testing will also use white box techniques to ensure that data is validated, processed, stored, and returned correctly. Black box testing will also be performed for integration testing to ensure that any customer behavior outside of the baseline functionality will be accounted for and handled appropriately.

### 1.3 Adequacy Criterion

For unit tests, the main consideration will be for maximizing code coverage to ensure all logic is tested and works as expected. For integration testing, the integration of each technical component will be validated and each functional requirement will be tested with at least one corresponding test case. 

### 1.4 Bug Tracking

Issue and enhancement tracking will be handled through the use of Github Issues. Issues will be created through the issue dialog and will be assigned to team members based on availability. Each issue will include a brief description of what the issue is and whether it is a bug or an enhancement.

### 1.5 Technology

J unit will be used for unit tests. The team will perform integration and regression testing manually.

## 2 Test Cases

*This section should be the core of this document. You should provide a table of test cases, one per row. For each test case, the table should provide its purpose, the steps necessary to perform the test, the expected result, the actual result (to be filled later), pass/fail information (to be filled later), and any additional information you think is relevant.*


| Test Script Number | Functionality                   | Steps                                                                                                                                                                                            | Expected Result                                                                                                | Actual Result | Test Status |
|--------------------|:--------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------|:--------------|:------------|
| 1                  | Test entering current job       | 1. Start app<br>2. Click "Enter/Edit Current Job" button<br>3. Complete all fields for the current job<br>4. Click "Submit" button<br>5. Verify the record is stored in the database             | The entered information will be saved as the current job and will be stored in the database                    | TBD           | TBD         |
| 2                  | Test enter job offer            | 1. Start app<br>2. Click "Create Job Offer"<br>3. Complete all fields for the job offer<br>4. Click "Submit" button<br>5. Verify the record is stored in the database                            | The entered information will be saved as a new job offer record and will be stored in the database             | TBD           | TBD         |
| 3                  | Test adjust comparison settings | 1. Start app<br>2. Click "Edit Comparison Settings" button<br>3. Complete all fields for the comparison settings<br>4. Click "Submit" button.<br>5. Verify the record is stored in the database  | The entered comparison weights will be saved as a comparison setting record and will be stored in the database | TBD           | TBD         |
| 4                  | Test compare job offers         | 1. Start app<br>2. Click "Compare Job Offers" button<br>3. Select a job offer to compare to the current job<br>4. Click the "Compare" button                                                     | The current job and the selected job offer will be pulled from the database and displayed to the userc         | TDB           | TBD         |