package br.dev.victor.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.victor.tarefas.dao.FuncionarioDAO;
import br.dev.victor.tarefas.model.Funcionario;
import br.dev.victor.tarefas.model.Tarefa;
import br.dev.victor.tarefas.ui.FrameFuncionario;
import br.dev.victor.tarefas.ui.FrameListaFuncionario;
import br.dev.victor.tarefas.ui.*;
import br.dev.victor.tarefas.utils.Utils;


public class Main {
	
	//determinando caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132598\\tarefa\\tarefas.txt";
	
	public static void main(String[] args) {
	
		FrameHome tela = new FrameHome();
		tela.criarHome();
		
	}
	
	private static void gravarArquivo(){
		 
		FileWriter arquivo = null;
		BufferedWriter escritor = null;
		
		try {
			
			arquivo = new FileWriter(path, true);
			escritor = new BufferedWriter(arquivo);
			
			escritor.write("Ultima linha por enquanto\n");
			escritor.flush();
			
		} catch (Exception erro) {
			System.out.println(erro);
		}
		
	}

	private static void lerArquivo() {
		

		//abrir arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String linha = buffer.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado!");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo!");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico!");
			System.out.println(erro.getMessage());
		}
		
		
		
	}

}
