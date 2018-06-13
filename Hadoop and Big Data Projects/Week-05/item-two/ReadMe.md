**Deliverable Part 1**

To find the minimum temperature in the given data set.

Step 1: Navigate to the data folder in the virtual machine and copy the downloaded sample text files to a directory. Concatenate them and give it an appropriate name such as 90919293-sample.txt.

Step 2: Make the hdfs directory by using the following command:
hadoop fs -mkdir -p vnc/input/ncdc/week5/mintemperature

Step 3: Copy the file from the local system by using the command: 
hadoop fs -copyFromLocal 90919293-sample.txt vnc/input/ncdc/week5/mintemperature/

Step 4: Compile the java codes by navigating to the path where we put it by using the command: 
hadoop com.sun.tools.javac.Main MinTemperature*.java

Step 5: Jar the file by using the command: 
jar cf mint.jar MinTemperature.class

Step 6: Execute the map reduce job and by creating an output path which is suitable. The command is as follows: 
hadoop jar mint.jar MinTemperature vnc/input/ncdc/week5/mintemperature/90919293-sample.txt vnc/output/ncdc/week5/mintemperature/2

Step 7: The output is obtained with the following command:
hadoop fs -cat vnc/output/ncdc/week5/mintemperature/2

The output is given below: 

![mintemperature](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/mintemperatureweek5.PNG)

The screenshot of the history server after the execution is added below:

![Hist](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/mint_jobhistory_week5.PNG)
