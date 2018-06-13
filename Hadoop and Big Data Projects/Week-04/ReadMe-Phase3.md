**Steps to run Phase III**

Step 1: Obtain the shell script attached in the repository and put it into the folder with the vagrant file. The shell script is given below. 

![script](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/shellscriptweek04.PNG)

Also add the following lines in the vagrant box-
config.vm.provision :shell, path: "setup.sh"
This will enable the shell script to be read during booting of the virtual machine. 

Step 2: When the system is reloaded with the provision the shell script is executed and this downloads mysql on the virtual machine. 

Step 3: Create the database called vnc04 by using the sql command- create database vnc04; Later create the tables with the given sql commands

CREATE TABLE vncdc9091 (usaweather_st_id VARCHAR(6), wbanweather_st_id INTEGER, obvyr INTEGER, latitude VARCHAR(6), longitude VARCHAR(7), elevation VAR
5), winddir INTEGER, sky_ceil_ht INTEGER, visibility_dist INTEGER, air_temp VARCHAR(5), dew_pt_temp VARCHAR(5), atm_pressure INTEGER);

CREATE TABLE vncdc9192 (usaweather_st_id VARCHAR(6), wbanweather_st_id INTEGER, obvyr INTEGER, latitude VARCHAR(6), longitude VARCHAR(7), elevation VAR
5), winddir INTEGER, sky_ceil_ht INTEGER, visibility_dist INTEGER, air_temp VARCHAR(5), dew_pt_temp VARCHAR(5), atm_pressure INTEGER);

The tables are described as follows.

![tables](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week04tables.PNG)

Step 4: The jar file for connecting the database is downloaded and put into the data folder in the local system. The jar file which was downloaded corresponds to mysql-connector-java-5.1.13.jar

Step 5: Put the java code which is maxtemperature9091.java into the data folder in the physical system. 

Step 6: Boot the virtual machine and navigate to the vagrant_data folder. Now compile the java code using the following command. 
javac maxtemperature9091.java

Step 7: Now time to run the code with the following command.
java -Xmx4096m -cp .:mysql-connector-java-5.1.13.jar maxtemperature9091

The job is then completed and we can see the below output

![9091output](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/9091output.PNG)

Step 8: We then run and compile the second java code which has the slight modifications as per the combined years required. In case the file has not been concatenated we use the cat command to concatenate the required file with the combined data. 
cat 1992-sample.txt 1993-sample.txt >> 9293-sample.txt
Same command later to compile the code
javac maxtemperature9293.java
And then the same command to execute 
java -Xmx4096m -cp .:mysql-connector-java-5.1.13.jar maxtemperature9293

The job is then completed and we can see the below output

![9293](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/9293output.PNG)

The results clearly show that the hadoop job takes considerably less time for execution compared to the execution in mysql. 