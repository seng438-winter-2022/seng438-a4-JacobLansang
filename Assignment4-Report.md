**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |  8   |
| -------------- | --- |
| Student Names: |  Kaitlin Culligan   |
|                |  Kunal Dhawan   |
|                |  Chloe Bouchard   |
|                |  Jacob Lansang   |

# Introduction

In this lab, we will test a software using both Mutation Testing and GUI Testing. In mutation testing, we will use a software called Pitest to inject faults into a software to see our mutation score based on our unit tests. By using these mutation test results, we will attempt to increase our mutation score by attempting to kill the mutants that were not killed by our previously made tests. In GUI testing, we will use the software called Selenium and Sikulix in order to create test cases to be used to test certain functions of online websites. Selenium and Sikulix will help us record test cases and run them in an automated environment.

# Analysis of 10 Mutants of the Range class 

1. Less than to less or equal (contains()) -> KILLED:

This mutation changed an equality in line 144 to less than or equal instead of less than. This mutation was killed by one of our test cases because this test case did account for boundary cases when it came to inputs for this method.

2. Incremented (a++) double field lower (contains()) -> SURVIVED:

This mutation post-incremented the value called "lower" in the contains methods. This mutation survived because it get incremented after it is used in this line and gets returned, the inequality does not make sense as the lower value gets increased so the value is no longer within the correct range. 

3. Decremented (--a) double fieldupper (contains()) -> KILLED:

This mutation pre-incremented the value called upper in our contains method. This mutation was killed because our tests accounted for 

4. Greater than to equal -> KILLED (intersects()):

This mutation changed the equality from greater than to equal. This test was killed because we tested this method by using an equal value in our tests that failed for this case. 

5. Incremented (a++) double field lower -> SURVIVED (intersects()):

This mutation changed the value of lower by incrementing it after it is returned. This mutant survived because the value of the lower bound after it is incremented means that the condition in line 157 or 158 is no longer true.

6. Negated double field lower -> KILLED (intersects()):

This mutation changed the value of lower to the opposite sign. For example, if lower was positive it would be changed to negative. This mutation was killed because the value of lower, when changed to negative, would only change the value of the lower bound to something different, which woudl not effect the conditional statements in line 157 or 158.

7. Incremented (a++) double local variable number 3 -> SURVIVED (intersects()):

This mutation changed the value of lower by post-incrementing it. This mutation survived because we did not test near the boundary of b1 that is close to this.lower. 

8. Greater or equal to less than -> SURVIVED (intersects()):

This mutation changed the greater equality to a less than equality. This mutation survived because we did not have a test case that covered that section of the code. We do not cover the else statement in line 161.

9. Greater than or equal to equal -> SURVIVED (intersects()):

This mutation changed the greater than or equal equality to a less than equality. This mutation survived because we did not have a test case that covered that section of the code. We do not cover the else statement in line 161.

10. Incremented (a++) double local variable number 1 -> SURVIVED (intersects()):

This mutation changed the value of variable number 1 and post-incremented it. This mutation survived because we did not have a test case that covered that section of the code. We do not cover the else statement in line 161. 


