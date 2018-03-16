# FDB (Football DataBase) By INSE Team 5c

Hi there, this project aims to get football fans all the statistics they could ever need on a easy to use desktop application (Windows only at this point, MAC support will come at some point) Note: MySQl is the only supported datasbase language currently.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
Basic Mode - Application requests data from remote database on the internet (Currently Unavalible, due to not being able to host it anywhere)
```
No Extra requirements right now...
```

Advanced Mode - Downloading the database and running it on your local machine (Only mode avalible right now)
```
* [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) - used to store the database and run the local server
```

For Developer Mode - Want to edit the code yourself? Great! 
```
* [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) - used to store the database and run the local server
* [MySQL Java Connector](https://dev.mysql.com/downloads/connector/j/) - The connector for java and the MySQL Database Netbeans (Recommended IDE for Development)
```

### Install

for a video demo look here: https://www.youtube.com/watch?v=DbqIfk1FLBg

Download the Jar File located at:
```
INSE_Team_5C/FDB/dist/FDB.jar
```
Download the SQL Scripts located at:
```
INSE_Team_5C/Database Scripts/population.sql
INSE_Team_5C/Database Scripts/table_creation.sql
```
Install MySql Workbench (See Prerequisites for download).  
Once set up create a new Server with username and root being "root" and ensure the localhost port is :3306  (SCREENSHOT THIS)
Load the SQl Scripts into MySQlWorkbench, be sure to load the scripts in the order or you'll encounter an error  
```
INSE_Team_5C/Database Scripts/table_creation.sql
INSE_Team_5C/Database Scripts/population.sql
```
Run the FDB.jar and you should be welcomed with the welcome screen, pick a team and go!  
