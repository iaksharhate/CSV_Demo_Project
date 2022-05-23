package com.bridgelabz;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {

    public static String FILE_PATH_DEMO = "C:\\Users\\iaksh\\IdeaProjects\\CSV Demo\\src\\main\\resources\\Demo.csv";

    public static void main(String[] args) {

        try {
            Writer writer = Files.newBufferedWriter(Paths.get(FILE_PATH_DEMO));
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<CSVUser> csvUserList = new ArrayList<>();

            csvUserList.add(new CSVUser("Akshar Pichai","sundar.pichai@gmail.com","+91-9988776655","INDIA"));
            csvUserList.add(new CSVUser("Jeff Bezos","jeff.bezos@amazon.com","+1-9999988888","USA"));

            beanToCsv.write(csvUserList);
            writer.close();

        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }
}
