# Academic Planner

small change

This Project uses Maven for build and file control. The project is in the academic-planner/ directory.

## Overview

Students have very tight schedules, they are required to deal with multiple deadlines, exams, attendance criteria etc., due to this burden it is difficult for students to plan their Academics and still strike an optimal balance. 
The purpose of this project was to introduce an innovative solution that would combat this issue – An Academic Planner. Students may keep track of their courses, events, holidays, attendances, and grades over the course of a semester.

## Feature Overview
The Academic Planner is a GUI where users may do the following:

* Add/Edit/Delete Courses and relevant details
* Add/Edit/Delete Components for each Course
* Add/Edit/Delete Events in a Central Calendar
* Set and Record Attendance for each Course
* View Attendance Statistics
* Calculate a Predicted Grade based on your Inputs
* Cross Platform Compatibility: Compatible on MacOS, Windows and Linux since SQLite and Java swing have been used, which are compatible across several platforms. It will maintain a native look on each.


## Core Concepts Used
The Project is created with Java and utilises the following:

* OOP Concepts – Inheritance, Polymorphism, Abstraction and Encapsulation.
* Java Swing – The Guided User Interface is designed with the Java Swing toolkit.
* Java JBDC SQLite3 – All data that is used by the Application Backend is stored in a local SQLite Database.
* Java IO – Certain Settings and Login details are stored in files, which are created with the help of the IO Package.
* Java Date – Due to several usages of Date based input/output, the Date package helps handle dates.
* Maven – Maven is a build automation tool, it was used to make development, compilation, and dependencies easier.
* Junit – The Junit package was used to write unit tests, in order to ensure correctness of the code.

## Future Roadmap
Software must always be evolving so in the future; we plan to add features such as:

* Advanced Grade Prediction based on collected data.
* Memory system, that remembers previous semester data and uses it for prediction/recommendations.
* Link to SendGrid API to send reminders as emails/SMS for events and component deadlines.
* Centralised database to store login and all other data to the cloud.

