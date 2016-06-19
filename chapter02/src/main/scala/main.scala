import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object Main {
  def main(args: Array[String]): Unit = {
    val lines = sc.textFile("chapter01.md")
    println(lines.count())
    println(lines.first())

    // Filtering
    lines.filter(line => line.contains("Python"))

  }

}
