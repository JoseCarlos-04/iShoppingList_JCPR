package com.iescarrillo.ishoppinglist_jcpr.database;

import com.iescarrillo.ishoppinglist_jcpr.models.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Person> personList;

    public static void initializeList(){
        personList = new ArrayList<>();

        Person p = new Person();

        p.setName("José Carlos");
        p.setSurname("Parrilla Romero");
        p.setEmail("jparrom736@iescarrillo.es");
        p.setAge(20);
        p.setPhone("681635033");
        p.setDni("49388736P");

        personList.add(p);

        for (int i = 0; i < 50; i++){
            Person p2 = new Person();

            p2.setName("José Carlos" + i);
            p2.setSurname("Parrilla Romero" + i);
            p2.setEmail("jparrom736@iescarrillo.es");
            p2.setAge(20);
            p2.setPhone("681635033");
            p2.setDni("49388736P");

            personList.add(p2);
        }
    }

}
