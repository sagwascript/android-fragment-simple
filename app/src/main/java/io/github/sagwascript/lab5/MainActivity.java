package io.github.sagwascript.lab5;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.ListenerNama {

    public ArrayList<String> insertedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertedName = new ArrayList<String>();
    }

    public void onButtonClick(View v)
    {
        FragmentManager manager = getFragmentManager();
        FragmentTwo fragmentTwo = (FragmentTwo) getFragmentManager().findFragmentById(R.id.fragment_two);
        Fragment frag = manager.findFragmentByTag("fragment_insert_name");

        if (frag != null) {
            manager.beginTransaction().remove(frag).commit();
        }

        switch(v.getId())
        {
            case R.id.btn_one_create_new:

                if (fragmentTwo == null)	// PHONE!
                {
                    // Need to launch another activity
                    MyDialogFragment insertNameDialog = new MyDialogFragment();
                    insertNameDialog.show(manager, "fragment_insert_name");
                } else	// TABLET!
                {
                    // Let's do nothing right now, and just show up a toast.
                    Toast.makeText(this, "Will be implemented later", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_one_open_existing:

                Intent i = new Intent(this, DrawingActivity.class);
                i.putStringArrayListExtra("LIST_NAMA", insertedName);
                startActivity(i);

                break;

            default:
        }
    }

    @Override
    public void onFinishUserDialog(String nama) {
        insertNewName(nama);
        Toast.makeText(this, "Hello, " + nama, Toast.LENGTH_SHORT).show();
    }

    void insertNewName(String nama) {
        insertedName.add(nama);
        Intent i = new Intent(this, DrawingActivity.class);
        i.putStringArrayListExtra("LIST_NAMA", insertedName);
        startActivity(i);
    }

}