This mutation pre-decremented 
# Report all the statistics and the mutation score for each test class
For the RangeTest.java class, our initial mutation score was 34%, with a total of 431/1259 KILLED mutants, as seen below. 
![image](https://user-images.githubusercontent.com/65249093/159017033-9f7fc2e9-6f05-4d8a-8ab0-00de58f1a7ac.png)

After modifying the test cases for RangeTest.java, our final mutation score is 52% with a total of 653/1259 KILLED mutants. The image below shows the result generated from the mutation test report.
![image](https://user-images.githubusercontent.com/65249093/159016887-b99570e4-8dc9-4313-ae04-8d69cfeadbcb.png)

For the DataUtilitiesTest.java class, our initial mutation score was 84%, with a total of 579/687 KILLEd mutants. This result is shown below:
![image](https://user-images.githubusercontent.com/65249093/159017257-a1f07533-c885-4dd7-ae08-772f97c3f935.png)

After modifying the tests cases for DataUtilities.java, our final mutation score is 87%, with 595/687 KILLED mutants:
![image](https://user-images.githubusercontent.com/65249093/159017460-931c0e53-1c7c-4ea9-8ebb-24d925c5ba3d.png)



# Analysis drawn on the effectiveness of each of the test 
Based on the results of the mutation scores, RangeTest has a pretty low effectiveness. It originally resulted in a 34% mutation score, which indicates that our tests did not take into account all possible inputs. 
On the other hand, our mutation score for DataUtilitiesTest.java was quite high, with a result of 84%. This means that our initial test cases took into account a lot of different possible inputs.

# A discussion on the effect of equivalent mutants on mutation score accuracy

A way to discuss equivalent mutants, is by analyzing the mutants to see what line of code it effects and whether or not it survives. IF multiple mutants make similar changes to the code on the same line, and all survive, it is reasonable to assume that they are equivalent mutants. 

#Some equivalent mutants in DataUtilities:

Line 104: less than to greater than AND less than to greater or equal -> both mutations survived and made very similar changes to the code

Line 130: post-increment/decrement of local variable number 2 -> both mutations survived and made identical changes to the code in terms of how it operates

Line 213: post-increment/decrement of local variable number 3 -> both mutations survived and made identical changes to the code in terms of how it operates


#Some equivalent mutants in Range:

Line 123: post-increment/decrement of field upper -> both mutations survived and made very similar changes to the code

Line 157: pre-increment/decrement of field b0 -> both mutations survived and made very similar changes to the code

Line 189: not equal to less than AND not equal to less than or equal -> both mutations survived and made very similar changes to the code


The above methodology was applied for finding the equivalent mutants in both test classes. Equivalent mutants would impact the mutation score by multiplying the number of mutations that were either killed or survived. Since equivalent mutants have the same effect on the SUT, if one of them is caught by a test case, the others should also be caught by the same or similar test cases. Additionally, if a set of equivalent mutants survives testing, it means that there are no test cases which can catch those types of changes in the source code.

# A discussion of what could have been done to improve the mutation score of the test suites

The single largest thing that could have been done to imporve the mutation score of the test suites is ensuring that there were assert statements in the test cases. This was especially true for RangeTest, as there were almost no assert statements in most of the test cases. The lack of assert statements meant that the test cases were never actually checking the output of the SUT. This meant that any changes in the output which reflected the changes in the source code were never picked up by the test suite. As a result, the mutation score was significantly lowered.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

| Advantages      |  Disadvantages   |
| --------------- | --------------- |
| Able to detect most faults in source code   |  Hard to implement   |
| Can help to find out errors in test cases | Can lead to confusion due to complex mutants created and mistakes in the original code |
|  Improves quality of software |  Can be time-consuming |
|  Has a high level of error detection as it finds code ambiguity and incorrect values in variables during early stages |  Is not applicable for black box testing |

# Explain your SELENUIM test case design process
In order to create SELENIUM test cases, we first had to determine which functionalities we were going to be checking. We decided to test the sportchek website. We listed off some of the the main functionalities that an average user would execute. More specifically, we decided on:
|Features |
|----------|
 | Adding an item to the cart|
 | Purchasing an item|
 | Clearing shopping cart|
 | Logging out|
 | Logging in with valid username and password|
 | Logging in with invalid username and password|
 | Registering for an account|
 | Removing an item from shopping cart|
 
Once these functionalities were determined, we planned out which steps needed to be taken in order to accomplish all of these actions. After having determined these steps, we opened up SELENIUM and recorded our sequence of steps.

# Explain the use of assertions and checkpoints
We added the command "assert value" to check that the inputed value matched the test's expectation. This was especially useful for situations where the tests still required user input. We noticed that SELENIUM did not automate the typing of a text field. This is where assertions were necessary.

# How did you test each functionaity with different test data
In order to check each functionality with different data, we simply duplicated our tests, and replaced the Value being checked with another one. For example, for the login, we copied the original test, and replaced the input value to be a different, valid email. This allowed us to expand our test data a bit. 

# Discuss advantages and disadvantages of Selenium vs. Sikulix

|Selenium      |  Sikulix   |
| --------------- | --------------- |
| It is a simple chromium extension, hence easier to install and get started | It is a legacy app (jar file) and took more effort to get started    |
|                |     |
|  |  |
|                |    |
|                |     |

# How the team work/effort was divided and managed

In order to complete the Part A, we all joined together on a call and one team member shared their screen. All together, we then went through the work together. We collectively decided what to write for our tests, and the person sharing their screen was in charge of writing down our suggestions. This was very effective, since 4 people were tackling a problem at the same time.

# Difficulties encountered, challenges overcome, and lessons learned

We all had difficulties running the mutation tests. In the end, one of us managed to get them to run. This meant that we had to be extra mindful of how we went about doing the remainder of the assignment since we could only run the mutation tests once every 15 minutes. Additionally, we were unable to start the lab until later in the week which meant that we were pressed for time and it made it difficult to get the lab done on time. In future, we will aim to start the assignment sooner so that we will have more time to overcome any difficulties that arise.

# Comments/feedback on the lab itself
This lab was very interesting, and was helpful for learning mutations and GUI testing. However, our group had a hard time getting our environmnet set up for the mutation testing. It would have been useful to have very explicitly stated instructions for setting up external libaries and file structure. This would have helped us to get our testing done sooner.
