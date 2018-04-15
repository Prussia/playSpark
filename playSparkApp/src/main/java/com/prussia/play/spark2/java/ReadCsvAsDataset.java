package com.prussia.play.spark2.java;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;

public class ReadCsvAsDataset {

    public static void main(String[] args) {

        SparkSession spark = SparkSession.builder()
                .master("local[*]")
                .appName("Example")
                .getOrCreate();

        Dataset<Person> ds = spark.read()
                .option("header", "true")
                .csv("testdata/people.csv")
                .as(Encoders.bean(Person.class));

        ds.show();

    }


}

