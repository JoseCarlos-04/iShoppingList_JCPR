package com.iescarrillo.ishoppinglist_jcpr.activities;

import static com.iescarrillo.ishoppinglist_jcpr.database.Database.personList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.iescarrillo.ishoppinglist_jcpr.R;
import com.iescarrillo.ishoppinglist_jcpr.adapters.PersonAdapter;
import com.iescarrillo.ishoppinglist_jcpr.models.Person;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName, tvEmail, tvDni, tvPhone;
    private Spinner spPersons;
    private Button btnSendPerson;

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
        spPersons = findViewById(R.id.spPersons);
        btnSendPerson = findViewById(R.id.btnSendPerson);

        // Obtengo el intent que ha iniciado la Activity
        Intent intent = getIntent();

        Person p = (Person) intent.getSerializableExtra("person");

        Log.i("person", p.toString());

        tvName.setText(p.getName() + p.getSurname());
        tvEmail.setText(p.getEmail());
        tvDni.setText(p.getDni());
        tvPhone.setText(p.getPhone());

        PersonAdapter adapter = new PersonAdapter(DetailActivity.this, 0, personList);
        spPersons.setAdapter(adapter);

        btnSendPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(DetailActivity.this, MainActivity.class);

                intentMain.putExtra("person", (Person) spPersons.getSelectedItem());

                Log.i("persona seleccionada", spPersons.getSelectedItem().toString());

                startActivity(intentMain);
            }
        });

    }
}