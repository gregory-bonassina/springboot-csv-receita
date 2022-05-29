package com.dbserver.sincronizacaoreceita.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReceitaServiceTest {

    public static ReceitaService receitaService;

    @BeforeAll
    public static void init() {
        receitaService = ReceitaService.getInstance();
    }

    @Test
    public void atualizarContaTest() {
        String agencia = "0101";
        String conta = "123456";
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount( agencia, conta, saldo, status );

        Assertions.assertTrue( result );
    }

    @Test
    public void withNoAgencyTest() throws RuntimeException, InterruptedException {
        String agencia = null;
        String conta = "123456";
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertFalse( result );
    }

    @Test
    public void withNoFourNumbersAgencyTest() {
        String agencia = "123456";
        String conta = "123456";
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertFalse( result );
    }

    @Test
    public void withNoAccountTest() {
        String agencia = "1234";
        String conta = null;
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertFalse( result );
    }

    @Test
    public void withNoSixNumbersAccountTest() {
        String agencia = "1234";
        String conta = "123";
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertFalse( result );
    }

    @Test
    public void withNoStateTest() {
        String agencia = "1234";
        String conta = "123456";
        double saldo = 100.00;
        String status = null;

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertFalse( result );
    }

    @Test
    public void withContainsStateTest() {
        String agencia = "1234";
        String conta = "123456";
        double saldo = 100.00;
        String status = "A";

        boolean result = receitaService.updateAccount(agencia, conta, saldo, status);

        Assertions.assertTrue( result );
    }
}
