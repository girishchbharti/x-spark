package com.knoldus.spark.mlib

/*import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkContext, SparkConf}*/

/**
 * Created by knoldus on 26/7/16.
 */
object PredictionSample1 extends App{
  override def main(args: Array[String]) {

    /*val conf = new SparkConf().setAppName("Assignment1").setMaster("local[4]")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

    val pageCounts​FilePath = "/home/knoldus/SPARK/PROJECTS/FILES_SPARK_ASSIGNMENTS/ASSIGNMENT_1/pagecounts-20151201-220000.txt"
    val pageCounts​: RDD[String] = sc.textFile(pageCounts​FilePath, 4).cache()
    // Every record of this DataFrame contains the label and
    // features represented by a vector.
    val df = sqlContext.createDataFrame(pageCounts​).toDF("label", "features")

    // Set parameters for the algorithm.
    // Here, we limit the number of iterations to 10.
    val lr = new LogisticRegression().setMaxIter(10)

    // Fit the model to the data.
    val model = lr.fit(df)

    // Inspect the model: get the feature weights.
    val weights = model.weights

    // Given a dataset, predict each point's label, and show the results.
    model.transform(df).show()*/
  }

}
