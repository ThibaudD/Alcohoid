package fr.thib.alcohoid;

import fr.sensei.alcohoid.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class CreateActivity extends Activity{

	private ListenersCreate lc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create);
		lc = new ListenersCreate(this);
		
		((Button) findViewById(R.id.button_add_bottle)).setOnClickListener(lc);		
		((Button) findViewById(R.id.button_return)).setOnClickListener(lc);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
