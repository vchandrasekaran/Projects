#!/bin/bash

sqoop import --connect jdbc:mysql://localhost/hadoopguide --table widgets -m 1 --username root --password itmd521  --where  "id >=1000 AND id <=3000"