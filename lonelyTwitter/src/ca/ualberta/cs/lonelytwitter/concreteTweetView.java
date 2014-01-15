package ca.ualberta.cs.lonelytwitter;

public class concreteTweetView implements tweetView {

	public String formatTweet(lonelyTweetModel lt) {
		// TODO Auto-generated method stub
		
		return lt.getTimestamp().toString()+" | "+lt.getText();
	}

}
