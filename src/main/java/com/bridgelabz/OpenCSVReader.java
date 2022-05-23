package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.bridgelabz.CreateCSVFile.FILE_PATH;

public class OpenCSVReader {
    public static void main(String[] args) throws IOException {

        try (
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
        ){
            String [] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null){
                System.out.println("Name: "+ nextRecord[0]);
                System.out.println("Email: "+ nextRecord[1]);
                System.out.println("Phone: "+ nextRecord[2]);
                System.out.println("County: "+ nextRecord[3]);
                System.out.println("**********************************************");
            }
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
