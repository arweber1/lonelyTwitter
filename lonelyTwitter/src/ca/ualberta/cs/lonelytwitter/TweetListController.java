package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListController {
        private static TweetListModel tweetListModel = null;

		public TweetListController() {
			super();
			// TODO Auto-generated constructor stub
			if (tweetListModel == null)
			{
			tweetListModel = new TweetListModel();
			}
		}
		
		public void addTweet(String text)
		{
			LonelyTweetModel lt = new NormalTweetModel(text);
			ArrayList<LonelyTweetModel> list = tweetListModel.getList();
			list.add(lt);
		}
        
}
 