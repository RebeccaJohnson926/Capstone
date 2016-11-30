package capstone;

/**
 * Created by Casey on 11/4/16.
 * Edited by Rebecca on 11/28/16.
 */

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Sentiment {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        dictionary();

        SparkConf sparkConf = new SparkConf()
                .setAppName("Tweets Android")
                .setMaster("local[2]");
        SparkContext sc = new SparkContext(sparkConf);

        SQLContext sqlContext = new SQLContext(sc);

        try {
            DataFrame tweets = sqlContext.read().json("tweets1.json"); // load old tweets into a DataFrame
            tweets.registerTempTable("tweetDF");

            DataFrame tweetText = sqlContext.sql("SELECT text FROM tweetDF");
            int numTweets = (int) tweetText.count();
            System.out.println(numTweets);

            //go through all tweets and analyze the sentiment of each
            for(int i = 0; i<numTweets; i++) {

                int count = 1;
                int sent = 0;

                String tweet = tweetText.take(numTweets)[i].toString();
                tweet = tweet.substring(1, tweet.length() - 1);
                System.out.println(tweet);

                Scanner scan = new Scanner(tweet);
                int temp = 0;

                while (scan.hasNext()) {
                    temp += find(scan.next().replace('#', '\t').toLowerCase());
                }
                System.out.println("Tweet: " + count + " " + temp);
                count++;
                sent += temp;

                sent = sent / (count - 1);
                System.out.println("Overall Sentiment: " + sent);

            }

        } catch (Exception e){
            System.out.println(e);
        }
//        File file = new File("test.txt");
//        Scanner scan = new Scanner(file);
//
//        String tweet;
//        int count = 1;
//        int sent = 0;
//
//        //while(scan.hasNext()) {
//        for(int j = 0; j < 2; j++) {
//            //sent = 0;
//            tweet = scan.nextLine();
//            //System.out.println(tweet);
//            int first = 0;
//            for(int i = 0; i < 7; i++) {
//                first = tweet.indexOf('"', first) + 1;
//                //System.out.println("index: "+first);
//            }
//
//            String str = tweet.substring(first, tweet.indexOf('"', first));
//            System.out.println(str);
//            Scanner s = new Scanner(str);
//            int temp = 0;
//
//            while(s.hasNext()) {
//                temp += find(s.next());
//            }
//            System.out.println("Tweet: "+ count + " " + temp);
//            count ++;
//            sent += temp;
//        }
//        sent = sent/(count-1);
//        System.out.println("Overall Sentiment: "+sent);

    }

    public static void dictionary() throws IOException {
        File file = new File("AFIN-111.txt");
        Scanner dic = new Scanner(file);

        String temp;
        int v;

        while(dic.hasNext()) {
            temp = dic.next().toString();
            //System.out.println(temp);
            v = Integer.parseInt(dic.next());
            map.put(temp, v);
        }
    }

    public static int find(String word) {
        if(map.containsKey(word)) {
            System.out.println("word: "+word+" value: "+map.get(word));
            return map.get(word);
        }
        else
            return 0;
    }
}
