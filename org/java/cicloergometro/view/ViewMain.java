/* ViewLogin.java: Tela de login do sistema
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data: 14/06/2022
 * Data da última modificação: 16/06/2022
 */

package org.java.cicloergometro.view;

//import org.java.cicloergometro.model.dao.LoginDAO; // Usado para verificar o login
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.java.cicloergometro.model.dao.LoginDAO;

import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ViewMain{
    private JFrame frame;
    private JPanel panel;
    private JLabel lblUsuario, lblSenha;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnLogar;
//    private JButton btnCadastrar;
    private JButton btnSair;
    private JRadioButton optMedico;
    private JRadioButton optEnfermeiro;
    private JRadioButton optFisioterapeuta;
    private JRadioButton optPaciente;
    private JRadioButton optRecepcionista;
    private ButtonGroup grupo; // Leia o comentario da linha 91
    //private LoginDAO loginDAO = new LoginDAO();
    private static final int altura = 500;
    private static final int largura = 550;
    private static final String titulo = "Login";
/*    private static final String tiposUsuario[] = { "Medico", "Enfermeiro", "Fisioterapeuta", 
                                                   "Recepcionista", "Paciente" };
*/
    /* Construtor */
    public ViewMain(){
        frame = new JFrame();
        
        frame.setTitle(titulo);
        
        panel = new JPanel();
        frame.add(panel);
        
        panel.setLayout(null);

        lblUsuario = new JLabel("Login: ");
        lblUsuario.setBounds(130, 150, 80, 25);
        this.panel.add(lblUsuario);

        txtUsuario = new JTextField(15);
        txtUsuario.setBounds(200, 150, 165, 25);
        this.panel.add(txtUsuario);

        lblSenha = new JLabel("Senha: ");
        lblSenha.setBounds(130, 180, 80, 25);
        this.panel.add(lblSenha);

        txtSenha = new JPasswordField(15);
        txtSenha.setBounds(200, 180, 165, 25);
        this.panel.add(txtSenha);

        optMedico = new JRadioButton("Medico", false);
        optMedico.setBounds(100, 210, 100, 25);
        this.panel.add(optMedico);
        
        optEnfermeiro = new JRadioButton("Enfermeiro", false);
        optEnfermeiro.setBounds(210, 210, 110, 25);
        this.panel.add(optEnfermeiro);
        
        optFisioterapeuta = new JRadioButton("Fisioterapeuta", false);
        optFisioterapeuta.setBounds(340, 210, 140, 25);
        this.panel.add(optFisioterapeuta);
        
        optMedico = new JRadioButton("Recepcionista", false);
        optMedico.setBounds(150, 230, 140, 25);
        this.panel.add(optMedico);
        
        optPaciente = new JRadioButton("Paciente", false);
        optPaciente.setBounds(290, 230, 140, 25);
        this.panel.add(optPaciente);

        /* Faz com que o usuário
         * possa selecionar apenas
         * uma opção */
        grupo = new ButtonGroup();
        grupo.add(optMedico);
        grupo.add(optEnfermeiro);
        grupo.add(optFisioterapeuta);
//        grupo.add(optMedico);
        grupo.add(optPaciente);
        
        btnLogar = new JButton("Logar");
        btnLogar.setBounds(135, 260, 80, 25);
        btnLogar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /* Verifica se o botão logar foi pressionado */
                if(e.getSource() == btnLogar){
                    if(!optMedico.isSelected() && !optEnfermeiro.isSelected() &&
                       !optFisioterapeuta.isSelected() && !optMedico.isSelected() &&
                       !optPaciente.isSelected()){
                        JOptionPane.showMessageDialog(null, "Erro: Selecione o tipo de login", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    /* Verifica se o usuario e senha são validos */
//                    else if(optMedico.isSelected() && loginDAO.verificaLogin(tiposUsuario[0], txtUsuario.getText(), String.valueOf(txtSenha.getPassword()))){
                    else if(optMedico.isSelected() && String.valueOf(txtSenha.getPassword()).equals("123")){
                        frame.dispose();
                        new ViewMedico();
                    }
//                    else if(optEnfermeiro.isSelected() && loginDAO.verificaLogin(tiposUsuario[1], txtUsuario.getText(), String.valueOf(txtSenha.getPassword()))){
                    else if(optEnfermeiro.isSelected() && String.valueOf(txtSenha.getPassword()).equals("123")){
                        frame.dispose();
                        new ViewEnfermeiro();
                    }
//                    else if(optFisioterapeuta.isSelected() && loginDAO.verificaLogin(tiposUsuario[2], txtUsuario.getText(), String.valueOf(txtSenha.getPassword()))){
                    else if(optFisioterapeuta.isSelected() && String.valueOf(txtSenha.getPassword()).equals("123")){
                        frame.dispose();
                        new ViewFisioterapeuta();
                    }
//                    else if(optMedico.isSelected() && loginDAO.verificaLogin(tiposUsuario[3], txtUsuario.getText(), String.valueOf(txtSenha.getPassword()))){
                    else if(optRecepcionista.isSelected() && String.valueOf(txtSenha.getPassword()).equals("123")){
                        frame.dispose();
                        new ViewRecepcao();
                    }
//                    else if(optPaciente.isSelected() && loginDAO.verificaLogin(tiposUsuario[4], txtUsuario.getText(), String.valueOf(txtSenha.getPassword()))){
                    else if(optPaciente.isSelected() && String.valueOf(txtSenha.getPassword()).equals("123")){
                        frame.dispose();
                        new ViewPaciente();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Erro: Usuario ou senha invalida!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        this.panel.add(btnLogar);
        /*
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(220, 260, 105, 25);
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnCadastrar){
                    frame.dispose();
                    new ViewCadastrar();
                }
            }
        });
        this.panel.add(btnCadastrar);
        */
        btnSair = new JButton("Cancelar");
        btnSair.setBounds(330, 260, 100, 25);
        btnSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                /* Se o botão cancelar foi pressionado
                 * o programa fecha */
                if(e.getSource() == btnSair){
                    System.exit(0);
                }
            }
        });
        this.panel.add(btnSair);

        frame.setSize(largura, altura);
        frame.setResizable(false); // Impede que o usuário altere as dimensões da janela
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Deixa a janela centralizada na tela

        frame.setVisible(true);
    }
}
