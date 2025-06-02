package br.dev.victor.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.victor.tarefas.factory.FileFactory;
import br.dev.victor.tarefas.model.Funcionario;

public class FuncionarioDAO {
	
	private Funcionario funcionario;
	private FileFactory ff = new FileFactory();

	//Método construtor
	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		
		FileFactory ff = new FileFactory();
		
		
		try {
			//retorna o bufferedWrited com o caminho
			BufferedWriter bw = ff.getBufferedWriter();
			
			
			//Escrever o funcionario e criando um objeto e serializando como string para escrever no arquivo
			bw.write(funcionario.toString());
			//Descarga para o arquivo
			bw.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//mostrar a lista de funcionarios
	public List<Funcionario> showEmployees() {
		
		//declarei a lista que se chama funcionarios
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			// está com nosso arquivo em memoria, colocando o ponteiro na primeira
			BufferedReader br = ff.getBufferedReader();
			//vai ler a linha e posicionar a proxima
			String linha = br.readLine();
			
			do {
				linha = br.readLine();
				Funcionario f = new Funcionario();
				//split para cortar, vetor abrindo com []
				String[] funcionario = linha != null ? linha.split(","): null;
				// criando o objeto funcionario, sabendo que a , é o separador, e colocando cada informação
				// em seu campo certo, 0,1,2,3
				f.setCodigo(funcionario[0]);
				f.setNome(funcionario[1]);
				f.setTelefone(funcionario[2]);
				f.setEmail(funcionario[3]);
				
				//criando funcionario, na lista funcionarios
				funcionarios.add(f);
				
				
			} while (linha != null );
			
			
			System.out.println(funcionario);
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return funcionarios;
	}
	
	
	
}
