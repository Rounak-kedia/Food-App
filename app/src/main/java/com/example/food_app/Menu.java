package com.example.food_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.food_app.Model.Food;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    //Initialization
    ListView list;
    Myadapter myadap;
    Integer category;
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> price=new ArrayList<>();
    ArrayList<Food> fooditems=new ArrayList<>();
    Button b;
    Integer pressed;
    Button previous;
    FirebaseDatabase database;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        list=findViewById(R.id.items);
        myadap= new Myadapter();

        //Get Category clicked
        Intent intent= getIntent();
        category=intent.getIntExtra(Dashboard.EXTRA_category, 0);
        //set selected button
        switch (category)
        {
            case R.id.img_pizza:
                b=findViewById(R.id.Pizza);
                break;
            case R.id.img_pasta:
                b=findViewById(R.id.Pasta);
                break;
            case R.id.img_burger:
                b=findViewById(R.id.Burger);
                break;
            case R.id.img_sides:
                b=findViewById(R.id.Sides);
                break;
            case R.id.img_dessert:
                b=findViewById(R.id.Dessert);
                break;
            case R.id.img_beverages:
                b=findViewById(R.id.Beverages);
                break;
        }
        b.setBackgroundResource(R.drawable.round_btn_menu_black);
        b.setTextColor(ContextCompat.getColor(this,R.color.white));
        previous = b;

        //
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Food");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //data
        title.add("Farm House");
        title.add("Crowded House");
        title.add("Margeritta");
        title.add("Awesome Jalapenoes");
        title.add("Paneer Tikka");
        title.add("Paneer Tikka B");
        title.add("Paneer Tikka C");
        price.add("Rs. 400");
        price.add("Rs. 500");
        price.add("Rs. 200");
        price.add("Rs. 400");
        price.add("Rs. 400");
        price.add("Rs. 400");
        price.add("Rs. 450");
        list.setAdapter(myadap);

    }

    @Override
    public void onClick(View v) {
        pressed = v.getId();
        switch (pressed)
        {
            case R.id.Pizza:
                b=findViewById(R.id.Pizza);
                break;
            case R.id.Pasta:
                b=findViewById(R.id.Pasta);
                break;
            case R.id.Burger:
                b=findViewById(R.id.Burger);
                break;
            case R.id.Sides:
                b=findViewById(R.id.Sides);
                break;
            case R.id.Dessert:
                b=findViewById(R.id.Dessert);
                break;
            case R.id.Beverages:
                b=findViewById(R.id.Beverages);
                break;
        }

        //load its menu

        b.setBackgroundResource(R.drawable.round_btn_menu_black);
        b.setTextColor(ContextCompat.getColor(this,R.color.white));

        previous.setBackgroundResource(R.drawable.round_btn_menu_white);
        previous.setTextColor(ContextCompat.getColor(this,R.color.black));
        previous=b;
    }

    class Myadapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return title.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v= LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_cards,null);
            TextView t = v.findViewById(R.id.item_title);
            TextView p = v.findViewById(R.id.price);
            ImageView i=v.findViewById(R.id.item_img);
            i.setImageResource(R.drawable.farmhouse);
            t.setText(title.get(position));
            p.setText(price.get(position));
            return v;
        }
    }
}
