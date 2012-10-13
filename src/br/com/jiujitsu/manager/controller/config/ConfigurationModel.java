package br.com.jiujitsu.manager.controller.config;

/**
 *
 * @author pc
 */
public class ConfigurationModel {
    
    private String dbdir;
    private boolean ativetyping;
    private int index_campo_pesquisa;

    /**
     * @return the dbdir
     */
    public String getDbdir() {
        return dbdir;
    }

    /**
     * @param dbdir the dbdir to set
     */
    public void setDbdir(String dbdir) {
        this.dbdir = dbdir;
    }

    /**
     * @return the ativetyping
     */
    public boolean isAtivetyping() {
        return ativetyping;
    }

    /**
     * @param ativetyping the ativetyping to set
     */
    public void setAtivetyping(boolean ativetyping) {
        this.ativetyping = ativetyping;
    }

    /**
     * @return the index_campo_pesquisa
     */
    public int getIndex_campo_pesquisa() {
        return index_campo_pesquisa;
    }

    /**
     * @param index_campo_pesquisa the index_campo_pesquisa to set
     */
    public void setIndex_campo_pesquisa(int index_campo_pesquisa) {
        this.index_campo_pesquisa = index_campo_pesquisa;
    }  

}