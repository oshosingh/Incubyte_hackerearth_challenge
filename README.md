
  

# Incubyte Challenge
  
  ## Tech Stack
  1. React JS (Frontend)
  2. Spring Boot (Backend)
  3. H2 In Memory Database
  4. JPA 
  5. Heroku (Deployment)

  ### Deployment
  1. Used Heroku to deploy the applications.
  2. Frontend Url - > https://oshofrontend.herokuapp.com/
  3. Backend Url -> https://oshobackend.herokuapp.com
  
  ## Folder Structure
  There are two subfolders in the root folder.
  
  1. Backend/
  
      
     > This folder contains Spring Boot code for backend APIs that accept input from the frontend and save data in the   database.
     
     I have created four Apis:
     1. Get All Words -> Fetches all the words in the database
     2. Post Word -> Saves a new word in the database.
     3. Update word -> Updates existing word in the database
     4. Delete word -> Delete existing word

     A screenshot of the Rest API Controller class is shown below.
     
     ![image](https://user-images.githubusercontent.com/35776307/160276927-79d90229-9922-4122-bdc5-bee759dc415f.png)
     
     The words are stored in the H2 database. H2 is a database that runs entirely in memory.
  
     ### Test Code
     > The src/test/java/com/example/backend/WordsControllTest.java file contains all of the test methods. A screenshot of the test results is shown below.
     
     ![image](https://user-images.githubusercontent.com/35776307/160271695-9720f5df-98a5-41fd-b421-f40b81456c9d.png)

  ===========================================================================
  
  2. Frontend/
  
     > This folder Contains the ReactJS code for the UI of the application.  
     The main page, seen below in the screenshot, allows users to add and update entries in the dictionary.
     
     ![image](https://user-images.githubusercontent.com/35776307/160276946-93f65814-9be7-421c-91c8-908e86624862.png)
     
     1. In the top section, users can enter words and save it in the dictionary.
     2. The second sections, displays the existing words in the database. User can edit the existing word by entering new word
        in the input section and then update it by clicking on the Edit Word button.
     3. Delete button can be used to delete the word.
        
        ** The left most number denotes id of the word in database. ** 

        ### Note: 
        1. Empty string is not allowed in the form.
        2. Please wait for few seconds, the components will auto-refresh.

  ### Build Steps
  1. Frontend -> npm run build
  2. Backend -> mvn clean install
    
