package com.iescarrillo.ishoppinglist_jcpr.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.iescarrillo.ishoppinglist_jcpr.R;
import com.iescarrillo.ishoppinglist_jcpr.models.Person;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvDni, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvDni = findViewById(R.id.tvDni);
        tvPhone = findViewById(R.id.tvPhone);

        // Obtengo el intent que ha iniciado la Activity
        Intent intent = getIntent();

        Person p = (Person) intent.getSerializableExtra("person");

        tvName.setText(p.getName() + p.getSurname());
        tvEmail.setText(p.getEmail());
        tvDni.setText(p.getDni());
        tvPhone.setText(p.getPhone());

        Log.i("person", p.toString());

    }
}