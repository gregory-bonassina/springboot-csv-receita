package com.dbserver.sincronizacaoreceita;

import java.io.File;

import com.dbserver.sincronizacaoreceita.controller.ReceitaController;
import com.dbserver.sincronizacaoreceita.util.FileUtilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SincronizacaoReceita implements CommandLineRunner {

    private static SincronizacaoReceita instance;

    /**
     * getInstance
     * 
     * @return SincronizacaoReceita
     */
    public static SincronizacaoReceita getInstance() {
        if ( instance == null ) {
            instance = new SincronizacaoReceita();
        }
        return instance;
    }

    /**
     * main
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SincronizacaoReceita.class, args);
    }

    /**
     * run
     */
    @Override
    public void run(String... args) throws Exception {
        // args = new String[] {
        //     "C:/Users/Greg/Desktop/input.csv"
        // };

        SincronizacaoReceita.getInstance().startup( args );
    }

    /**
     * startup
     * 
     * @param args
     */
    private void startup(String...args) {
        String path = args[0];

        // Verificar se o arquivo de fato existe
        File file = FileUtilities.getFileFromPath(path);

        new ReceitaController().generateCSV(file, path);
    }
}
