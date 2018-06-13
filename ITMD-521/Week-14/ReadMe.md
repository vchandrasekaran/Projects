**Week-13 Cluster Assignment**

**Test 1**

• Without combiner, without intermediate compression, and 1 reducers
• Without combiner, without intermediate compression, and 2 reducers
• Without combiner, without intermediate compression, and 4 reducers
• Without combiner, without intermediate compression, and 8 reducers


![test1](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test1a.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers. 

On the first look we can see that the number of reducers play a huge role in the process times in the test. We can see that the reduce times for the given tasks reduces significantly as the number of reducers increase. Also we notice that the file format also has an impact on the process times as the gz files are run faster and the bz2 files are next to the gz files. The text files are run comparitively slower than the other two kinds of files. 

We can see that the increase in reducers reduces the process times. As per page 175 in the text book we can see that more number of reducers have to be used and is practically true in the test 1. 


**Test 2**

• With combiner, with intermediate compression, and 1 reducers
• With combiner, with intermediate compression, and 2 reducers
• With combiner, with intermediate compression, and 4 reducers
• With combiner, with intermediate compression, and 8 reducers

![test2](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/Test2.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers. 

We can see that the combiners and the compression is used. The graph shows that with more reducers the process time is increased across all the file types. The compression is used on gzip compressed file which does not support splitting. The map reduce will not try to split the gz filesince it is not supported. In this case a single map will process the HDFS blocks and will not be local to the map. Due to this the time taken for execution will be longer compared to the other formats. The bz2 files should ideally be supported by the compression and is suited for map reduce jobs. This information is obtained from the sections compression and input splits in pg 105 of the text book. 

Also increasing the number of reducers may not always be a good tactic. In this particular test more time is wasted on shuffle and merging as a result of more reducers used on smaller file sizes. More spill files are created due to the small file sizes which hinders the perfomance in this case.the ideal number of reducers are to be used to achieve perfomance. 

**Test 3**

• With combiner, without intermediate compression, and 1 reducers
• With combiner, without intermediate compression, and 2 reducers
• With combiner, without intermediate compression, and 4 reducers
• With combiner, without intermediate compression, and 8 reducers

![test3](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/Test3.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers. 

The graph gives us a straightforward picture on how effective combiners can be along with the reducers. As the number of reducers increase with combiners there is a fall in the execution times. The gz file with 8 reducers executes in about 5 minutes when compared to the text file with one reducer and combiner. Therefore the gz file format can also be concluded as an optimization when used with more reducers and a combiner. More reducers means more parallelism and the combiners reduces the average shuffle times as well. Context from pg 215 relating reducers and pg 34 for combiners. 


**Test 4**

• Repeat test 1 using the datasets located in: /user/ncdc/80/ (Lastname A-K) and /user/ncdc/90/
(Lastname L-Z)
• For test 4-6 You will need modify your MaxTemperature code to account for bad records use the
sample code on P.174 of textbook section 6-12 to include a counter that will output the number of
bad records at the end of the job – place this new code and jar file in Week-13 -> badrecord folder

![Test4](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test4.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers. 

We can see that a larger file is used here which is directly proportional to the large execution times. The combiners are not used which will not support any of the large number of reducers used here. On the whole we are just running a simple map reduce job and we can say that based on the bz files the larger the number of reducers the faster is the job execution timigs. Here the ideal number of reducers to be used can be chosen to be 4 as this has the least execution times across all the file formats based on the size of the file. 

**Test 5**

• Repeat test 2 using the datasets located in: /user/ncdc/80/ (Lastname A-K) and /user/ncdc/90/
(Lastname L-Z)
• For test 4-6 You will need modify your MaxTemperature code to account for bad records use the
sample code on P.174 of textbook section 6-12 to include a counter that will output the number of
bad records at the end of the job – place this new code and jar file in Week-13 -> badrecord folder

![test5](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test5.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers.

The compression and combiner is used here. We can see that as we increase the number of reducers for the jobs across all file types there is a decrease in the job execution timings. On large files such as the dataset used here for this analysis we can conclude that the more number of reducers we use with compression and combiners we will get faster results. Another interesting fact here is that with two reducers we seem to get optimal performance for all the three file types. The combiners are responsible for reducing the average shuffle times for more reducers used. The compression works effectively on the bz2 file and is comparatively weaker for the gz file as there is a rise in the execution times slightly. Choosing two reducers for this file type can help with performance due to the size of the file and the splits used by the map reduce job. Since a map job can perform on one fille without splitting into multiple smaller files this seems to be the optimal tuned tactic. 

**Test 6**

• Repeat test 3 using the datasets located in: /user/ncdc/80/ (Lastname A-K) and /user/ncdc/90/
(Lastname L-Z)
• For test 4-6 You will need modify your MaxTemperature code to account for bad records use the
sample code on P.174 of textbook section 6-12 to include a counter that will output the number of
bad records at the end of the job – place this new code and jar file in Week-13 -> badrecord folder

![test6](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test6.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers.

The above graph shows the impact of the combiner on the reducers clearly. We can observe that the combiners are playing their role with the reduced process times for the records with more reducers. This can be clearly observed with the text files as the reducers increase there is a fall in the execution times due to the effect of the combiner. Another point to observe is the lack of the compression has played a part on the execution times of the bz2 and the gz files. When compared with the previous result of test 5 we can see that the job execution times in this test have gone down without the usage of the compression and only the combiners. this shows that we should not be using the compression always along with the combiners as it is not necessarily an optimal idea. 


**Test 7**

• Repeat test 1 using the datasets located in: /user/ncdc/80-90/ (ALL students)

![test7](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test7.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers.

The above graph is given for the tests with no combiner and compression used and just the reducers and the file types are a criteria. The graph obtained is similar to the graph obtained from test 1 and we can say that the time diffeence is purely because of a larger file size used in this test. an important observation here is the bz2 files are more effective with 2 or 4 reducers used for larger files like this one. As and when the size of the file increases we can see that the number of reducers we choose have to be more precise for optimal perfomance. 

**Test 8**

• Repeat test 2 using the datasets located in: /user/ncdc/80-90/ (ALL students)

![test8](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test8.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers.

The above graph is obtained with the use of combiner and compression. The tests have a very simple graph that tells us that as and when we add more reducers the process times increase. So we can conclude that the number of reducers have to be lesser for large files with combiners and compression used. The bz2 files take nearly half the time taken by the raw text files. So a compressed bz2 file that supports splitting helps in the optimization for this dataset. As more reducers are used with compression there is no detail as to where the next split starts from so the time taken to process this by the reducers in mapping is considerable large. 

**Test 9**

• Repeat test 3 using the datasets located in: /user/ncdc/80-90/ (ALL students)

![test9](https://github.com/illinoistech-itm/vchandrasekaran/blob/master/ITMD-521/Images/test9.PNG)

Answer

The above graph is plotted with the elapsed time in minutes on the y axis and the file application ids are given on the x axis. The file type is also mentioned on the x axis headings for better clarity with analysis regarding the file types and its influence in obtaining the process timings. The colours of the bars indicate the number of reducers used for that particular job and is as follows: Green for 1 reducer, pink for 2 reducers, orange for 4 reducers and red for 8 reducers.

The test shows the effect of the combiner on the datasets. Similar to the previous tests it is safe to assume that the combiners works effectively without compression with more number of reducers. This is similar to the test 5 result and the optimal number of reducers to be used here is 4 as it suits the file size used. 


**Conclusion (test 17)**

Write your general conclusion and recommendation for the optimal performance characteristics relating to
intermediate compression, compression, combiners, block size, and number of reducers based on this
work load and dataset results (reference your test results above).

Answer

When it comes to tuning a job there are several factors that come in the picture. The major factors that we have encountered here would be intermediate compression, compression, combiner usage, the default block sizes and the number of reducers. The role of each of these individual characteristics vary upon the file type and aslo the size of the file. 

Number of reducers: It is always optimal to use more than a single reducer. The reduce tasks should run for atleast 5 minutes and be able to produce a blocks worth of data to be effective. Using a single reducer will result in all the intermediate data flowing through one reducer and will increase the process time. Almost every time increasing the reducer will reduce the reduce phase due to more parallel tasks being executed. But increasing this number too high based on the file size can have adverse effects. This number should be chosen such that each reducer can produce atleast one blocks worth of data. 

When there is no combiner and compression used the reducer number is always a factor as the more number of reducers on larger file reduces the process time considerable. The reducers when used with combiners are most effective which can be seen in the tests with the combiners namely tests 3, 6 and 9. The adverse effects can be seen with reducers used in test 2 and 8. More reducers should be used with combiners and the file size should be considerably larger. 

Combinbers: The combiners are used to limit the data transfered between map and reduce tasks. It definately helps to optimize the performance of the job as seen by its usage in tests 3,6 and 9. The combiners are used to effectively reduce the shuffle and sort phases which can be seen here with larger files. However we can see that the combiners used on small files with one reducer is just a waste of time. So the combiners should be used with more reducers and when the file size is large. 

Intermediate compression: The job execution tme can almost always benefit from using map output compression. The mapper output is written t othe disk and transferred across the network. Using a fast compressor can boost the performance as the volume of data to be transfereed is reduced. The test 2 shows that the intermediate compression helps to reduce the process times of the job. 

Compression: The compression of files helps in the optimal performance gain The bz2 compressed files are the most effective as it supports splitting. Let us go through the above tests to analyse the results. The smaller files used in the test 1 show that compression on the files reduces the process times. As we move further in test 2 we can see that the compression on the files with more reducers will increase the time for processing. As seen in test 3 we can see that compression with combiners and more number of reducers can be an optimal solution for smaller files. In tests 4 and 5 the compressed files with the effect of the reducers will increase the process timings. We can also see this effect of compression in est 8 where it is clear that compressed file with bz2 format will be very effective in reducing the process times. 

