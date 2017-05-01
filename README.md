# Class Project for B552 , Spring 2017 
# Smart-Assitant
Knowledge Based AI system for personal Use


This is Maven based Java Application to provide all the functionality required for Smart-Assitant. 

Steps to run the appication - 

1 > Make Sure java is intalled on the machine and JDK is setup.
2 > Make sure Maven is intalled on operating system. 
3 > Build the application using maven 
    Go to the path where code is extracted (parent of pom.xml file) and the below code

	
	# Command
	
	mvn clean install
	
	Or
	
	clean install ( incase using eclipse)

3 > A jar file will be generated , which can be trigger using below command

	java -jar <path><jar file name>
	
	Or
	
	ctrl+F11 (incase of eclipse)

4 > Send a simple HTTP request to the host with end point as /reply and query as part of query parameter with field as content.

    For example - If you are running the application on local Machine Send a HTTP GET request to below endpoint - 

     http://localhost:8080/reply?content=what is your address ? #

    Identify the result based on resposne status as explaied in output file. Answer to tyhe question will be returned as response body. 


# Team Member -

	 Karan Lamba 
	 Sujeet Kumar 




