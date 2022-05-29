package com.dbserver.sincronizacaoreceita.model;

/**
 * @author Gregory Bonassina
 */
public class Account {

    private String agencia;
    private String conta;
    private double saldo;
    private String status;

    public Account() {
        
    }
    /**
     * 
     * @param agencia
     * @param conta
     * @param saldo
     * @param status
     */
    public Account(String agencia, String conta, double saldo, String status) {
        setAgencia(agencia);
        setConta(conta);
        setSaldo(saldo);
        setStatus(status);
    }
    
    /** 
     * @return String
     */
    public String getAgencia() {
        return agencia;
    }
    
    /** 
     * @return String
     */
    public String getStatus() {
        return status;
    }
    
    /** 
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /** 
     * @return double
     */
    public double getSaldo() {
        return saldo;
    }
    
    /** 
     * @param saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    /** 
     * @return String
     */
    public String getConta() {
        return conta;
    }
    
    /** 
     * @param conta
     */
    public void setConta(String conta) {
        this.conta = conta;
    }
    
    /** 
     * @param agencia
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
}
