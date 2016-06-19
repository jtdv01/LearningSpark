println("Input had "+badLinesRDD.count()+ " bad lines")
badLinesRDD.take(10).foreach(println)
