name := "Spark Training"

scalaVersion := "2.10.5"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.0"

libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.3"

libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.1.3"

initialCommands += """
  val sc = new org.apache.spark.SparkContext("local[*]", "shell")
  """.stripMargin

cleanupCommands += """
  println("Closing the SparkContext:")
  sc.stop()
  """.stripMargin

fork in run := true
