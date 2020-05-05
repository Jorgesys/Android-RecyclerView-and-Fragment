package com.jorgesys.recyclerviewinfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private List<Person> persons;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.list_fragment, container, false);
        initArrayPersons();


        RecyclerView recyclerViewH = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerViewH.setAdapter(new MyRecyclerViewAdapter(persons, new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                Toast.makeText(getActivity(), persons.get(position).getName(), Toast.LENGTH_SHORT).show();

               // Create new fragment and transaction.
                Fragment newFragment = DetailFragment.newInstance(position);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                transaction.replace(R.id.frameContainer, newFragment);
                //Add transaction to the back stack
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        }));

        //Vertical orientation.
        recyclerViewH.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        // Inflate the layout for this fragment
        return v;
    }

    private void initArrayPersons() {
        persons = new ArrayList<Person>();
        //Get values from strings.xml
        String[] names = getResources().getStringArray(R.array.names);
        int[] ages = getResources().getIntArray(R.array.ages);
        String[] urlImages = getResources().getStringArray(R.array.images);
        //Store values in ArrayList persons.
        for (int i = 0; i < names.length; i++) {
            persons.add(new Person(names[i], ages[i], urlImages[i]));
        }
    }

}