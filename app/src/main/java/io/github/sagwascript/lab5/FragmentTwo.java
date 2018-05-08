package io.github.sagwascript.lab5;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentTwo extends Fragment
{
    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> list_nama;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_02, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getActivity().findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list_nama);
        listView.setAdapter(adapter);
    }

    public void setListData(Bundle data) {
        list_nama = data.getStringArrayList("LIST_NAMA");
    }

}
