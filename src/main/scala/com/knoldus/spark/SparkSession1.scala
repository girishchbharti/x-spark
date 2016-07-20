package com.knoldus.spark

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by knoldus on 16/7/16.
 */
object SparkSession1 {

  def main(args: Array[String]) {
    val logFile = "/home/knoldus/SPARK/spark-2.0.0-preview-bin-hadoop2.3/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Assignment1").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"\n\n\n\n\n\n\nLines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}
