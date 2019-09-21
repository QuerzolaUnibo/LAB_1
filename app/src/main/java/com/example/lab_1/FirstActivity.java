package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private ConstraintLayout main;
    private Button myButton, secondActivityBtn, remove_button;
    private TextView myTextView, rmvTextView;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        main = (ConstraintLayout) findViewById(R.id.main);
        myButton = (Button) findViewById(R.id.button);
        remove_button = (Button) findViewById(R.id.remove_btn);
        rmvTextView = (TextView) findViewById(R.id.rmv_textview);
        secondActivityBtn = (Button) findViewById(R.id.secondActivityButton);
        myTextView = (TextView) findViewById(R.id.textView);

        myButton.setOnClickListener( myButtonClick );
        remove_button.setOnClickListener( removeOnClick );
        secondActivityBtn.setOnClickListener( startSecondActivity );
        secondActivityBtn.setOnLongClickListener( startSecondActivityLong );

        myTextView = (TextView) findViewById(R.id.textView);
    }

    View.OnClickListener myButtonClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
           myTextView.setText(myTextView.getText() + "\nNext line");
        }
    };

    View.OnClickListener removeOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            rmvTextView = (TextView) findViewById(R.id.rmv_textview);
            if (rmvTextView != null)
                main.removeView(rmvTextView);
        }
    };

    public void runSecondActivity (boolean b) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra ("flag", b);
        context.startActivity(intent);
    }

    View.OnClickListener startSecondActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            runSecondActivity(true);
        }
    };

    View.OnLongClickListener startSecondActivityLong = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            runSecondActivity(false);
            return true;
        }
    };
}


