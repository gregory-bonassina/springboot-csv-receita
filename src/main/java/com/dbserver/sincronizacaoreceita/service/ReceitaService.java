package com.dbserver.sincronizacaoreceita.service;

import java.util.Arrays;
import java.util.List;

import com.dbserver.sincronizacaoreceita.model.Receita;

import org.springframework.stereotype.Service;

/**
 * @author gabriel_stabel<gabriel_stabel@sicredi.com.br>
 */
@Service("receitaService")
public class ReceitaService implements AccountService {

    private static ReceitaService instance;

    private ReceitaService() {}

    /**
     * getInstance
     * 
     * @return ReceitaService
     */
    public static ReceitaService getInstance() {
        if ( instance == null ) {
            instance = new ReceitaService();
        }
        return instance;
    }

    /**
     * atualizarConta
     * 
     * @param agencia
     * @param conta
     * @param saldo
     * @param status
     * @return
     * @throws RuntimeException
     * @throws InterruptedException
     */
    // Esta é a implementação interna do "servico" do banco central. Veja o código
    // fonte abaixo para ver os formatos esperados pelo Banco Central neste cenário.
    @Override
    public boolean updateAccount(String agencia, String conta, double saldo, String status) {

        try {
            // Formato agencia: 0000
            if (agencia == null || agencia.length() != 4) {
                return false;
            }

            // Formato conta: 000000
            if (conta == null || conta.length() != 6) {
                return false;
            }

            // Tipos de status validos:
            List<String> tipos = Arrays.asList(Receita.STATES);

            if (status == null || !tipos.contains(status)) {
                return false;
            }

            // Simula tempo de resposta do serviço (entre 1 e 5 segundos)
            long wait = Math.round(Math.random() * 4000) + 1000;
            Thread.sleep(wait);

            // Simula cenario de erro no serviço (0,1% de erro)
            long randomError = Math.round(Math.random() * 1000);
            if (randomError == 500) {
                throw new RuntimeException("Error");
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
        return true;
    }
}
