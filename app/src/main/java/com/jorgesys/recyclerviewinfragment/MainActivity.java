package com.jorgesys.recyclerviewinfragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create new fragment and transaction.
        Fragment newFragment = new ListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the container view with this fragment,
        transaction.replace(R.id.frameContainer, newFragment);

        //We must not add the transaction to the back stack.
        //transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();


    }


}
