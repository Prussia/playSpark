package com.prussia.play.spark2;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.io.File;
import java.util.Arrays;

@Log4j2
public class WordCountJava8 {

    public static void main(String[] args) throws Exception {

        log.trace("WordCountJava8 entry trace");
        log.info("WordCountJava8 entry info");
        log.warn("WordCountJava8 entry warn");
        log.debug("WordCountJava8 entry DEBUG");
        FileUtils.deleteDirectory(new File("testdata/words_java8.txt"));

        SparkConf sparkConf = new SparkConf()
                .setAppName("Example")
                .setMaster("local[*]");

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // open the text file as an RDD of String
        JavaRDD<String> textFile = sc.textFile("testdata/shakespeare.txt");

        // convert each line into a collection of words
        JavaRDD<String> words = textFile.flatMap(line -> Arrays.asList(WordHelper.split(line)).iterator());

        // map each word to a tuple containing the word and the value 1
        JavaPairRDD<String, Integer> pairs = words.mapToPair(word -> new Tuple2<>(word, 1));

        // for all tuples that have the same key (word), perform an aggregation to add the counts
        JavaPairRDD<String, Integer> counts = pairs.reduceByKey((a, b) -> a + b);

        // perform some final transformations, and then save the output to a file
        counts.filter(tuple -> tuple._2() > 100)
                .saveAsTextFile("testdata/words_java8.txt");

    }

}
