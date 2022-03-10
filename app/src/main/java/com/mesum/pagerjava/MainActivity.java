package com.mesum.pagerjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import com.google.android.material.tabs.TabLayout;
import com.mesum.pagerjava.databinding.ActivityMainBinding;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Toolbar tb;
    PagerAdapter pA;
    ViewPager vp;
    int paramsCounter = 5;
    private ActivityMainBinding binding;
    private View  layout;
    GridView simpleList;
    ArrayList birdList=new ArrayList<>();
    GridView simpleGrid;
    int flags[] = {R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping};
    int subflags[] = {R.drawable.personshopping, R.drawable.personshopping, R.drawable.personshopping};
    ScrollView scrollView;
    GridView subgrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        layout = binding.getRoot();
        setContentView(layout);
        tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pA = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        vp = findViewById(R.id.pager);
        vp.setAdapter(pA);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        }
        );

        populateGrid();
        populateSubGrid();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the options menu
        getMenuInflater().inflate(R.menu.options_menu, menu);
        getMenuInflater().inflate(R.menu.bardcode_menu, menu);
        getMenuInflater().inflate(R.menu.cartmenu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.headphone:
                Toast.makeText(getApplicationContext(), "Thank you for contacting customer support", Toast.LENGTH_SHORT).show();
                return true;
            default:
                //Do nothing
        }
        return super.onOptionsItemSelected(item);

    }
    public void populateGrid(){
        simpleGrid = (GridView) findViewById(R.id.gridbody);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), flags);
        simpleGrid.setAdapter(customAdapter);
    }

    private void populateSubGrid(){
        subgrid = (GridView) findViewById(R.id.gridsub);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), subflags);
        subgrid.setAdapter(customAdapter);
    }


}