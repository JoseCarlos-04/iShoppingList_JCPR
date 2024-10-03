package com.iescarrillo.ishoppinglist_jcpr.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.iescarrillo.ishoppinglist_jcpr.R;
import com.iescarrillo.ishoppinglist_jcpr.models.Person;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private List<Person> persons;

    // Llamada al constructor del padre (contexto, idResource, lista de objetos que queremos recorrer)
    public PersonAdapter(Context context, int resource, List<Person> persons) {
        super(context, resource, persons);

        this.persons = persons;
    }

    // Método para indicar el XML de la vista y realizar las modificaciones
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Person p = this.persons.get(position);

        // Si todavía no se ha creado la vista
        if (convertView == null){
            /* Aquí le indicamos el XML que queremos que cree llamando al método .inflate
               Método .inflate(hace referencia al xml que queremos mostrar, ViewGroup parent,
               false para que primero cree el xml padre y luego el hijo)*/
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_person, parent, false);
        }

        // Recogemos de la vista los componentes
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);
        TextView tvPhone = convertView.findViewById(R.id.tvPhone);

        // Modificamos los atributos de los componentes
        tvName.setText(p.getName() + " " + p.getSurname());
        tvEmail.setText(p.getEmail());
        tvPhone.setText(p.getPhone());

        return convertView;
    }

}
