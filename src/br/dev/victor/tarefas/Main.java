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

public class Main {
	
	//determinando caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132598\\tarefa\\tarefas.txt";
	
	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<String>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		frutas.add("abacaxi");
		frutas.add("framboesa");
		frutas.add("laranja");
		
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(7);
		funcionario.setEmail("Marcos@gmail.com");
		funcionario.setMatricula("2519290");
		funcionario.setNome("Marcos");
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setCodigo(6);
		funcionario2.setEmail("Marcas@gmail.com");
		funcionario2.setMatricula("2519290");
		funcionario2.setNome("Marcas");
		
		funcionarios.addAll(List.of(funcionario,funcionario2));
		
		funcionarios.add(funcionario);
		funcionarios.add(funcionario2);
		
		System.out.println(frutas);
		System.out.println(funcionarios);
		
		for (Funcionario f: funcionarios) {
			System.out.print(f.getNome() + " - ");
			System.out.println(f.getEmail());
		}
		
//		Funcionario funcionario = new Funcionario();
//		funcionario.setCodigo(5);
//		funcionario.setEmail("Marcos@gmail.com");
//		funcionario.setMatricula("2519290");
//		funcionario.setNome("Marcos");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
//
//		System.out.println(funcionario.toString());
	}
	
	private static void gravarArquivo() {
		
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
