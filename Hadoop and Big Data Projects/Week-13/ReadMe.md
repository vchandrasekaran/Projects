## SPARK ASSIGNMENT ##

Follow these Instructions to perform a simple data analysis in Spark

Step 1: Download and install spark 

*To download spark go to the following link and download the version which is made for hadoop 1.6.
http://spark.apache.org/downloads.html

*Use wget and the mirror link and download through the console. 
Once the download is done tar the spark file from the home directoryas follows

tar xzf spark-x.y.z-bin-distro.tgz

*Next we export spark home and set the path 

export SPARK_HOME=~/home/vagrant/spark

*Next we export the path and it is done as follows. 

export PATH=$PATH:$SPARK_HOME/bin

*Update the bashrc file with the changes and save it. 

*Once we are done we can test the sparks successful installation which can be confirmed as given in the screenshot below. 
![img](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/Spark_install_screenshot.PNG)

# Steps to follow for execution of section d #

Step 1: Load the avro file into the hdfs by using the following commands.

val categories = spark.read.format(“com.databricks.spark.avro”).load(“/home/vagrant/week-13/categories.avro”)
val products = spark.read.format(“com.databricks.spark.avro”).load(“/home/vagrant/week-13/products.avro”)

Step 2: Display the output by using the following command.
categories.take(20).foreach(println)
products.take(20).foreach(println)

The screenshot of the output is given below. 

![img1](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Week-13/Results/Result.PNG)
The code is also given in the code file in code folder under section code for section d.

# Steps to follow for execution of step e #

Step 1: Copy the code under the section code for step e in the code file in code folder and execute it. 
Step 2: The text file is obtained by going to the vagrant folder and opening the folder by the name Result_0.
step 2: Cat the file to the text file by using the following command. 

cat part-00000 > Result_0.txt

Step 3: The output is given as a text file with the name Result_0 in the results folder. 

The screenshot of the output file is given here.

![img2](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/txtfile_price.PNG)

# Steps to follow for execution of step f #

Step 1: copy the code under the section code for step f in the code file in code folder and execute it.
Step 2: The text file is obtained by going to the vagrant folder and going into Result_1.csv. Next cat the part r file onto the text file like given below. 

cat part-00000-be1a1c54-760f-4c28-b68e-4b73f5e57f98-c000.csv -> Result_1.txt

Step 3: Close the scala operation and cat the file to the text file by using the following command.

The screenshot of the output file is given here. 

![img3](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/Week_13_part.PNG)

# Steps to follow for execution of step g #
Step 1: copy the code under the section code for step g in the code file in code folder and execute it.
Step 2: The avro file is obtained by going to the vagrant folder and going into Result_2. Next cat the part r file onto the avro file like given below. 

cat part-00000-25d035b6-35e3-4de1-8b58-4d678580f71c-c000.avro -> Result_2.avro

The screenshot of the output file is given below which was obtained in the spark shell. 

![img4](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/week_13_final_step.PNG)









