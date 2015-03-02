package com.example.navigation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listViewleft;
	String arrayItem[];
	
	android.support.v4.app.ActionBarDrawerToggle drawerToggle;
DrawerLayout drawerLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listViewleft = (ListView) findViewById(R.id.listViewleft);
		arrayItem = getResources().getStringArray(R.array.list);
		listViewleft.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, arrayItem));
		
		drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
		getActionBar().setHomeButtonEnabled(true);
	
		
		
		listViewleft.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				listViewleft.setItemChecked(arg2, true);
				setItem(arg2);
			}
		});
		
		/*drawerToggle=new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_launcher,
				R.string,R.string.drawerClose);*/
		drawerToggle=new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawerOpen, R.string.drawerClose){

					@Override
					public void onDrawerClosed(View drawerView) {
						// TODO Auto-generated method stub
						super.onDrawerClosed(drawerView);
					}

					@Override
					public void onDrawerOpened(View drawerView) {
						// TODO Auto-generated method stub
						super.onDrawerOpened(drawerView);
					}
			
		};
		drawerLayout.setDrawerListener(drawerToggle);
		
		
	}

	public void setItem(int positionK) {
		String title = arrayItem[positionK];
		setTitle(title);
	}

	public void setTitle(String title) {
		getActionBar().setTitle(title);
	}
	
@Override
protected void onPostCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onPostCreate(savedInstanceState);
   drawerToggle.syncState();
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	if(drawerToggle.onOptionsItemSelected(item))
			
			{
		return true;
			}
			
	return super.onOptionsItemSelected(item);
}
@Override
public void onConfigurationChanged(Configuration newConfig) {
	// TODO Auto-generated method stub
	super.onConfigurationChanged(newConfig);
	drawerToggle.onConfigurationChanged(newConfig);
}

}
