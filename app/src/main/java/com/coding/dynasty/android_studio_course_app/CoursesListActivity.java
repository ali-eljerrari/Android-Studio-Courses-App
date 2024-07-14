package com.coding.dynasty.android_studio_course_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class CoursesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_courses_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setSupportActionBar(findViewById(R.id.toolbar));

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Popular Courses");

        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList<CoursesDomain> items = new ArrayList<>();
        items.add(new CoursesDomain("Advanced  certification Program in AI", 169, "ic_1"));
        items.add(new CoursesDomain("Google Cloud Platform Architecture", 69, "ic_2"));
        items.add(new CoursesDomain("Fundamental of java Programming", 150, "ic_3"));
        items.add(new CoursesDomain("Introduction to UI design history", 79, "ic_4"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering", 49, "ic_5"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering2", 100, "ic_1"));
        items.add(new CoursesDomain("PG Program in Big Data Engineering3", 419, "ic_2"));

        RecyclerView recyclerViewCourse = findViewById(R.id.view);
        recyclerViewCourse.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        RecyclerView.Adapter<CoursesAdapter.Viewholder> adapterCourceList = new CoursesAdapter(items);
        recyclerViewCourse.setAdapter(adapterCourceList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(CoursesListActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}