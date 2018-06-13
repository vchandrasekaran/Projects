# Assignment week-11 #

# Step 1 #

We configure scoop on the virtual machine and perform the required path assignments. Once the system is set up we install mysql client with the username as root and password as itmd521

# Step 2 #

We need to set up the database and schema to perform the operations in this assignment. for this step run the create.sql script which will create the associated tables and schema. 

The database would have the following entries upon execution of the script. 

![tablewidgets](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step1.PNG)

# Step 3 #

We have to populate the table for a realistic hadoop scoop experience and for thiis reason we generate random records using the schema given in the text book. For the successful completion of this  step run the step2.sh script which uses a sql procedure. 

The screenshot of the code and the database entries is given below.  

![step2shell](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step2sh.PNG)

![step2db](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step2db.PNG)

# Step 4 #

The scoop import job is performed in this step. The scoop command to be used to import the records fromm the database to the hdfs system is as follows. 

sqoop import --connect jdbc:mysql://localhost/hadoopguide --table widgets -m 1 --username root --password itmd521

We perform this with the help of a shell script containing the above command. The screenshots of the script and the records in the hdfs system is given upon successful completion of this step. 

![step3shell](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step3sh.PNG)

![step3hdfs](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step3hdfs.PNG)

# Step 5 #

The sqoop import for a subset of the database in hdfs is performed in this step. This is particularly useful when we try to extract only a part of the database for analytic purpose and not the entire data. The command is given below. 

sqoop import --connect jdbc:mysql://localhost/hadoopguide --table widgets -m 1 --username root --password itmd521  --where  "id >=1000 AND id <=3000"

The shell script is provided for the same step and the screenshots are given below. Only records between 1000 and 3000 are displayed here. 

![step4shell](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step4sh.PNG)

![step4hdfs](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step4hdfs.PNG)

# Step 6 #

We have to run the MaxWidgetId file as per the steps given in the text book. This will result in an imported record with the last available record in the hdfs. So it displays line 3000 which is the result of the last step. The command to execute it is as follows

hadoop jar sqoop-examples.jar MaxWidgetId -libjars $SQOOP_HOME/sqoop-1.4.6.jar

The screenshot is given below. 

![import](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week11step5.PNG)

# Step 7 # 

We perform the map reduce task for finding the mode. The java file for this particular operation is given along with the folder. The same steps as performed in the last step is followed and the result is the mode of the individual items. The output in part-r-00000 is given bbelow and the codes have also been updated. 

![step6](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/part-r-00000.PNG)












