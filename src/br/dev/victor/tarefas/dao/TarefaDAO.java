package br.dev.victor.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.victor.tarefas.factory.FileFactory;
import br.dev.victor.tarefas.model.Tarefa;
import br.dev.victor.tarefas.model.Funcionario; 



public class TarefaDAO {

	private Tarefa tarefa;
	private FileFactory ff = new FileFactory();

	// Método construtor
	public TarefaDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void gravar() {

		try {

			
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\Garibas\\Documents\\SENAI\\Celso\\Tarefas.txt", true);

			bw.write(tarefa.toString());
			bw.flush();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public List<Tarefa> showTarefas() {

		List<Tarefa> tarefas = new ArrayList<>();

		try {

			
			BufferedReader br = ff.getBufferedReader("C:\\Users\\Garibas\\Documents\\SENAI\\Celso\\Tarefa.txt");

			String linha = br.readLine();

			do {
				linha = br.readLine();

				Tarefa t = new Tarefa();
				String[] tarefa = linha != null ? linha.split(",") : null;

				if (tarefa != null) {
					t.setCodigo(tarefa[0]);
					t.setTitulo(tarefa[1]);
					t.setResponsavel(tarefa[7]);				

					tarefas.add(t);
				}

			} while (linha != null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return tarefas;
	}
	
}