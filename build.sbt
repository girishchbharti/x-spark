name := "x-spark"

version := "0.0.1"

scalaVersion := "2.11.8"


// additional libraries
libraryDependencies ++= Seq(
  //Spark
  "org.apache.spark" %% "spark-core" % "2.0.0",
  "org.apache.spark" %% "spark-sql" % "2.0.0"
  /*"org.apache.spark" %% "spark-hive" % "1.3.1",
  "org.apache.spark" %% "spark-streaming" % "1.3.1",
/"org.apache.spark" %% "spark-streaming-kafka" % "1.3.1",
  "org.apache.spark" %% "spark-streaming-flume" % "1.3.1",
  "org.apache.spark" %% "spark-mllib" % "1.3.1",
  "joda-time" % "joda-time" % "2.9.2",*/
  //Swagger
//  "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.6.2"
)
