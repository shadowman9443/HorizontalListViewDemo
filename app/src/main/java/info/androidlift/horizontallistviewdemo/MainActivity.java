package info.androidlift.horizontallistviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import info.androidlift.horizontallistviewdemo.helper.Utils;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<String> alName;
    ArrayList<Integer> alImage;
    private Utils utils;

    private ArrayList<String> imagePaths = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for image
        utils = new Utils(this);

        // Initilizing Grid View
        //InitilizeGridLayout();

        // loading all image paths from SD card
        imagePaths = utils.getFilePaths();

        alName = new ArrayList<>(Arrays.asList("Cheesy...", "Crispy... ", "Fizzy...", "Cool..."));
        alImage = new ArrayList<>(Arrays.asList(R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy, R.drawable.cheesy));

        // Calling the RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        // The number of Columns
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HLVAdapter(MainActivity.this, alName, imagePaths);
        mRecyclerView.setAdapter(mAdapter);

    }
}
