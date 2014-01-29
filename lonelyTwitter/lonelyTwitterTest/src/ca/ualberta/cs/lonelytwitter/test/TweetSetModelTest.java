package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;


public class TweetSetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{

	public TweetSetModelTest()
	{

		super(LonelyTwitterActivity.class);
	}

	
	public void testCount(){
		ArrayList<LonelyTweetModel> tweets = new ArrayList<LonelyTweetModel>();
		
		tweets.add(new ImportantTweetModel("Hello"));
		tweets.add(new NormalTweetModel("Goodbye"));
		tweets.add(new NormalTweetModel("Hello"));
		
		ArrayList<LonelyTweetModel> tweets2 = new ArrayList<LonelyTweetModel>();
		tweets2 = tweets.getTweets(tweets);
		
		//assertEquals("tweet set should start empty", 0, tweets.countTweets());
		
		//tweets.addTweet(new NormalTweetModel("test"));
		//assertEquals("after a tweet, the count should be 1", 1, tweets.countTweets());
		
		for (int i = 0; i < tweets.size(); i++){ 
			assertEquals("these should be equal", tweets.get(i) , tweets2.get(i) );
		}
	}
	
}
