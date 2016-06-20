# Basic RDD

```java
val lines = sc.textFile("hdfs://data.txt")
val linesLenghts = lines.map(s => s.length)
val totalLengths = lineLengths.reduce((a,b) => a + b)
```
