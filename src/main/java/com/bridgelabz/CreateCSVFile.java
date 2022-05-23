package com.bridgelabz;

import java.io.File;
import java.io.IOException;

public class CreateCSVFile {
    public static void main(String[] args) throws IOException {

        createFile();

    }

    public static void createFile() throws IOException {
        final String FILE_PATH = "C:\\Users\\iaksh\\IdeaProjects\\CSV Demo\\src\\main\\resources\\users.csv";

        File file = new File(FILE_PATH);

        if (file.createNewFile()){
            System.out.println("File created "+ file.getName());
        }else {
            System.out.println("File exist "+ file.getName());
        }
    }
}
