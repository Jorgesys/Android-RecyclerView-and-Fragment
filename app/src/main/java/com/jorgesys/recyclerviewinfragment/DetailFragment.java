package com.jorgesys.recyclerviewinfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class DetailFragment extends Fragment {


    public static DetailFragment newInstance(int index) {
        DetailFragment f = new DetailFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.detail_fragment, container, false);

        ImageView imageView = v.findViewById(R.id.imageView);
        Person p = getPersonByIndex(getShownIndex());

        Picasso.get()
                .load(p.getUrlImage())
                .into(imageView);


        return v;
    }


    private Person getPersonByIndex(int index) {
        //Get values from strings.xml
        String name = getResources().getStringArray(R.array.names)[index];
        int age = getResources().getIntArray(R.array.ages)[index];
        String urlImage = getResources().getStringArray(R.array.images)[index];
        //Store values in ArrayList persons.
        Person person = new Person(name, age, urlImage);
        return person;
    }



}