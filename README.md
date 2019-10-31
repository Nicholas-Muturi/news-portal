# News Portal
##### By Nicholas M

## Description
News Portal is a project where we practice using REST API for querying and retrieving information. As a user, you should be able to view all all departments present, news articles (general or department-specific) and create users within a department as well as view information regarding a particular department or user.

## Prerequisites
1. PostgreSQL
2. Java JDK
3. Gradle
4. Git
5. Some prior knowledge of Java
6. Some prior knowledge of Spark framework
7. Postman
8. (optional) Java IDE

## Built With
1. Java & Gradle
2. Spark
3. Junit for testing
4. PostgreSQL database

## Setup Guide
##### PostgreSQL
###### Installation
+ Run `sudo apt-get install postgresql postgresql-contrib libpq-dev` in the terminal to install PostgreSQL in your device.
+ Enter y when prompted `Do you want to continue? [Y/n]` and wait for the installation to complete.
+ Create your own credentials with superuser capabilities with the same name as our login name by running `sudo -u postgres createuser --superuser $USER`
+ Next, we’ll have to create a database with the same name as our login name by running `sudo -u postgres createdb $USER`
+ Finally run `psql` in the terminal to connect to the server
###### Structure
+ After running the `psql` command to connect to the server, proceed to create the database wildlife-tracker by executing the following command: `create database news_portal;`
+ Follow it up with this following command to connect to the newly created database`\c news_portal;`
+ Once connected, create the following tables by running these commands:  
```
CREATE TABLE users (id serial primary key, name varchar, position varchar, role varchar, department varchar);
CREATE TABLE news (id serial primary key, title varchar, description varchar, type varchar, author varchar);
CREATE TABLE departments (id serial primary key, name varchar, description varchar, totalemployees int);
CREATE TABLE departments_users (id serial primary key, deptid int, userid int);
CREATE TABLE departments_news (id serial primary key, deptid int, newsid int, userid int);
CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;
```
+ The last command creates the test database that shall be used to run your tests on. insert `\q` to exit psql server.

##### Java
+ Run `java --version` to check which version of java you have installed in your device. If you have java installed, you should see an output slightly similar to the one below...  
_**openjdk 10.0.2 2018-07-17**_  
_**OpenJDK Runtime Environment (build 10.0.2+13-Ubuntu-1ubuntu0.18.04.4)**_  
 ... then you need to install java by running this : `sudo apt install default-jre`

+ Clone the repository into a desired folder by running the following link in your terminal: `https://github.com/Nicholas-Muturi/news-portal.git`

###### (for users with an IDE such as IntelliJ)
+ Open the project using the IDE you have installed
+ Build and Run the project.
+ Open your browser or postman (preferred) in order to interact with the API
+ Use the path `/sitemap` in the url when running the project to get a list of all paths in a summarized form

###### (for users without an IDE)
+ Navigate to the folder containing the project
+ Build the gradle by running: `gradle build`.
+ Compile the code by running: `gradle compileJava`
+ Navigate to the App class file located at build/classes/java/main and run: `java App`.
+ Open your browser or postman (preferred) in order to interact with the API
+ Use the path `/sitemap` in the url when running the project to get a list of all paths in a summarized form

## Live Site
[Visit API website](https://news-portal-0047.herokuapp.com/)

## License
This projects has a MIT License [found here](LICENSE)