package br.com.jiujitsu.manager.controller.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ho.yaml.Yaml;

/**
 *
 * @author Andrey Luiz
 */
public class Configuration {
    
    File file = new File("C:\\jiujitsu\\manager\\config.yaml");
        
    public String getDatabaseDir() {
        ConfigurationModel config = null;
        try {
            config = Yaml.loadType(file, ConfigurationModel.class);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return config.getDbdir();
    }   

}