package com.example.food_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ListView list;
    Myadapter myadap;
    Integer category;
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> price=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        list=findViewById(R.id.items);
        myadap= new Myadapter();

        //Get Category clicked
        Intent intent= getIntent();


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

 /*   private void setbutton(String cat) {
        switch (cat)
        {
            case R.id.img_pizza:


        }
    }
*/
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
