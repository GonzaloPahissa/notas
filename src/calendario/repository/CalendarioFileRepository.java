package calendario.repository;

import common.FileMethods;
import nota.model.INota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import calendario.model.Calendario;
import calendario.model.ICalendario;

public class CalendarioFileRepository implements ICalendarioRepository {

    private HashMap<String, Calendario> repo;
    private final String path = "data/calendario.dat";

    public CalendarioFileRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public boolean exists(String nombre) {
        return repo.containsKey(nombre);
    }

//    @Override
	@Override
    public boolean create(Calendario calendario) {
        repo.put(calendario.getNombre(), calendario);
        FileMethods.writeMapToFile(repo, path);
        return true;
    }

    @Override
    public Calendario read(String nombre) {
        return repo.get(nombre);
    }

    @Override
    public void remove(String nombre) {
        repo.remove(nombre);
        FileMethods.writeMapToFile(repo, path);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Calendario> readAll() {
        repo = FileMethods.readMapFromFile(path);
        Collection<Calendario> values = repo.values(); // pasar los valores de map a arraylist
        ArrayList<Calendario> rE = new ArrayList<Calendario>(values);
        return rE;
    }

    public void saveAll() {
        FileMethods.writeMapToFile(repo, path);
    }



}