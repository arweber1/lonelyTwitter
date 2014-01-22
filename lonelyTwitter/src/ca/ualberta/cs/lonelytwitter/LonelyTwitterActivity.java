package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	ArrayAdapter<String> adapter2;
	ArrayList<String> tweets2 ;
	ArrayList<LonelyTweetModel> new_array_list;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	    tweets2 = new ArrayList<String>();	
        adapter2 = new ArrayAdapter<String>(this,R.layout.list_item,tweets2);
        
        try {
            FileInputStream fis = openFileInput(FILENAME);
			
			Reader reader = new InputStreamReader(fis);
			
			Gson object = new Gson();
			
			//try{
				NormalTweetModel son = object.fromJson(reader, NormalTweetModel.class);
				tweets2.add(son.text+"\n"+son.timestamp.toString());
			
			
			//}catch(EOFException e){
        	
        
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
        oldTweetsList.setAdapter(adapter2);
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                NormalTweetModel new_model = new NormalTweetModel(text);
				saveInFile(new_model);
                
				try {
					FileInputStream fis = openFileInput(FILENAME);
					
					Gson gson = new Gson();

					Reader reader = new InputStreamReader(fis);

					NormalTweetModel response= gson.fromJson(reader, NormalTweetModel.class);
					tweets2.add(response.text+"\n"+response.timestamp.toString());
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				adapter2.notifyDataSetChanged();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets2 = loadFromFile();
		oldTweetsList.setAdapter(adapter2);
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		
		
		try {
			FileInputStream fis = openFileInput(FILENAME);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(NormalTweetModel new_tweet) {
		try {
			Gson g_object = new Gson();
			String to_be_stored = g_object.toJson(new_tweet);
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			System.out.println(to_be_stored+"qqqqqq");
			/*fos.write(new String(date.toString() + " | " + text)
					.getBytes());*/
			fos.write(to_be_stored.getBytes());
			
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
