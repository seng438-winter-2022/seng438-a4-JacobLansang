**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:      |  8   |
| -------------- | --- |
| Student Names: |  Kaitlin Culligan   |
|                |  Kunal Dhawan   |
|                |  Chloe Bouchard   |
|                |  Jacob Lansang   |

# Introduction


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
For the RangeTest.java class, our initial mutation score was 34%, with a total of 431/1259 KILLED mutants. After modifying the test cases for RangeTest.java, our final mustation score is 52% with a total of 653/1259 KILLED mutants.

For the DataUtilitiesTest.java class, our initial mutation score was 86%, with a total of sdfs/ssfs KILLEd mutants. After modifying the tests cases for DataUtilities.java, our final mutation score is sf%


# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

A way to discuss equivalent mutants, is by analyzing the mutants to see what line of code it effects and whether or not it survives. IF multiple mutants make similar changes to the code on the same line, and all survive, it is reasonable to assume that they are equivalent mutants. 

Some equivalent mutants in DataUtilities:
Line 104: less than to greater than AND less than to greater or equal -> both mutations survived and made very similar changes to the code
Line 130: post-increment/decrement of local variable number 2 -> both mutations survived and made identical changes to the code in terms of how it operates
Line 213: post-increment/decrement of local variable number 3 -> both mutations survived and made identical changes to the code in terms of how it operates

some equivalent mutants in Range:
Line 123: post-increment/decrement of field upper -> both mutations survived and made very similar changes to the code
Line 157: pre-increment/decrement of field b0 -> both mutations survived and made very similar changes to the code
Line 189: not equal to less than AND not equal to less than or equal -> both mutations survived and made very similar changes to the code

The above methodology was applied for finding the equivalent mutants,

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

| Advantages      |  Disadvantages   |
| --------------- | --------------- |
| Able to detect most faults in source code   |  Hard to implement   |
| Can help to find out errors in test cases | Can lead to confusion due to complex mutants created and mistakes in the original code |
|  Improves quality of software |  Can be time-consuming |
|  Has a high level of error detection as it finds code ambiguity and incorrect values in variables during early stages |  Is not applicable for black box testing |

# Explain your SELENUIM test case design process

# Explain the use of assertions and checkpoints

# How did you test each functionaity with different test data

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

# Comments/feedback on the lab itself
