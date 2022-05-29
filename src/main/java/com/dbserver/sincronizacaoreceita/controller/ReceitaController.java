package com.dbserver.sincronizacaoreceita.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dbserver.sincronizacaoreceita.model.Receita;
import com.dbserver.sincronizacaoreceita.service.ReceitaService;
import com.dbserver.sincronizacaoreceita.util.CSVUtilities;
import com.dbserver.sincronizacaoreceita.util.NumberUtilities;

import org.apache.commons.csv.CSVRecord;

/**
 * @author Gregory Bonassina
 */
public class ReceitaController {
    
    /**
     * ReceitaController
     */
    public ReceitaController() {
    }

    /**
     * launch
     * 
     * @param file
     * @param path
     */
    public void generateCSV( File file, String path ) {
        try {
            // Verificar se é um arquivo CSV
            if ( file != null && CSVUtilities.hasCSVFormat(path) ) {
                List<Receita> receitas = new ArrayList<Receita>();

                if (file != null) {
                    // Ler o arquivo csv e colocar seus valores em uma lista
                    List<CSVRecord> records = CSVUtilities.getCSVRecords(file);

                    if (records != null && !records.isEmpty()) {
                        CSVRecord headers = records.get(0);

                        // Comparação para ver se existe a mesma quantidade e os mesmos Cabeçalhos
                        if (!headers.toList().equals(Arrays.asList(Receita.HEADERS))) {
                            System.out.println("Seu arquivo está incorreto, por favor, verifique a ordem dos valores para que obedeça a seguinte ordem:");
                            System.out.println(Receita.HEADER_AGENCIA + ";" + Receita.HEADER_CONTA + ";" + Receita.HEADER_SALDO + ";" + Receita.HEADER_STATUS);

                            System.exit(0);
                        }

                        // Remover o cabeçalho dos valores 
                        records.remove(headers);
                    }

                    // Realizar a leitura dos valores e popular uma listagem dos mesmos
                    for (int i = 0; i < records.size(); i++) {
                        CSVRecord record = records.get(i);
                        List<String> values = record.toList();

                        if (values.size() == Receita.HEADERS.length) {
                            Receita receita = new Receita();
                            receita.setAgencia(values.get(0));
                            receita.setConta(values.get(1).replaceAll("-", ""));
                            receita.setSaldo(NumberUtilities.formatToDouble(values.get(2)));
                            receita.setStatus(values.get(3));

                            receitas.add(receita);
                        }
                    }
                }

                // Iterar a listagem e atualizar as contas, com os valores que vieram da planilha
                for (Receita receita : receitas) {
                    boolean result = ReceitaService.getInstance().updateAccount( receita.getAgencia(), receita.getConta(), receita.getSaldo(), receita.getStatus() );

                    // Popular o resultado caso houve sucesso em atualizar ou havia algum valor inválido
                    receita.setResult(result);
                }

                // Criar arquivo CSV com os valores atualizados e o resultado
                CSVUtilities.createCSVFile(receitas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
