package br.dev.victor.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private FileWriter fw;
	private BufferedWriter bw;
	
	private FileReader fr;
	private BufferedReader br;
	
	private String pathFuncionarios = "C:\\Users\\25132598\\tarefa\\funcionarios.csv";
	
	public BufferedReader getBufferedReader() throws FileNotFoundException, IOException {
		
		//aqui nao se adiciona true por que é somente para leitura nao para gravação
		fr = new FileReader(pathFuncionarios);
		br = new BufferedReader(fr);
		return br;
		
	}
	
	public BufferedWriter getBufferedWriter()  throws FileNotFoundException, IOException {
		//true para adicionar coisas novas ao arquivo
			fw = new FileWriter(pathFuncionarios, true);
			bw = new BufferedWriter(fw);
			
			return bw;
	}
}
