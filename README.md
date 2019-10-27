# News Portal
##### By Nicholas M

## Description
~~blank~~

##### Project Properties
~~blank~~

## Prerequisites
1. PostgreSQL
2. Java JDK
3. Gradle
4. Git
5. Some prior knowledge of Java
6. Some prior knowledge of Spark framework
7. (optional) Java IDE

## Built With
1. HTML + Handlebars/Moustache
2. Css
3. Java
4. Gradle
5. Spark
6. Junit for testing
7. PostgreSQL database

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
<Database table commands to be inserted here>
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

###### (for users without an IDE)
+ Navigate to the folder containing the project
+ Build the gradle by running: `gradle build`.
+ Compile the code by running: `gradle compileJava`
+ Navigate to the App class file located at build/classes/java/main and run: `java App`.

## Live Link
Not available at the moment.

## License
This projects has a MIT License [found here](LICENSE)