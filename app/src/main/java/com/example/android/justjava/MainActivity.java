package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;
    int toppingQuantity = 0;

    //    public void itemClicked(View view) {
//        //code to check if this checkbox is checked!
//        CheckBox checkBox = (CheckBox)view;
//        if(checkBox.isChecked()){
//            toppingQuantity++;
//            totalPrice();
//        }else{
//            toppingQuantity--;
//            totalPrice();
//        }
//
//    }
    String topping1 = "", topping2 = "", topping3 = "", topping4 = "", topping5 = "", topping6 = "";

    public void topping1Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping1="Whipped Cream";
            toppingQuantity++;
            totalPrice();
        } else {
            topping1="";
            toppingQuantity--;
            totalPrice();
        }

    }

    public void topping2Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping2=", Brown Sugar";
            toppingQuantity++;
            totalPrice();
        } else {
            topping2="";
            toppingQuantity--;
            totalPrice();
        }

    }public void topping3Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping3=", Mollases";
            toppingQuantity++;
            totalPrice();
        } else {
            topping3="";
            toppingQuantity--;
            totalPrice();
        }

    }public void topping4Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping4=", Choco Chips";
            toppingQuantity++;
            totalPrice();
        } else {
            topping4="";
            toppingQuantity--;
            totalPrice();
        }

    }public void topping5Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping5=", Sprinkles";
            toppingQuantity++;
            totalPrice();
        } else {
            topping5="";
            toppingQuantity--;
            totalPrice();
        }

    }public void topping6Clicked(View view) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            topping6=", Cocoa Powder";
            toppingQuantity++;
            totalPrice();
        } else {
            topping6="";
            toppingQuantity--;
            totalPrice();
        }

    }


    public void increment(View view) {
        display(++quantity);
        totalPrice();
    }

    public void decrement(View view) {
        if (quantity > 1) {
            display(--quantity);
            totalPrice();
        } else
            Toast.makeText(this, "Order atleast one coffee", Toast.LENGTH_SHORT).show();

    }

    int totalprice;

    public void totalPrice() {
        totalprice = (quantity * 10) + (toppingQuantity * quantity * 2);
        displayPrice(totalprice);
    }

    public void submitOrder(View view) {
        EditText namefield = (EditText) findViewById(R.id.name_view);
        String name = namefield.getText().toString();

        String messege;
        messege = name + "\nTotal products chosen: " + quantity + " Coffee" + "\nPrice: $" + totalprice + "\nToppings: "+topping1+topping2+topping3+topping4+topping5+topping6 + "\nOrder Placed\nThankyou";
//        displayMessege(messege);

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"mishradesh01@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "This order is for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, "" + messege);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
//    private void displayMessege(String messege){
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(messege);
//    }
}