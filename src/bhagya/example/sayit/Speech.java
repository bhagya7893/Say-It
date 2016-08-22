package bhagya.example.sayit;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.RecognizerIntent;
import android.annotation.TargetApi;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;

public class Speech extends Activity {
	
	protected static final int RESULT_SPEECH = 1;
	  
    private ImageButton btnSpeak;
    private TextView txtText;
  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_speech);
		// Show the Up button in the action bar.
		setupActionBar();
		
		 txtText = (TextView) findViewById(R.id.txtText);
		  
	        btnSpeak = (ImageButton) findViewById(R.id.btnSpeak);
	  
	        btnSpeak.setOnClickListener(new View.OnClickListener() {
	        	
	        	public void onClick(View v) {
	        		  
	                Intent intent = new Intent(
	                        RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	  
	      intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "en-US");
	  
	                try {
	                	startActivityForResult(intent, RESULT_SPEECH);
	                    txtText.setText("");
	                } catch (ActivityNotFoundException a) {
	                    Toast t = Toast.makeText(getApplicationContext(),
	                   "Opps! Your device doesn't support Speech to Text",
	                            Toast.LENGTH_SHORT);
	                    t.show();
	                }
	            }
	        });
	  
	    }

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.speech, menu);
		return true;
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
  
        switch (requestCode) {
        case RESULT_SPEECH: {
            if (resultCode == RESULT_OK && null != data) {

            	 ArrayList<String> text = data
                         .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
             
                           txtText.setText(text.get(0));
                       }
                       break;
                   }
             
                   }
               }

}
