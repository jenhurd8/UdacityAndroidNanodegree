package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    TextView mOriginTv;
    TextView mAlsoKnownAsTvHeading;
    TextView mIngredientsTvHeading;
    TextView mPlaceOfOriginTvHeading;
    TextView mDescriptionTv;
    TextView mIngredientsTv;
    TextView mAlsoKnownAsTv;
    TextView mDescriptionTvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.image_iv);
        mOriginTv = (TextView) findViewById(R.id.origin_tv);
        mAlsoKnownAsTvHeading = (TextView) findViewById(R.id.also_known_tv_heading);
        mIngredientsTvHeading = (TextView) findViewById(R.id.ingredients_tv_heading);
        mPlaceOfOriginTvHeading = (TextView) findViewById(R.id.place_of_origin_tv_heading);
        mDescriptionTv = (TextView) findViewById(R.id.description_tv);
        mIngredientsTv = (TextView) findViewById(R.id.ingredients_tv);
        mAlsoKnownAsTv = (TextView) findViewById(R.id.also_known_tv);
        mDescriptionTvHeading = (TextView) findViewById(R.id.description_tv_heading);

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sandwiches);

        // Simplification: Using a ListView instead of a RecyclerView
        ListView listView = findViewById(R.id.sandwiches_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchDetailActivity(position);
            }
        });
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }
}
