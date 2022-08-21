package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView userName = findViewById(R.id.userName);
        TextView userAge = findViewById(R.id.userAge);
        TextView userJob = findViewById(R.id.userJob);
        TextView userPhone = findViewById(R.id.userPhone);
        TextView userEmail = findViewById(R.id.userEmail);

        //bonus
        userPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345678"));
                startActivity(intent);
            }
        });



        Bundle bundle = getIntent().getExtras();

        String nameString = bundle.getString("name");
        userName.setText(nameString);
        String jobString = bundle.getString("job");
        userJob.setText(jobString);
        String emailString = bundle.getString("email");
        userEmail.setText(emailString);
        String ageString = String.valueOf(bundle.getInt("age"));
        userAge.setText(ageString);
        String phoneNumberString = String.valueOf(bundle.getInt("phone number"));
        userPhone.setText(phoneNumberString);

    }
}