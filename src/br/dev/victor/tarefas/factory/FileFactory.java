package br.dev.victor.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

    // Retorna um BufferedReader para leitura
    public BufferedReader getBufferedReader(String path) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        return br;
    }

    // Retorna um BufferedWriter para gravação
    public BufferedWriter getBufferedWriter(String path, boolean append) throws FileNotFoundException, IOException {
        FileWriter fw = new FileWriter(path, append); // true = adiciona ao fim
        BufferedWriter bw = new BufferedWriter(fw);
        return bw;
    }
}