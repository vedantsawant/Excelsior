package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class InputFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    View myFragment;
    private TextView datetext,tv1,tv2,tv3,tv4,tv5;
    private EditText firno1,loc;
    private Spinner crimetype,time;
    private Button selectdate,submit;
    private String firno,date,ctype,area1,time1;
    private Context context;
    CrimeIncident crimeIncident;
    FirebaseDatabase database;
    DatabaseReference reff;
    private String[] ar = {"theft","pickpocketing","hitandrun"};
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.input_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        datetext = (TextView) getView().findViewById(R.id.date);
        submit = getView().findViewById(R.id.button1);
        selectdate = getView().findViewById(R.id.selectdate);
        tv1 = getView().findViewById(R.id.tv1);
        tv2 = getView().findViewById(R.id.tv2);
        tv3 = getView().findViewById(R.id.tv3);
        tv4 = getView().findViewById(R.id.tv4);
        tv5 = getView().findViewById(R.id.tv5);
        crimeIncident = new CrimeIncident();
        firno1 = getView().findViewById(R.id.editfirno);
        crimetype = getView().findViewById(R.id.crimetype);
        loc = getView().findViewById(R.id.editloc);
        time = getView().findViewById(R.id.edittime);
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("CrimeIncident");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               crimeIncident.setArea(loc.getText().toString());
               crimeIncident.setCrimetype(crimetype.getPrompt().toString());
               crimeIncident.setDate(selectdate.getText().toString());
               crimeIncident.setTime(time.getPrompt().toString());
               reff.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       reff.child("member1").setValue(crimeIncident);
                       Toast toast = Toast.makeText(getContext(),"DATA UPLOADED SUCCESSFULLY",Toast.LENGTH_SHORT);
                       toast.show();
                   }

                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });

            }
        });
        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        getView().findViewById(R.id.selectdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

    }
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this.getContext(),this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = "month/day/year: " + month + "/" + dayOfMonth + "/" + year;
        datetext.setText(date);
    }

}
