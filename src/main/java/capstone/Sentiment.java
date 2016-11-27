package com.seigneurin.spark.pojo;

/**
 * Created by Casey on 11/4/16.
 */

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Sentiment {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        dictionary();

        File file = new File("test.txt");
        Scanner scan = new Scanner(file);

        String tweet;
        int count = 1;
        int sent = 0;

        //while(scan.hasNext()) {
        for(int j = 0; j < 2; j++) {
            //sent = 0;
            tweet = scan.nextLine();
            //System.out.println(tweet);
            int first = 0;
            for(int i = 0; i < 7; i++) {
                first = tweet.indexOf('"', first) + 1;
                //System.out.println("index: "+first);
            }

            String str = tweet.substring(first, tweet.indexOf('"', first));
            System.out.println(str);
            Scanner s = new Scanner(str);
            int temp = 0;

            while(s.hasNext()) {
                temp += find(s.next());
            }
            System.out.println("Tweet: "+ count + " " + temp);
            count ++;
            sent += temp;
        }
        sent = sent/(count-1);
        System.out.println("Overall Sentiment: "+sent);

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
