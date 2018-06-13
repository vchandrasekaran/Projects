**Deliverable Part 1**
Station ID that has the most invalid temperature records.

Step 1: Navigate to the data folder in the virtual machine and copy the downloaded sample text files to a directory. Concatenate them and give it an appropriate name such as 90919293-sample.txt.

Step 2: Make the hdfs directory by using the following command:
hadoop fs -mkdir -p vnc/input/ncdc/week5/invalid

Step 3: Copy the file from the local system by using the command: 
hadoop fs -copyFromLocal 90919293-sample.txt vnc/input/ncdc/week5/invalid/

Step 4: Compile the java codes by navigating to the path where we put it by using the command: 
hadoop com.sun.tools.javac.Main MaxInvalidStationID*.java

Step 5: Jar the file by using the command: 
jar cf inv.jar MaxInvalidStationID.class

Step 6: Execute the map reduce job and by creating an output path which is suitable. The command is as follows: 
hadoop jar inv.jar MaxInvalidStationID vnc/input/ncdc/week5/invalid/90919293-sample.txt vnc/output/ncdc/week5/invalid/2

Step 7: The output is obtained with the following command:
hadoop fs -cat vnc/output/ncdc/week5/invalid/2

The output is given below:

![inv](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week5invalid.PNG)

The screenshot of the history server after the execution is added below:

![inv](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/history_server_invalid_week5.PNG)

The output is for the station id 99994 and it has the most number of invalid records which corresponds to 218 records under that station. 