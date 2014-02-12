package ca.ualberta.cs.lonelytwitter.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

@SuppressLint("NewApi")
public class IntentReaderActivityTests extends ActivityInstrumentationTestCase2<IntentReaderActivity> {
	
	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent", 
				text, activity.getText());
		
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		
		assertEquals("IntentReaderActivity should get text from intent", 
				text + text, activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should display text", text, textView.getText().toString());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		
		//TextView textView = (TextView) 
		assertEquals("IntentReaderActivity should get text from intent", 
				"!olleh", activity.getText());
	}

	public void testCheckIfNull() {
		Intent intent = new Intent();
		String text = "";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("IntentReaderActivity should get text from intent", 
				text, textView.getText().toString());
	}
	
	public void testVisibleOnScreen() {
		Intent intent = new Intent();
		String text = "hello!";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
				
		assertNotNull(activity);
		View view = activity.getWindow().getDecorView();
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		//("IntentReaderActivity should get text from intent", 
			//	activity.getWindow().getDecorView(), activity.getText());
		
		ViewAsserts.assertOnScreen(view, textView);
		
	}
}
