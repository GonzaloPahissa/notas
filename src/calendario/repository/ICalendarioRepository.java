package calendario.repository;

import nota.model.INota;

import java.util.ArrayList;

import calendario.model.Calendario;
import calendario.model.ICalendario;

public interface ICalendarioRepository {

    boolean exists(String nombre);
    boolean create(Calendario receta);
    INota read(String nombre);
    void remove(String nombre);
    ArrayList<Calendario> readAll();
    void saveAll();


}
