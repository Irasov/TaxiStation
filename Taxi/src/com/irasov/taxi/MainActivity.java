package com.irasov.taxi;

import com.irasov.taxi.creator.Creator;
import com.irasov.taxi.entity.TaxiStation;
import com.irasov.taxi.logic.Action;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private Button button;
	private TaxiStation taxiStation;
	private EditText showTaxiStation;
	private static final String TAG = "myLogs";
	private static final String MESSAGE = "Application run!";
	private static final String MESSAGE_CREATE = "Taxi Station Create!";
	private static final int ID_SORT_BY_PRICE = 1;
	private static final int ID_SORT_BY_YEAR = 2;
	private static final int ID_CATEGORY = 0;
	private static final String TITLE_MENU_SORT_BY_PRICE ="sort by price";
	private static final String TITLE_MENU_SORT_BY_YEAR ="sort by year";
	
	
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		   case R.id.CreateTaxiStation:
			   Log.d(TAG, "������ ������ �������!");
			   taxiStation = new TaxiStation("Allo");
			   Creator creator = new Creator(taxiStation,7);
			   creator.createCar();
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
		button.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(ID_CATEGORY,ID_SORT_BY_PRICE,ID_CATEGORY,TITLE_MENU_SORT_BY_PRICE);
		menu.add(ID_CATEGORY,ID_SORT_BY_YEAR,ID_CATEGORY,TITLE_MENU_SORT_BY_YEAR);
		return super.onCreateOptionsMenu(menu);
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
		}
		return super.onOptionsItemSelected(item);
	}
}