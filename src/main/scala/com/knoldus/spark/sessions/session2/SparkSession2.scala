package com.knoldus.spark.sessions.session2

import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.catalyst.encoders.ExpressionEncoder
import org.apache.spark.sql.{Dataset, DataFrame, SparkSession}
import java.sql.Timestamp
import java.text.SimpleDateFormat



/**
 * Created by knoldus on 30/7/16.
 */
object SparkSession2 {

  def main(args: Array[String]) {
    implicit val stringIntMapEncoder: ExpressionEncoder[Map[String, Int]] = ExpressionEncoder()
    implicit val mapEncoder = org.apache.spark.sql.Encoders.kryo[Map[String, Any]]

    val conf = new SparkConf().setAppName("SparkSample").setMaster("local[4]")
    val spark = new SparkContext(conf)


    val sparkSession = SparkSession.builder().appName("PersonApp").master("local[4]").getOrCreate()
    import sparkSession.implicits._

    val df = sparkSession.sqlContext.read.option("header", true).csv("/home/knoldus/SPARK/PROJECTS/FILES_SPARK_ASSIGNMENTS/ASSIGNMENT_2/Fire_Department_Calls_for_Service.csv")


    /**
     * How many different types of calls were made to the Fire Department?
     */
    val totalCallTypeCounts = df.select(df("Call Type")).distinct().count()
    println(s"\n\n\n\n\n\n\n***************TOTAL COUNT FOR CALL TYPE: ${totalCallTypeCounts}")

    /**
     * How many incidents of each call type were there?
     */
    val incidentCountForCallType = df.groupBy(df("Call Type")).count()
    println(s"\n\n\n\n\n\n\n***************TOTAL INCIDENT COUNT FOR CALL TYPE: ${incidentCountForCallType.show()}")


    /**
     * How many years of Fire Service Calls in the data file?
     */
    val watchDates: DataFrame = df.select(df("Watch Date"))

//    val years: DataFrame = watchDates.map(date => date.getString(0).split("/")(0).toInt).toDF().agg(max(df("value")))

//    years.createOrReplaceTempView("years")

//    val res = sparkSession.sql("select MAX('value') FROM years").as[Int]

//    years.show()

//    val dates: Unit = watchDates.map(_.getValuesMap[String](List("Watch Date"))).show()//.map(date => date.getAs("Watch Date").asInstanceOf[String].split("/")(2).toInt)


    spark.stop()
  }

}

//case class CallDate(date: Date)