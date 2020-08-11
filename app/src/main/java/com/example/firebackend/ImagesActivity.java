package com.example.firebackend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference refrence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();

        refrence = database.getReference("User");


    }

    @Override
    protected void onStart() {
        super.onStart();
       FirebaseRecyclerAdapter<Member,ViewHolder> firebaseRecyclerAdapter =
               new FirebaseRecyclerAdapter<Member, ViewHolder>(
                       Member.class,
                       R.layout.image_item,
                       ViewHolder.class,
                       refrence
               ) {
                   @Override
                   protected void populateViewHolder(ViewHolder viewHolder, Member member, int i) {

                       viewHolder.setDetails(getApplicationContext(),member.getTitle(),member.getImage());
                   }
               };
         recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
