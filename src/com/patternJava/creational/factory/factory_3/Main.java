package com.patternJava.creational.factory.factory_3;

public class Main {
    public static void main(String[] args) {
        // if method createFile not static
        // - - create instance of FileWriterFactory
        // - - then from this instance invoke method createFile
        FileWriterFactory fileWriterFactory = new FileWriterFactory();
        FileWriter fileWriter = fileWriterFactory.createFile("pdfFile");
        fileWriter.createFile();

        System.out.println("--------------------");
        System.out.println("---if static method in Factory---");
        //if method createFile static
        FileWriter fileWriter2 = FileWriterFactory.createFile("wordFile");
        fileWriter2.createFile();

        System.out.println("--------------------");
        //if method createFile static
        FileWriter fileWriter3 = FileWriterFactory.createFile("txt");
        fileWriter3.createFile();
    }
}

interface FileWriter {
    void createFile();
}

class PDFWriter implements FileWriter {
    @Override
    public void createFile() {
        System.out.println("output PDF file");
    }
}
class WordWriter implements FileWriter {
    @Override
    public void createFile() {
        System.out.println("output Word file");
    }
}
class FileWriterFactory {

//    public FileWriter createFile(String fileType) {
    public static FileWriter createFile(String fileType) {
        String WORD_FILE = "wordFile";
        String PDF_FILE = "pdfFile";
        if (WORD_FILE.equalsIgnoreCase(fileType)) {
            return new WordWriter();
        } else if (PDF_FILE.equalsIgnoreCase(fileType)) {
            return new PDFWriter();
        } else {
            throw new RuntimeException("no such file type ");
        }

    }
}