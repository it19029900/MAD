package com.example.it19029900;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String book_title[] = {"To Kill ",	"LOR 01","LOR 02","Narnia 01","Narnia 02","Narnia 03"};
    String book_price[] = {"Rs 750","Rs 500","Rs 500","Rs 550","Rs 800","Rs 500","Rs 500"};
    int book_img[] = {R.drawable.a,R.drawable.b,R.drawable.b,R.drawable.b,R.drawable.c,R.drawable.c,R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        CustomeAdepter adepter = new CustomeAdepter(this,book_title,book_img,book_price);
        listView.setAdapter(adepter);
    }
}

class CustomeAdepter extends ArrayAdapter<String>{

    Context context;
    int[] images;
    String[] title;
    String[] price;
    public CustomeAdepter(Context context, String title[],int[] images,String[] price) {
        super(context,R.layout.single_row,R.id.title,title);
        this.context = context;
        this.images = images;
        this.title = title;
        this.price = price;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row,parent,false);

        ImageView imageView = row.findViewById(R.id.imageView);
        TextView titleView = row.findViewById(R.id.title);
        TextView priceView = row.findViewById(R.id.price);

        imageView.setImageResource(images[position]);
        titleView.setText(title[position]);
        priceView.setText(price[position]);
        return row;
    }
}