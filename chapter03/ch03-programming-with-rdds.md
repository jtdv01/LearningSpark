# RDD
- an immutable distrubted collection of objects
- split into multiple paritions

# Creating RDD's
- load an external dataset
- parallelize a colleciton in your tdriver program

Simplest way
- take an existing collection and pass it to SparkContext's parrallelize() method

```scala
val lines = sc.parallelize(List("pandas","I like pandas"))
```

# RDD Operations
## Transforms

Filter example

```
val inputRDD = sc.textFile("log.txt")
val errorsRDD = inputRDD.filter(line => line.contains("error"))
```

### Union Transforms

```python
errorsRDD = inputRDD.filter(lambda x: "error" in x)
warningsRDD = inputRDD.filter(lambda x: "warning" in x)
badLinesRDD = errorsRDD.union(warningsRDD)
```

## Actions
```java
println("Input had " + badLinesRDD.count() + " bad lines")
println("Here they are")
badLinesRDD.take(10).foreach(println)
```
--------
# Passing functions to Spark

```java
class SearchFunctions(val query:String){
  def isMatch(s:String):Boolean ={
    s.contains(query)
  }

  def getMatchesFunctionReference(rdd:RDD[String]):RDD[Boolean]={
    rdd.map(isMatch)
  }

  def getMatchesFieldReference(rdd:RDD[String]):RDD[Array[String]]={
    // problem: all query will be passed
    rdd.map(x=>x.split(query))
  }

  def getMatchesNoReference(rdd:RDD[String]):RDD[Array[String]]={
    // safe:
    val query_safe = this.query;
    rdd.map(x => x.split(query_safe))
  }

}
```


-----
# Basic RDD's

## Element wise Transforms

```java
val input = sc.parallelize(List(1,2,3))
val result = input.map(x => x*x)
println(result.collect().mkString(","))
```

## Flat map

```java
val lines = sc.parallelize(List("Hello world","there"))
val result = lines.flatMap(x => x.split(" "))
println(result.first()) // Hello
```

# 
