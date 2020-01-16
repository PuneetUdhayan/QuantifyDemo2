package com.example.quantifydemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PrevTestFragment extends Fragment {

    private ListView previousTests;
    private DatabaseReference myRef;
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;
    private ArrayList<MarksAndAnswers> tests=new ArrayList<>();
    private String id;
    private PreviousTestAdapter previousTestAdapter;
    private ListView listView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prev_test,container, false);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        id=currentUser.getUid();
        previousTests=view.findViewById(R.id.results_list);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Results").child(id);
        listView=view.findViewById(R.id.results_list);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                tests.clear();

                for(DataSnapshot i:dataSnapshot.getChildren()){
                    MarksAndAnswers temp=i.getValue(MarksAndAnswers.class);
                    tests.add(temp);
                }

                previousTestAdapter=new PreviousTestAdapter(getActivity(),R.layout.results_card,tests);
                listView.setAdapter(previousTestAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;

    }
}
