<link rel="stylesheet" type="text/css" media="all" href="./styles/style.css" />

# Unit Testing - Lecture Notes
###### (05/24/2018)

## **Overview of Session**
Large software systems can get complex and the smallest changes can have unintended consequences. At the same time, agile software development requires rapid iteration and an ability to change.

*How do we verify that the components of code that we write are correct and that changes don't cause unintended consequences?*

## **Session Objectives**

* Students should be able to list the pros and cons associated with Manual versus Automated testing
* Students should be able to state the difference between Exploratory and Regression testing
* Students should be able to state the difference between Unit, Integration and Acceptance testing
* Students should be able to create and run Unit tests
* Students should be able to effectively choose the proper asserts from an JUnit framework
* Students should be able to describe boundary cases and how to spot what the boundary cases are in a piece of code

## **Classroom Preparation**
* None

## **Agenda and Timing for Session**

**Note:** There are no book topics on this section

* Software Development Lifecycle (0:20)
* Testing Overview (0:40)
* Break (0:10)
* Unit Testing (0:30)
* Tests With JUnit (0:30)
* Code Coverage (0:10) (Optional)

## **Topic List w/Notes** <div class=topicNote>(and <span class='link'>links</span> to e-book section when available)</div>

### Software Development Lifecycle

Typically before beginning the lecture on Testing, it is important to indicate to students the full SDLC and the various phases.

Indicate the difference between Waterfall and Agile mainly. ([Link that compares Waterfall vs Agile](https://www.guru99.com/waterfall-vs-agile.html))


### Software Testing Overview
- **Manual vs Automated Testing**    [Link to comparison](http://www.base36.com/2013/03/automated-vs-manual-testing-the-pros-and-cons-of-each/)
    - *What are the strengths of human testers?*
    - *What are the strengths of computers?*

    - **Manual Testing**
        - Creativity
        - Can evaluate subjective qualities like user friendliness and usability
    - ***Automated Testing***
        - Speed / Efficiency
        - Lower cost of execution
        - Accuracy
        - Dependability / Repeatability
- **Exploratory vs Regression**

    <div class="definition note"><span><strong>Exploratory Testing</strong></span> explores the functionality of the system looking for defects, missing features, or other opportunities for improvement. Almost always manual.</div>

    <div class="definition note"><span><strong>Regression Testing</strong></span> validates that existing functionality continues to operate as expected. </div>

- **Unit, Integration, and Acceptance Testing**
    - As you progress from Unit Testing -> Integration Testing -> Acceptance Testing:
        - longer runtime
        - more expensive to write
        - harder to troubleshoot

    <div class="definition note"><span><strong>Acceptance Testing</strong></span> is performed from the perspective of a user of the system to verify that the functionality of the system satisfies user needs.</div>

    <div class="definition note"><span><strong>Integration Testing</strong></span> is a broad category of tests that validate the integration between units of code or code and outside dependencies such as databases or network resources.</div>

    <div class="definition note"><span><strong>Unit Testing</strong></span> is low level of testing performed by programmers that validates individual “*units*” of code *function as intended by the programmer*. Always automated.</div>

- **Other Types of Testing**
    - Discussion: *What kinds of things other than application functionality might we test for?*
    - Performance / Scalability
    - Security
    - Usability
    - Accessibility
    - Portability / Compatibility

- **Who Does Testing?**
    - Dedicated software testers, different skill sets, QA vs. QC
    - Developers test their own code for correctness
    - Business people test code for usability and acceptance

### Introduction to Unit Testing
- **Reasons for Unit Testing**
   - Large software systems can get complex, each piece needs to be correct
   - Encourages programmers to think of error cases
   - Changes can have unintended consequences
   - Agile software development requires rapid iteration and ability to change
- **Unit Tests Should Be:**
    - Fast - elapsed time of running a unit test should be measured in milliseconds
    - Reliable / Repeatable - if a passed/failed once, it should pass/fail again, assuming no code changes
    - Independent - a test should be able to be run independently of other tests and tests should not have interactions with one another
    - Obvious - easy to determine why it failed
- **General Structure of a Test**
    - Arrange - begin by arranging the conditions of the test, such as setting up test data
    - Act - perform the action of interest, meaning the thing we're testing
    - Assert - validate that the expected outcome occurred by means of an assertion, like a certain value was returned or a file exists
- **Unit Testing Best Practices**
    - No external dependencies
    - One *logical* assertion per test, meaning each test should only contain one "concept"
    - Test code should be of the same quality as production code
- **How to Unit Test**
    - Find boundary cases in the code
        - Is there an if statement?
            - Test around the condition that the if statement tests
        - Is there a loop?
            - Test arrays in the loop that are empty, only one element, lots of elements
        - Is an object passed in?
            - Pass in null, an empty object, an object missing values that the method expects

### Implementing Tests With JUnit
- Introduce unit testing framework
- How to organize tests
    - A Test class per class file
    - Possibly multiple test methods per method
- Each method is a test
- Naming conventions

### Code Coverage
[Link to description of Code Coverage](https://confluence.atlassian.com/clover/about-code-coverage-71599496.html)

## Instructor Led Exercises

**For Java, you may want to also create a new test class to test the ArrayList class or String class**

- [Java Lecture Code](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/lecture/unit-testing-lecture/)

## Student Exercises (Individual & Pair)

- [Java Exercises](https://bitbucket.org/te-curriculum/module-1-introduction-to-java/src/master/exercises/unit-testing-exercises/)
