import org.apache.spark._
import org.apache.spark.sql.SQLContext

object Main {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("test").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val sqlCtx = new SQLContext(sc)

    val input = sqlCtx.jsonFile("../data/tweets/*/*")
    input.registerTempTable("tweets")
    sqlCtx.sql("""SELECT user.favouritesCount FROM tweets""").first()
    sqlCtx.sql("""SELECT sum(user.favouritesCount), sum(retweetCount) FROM tweets""").first()

  }
}
