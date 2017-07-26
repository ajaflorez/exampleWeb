package interfaces;

//  Declaración de los métodos a utilizar en el DAO

import java.util.ArrayList;

public interface DAO <Table>{
    
    public boolean insert(Table ta);
    public boolean delete(Object key);
    public boolean update(Table ta);
    public Table select(Object key);
    public ArrayList<Table> selectAll();
}
