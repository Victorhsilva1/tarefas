package br.dev.victor.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.*;

import br.dev.victor.tarefas.dao.FuncionarioDAO;
import br.dev.victor.tarefas.dao.TarefaDAO;
import br.dev.victor.tarefas.model.Funcionario;
import br.dev.victor.tarefas.model.Status;
import br.dev.victor.tarefas.model.Tarefa;
import br.dev.victor.tarefas.utils.Utils;

public class FrameCadastroTarefas {

    private JLabel labelTitulo;
    private JLabel labelDescricao;
    private JLabel labelStatus;
    private JLabel labelResponsavel;
    private JTextField txtTitulo;
    private JTextField txtDescricao;
    private JComboBox<Status> boxStatus;
    private JComboBox<String> boxResponsavel;

    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    private JButton btnSalvar, btnSair;

    public FrameCadastroTarefas() {
        criarTela();
    }

    private void criarTela() {
        JDialog tela = new JDialog((JFrame) null, "Cadastro de Tarefas", true);
        tela.setLayout(null);
        tela.setSize(400, 350);
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        labelTitulo = new JLabel("Título:");
        labelTitulo.setBounds(20, 20, 100, 25);
        txtTitulo = new JTextField();
        txtTitulo.setBounds(20, 45, 200, 25);

        labelDescricao = new JLabel("Descrição:");
        labelDescricao.setBounds(20, 80, 100, 25);
        txtDescricao = new JTextField();
        txtDescricao.setBounds(20, 105, 300, 25);

        labelStatus = new JLabel("Status:");
        labelStatus.setBounds(20, 140, 100, 25);
        boxStatus = new JComboBox<>(Status.values());
        boxStatus.setBounds(20, 165, 200, 25);

        labelResponsavel = new JLabel("Responsável:");
        labelResponsavel.setBounds(20, 200, 100, 25);
        boxResponsavel = new JComboBox<>();
        boxResponsavel.setBounds(20, 225, 200, 25);
        carregarFuncionarios();

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(20, 270, 100, 30);

        btnSair = new JButton("Sair");
        btnSair.setBounds(140, 270, 100, 30);

        Container painel = tela.getContentPane();
        painel.add(labelTitulo);
        painel.add(txtTitulo);
        painel.add(labelDescricao);
        painel.add(txtDescricao);
        painel.add(labelStatus);
        painel.add(boxStatus);
        painel.add(labelResponsavel);
        painel.add(boxResponsavel);
        painel.add(btnSalvar);
        painel.add(btnSair);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Tarefa tarefa = new Tarefa();
                tarefa.setCodigo(Utils.gerarUUID());
                tarefa.setTitulo(txtTitulo.getText());
                tarefa.setDescricao(txtDescricao.getText());
                tarefa.setStatus((Status) boxStatus.getSelectedItem());
                tarefa.setResponsavel((String) boxResponsavel.getSelectedItem());

                new TarefaDAO(tarefa).gravar();

                JOptionPane.showMessageDialog(tela, "Tarefa gravada com sucesso!");
                limparFormulario();
            }
        });

        btnSair.addActionListener(e -> tela.dispose());

        tela.setVisible(true);
    }

    private void carregarFuncionarios() {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            List<Funcionario> funcionarios = dao.showEmployees();

            for (Funcionario f : funcionarios) {
                boxResponsavel.addItem(f.getNome());
                listaFuncionarios.add(f);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar funcionários: " + e.getMessage());
        }
    }

    private void limparFormulario() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        boxStatus.setSelectedIndex(0);
        boxResponsavel.setSelectedIndex(0);
    }
}