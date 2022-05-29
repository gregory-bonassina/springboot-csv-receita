package com.dbserver.sincronizacaoreceita.service;

/**
 * @author Gregory Bonassina
 */
public interface AccountService {
    public boolean updateAccount( String agencia, String conta, double saldo, String status );
}
