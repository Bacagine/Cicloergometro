/* ViewAdmin.java: Tela para cadastrar endereços
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 16/06/2022
 */

/*  voltar new ViewCastroMedico(medico, endereco) */

package org.java.cicloergometro.view;

import org.java.cicloergometro.model.bean.Consulta;
import org.java.cicloergometro.model.bean.Endereco;
import org.java.cicloergometro.model.bean.Medico;
import org.java.cicloergometro.model.bean.Paciente;
import org.java.cicloergometro.model.dao.ConsultaDAO;
import org.java.cicloergometro.model.dao.EnderecoDAO;
import org.java.cicloergometro.model.dao.MedicoDAO;
import org.java.cicloergometro.model.dao.PacienteDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

public class ViewCadastroEndereco{
    private JFrame frame;
    private JPanel panel;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCEP;
	private JLabel lblNumero;
	private JLabel lblCidade;
	private JLabel lblUF;
//	private JLabel lblLogradouro;
	private JLabel lblComplemento;
    private JTextField txtRua;
	private JTextField txtBairro;
	private JFormattedTextField txtCEP;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JComboBox<String> boxUF;
//	private JTextField txtLogradouro;
	private JTextField txtComplemento;
    private JButton btnCadastrar;
//    private JButton btnCancelar;
    private JButton btnVoltar;
    private EnderecoDAO enderecoDAO;
    private static final String titulo = "Cadastro Endereco";
    private static final int altura = 760;
    private static final int largura = 760;
    private static final String estados[] = { "-- selecione --", "AC",
                                              "AL", "AP", "AM",
                                              "BA", "CE", "DF",
                                              "ES", "GO", "MA",
                                              "MT", "MS", "MG",
                                              "PA", "PB", "PR",
                                              "PE", "PI", "RJ",
                                              "RN", "RS", "RO",
                                              "RR", "SC", "SP",
                                              "SE", "TO" };

    public ViewCadastroEndereco(){

        printForm();
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        if(!enderecoDAO.insertEndereco(endereco)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ViewCadastroEndereco(Medico medico){
        frame = new JFrame(titulo);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        printForm();
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        medico.setEndereco(endereco);
                        MedicoDAO medicoDAO = new MedicoDAO();
                        if(!medicoDAO.insertMedico(medico)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Medico Cadastrado");
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        voltarCadastroMedico(medico);

        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ViewCadastroEndereco(Medico medico, Endereco endereco){
        frame = new JFrame(titulo);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        printForm();
        this.txtRua.setText(endereco.getLogradouro());
        this.txtNumero.setText(String.valueOf(endereco.getNumero()));
        this.txtComplemento.setText(endereco.getComplemento());
        this.txtBairro.setText(endereco.getBairro());
        this.txtCidade.setText(endereco.getCidade());
        this.boxUF.setSelectedItem(endereco.getUF());
        this.txtCEP.setText(endereco.getCEP());

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        medico.setEndereco(endereco);
                        MedicoDAO medicoDAO = new MedicoDAO();
                        if(!medicoDAO.insertMedico(medico)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Medico Cadastrado");
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        voltarCadastroMedico(medico);

        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ViewCadastroEndereco(Paciente paciente){
        frame = new JFrame(titulo);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        printForm();
        
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        paciente.setEndereco(endereco);
                        PacienteDAO pacienteDAO = new PacienteDAO();
                        if(!pacienteDAO.insertPaciente(paciente)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public ViewCadastroEndereco(Consulta consulta){
        initWindow();

        printForm();

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        consulta.setEndereco(endereco);
                        ConsultaDAO consultaDAO = new ConsultaDAO();
                        if(!consultaDAO.insertConsulta(consulta)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Medico Cadastrado");
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        voltarCadastroConsulta(consulta);

        finalWindow();
    }

    public ViewCadastroEndereco(Consulta consulta, Endereco endereco){
        initWindow();

        printForm();
        this.txtRua.setText(endereco.getLogradouro());
        this.txtNumero.setText(String.valueOf(endereco.getNumero()));
        this.txtComplemento.setText(endereco.getComplemento());
        this.txtBairro.setText(endereco.getBairro());
        this.txtCidade.setText(endereco.getCidade());
        this.boxUF.setSelectedItem(endereco.getUF());
        this.txtCEP.setText(endereco.getCEP());

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(640, 690, 110, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    if(txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() ||
                       txtCEP.getText().isEmpty() || txtNumero.getText().isEmpty() ||
                       txtCidade.getText().isEmpty() || String.valueOf(boxUF.getSelectedIndex()).equals(estados[0])){
                        JOptionPane.showMessageDialog(null, "Erro: Preencha os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                         txtCEP.getText(), Integer.parseInt(txtNumero.getText()),
                                                         txtCidade.getText(), String.valueOf(boxUF.getSelectedItem()),
                                                         txtComplemento.getText());
                        consulta.setEndereco(endereco);
                        ConsultaDAO consultaDAO = new ConsultaDAO();
                        if(!consultaDAO.insertConsulta(consulta)){
                            JOptionPane.showMessageDialog(null, "Erro: Não foi possivel realizar o cadastro", "ERRO!", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Medico Cadastrado");
                        }
                    }
                }
            }
        });
        panel.add(btnCadastrar);

        voltarCadastroConsulta(consulta);

        finalWindow();
    }    

    private void initWindow(){
        frame = new JFrame(titulo);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
    }

    private void finalWindow(){
        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void printForm(){
        lblRua = new JLabel("Rua: *");
        lblRua.setBounds(10, 20, 165, 25);
        panel.add(lblRua);

        txtRua = new JTextField();
        txtRua.setBounds(80, 20, 165, 25);
        panel.add(txtRua);

        lblNumero = new JLabel("Nº: *");
        lblNumero.setBounds(265, 20, 165, 25);
        panel.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(310, 20, 85, 25);
        panel.add(txtNumero);

        lblComplemento = new JLabel("Complemento: ");
        lblComplemento.setBounds(400, 20, 165, 25);
        panel.add(lblComplemento);

        txtComplemento = new JTextField();
        txtComplemento.setBounds(510, 20, 165, 25);
        panel.add(txtComplemento);

        lblBairro = new JLabel("Bairro: *");
        lblBairro.setBounds(10, 50, 165, 25);
        panel.add(lblBairro);

        txtBairro = new JTextField();
        txtBairro.setBounds(80, 50, 165, 25);
        panel.add(txtBairro);

        lblCidade = new JLabel("Cidade: *");
        lblCidade.setBounds(265, 50, 165, 25);
        panel.add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(340, 50, 80, 25);
        panel.add(txtCidade);
        
        lblUF = new JLabel("UF: *");
        lblUF.setBounds(10, 80, 165, 25);
        panel.add(lblUF);

        boxUF = new JComboBox<String>(estados);
        boxUF.setBounds(80, 80, 165, 25);
        panel.add(boxUF);

        lblCEP = new JLabel("CEP: *");
        lblCEP.setBounds(265, 80, 165, 25);
        panel.add(lblCEP);

        txtCEP = new JFormattedTextField();
        try {
            MaskFormatter cepMask = new MaskFormatter("#####-###");
            cepMask.install(txtCEP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtCEP.setBounds(320, 80, 80, 25);
        panel.add(txtCEP);
    }

    /* Botão para voltar para a tela ViewCadastroMedico
     * Esta função é usada para não perder os dados de endereço
     * já digitados no formulario */
    private void voltarCadastroMedico(Medico medico){
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 690, 110, 25);
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnVoltar){
                    String UF = String.valueOf(boxUF.getSelectedItem());
                    int numero = Integer.parseInt(txtNumero.getText());
                    Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                     txtCEP.getText(), numero, txtCidade.getText(),
                                                     UF, txtComplemento.getText());
                    frame.dispose();
                    new ViewCadastroMedico(medico, endereco);
                }
            }
        });
        panel.add(btnVoltar);
    }

    private void voltarCadastroConsulta(Consulta consulta){
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 690, 110, 25);
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnVoltar){
                    String UF = String.valueOf(boxUF.getSelectedItem());
                    int numero = Integer.parseInt(txtNumero.getText());
                    Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(),
                                                     txtCEP.getText(), numero, txtCidade.getText(),
                                                     UF, txtComplemento.getText());
                    frame.dispose();
                    new ViewCadastroConsulta(consulta, endereco);
                }
            }
        });
        panel.add(btnVoltar);
    }
