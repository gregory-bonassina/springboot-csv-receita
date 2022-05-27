package com.dbserver.sincronizacaoreceita.util;

import java.io.File;

/**
 * @authro Gregory Bonassina
 */
public class FileUtilities {

    /**
     * getFileFromPath
     * 
     * @param path
     * @return File
     */
    public static File getFileFromPath(String path) {
        if (isFile(path)) {
            File file = new File(path);

            // Verificar se o arquivo existe
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    /**
     * isFile
     * 
     * @param path
     * @return boolean
     */
    public static boolean isFile(String path) {
        // Verificar se realmente é um arquivo o caminho passado
        return new File(path).isFile();
    }
}
