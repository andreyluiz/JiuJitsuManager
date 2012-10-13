package br.com.jiujitsu.manager.controller.database;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 *
 * @author Andrey
 */
public class Connection {
    
    public static ObjectContainer get(String db_name) {
        return Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), db_name);
    }

}