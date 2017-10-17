/*
 * Creation : 15 oct. 2017
 */
package com.hatofa.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ModifierFichierJson {

    public static void main(String[] args) throws Exception {

        PrintWriter fos = null; // canal d'écriture
        BufferedReader fis = null; // canal de lecture

        String nomFichierJson = "c:/user/E306440/Temp/json/test.json";
        String nomFichierJsonModifie = "c:/user/E306440/Temp/json/test_modifie.json";
        List<String> liste = new ArrayList<String>();

        try {
            fis = new BufferedReader(new FileReader(nomFichierJson));
            fos = new PrintWriter(new BufferedWriter(new FileWriter(nomFichierJsonModifie)));

            String ligne;

            // on supprime l'entete su message
            while ((ligne = fis.readLine()) != null) {
                if (!ligne.trim().startsWith("\"data")) {
                    continue;
                }
                liste.add("{");
                liste.add("\"data\": { ");
                fis.readLine();
                break;
            }

            // on parcourt les data
            while ((ligne = fis.readLine()) != null) {
                liste.add(ligne);
            }

            // on supprime un crochet inutile
            int leng = liste.size();
            liste.remove(leng - 2);

            for (String line : liste) {
                fos.println(line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null)
                fos.close();
            if (fis != null)
                fis.close();
        }

    }

}
