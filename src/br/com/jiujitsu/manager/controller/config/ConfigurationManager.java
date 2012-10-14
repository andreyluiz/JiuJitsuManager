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
public class ConfigurationManager {
    
    ConfigurationModel config = null;
    File file = new File("C:\\jiujitsu\\manager\\config.yaml");
    private static ConfigurationManager instance;
    
    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    
    private void loadYaml() {
        try {
            config = Yaml.loadType(file, ConfigurationModel.class);            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigurationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDatabaseDir() {
        if (config == null) {
            loadYaml();
        }
        return config.getDbdir();
    }   

}