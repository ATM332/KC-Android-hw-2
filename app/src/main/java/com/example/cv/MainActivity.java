package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Name= findViewById(R.id.name);
        EditText Age= findViewById(R.id.age);
        EditText Job= findViewById(R.id.job);
        EditText Phone= findViewById(R.id.phone_number);
        EditText Email= findViewById(R.id.email);

        Button button = findViewById(R.id.button);

        Name.addTextChangedListener(textWatcher);
        Age.addTextChangedListener(textWatcher);
        Job.addTextChangedListener(textWatcher);
        Phone.addTextChangedListener(textWatcher);
        Email.addTextChangedListener(textWatcher);

        button.setEnabled(false);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                CV cv = new CV("Awrad", 17,"studnet",12345678,"awrad@gmail.com");

                Intent intent = new Intent(MainActivity.this , MainActivity2.class);

                intent.putExtra("age", cv.getAge());
                intent.putExtra("email", cv.getEmail());
                intent.putExtra("job", cv.getJob());
                intent.putExtra("name", cv.getName());
                intent.putExtra("phone number", cv.getPhoneNumber());
                startActivity(intent);


            }
        });







    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            EditText Name= findViewById(R.id.name);
            EditText Age= findViewById(R.id.age);
            EditText Job= findViewById(R.id.job);
            EditText Phone= findViewById(R.id.phone_number);
            EditText Email= findViewById(R.id.email);

            Button button = findViewById(R.id.button);


            String nameInput = Name.getText().toString();
            String ageInput = Age.getText().toString();
            String jobInput = Job.getText().toString();
            String phoneInput = Phone.getText().toString();
            String emailInput = Email.getText().toString();

            if(!nameInput.isEmpty() && !ageInput.isEmpty() && !jobInput.isEmpty() && !phoneInput.isEmpty() && !emailInput.isEmpty()){
                button.setEnabled(true);

            }else{
                button.setEnabled(false);

            }



        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}