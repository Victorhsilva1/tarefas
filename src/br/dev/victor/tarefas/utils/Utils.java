package br.dev.victor.tarefas.utils;

import java.util.UUID;

public class Utils {

	
	public static String gerarUUID() {
		//UUID é um numero de identificação 
		UUID uuid = UUID.randomUUID();
				//transformando o uuid em string
		String uuidStr = uuid.toString().substring(0, 8);
		
		return uuidStr;
		
	}
	
}
