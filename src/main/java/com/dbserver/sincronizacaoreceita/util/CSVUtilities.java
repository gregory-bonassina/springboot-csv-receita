package com.dbserver.sincronizacaoreceita.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dbserver.sincronizacaoreceita.model.Receita;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/**
 * @author Gregory Bonassina
 */
public class CSVUtilities {
    public static String TYPE       = "csv";
    public static String DELIMITER  = ";";

    /**
     * hasCSVFormat
     * 
     * @param path
     * @return boolean
     */
    public static boolean hasCSVFormat(String path) {
        // Verificar se a extensão do arquivo é CSV
        String fileExtension = FilenameUtils.getExtension(path);

        return TYPE.equalsIgnoreCase(fileExtension);
    }

    /**
     * getCSVRecords
     * 
     * @param is
     * @param delimiter
     * @return List<CSVRecord>
     * @throws IOException
     */
    public static List<CSVRecord> getCSVRecords(File file) throws IOException {
        // Ler o arquivo CSV e retornar os seus valores
        List<CSVRecord> csvRecords = new ArrayList<CSVRecord>();
        CSVParser csvParser = null;
        try {
            InputStream is = new FileInputStream(file);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(DELIMITER).setSkipHeaderRecord(true).build();
            csvParser = new CSVParser(fileReader, csvFormat);

            csvRecords = csvParser.getRecords();

            csvParser.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return csvRecords;
    }

    /**
     * createCSVFile
     * 
     * @param receitas
     * @param headers
     * @param outputFileName
     */
    public static void createCSVFile(final List<Receita> receitas) {
        ByteArrayInputStream byteArrayInputStream = writeDataToCsv(receitas);

        try {
            // Pegar o caminho onde está sendo executado
            Path cwd = Path.of("").toAbsolutePath();

            // remove caracteres especiais e espaços caso houver
            String decodedPath = URLDecoder.decode(cwd.toString(), "UTF-8");

            // Concatenar caminho original com nome do arquivo de output + a hora atual para ser um arquivo único
            decodedPath += File.separator + "outputFile" + System.currentTimeMillis() + "." + TYPE;

            // Fazer a cópia do input stream para e criar o arquivo
            IOUtils.copy(byteArrayInputStream, new FileOutputStream(decodedPath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * writeDataToCsv
     * 
     * @param receitas
     * @param headers 
     * @return ByteArrayInputStream
     */
    private static ByteArrayInputStream writeDataToCsv(final List<Receita> receitas) {
        // Receber a lista de Receitas com o resultado e escrever no formato de csv.
        CSVFormat FORMAT = CSVFormat.DEFAULT.builder().setDelimiter(DELIMITER).setHeader(Receita.HEADERS_OUTPUT).build();

        try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
                final CSVPrinter printer = new CSVPrinter(new PrintWriter(stream), FORMAT)) {
            for (final Receita receita : receitas) {
                final List<String> data = Arrays.asList(
                        receita.getAgencia(),
                        receita.getConta(),
                        String.valueOf(receita.getSaldo()),
                        receita.getStatus(),
                        receita.getResult());

                printer.printRecord(data);
            }

            printer.flush();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
        }
    }
}
