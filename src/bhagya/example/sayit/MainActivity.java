package bhagya.example.sayit;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			Button BtnSpeech = (Button)findViewById(R.id.btn2);
			BtnSpeech.setOnClickListener((OnClickListener)new btnListener());
			
			Button Launch = (Button) findViewById(R.id.btn3);
			Launch.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					Intent intent =new Intent(v.getContext(),Launch.class);
					startActivityForResult(intent,0);
				}
			});
			
			Button Help = (Button) findViewById(R.id.btn4);
			Help.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					Intent intent = new Intent(v.getContext(),Help.class);
					startActivityForResult(intent,0);
				}
			});
			
			
		Button Record = (Button) findViewById(R.id.btn1);
			Record.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					Intent intent =new Intent(v.getContext(),Record.class);
					startActivityForResult(intent,0);
				}
			});
			//Button Launch = (Button)findViewById(R.id.Btn4);
			//Launch.setOnClickListener((OnClickListener)new btnListener());
				
			
		}
			private class btnListener  implements OnClickListener {
				@Override	
				public void onClick(View v){
					Intent intent = new Intent(v.getContext(),Speech.class);
					startActivityForResult(intent,0);
				}
				
			
		}

		
		
		/*public void Speech(){
			
			Intent intent= new Intent(this,Speech.class);
			startActivity(intent);
			
		}*/

	}
