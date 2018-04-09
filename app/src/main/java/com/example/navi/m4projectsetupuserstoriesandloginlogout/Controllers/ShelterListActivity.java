package com.example.navi.m4projectsetupuserstoriesandloginlogout.Controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.Filter;
import android.widget.SearchView;
import android.widget.TextView;
import android.app.SearchManager;

import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.PreRegisteredShelters;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.Models.Shelter;
import com.example.navi.m4projectsetupuserstoriesandloginlogout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * An activity representing a list of Shelters. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ShelterDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class ShelterListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;



    private SimpleShelterRecyclerViewAdapter mAdaptor
            = new SimpleShelterRecyclerViewAdapter(this, PreRegisteredShelters.getInstance()
            .getShelters(), mTwoPane);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelter_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // Show the Up button in the action bar.
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

        if (findViewById(R.id.shelter_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }

        View recyclerView = findViewById(R.id.shelter_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        // Associate searchable configuration with the SearchView
        SearchView searchView = (SearchView) findViewById(R.id.search_bar);
        searchView.setIconified(false);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mAdaptor.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                mAdaptor.getFilter().filter(query);
                return false;
            }
        });

    }


    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
       // final PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();
//        PreRegisteredShelters preRegisteredShelters = new PreRegisteredShelters();
        recyclerView.setAdapter(mAdaptor);
    }

    public static class SimpleShelterRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleShelterRecyclerViewAdapter.ViewHolder>
            implements Filterable {

        private final ShelterListActivity mParentActivity;
        private List<Shelter> mValues;
        private final boolean mTwoPane;


        SimpleShelterRecyclerViewAdapter(ShelterListActivity parent,
                                      List<Shelter> items,
                                      boolean twoPane) {
            mValues = items;
            mParentActivity = parent;
            mTwoPane = twoPane;
        }

        @Override
        public Filter getFilter() {
            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    String charString = charSequence.toString();
                    PreRegisteredShelters preRegisteredShelters
                            = PreRegisteredShelters.getInstance();
                    List<Shelter> shelter_list;
                    if (charString.isEmpty()) {
                        shelter_list = preRegisteredShelters.getShelters();
                    } else {
                        List<Shelter> filteredList = new ArrayList<>();
                        for (Shelter row : preRegisteredShelters.getShelters()) {
                            //filter by key for testing
                            /*if (Integer.parseInt(row.getKey()) > Integer.parseInt(charString)) {
                                filteredList.add(row);
                            }*/
                            if (ShelterSearch.filterShelter(charString, row)) {
                                filteredList.add(row);
                            }
                        }

                        shelter_list = filteredList;
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = shelter_list;
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence charSequence,
                                              FilterResults filterResults) {
                    mValues = (ArrayList<Shelter>) filterResults.values;
                    notifyDataSetChanged();
                }
            };
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.shelter_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final PreRegisteredShelters preRegisteredShelters = PreRegisteredShelters.getInstance();

            holder.mValue = mValues.get(position);

            holder.mIdView.setText("" + mValues.get(position).getKey());
            holder.mContentView.setText(mValues.get(position).getName());

//            holder.itemView.setTag(mValues.get(position));
//            holder.itemView.setOnClickListener(mOnClickListener);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        //if a two pane window, we change the contents on the main screen
                        Bundle arguments = new Bundle();
                        arguments.putString(ShelterDetailFragment.ARG_ITEM_ID,
                                holder.mValue.getKey());

                        ShelterDetailFragment fragment = new ShelterDetailFragment();
                        fragment.setArguments(arguments);
                        mParentActivity.getSupportFragmentManager().beginTransaction()
                                .replace(R.id.shelter_detail_container, fragment)
                                .commit();
                    } else {
                        //on a phone, we need to change windows to the detail view
                        Context context = v.getContext();
                        //create our new intent with the new screen (activity)
                        Intent intent = new Intent(context, ShelterDetailActivity.class);
                        /*
                            pass along the id of the course so we can retrieve the correct data in
                            the next window
                         */
                        intent.putExtra(ShelterDetailFragment.ARG_ITEM_ID, holder.mValue.getKey());

                        preRegisteredShelters.setCurrentShelter(holder.mValue);

                        //now just display the new window
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public Shelter mValue;


            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id_text);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }
}
