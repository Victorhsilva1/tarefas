package br.dev.victor.tarefas.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FrameTarefa {

    private JFrame tela;
    private JTable tabelaTarefas;
    private DefaultTableModel modeloTabela;
    
    
    
    //Arquivo no SENAI C:\\Users\\25132598\\Tarefas\\Tarefas.txt
    private final String caminhoArquivo = "C:\\Users\\Garibas\\Documents\\SENAI\\Celso\\Tarefas.txt";

    public FrameTarefa() {
        criarTela();
        carregarTarefas();
    }

    private void criarTela() {
        tela = new JFrame("Tarefas do Usuário");
        tela.setSize(600, 400);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        JLabel titulo = new JLabel("Tarefas do Usuário");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setBounds(20, 10, 300, 30);

        String[] colunas = { "Código", "Atividade", "Responsável" };
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaTarefas = new JTable(modeloTabela);

        JScrollPane scroll = new JScrollPane(tabelaTarefas);
        scroll.setBounds(20, 50, 540, 220);

        JButton btnCadastrar = new JButton("Nova Tarefa");
        btnCadastrar.setBounds(20, 290, 120, 40);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(440, 290, 120, 40);

        btnCadastrar.addActionListener(e -> new FrameCadastroTarefas());
        btnSair.addActionListener(e -> tela.dispose());

        tela.add(titulo);
        tela.add(scroll);
        tela.add(btnCadastrar);
        tela.add(btnSair);

        tela.setVisible(true);
    }

    private void carregarTarefas() {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine(); 

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 3) {
                    modeloTabela.addRow(new Object[] {
                        dados[0], dados[1], dados[2]
                    });
                }
            }
        } catch (IOException e) {
            
        }
    }
}