/*
    private void printForm(Endereco endereco){
        lblRua = new JLabel("Rua: *");
        lblRua.setBounds(10, 20, 165, 25);
        panel.add(lblRua);

        txtRua = new JTextField();
        txtRua.setBounds(80, 20, 165, 25);
        panel.add(txtRua);

        lblNumero = new JLabel("Nº: *");
        lblNumero.setBounds(265, 20, 165, 25);
        panel.add(lblNumero);

        txtNumero = new JTextField();
        txtNumero.setBounds(310, 20, 85, 25);
        panel.add(txtNumero);

        lblComplemento = new JLabel("Complemento: ");
        lblComplemento.setBounds(400, 20, 165, 25);
        panel.add(lblComplemento);

        txtComplemento = new JTextField();
        txtComplemento.setBounds(510, 20, 165, 25);
        panel.add(txtComplemento);

        lblBairro = new JLabel("Bairro: *");
        lblBairro.setBounds(10, 50, 165, 25);
        panel.add(lblBairro);

        txtBairro = new JTextField();
        txtBairro.setBounds(80, 50, 165, 25);
        panel.add(txtBairro);

        lblCidade = new JLabel("Cidade: *");
        lblCidade.setBounds(265, 50, 165, 25);
        panel.add(lblCidade);

        txtCidade = new JTextField();
        txtCidade.setBounds(340, 50, 80, 25);
        panel.add(txtCidade);
        
        lblUF = new JLabel("UF: *");
        lblUF.setBounds(10, 80, 165, 25);
        panel.add(lblUF);

        boxUF = new JComboBox<String>(estados);
        boxUF.setBounds(80, 80, 165, 25);
        panel.add(boxUF);

        lblCEP = new JLabel("CEP: *");
        lblCEP.setBounds(265, 80, 165, 25);
        panel.add(lblCEP);

        txtCEP = new JFormattedTextField();
        try {
            MaskFormatter cepMask = new MaskFormatter("#####-###");
            cepMask.install(txtCEP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtCEP.setBounds(320, 80, 80, 25);
        panel.add(txtCEP);
    }
    */
}
