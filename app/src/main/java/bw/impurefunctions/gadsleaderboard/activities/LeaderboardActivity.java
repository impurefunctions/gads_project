package bw.impurefunctions.gadsleaderboard.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import bw.impurefunctions.gadsleaderboard.R;
import bw.impurefunctions.gadsleaderboard.fragments.SkilliQFragment;

public class LeaderboardActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    private String[] tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        tabTitles = getResources().getStringArray(R.array.tab_titles);
        tabLayout = findViewById(R.id.tabLayoutHome);
        viewPager = findViewById(R.id.viewPagerHome);
        Button submit = findViewById(R.id.submit);


        submit.setOnClickListener(view -> {
            Intent submitActivity = new Intent(LeaderboardActivity.this, ProjectSubmissionActivity.class);
            startActivity(submitActivity);
        });
        //Add 2 tabs to the TabLayout
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(this, 2);
        viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    Log.e("Tab", String.valueOf(position));
                    tab.setText(tabTitles[position]);
                }
        ).attach();
    }


}

class MyViewPagerAdapter extends FragmentStateAdapter {
    int totalTabs;

    public MyViewPagerAdapter(@NonNull FragmentActivity fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LearningLeadersFragment();
            case 1:
                return new SkilliQFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {

        return totalTabs;
    }

}
