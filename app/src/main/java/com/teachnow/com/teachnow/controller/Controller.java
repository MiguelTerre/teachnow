package com.teachnow.com.teachnow.controller;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.teachnow.com.teachnow.R;
import com.teachnow.com.teachnow.dominio.Empleo;
import com.teachnow.com.teachnow.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JULIO on 15/11/2017.
 */
//http://www.proyectosimio.com/es/programacion-android-base-de-datos-i-modelo-vista-controlador/
//https://androidexample.com/Use_MVC_Pattern_To_Create_Very_Basic_Shopping_Cart__-_Android_Example/index.php?view=article_discription&aid=116
public class Controller {

    private Model mdb;
    private ArrayAdapter<String> adapter;
    private Context context;

    public Controller(Context context) {
        mdb = new Model(context);
        this.context = context;
    }

    public void insertNotice(List<Empleo> empleos) {
        mdb = new Model(context);

        if (empleos.isEmpty() == false) {
            for (int i = 0; i < empleos.size(); i++) {
                mdb.insertarAviso(empleos.get(i).getName(), empleos.get(i).getDescription());
            }
        }
    }

    public void modifyAv() {
    }

    public void removeAv() {
    }

    public void searchAv() {
    }


    public ArrayAdapter<String> showEverything(String palabraClave) {
        mdb = new Model(context);
        List<String> list = new ArrayList<String>();

        if (palabraClave.isEmpty() != true) {
            for (int i = 0; i < mdb.recuperarAviso(palabraClave).size(); i++) {
                list.add(mdb.recuperarAviso(palabraClave).get(i).getName());
                list.add(mdb.recuperarAviso(palabraClave).get(i).getDescription());
            }
            adapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, list);
        } else {
            for (int i = 0; i < mdb.recuperarAvisos().size(); i++) {
                list.add(mdb.recuperarAvisos().get(i).getName());
                list.add(mdb.recuperarAvisos().get(i).getDescription());
            }
            adapter = new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, list);
        }
        return adapter;
    }
}
