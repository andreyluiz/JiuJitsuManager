package br.com.jiujitsu.manager.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class AtletaModel {
    
    private long id;
    private String nome;
    private Date data_nasc;
    private double peso;
    private char sexo;
    private boolean kimono;
    private char tipo_kimono;
    private String faixa;
    private String categoria_idade;
    private String categoria_peso;
    private String academia;
    
    public AtletaModel() {}
    
    public AtletaModel(long id) {
        this.id = id;
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the data_nasc
     */
    public Date getData_nasc() {
        return data_nasc;
    }

    /**
     * @param data_nasc the data_nasc to set
     */
    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the kimono
     */
    public boolean isKimono() {
        return kimono;
    }
    
    /**
     * @param kimono the kimono to set
     */
    public void setKimono(boolean kimono) {
        this.kimono = kimono;
    }

    /**
     * @return the tipo_kimono
     */
    public char getTipo_kimono() {
        return tipo_kimono;
    }

    /**
     * @param tipo_kimono the tipo_kimono to set
     */
    public void setTipo_kimono(char tipo_kimono) {
        this.tipo_kimono = tipo_kimono;
    }

    /**
     * @return the faixa
     */
    public String getFaixa() {
        return faixa;
    }

    /**
     * @param faixa the faixa to set
     */
    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    /**
     * @return the categoria_idade
     */
    public String getCategoria_idade() {
        return categoria_idade;
    }

    /**
     * @param categoria_idade the categoria_idade to set
     */
    public void setCategoria_idade(String categoria_idade) {
        this.categoria_idade = categoria_idade;
    }

    /**
     * @return the categoria_peso
     */
    public String getCategoria_peso() {
        return categoria_peso;
    }

    /**
     * @param categoria_peso the categoria_peso to set
     */
    public void setCategoria_peso(String categoria_peso) {
        this.categoria_peso = categoria_peso;
    }

    /**
     * @return the academia
     */
    public String getAcademia() {
        return academia;
    }

    /**
     * @param academia the academia to set
     */
    public void setAcademia(String academia) {
        this.academia = academia;
    }

}