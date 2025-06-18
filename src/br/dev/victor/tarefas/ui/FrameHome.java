package br.dev.victor.tarefas.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameHome {

	private JLabel labelTitulo;
	private JButton btnFuncionario;
	private JButton btnTarefas;
	private JButton btnSair;
	
public void criarHome() {
	 	JFrame tela = new JFrame("Cadastro de Funcionarios");
		tela.setLayout(null);
		tela.setSize(400, 300);
		tela.setResizable(false);
		tela.setFont(new Font("Arial", Font.BOLD, 16));
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setLocationRelativeTo(tela);
		
		JLabel lblTitulo = new JLabel();
		lblTitulo.setText("Escolha uma opção:");
		lblTitulo.setBounds(135, 0, 200, 40);
		
		JButton btnTarefas = new JButton();
		btnTarefas.setText("Tarefas");
		btnTarefas.setBounds(90, 60, 220, 50);
		
		JButton btnFuncionario = new JButton();
		btnFuncionario.setText("Funcionarios");
		btnFuncionario.setBounds(90, 130, 220, 50);
		
		JButton btnSair = new JButton();
		btnSair.setText("Sair");
		btnSair.setBounds(260, 220, 90, 30);
		
		
		tela.add(lblTitulo);
		tela.add(btnTarefas);
		tela.add(btnFuncionario);
		tela.add(btnSair);
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa ();
				
			}
		});
			
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
			
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(
					tela,
					"Confirma a saída do sistema?",
					"Sair do sistema",
					JOptionPane.YES_NO_OPTION
				);
				if (resposta == 0) {
					tela.setVisible(false);
				}
			}
		});
		
		tela.setVisible(true);
	}
}