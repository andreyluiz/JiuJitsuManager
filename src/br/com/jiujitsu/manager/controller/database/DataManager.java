package br.com.jiujitsu.manager.controller.database;

import br.com.jiujitsu.manager.controller.config.Configuration;
import com.db4o.ObjectContainer;
import java.util.List;

/**
 *
 * @author Andrey Luiz
 */
public abstract class DataManager {

    protected ObjectContainer db;
    protected String DB_DIR;
    protected Configuration config;
    protected static final String DATA_DB = "data";
    
    public DataManager() {
        config = new Configuration();
        DB_DIR = config.getDatabaseDir();
    }
    
    public abstract void store(Object object);
    
    public abstract void update(Object example, Object new_object);
    
    public abstract void delete(Object example);
    
    public abstract List<?> getAll();
    
    public abstract Object getById(long id);
    
    public abstract long getLastID();
    
    public abstract List<?> getByAttr(String attr, Object valor);
    
}
