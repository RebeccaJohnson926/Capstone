# Capstone 2017

Emily Bower, Rebecca Johnson, Casey Kaku

# #BirdFeed (Abstract)

#BirdFeed is a mobile application that allows users to view local Seattle restaurants and filter and sort restaurant data by popularity and/or cuisine. The app utilizes Spark Streaming to retrieve data from Twitter. Using a Naive Bayes Classifier, the app will calculate the sentiment of the tweet and adjusts the restaurant’s rating accordingly in a Firebase database. #BirdFeed also utilizes Android Studio, Google Play Services, and Twitter kits to present the data in a user-friendly way and provide in-app functions for the convenience of the user.

# Sentiment Analysis

This application will perform a Naive Bayes algorithm to predict the sentiment of a tweet.
Tweets are streamed in The StreamTweets.java file using Apache Spark then saved to the restaurant.json file.
Sentiment.java is used to process the the saved tweets and find their sentiment (scores < 0 are predicted negative sentiment, scores > 0 are predicted positive sentiment).