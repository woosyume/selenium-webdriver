#Each feature contains one feature
#Feature files use Gherkin language - business language
Feature: Test the login functionality on sdet university

#A feature may have given different scenarios
#Scenario uses Geven-When-Then structure

Scenario: the user should be able to login with correct username and password
Given user is on the login page
When user enters correct username and correct password
Then user gets confirmation