package io.github.sagwascript.lab5;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText eNama;

    public interface ListenerNama {
        void onFinishUserDialog(String nama);
    }

    public MyDialogFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input, container);
        eNama = (EditText) view.findViewById(R.id.nama);

        eNama.setOnEditorActionListener(this);
        eNama.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Silahkan isikan nama:");
        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        ListenerNama activity = (ListenerNama) getActivity();
        activity.onFinishUserDialog(eNama.getText().toString());
        this.dismiss();

        return true;
    }
}
