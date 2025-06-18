package br.dev.victor.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.victor.tarefas.model.Funcionario;

public class FuncionarioDAO {

    private Funcionario funcionario;
    private final String caminhoArquivo = "C:\\Users\\Garibas\\Documents\\SENAI\\Celso\\Funcionarios.txt";

    public FuncionarioDAO(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioDAO() {
        // Construtor vazio para leitura
    }

    public void gravar() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            bw.write(funcionario.toString());
            bw.newLine(); // Adiciona quebra de linha entre os registros
        } catch (IOException e) {
            System.out.println("Erro ao gravar funcionário: " + e.getMessage());
        }
    }

    public List<Funcionario> showEmployees() {
        List<Funcionario> funcionarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 4) {
                    Funcionario f = new Funcionario();
                    f.setCodigo(dados[0]);
                    f.setNome(dados[1]);
                    f.setTelefone(dados[2]);
                    f.setEmail(dados[3]);
                    funcionarios.add(f);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler funcionários: " + e.getMessage());
        }

        return funcionarios;
    }
}