package com.dbserver.sincronizacaoreceita.model;

/**
 * @author Gregory Bonassina
 */
public class Receita {

    public static final String HEADER_AGENCIA = "agencia";
    public static final String HEADER_CONTA   = "conta";
    public static final String HEADER_SALDO   = "saldo";
    public static final String HEADER_STATUS  = "status";
    public static final String HEADER_RESULT  = "resultado";

    public static final String[] STATES = {
        "A",
        "I",
        "B",
        "P"
    };

    public static final String[] HEADERS = {
            HEADER_AGENCIA,
            HEADER_CONTA,
            HEADER_SALDO,
            HEADER_STATUS
    };

    public static final String[] HEADERS_OUTPUT = {
            HEADER_AGENCIA,
            HEADER_CONTA,
            HEADER_SALDO,
            HEADER_STATUS,
            HEADER_RESULT
    };

    private String agencia;
    private String conta;
    private double saldo;
    private String status;
    private boolean result;

    /**
     * Receita
     */
    public Receita() {
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
     * @return String
     */
    public String getAgencia() {
        return agencia;
    }
    
    /** 
     * @param agencia
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /** 
     * @return boolean
     */
    public String getResult() {
        return result ? "Sucesso" : "Erro";
    }
    
    /** 
     * @param result
     */
    public void setResult(boolean result) {
        this.result = result;
    }
}