**Week-03**

1. Creating HDFS Directory

![img](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Week-03/HDFS_Directory.PNG)
*hadoop fs -mkdir -p vnc/ncdc/sample and then hadoop fs -ls vnc/ncdc/*

2. Loading sample data into HDFS

![img2](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Week-03/Load_hdfs.PNG)
*hadoop fs -copyFromLocal sample.txt vnc/ncdc/sample and then hadoop fs -ls vnc/ncdc/sample/*

3. Output 

![img3](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Week-03/Output.PNG)
*hadoop fs -cat vnc/output/ncdc/1/part-r-00000*



