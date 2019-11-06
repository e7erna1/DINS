# DINS
## Description
This application can create, edit, delete and view people in the database.
A person has the following characteristics:
* Name.
* Surname.
* Date of birth.
* Address of residence.
## Download, build and run application in docker:
* Download
  * Create a folder on your computer.
  * In this folder, open command line and run the command:
    ```bash 
    git clone https://github.com/iCode002/DINS.git 
    ```
* Build
  * Enter the following commands in the command line:
    * ```bash 
      gradle cleaar
      ```
    * ```bash 
      gradle build 
      ```
    * ```bash 
      gradle war 
      ```
  * Enter the following commands in the command line:
    * ```bash 
      docker-compose build 
      ```
* Run
  * Enter the following commands in the command line:
    * ```bash 
      docker-compose up 
      ```
  * To exit the application, use the keyboard shortcut Ctrl + C
# Working with application
In the browser, open the following URL: http://localhost:8080/DINS/index.xhtml
### Add user
|Field name  |  Example      |Format                        |
|------------|---------------|------------------------------|
| Name:      | Name          |String (Up to 40 characters)  |
| Surname:   | Surname       |String (Up to 50 characters)  |
| Birthday:  | 05/11/2019    |dd/MM/yyyy                    |
| Address:   | SPB           |String  (Up to 250 characters)|

Press button add
### Edit user
Enter name and press "Find"
You can change any of the fields except birthday, just change to a new value and click "Update".
After clicking the "clear" button, the table is cleared.
### Delete user
Enter name and press "Find"
For the person you are interested in, click "Delete".
After clicking the "clear" button, the table is cleared.
### Get by value
You should choose one of the items by which the program will search for a user for you.

| Get by value|
|-------------|
| Name        |
| Surname     |
| Address     |

Enter a value in the Value field and press "Find"
After clicking the "clear" button, the table is cleared.
### Get all
By clicking on the button "Find" displays all users.

After clicking the "Сlear" button, the table is cleared.
