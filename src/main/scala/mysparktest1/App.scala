package mysparktest1

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Hello world!
  *
  */
object App {
  def main(args: Array[String]) {
    var masterUrl = "spark://192.168.50.199:7077"
    var inputPath = "hdfs://192.168.50.199:9000/user/aml/test/test.txt"
    var outputPath = "hdfs://192.168.50.199:9000/user/aml/test/out"
    if (args.length == 1) {
      masterUrl = args(0)
    }
    else if (args.length == 3) {
      masterUrl = args(0)
      inputPath = args(1)
      outputPath = args(2)
    }
    println(s"masterUrl:$masterUrl, inputPath: $inputPath, outputPath: $outputPath")
    val sparkConf = new SparkConf().setMaster(masterUrl).setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rowRdd = sc.textFile(inputPath)
    val resultRdd = rowRdd.flatMap(line => line.split("\\s+")).map(word => (word, 1)).reduceByKey(_ + _)
    resultRdd.saveAsTextFile(outputPath)
  }
}
