package io.github.sagwascript.lab5;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrawingActivity extends Activity
{
	static ArrayList<String> list_nama;
	ListView listView;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drawing);

		Intent intent = getIntent();
		list_nama = intent.getStringArrayListExtra("LIST_NAMA");

		FragmentTwo fragmentTwo = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment_two);

		Bundle data = new Bundle();
		data.putStringArrayList("LIST_NAMA", list_nama);

		fragmentTwo.setListData(data);
	}

}
