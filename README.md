# project-salesforce-Error404

###1. Setting environment Variables
For this project is required to define some basic variables needed for the correct execution of the tests.
The project creates an env file in case there is none with the minimal variables required.
Please read the description of each variable and set its property before initializing the project.
```dotenv
BASE_URL= // refers to the http domain URL of the user, ending with /
SALESFORCE_USERNAME= // salesforce username
SALESFORCE_PASSWORD= // salesforce password
SALESFORCE_TOKEN= // token needed for the comunication with Salesforce and the project
SALESFORCE_CLIENT_ID= // client id from salesforce
SALESFORCE_CLIENT_SECRET= // client secret from salesforce
BASE_URL_CLASSIC= // refers to the http domain for classic view in salesforce, ends with /
SALESFORCE_VERSION= // refers to the layout, lightning or clasic version
```
- Another environment variables that are set automatically are:
```dotenv
EXPLICIT_WAIT_TIME=10 // explicit wait time for the driver
IMPLICIT_WAIT_TIME=20 // implicit wait time for the driver
BROWSER=CHROME // default web driver type
LANGUAGE=en // default salesforce site language (english)
```
- Browser can be set to: FIREFOX and EDGE.
- Language support en (english) and es (spanish).