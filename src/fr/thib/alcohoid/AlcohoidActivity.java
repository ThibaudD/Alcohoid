package fr.thib.alcohoid;

import java.util.ArrayList;

import fr.sensei.alcohoid.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class AlcohoidActivity extends Activity{
	private LinearLayout view;
	private ListenersAlcohoid listeners;
	EditText tv_amount;
	static ArrayList<Alcohol> alcohols;
	static ListView list;
	static AlcoholDAO db;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listeners = new ListenersAlcohoid(this);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        /*DataBase*/
        db = new AlcoholDAO(this);
        db.open();
        //db.DeleteAlcoholAll();
        alcohols = db.SelectAll();
       
        
        
        
        list = (ListView) this.findViewById(R.id.alcohol_lv);
        ListAdapter listadapter = new ListAdapter(this, alcohols);
        list.setAdapter(listadapter); 
        
        
        
        list.setOnItemClickListener(listeners);
        list.setOnItemLongClickListener(listeners);
        ((Button)findViewById(R.id.button_add)).setOnClickListener(listeners);
        ((Button)findViewById(R.id.button_add_bottle)).setOnClickListener(listeners);
        ((Button)findViewById(R.id.button_remove_bottle)).setOnClickListener(listeners);
        
        tv_amount = ((EditText) this.findViewById(R.id.et_amount));
        
        view = ((LinearLayout) this.findViewById(R.id.view_main));
        view.setOnCreateContextMenuListener(this);
        
        
    }
    @Override
    public void onDestroy(){
    	Log.i("info", "onDestroy called");
    	db.close();
    	super.onDestroy();
    }
    
    private void onCreateMenu(Menu menu){
    	SubMenu m = menu.addSubMenu(0, 2000, 0, "Sous menu 1");
    	m.add(0,1000,0,"Menu 1").setChecked(true).setCheckable(true);
    	m.add(0,1001,0,"Menu 2").setEnabled(false);
    	m.setIcon(android.R.drawable.ic_menu_call);
    	m.setHeaderIcon(android.R.drawable.ic_menu_agenda);
    	
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	onCreateMenu(menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()){
    	case 1000:
    		Toast.makeText(this, "Menu 1", 1000).show();
    	case 1001:
    		Toast.makeText(this, "Menu 2", 1000).show();
    	}
    	
    	return super.onOptionsItemSelected(item);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	menu.findItem(2000).setTitle("Menu");
    	return super.onPrepareOptionsMenu(menu);
    }			
		
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		onCreateMenu(menu);
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	@SuppressLint("ShowToast")
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch(item.getItemId()){
    	case 1000:
    		Toast.makeText(this, "ContextMenu 1", 1000).show();
    	case 1001:
    		Toast.makeText(this, "ContextMenu 2", 1000).show();
    	}
		return super.onContextItemSelected(item);
	}
}