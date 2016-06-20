/*
In the spark-shell docker

Copy a file to the hadoop cluster

```bash
echo "foo foo foo bar" > foo.txt
hadoop fs -copyFromLocal foo.txt /

# is now in "hdfs:/foo.txt"
```

Now go open /usr/local/spark/bin/spark-shell to
go to a scala repl

*/

val foo = sc.textFile("hdfs:/foo.txt")
val counts = foo.flatMap(line => line.split(" ")).map(word => (word,1))

// Now reduce it
val reduced = counts.reduceByKey(_ + _)
