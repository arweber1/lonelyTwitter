package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetSetModel extends LonelyTwitterActivity
{

	int count = 0;
	
	public int countTweets()
	{

		// TODO Auto-generated method stub
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel)
	{

		// TODO Auto-generated method stub
		count++;
	}

	public ArrayList<LonelyTweetModel> getTweets(ArrayList<LonelyTweetModel> tweets){
		
		return tweets;
	}
}
