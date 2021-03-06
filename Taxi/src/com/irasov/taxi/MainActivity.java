package com.irasov.taxi;

import com.irasov.taxi.creator.Creator;
import com.irasov.taxi.entity.TaxiStation;
import com.irasov.taxi.logic.Action;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button button;
	private TextView tv;
	private TaxiStation taxiStation;
	private EditText showTaxiStation;
	private static final String TAG = "myLogs";
	private static final String MESSAGE = "Application run!";
	private static final String MESSAGE_CREATE = "Taxi Station Create!";
	private static final int ID_SORT_BY_PRICE = 1;
	private static final int ID_SORT_BY_YEAR = 2;
	private static final int ID_EXIT = 3;
	private static final int ID_ANIM = 4;
	private static final int ID_TWO_ACTIVITY = 5;
	private static final int ID_CATEGORY = 0;
	private static final int ID_CATEGORY_EXIT = 1;
	private static final String TITLE_MENU_SORT_BY_PRICE ="sort by price";
	private static final String TITLE_MENU_TWO_ACTIVITY ="Two Activity";
	private static final String TITLE_MENU_SORT_BY_YEAR ="sort by year";
	private static final String TITLE_MENU_ANIM ="animation";
	private static final String MENU_EXIT ="exit";
	private boolean visibleMenu = false;
	
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		   case R.id.CreateTaxiStation:
			   Log.d(TAG, "������ ������ �������!");
			   taxiStation = new TaxiStation("Allo");
			   Creator creator = new Creator(taxiStation,7);
			   creator.createCar();
			   visibleMenu = true;
			   showTaxiStation.setVisibility(showTaxiStation.VISIBLE);
			   Toast.makeText(this,MESSAGE_CREATE , Toast.LENGTH_LONG).show();
			   break;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.d(TAG, "���������� ���������!");
		Toast.makeText(this,MESSAGE , Toast.LENGTH_LONG).show();
		button = (Button)findViewById(R.id.CreateTaxiStation);
		showTaxiStation = (EditText)findViewById(R.id.showTaxiStation);
		tv = (TextView)findViewById(R.id.textView1);
		button.setOnClickListener(this);
		registerForContextMenu(showTaxiStation);		
		registerForContextMenu(tv);	
	}

	
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		switch(v.getId()){
		case R.id.showTaxiStation:
			menu.add(ID_CATEGORY,ID_SORT_BY_PRICE,ID_CATEGORY,TITLE_MENU_SORT_BY_PRICE);
			menu.add(ID_CATEGORY,ID_SORT_BY_YEAR,ID_CATEGORY,TITLE_MENU_SORT_BY_YEAR);
			break;
		case R.id.textView1:
			menu.add(ID_CATEGORY,ID_ANIM,ID_CATEGORY,TITLE_MENU_ANIM);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(ID_CATEGORY,ID_SORT_BY_PRICE,ID_CATEGORY,TITLE_MENU_SORT_BY_PRICE);
		menu.add(ID_CATEGORY,ID_SORT_BY_YEAR,ID_CATEGORY,TITLE_MENU_SORT_BY_YEAR);
		menu.add(ID_CATEGORY_EXIT,ID_EXIT,ID_CATEGORY,MENU_EXIT);
		menu.add(ID_CATEGORY_EXIT,ID_TWO_ACTIVITY,ID_CATEGORY,TITLE_MENU_TWO_ACTIVITY);
		return super.onCreateOptionsMenu(menu);
	}
	

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.setGroupVisible(0, visibleMenu);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		Animation anim = null;
		switch(item.getItemId()){
	    case ID_SORT_BY_PRICE:
	    	showTaxiStation.setText(null);
			Action.sortCar(taxiStation.getTaxiStation(), Action.CONST_SORT_PRICE);
			showTaxiStation.append(taxiStation.toString());
			break;
	    case ID_SORT_BY_YEAR:
	    	showTaxiStation.setText(null);
			Action.sortCar(taxiStation.getTaxiStation(), Action.CONST_SORT_YEAR);
			showTaxiStation.append(taxiStation.toString());
			break;
	    case ID_EXIT:
	    	finish();
			break;
	    case ID_ANIM:
	    	anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
	    	tv.startAnimation(anim);
	    	break;
	
	}
		return super.onContextItemSelected(item);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		    case ID_SORT_BY_PRICE:
		    	showTaxiStation.setText(null);
				Action.sortCar(taxiStation.getTaxiStation(), Action.CONST_SORT_PRICE);
				showTaxiStation.append(taxiStation.toString());
				break;
		    case ID_SORT_BY_YEAR:
		    	showTaxiStation.setText(null);
				Action.sortCar(taxiStation.getTaxiStation(), Action.CONST_SORT_YEAR);
				showTaxiStation.append(taxiStation.toString());
				break;
		    case ID_EXIT:
		    	System.exit(0);
				break;
		    case ID_TWO_ACTIVITY:
		    	Intent intent = new Intent(this, MainActivityTwo.class);
		    	startActivity(intent);
				break;
		}
		return super.onOptionsItemSelected(item);
	}
}
