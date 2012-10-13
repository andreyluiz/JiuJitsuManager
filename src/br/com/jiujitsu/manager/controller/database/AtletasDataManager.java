package br.com.jiujitsu.manager.controller.database;

import br.com.jiujitsu.manager.model.AtletaModel;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrey Luiz
 */
public class AtletasDataManager extends DataManager {

    @Override
    public void store(Object object) {
        db = Connection.get(DB_DIR + DATA_DB);
        try {
            AtletaModel atleta = (AtletaModel) object;
            db.store(atleta);
        } catch (Db4oException except) {
            except.printStackTrace();
            System.out.println(except.getMessage());
        } finally {
            db.close();
        }
    }
    
    @Override
    public void update(Object example, Object new_object) {
        db = Connection.get(DB_DIR + DATA_DB);
        AtletaModel _example = (AtletaModel) example;
        AtletaModel _new_object = (AtletaModel) new_object;
        try {
            ObjectSet result = db.queryByExample(example);
            if (result.size() > 0) {
                AtletaModel found = (AtletaModel) result.next();
                
                found.setNome(_new_object.getNome());
                found.setData_nasc(_new_object.getData_nasc());
                found.setPeso(_new_object.getPeso());
                found.setSexo(_new_object.getSexo());
                found.setKimono(_new_object.isKimono());
                found.setTipo_kimono(_new_object.getTipo_kimono());
                found.setFaixa(_new_object.getFaixa());
                found.setCategoria_idade(_new_object.getCategoria_idade());
                found.setCategoria_peso(_new_object.getCategoria_peso());
                found.setAcademia(_new_object.getAcademia());
                
                db.store(found);
                
            } else {
                throw new Db4oException("Não foi encontrado o objeto para atualizar.");
            }
        } catch (Db4oException except) {
            except.printStackTrace();
            System.out.println(except.getMessage());
        } finally {
            db.close();
        }
    }

    @Override
    public void delete(Object example) {
        db = Connection.get(DB_DIR + DATA_DB);
        try {
            AtletaModel _example = (AtletaModel) example;
            ObjectSet result = db.queryByExample(_example);
            if (result.size() > 0) {
                AtletaModel atleta = (AtletaModel) result.next();
                db.delete(atleta);
            } else {
                throw new Db4oException("Não foi encontrado o objeto para deletar.");
            }            
        } catch (Db4oException except) {
            except.printStackTrace();
            System.out.println(except.getMessage());
        } finally {
            db.close();
        }
    }
    
    @Override
    public List<AtletaModel> getAll() {
        db = Connection.get(DB_DIR + DATA_DB);
        List<AtletaModel> retorno = new ArrayList<>();
        try {
            ObjectSet result = db.queryByExample(AtletaModel.class);
            for (Object o : result) {
                retorno.add((AtletaModel) o);
            }
        } catch (Db4oException except) {
            except.printStackTrace();
            System.out.println(except.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }

    @Override
    public AtletaModel getById(long id) {
        db = Connection.get(DB_DIR + DATA_DB);
        AtletaModel retorno = null;
        try {
            AtletaModel example = new AtletaModel(id);
            ObjectSet result = db.queryByExample(example);
            if (result.size() == 0) {
                retorno = null;
            } else {
                retorno = (AtletaModel) result.next();
            }
        } catch (Db4oException except) {
            except.printStackTrace();
            System.out.println(except.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }   

    @Override
    public long getLastID() {
        int i = 0;    
        long last = 0;    
        List<AtletaModel> lista = getAll();    
        while (i < lista.size()) {    
            if (last < lista.get(i).getId()) {    
                last = lista.get(i).getId();    
            }    
            i++;    
        }
        return last;
    }   

    @Override
    public List<AtletaModel> getByAttr(String attr, Object valor) {
        db = Connection.get(DB_DIR + DATA_DB);
        List<AtletaModel> retorno = new ArrayList<>();
        try {
            AtletaModel example = new AtletaModel();
                                   
            Class classe = example.getClass();
            Field atrib = classe.getDeclaredField(attr);
            atrib.setAccessible(true);
            atrib.getClass();
            atrib.set(example, valor);
            
            Query query = db.query();
            query.descend(attr).constrain(valor).like();
            
            ObjectSet result = query.execute();
            
            for (Object o : result) {
                retorno.add((AtletaModel) result.next());
            }
            
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(AtletaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException | SecurityException ex) {
            Logger.getLogger(AtletaModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Db4oException ex) {
            System.err.println(ex.getMessage());
        } finally {
            db.close();
        }
        return retorno;
    }
    
}
