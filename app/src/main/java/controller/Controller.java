package controller;

import android.app.Application;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import model.Model;

/**
 * Created by JULIO on 15/11/2017.
 */

//http://www.proyectosimio.com/es/programacion-android-base-de-datos-i-modelo-vista-controlador/
//https://androidexample.com/Use_MVC_Pattern_To_Create_Very_Basic_Shopping_Cart__-_Android_Example/index.php?view=article_discription&aid=116
public class Controller {

    private Model model;

    public Controller(Context context) {
        model = new Model(context);
    }

    public List<String> mostrar() {
        List<String> Trabajos = new ArrayList<String>();

        for (int i = 0; i < model.obtenerRegistrosEmpleo().size(); i++) {
            Trabajos.add(model.obtenerRegistrosEmpleo().get(i).getDescripcion());
        }
        return Trabajos;
    }


}
