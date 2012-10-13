package br.com.jiujitsu.manager.controller;

import br.com.jiujitsu.manager.controller.database.AtletasDataManager;
import br.com.jiujitsu.manager.model.AtletaModel;

/**
 *
 * @author Andrey Luiz
 */
public class MainController {

    public AtletaModel getById(long id) {
        AtletasDataManager manager = new AtletasDataManager();
        
        return manager.getById(id);
    }
    
    
    
}