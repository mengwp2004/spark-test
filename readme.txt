
#first setup these info
masterUrl = "spark://192.168.50.199:7077"
inputPath = "hdfs://192.168.50.199:9000/user/aml/test/test.txt"
outputPath = "hdfs://192.168.50.199:9000/user/aml/test/out"


#run command
spark-submit --class  mysparktest1.App  --master spark://192.168.50.199:7077  ./target/mysparktest1-1.0-SNAPSHOT.jar
