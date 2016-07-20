package com.knoldus.spark.sessions.assignments

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


/**
 * Created by knoldus on 18/7/16.
 */
object Assignment1 extends App{

  override def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("Assignment1").setMaster("local[4]")
    val sc = new SparkContext(conf)


    //Change file path on your local system for specific file
    val pageCounts​FilePath = "/home/knoldus/SPARK/PROJECTS/FILES_SPARK_ASSIGNMENTS/ASSIGNMENT_1/pagecounts-20151201-220000.txt"
    /**
     * RDD with name pagecount is being created
     */
    val pageCounts​: RDD[String] = sc.textFile(pageCounts​FilePath, 4).cache()

    /**
     * Printing 10 records from the file
     */
    println("\n\n\n\n**************** 10 records from data:")
    pageCounts​.take(10).map( line => println(s"********$line"))
    println("\n\n\n\n**************************************************")

    val totalRecords = pageCounts​.count()

    println("\n\n\n\n**************************************************")
    println(s"TOTAL RECORDS: $totalRecords")
    println("\n\n\n\n**************************************************")

    val englishPageCount = pageCounts​.filter(line => line.contains("/en/")).count()

    println("\n\n\n\n**************************************************")
    println(s"ENGLISH Page count: $englishPageCount")
    println("\n\n\n\n**************************************************")


    val movieCount: Long = pageCounts​.filter(line => line.split(" ")(2).toInt > 20000).count()

    println("\n\n\n\n**************************************************")
    println(s"MOVIES WITH 20000+ VIEWS: $movieCount")
    println("\n\n\n\n**************************************************")

    val numAs: Long = pageCounts​.filter(line => line.contains("a")).count()
    val numBs: Long = pageCounts​.filter(line => line.contains("b")).count()

    println("\n\n\n\n**************************************************")
    println(s"Lines with a: %s, Lines with b: %s".format(numAs, numBs))
    println("\n\n\n\n**************************************************")
  }

}
