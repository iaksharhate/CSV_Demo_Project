package com.bridgelabz;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {

    public static String FILE_PATH = "C:\\Users\\iaksh\\IdeaProjects\\CSV Demo\\src\\main\\resources\\users.csv";

    public static void main(String[] args) {

        try {
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));

            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while (csvUserIterator.hasNext()){
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name: " + csvUser.getName());
                System.out.println("Email: " + csvUser.getEmail());
                System.out.println("PhoneNo: " + csvUser.getPhoneNo());
                System.out.println("Country: " + csvUser.getCountry());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
