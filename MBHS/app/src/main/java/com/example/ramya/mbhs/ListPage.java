package com.example.ramya.mbhs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Ramya on 3/19/2016.
 */
public class ListPage extends Fragment {

    //TODO move these to the main activity so that they can be accessed from the calendar page
    private Event[] arrayOfEvents = new Event[] {
            new Event("Yoga Club is the best club that has ever existed at Blair", "Come do yoga!", "Room 352", "3/26", "3/26", "3:30PM", "4:30PM"),
            new Event("PuzzlePalooza", "Prizes are huge!", "Montgomery Blair HS", "5/18", "5/23", "10:00AM", "12:00PM"),
            new Event("Volleyball Game", "Blair vs. BCC", "Aux. Gym", "4/19", "4/19", "3:00PM", "5:00PM"),
            new Event("Early Release Day", "Dismissal at 1:00 PM", "Montgomery County Public Schools", "4/10", "4/10", "All Day", "All Day"),
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.event_list_page, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.eventListView);
        ListAdapter eventAdapter = new CustomEventAdapter(getContext(), arrayOfEvents);
        listView.setAdapter(eventAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Event value = (Event) adapter.getItemAtPosition(position);
                Intent i = new Intent(getContext(), DetailActivity.class);
                i.putExtra("thisEvent", arrayOfEvents[position].toStringArray());
                getContext().startActivity(i);

            }
        });

        return rootView;

    }


}
