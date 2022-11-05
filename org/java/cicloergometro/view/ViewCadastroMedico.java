/* ViewAdmin.java: Tela para cadastrar medicos
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 16/06/2022
 */


package org.java.cicloergometro.view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;

import org.java.cicloergometro.model.bean.Endereco;
import org.java.cicloergometro.model.bean.Medico;
import org.java.cicloergometro.model.bean.Pessoa;

public class ViewCadastroMedico{
    private JFrame frame;
    private JPanel panel;
    private JButton btnVoltar;
    private JButton btnProximo;
    private JLabel lblNome;
	private JLabel lblRG;
	private JLabel lblCPF;
	private JLabel lblSexo;
	private JLabel lblTelefone;
//	private JLabel lblEndereco;
	private JLabel lblDataNascimento;
    private JLabel lblLogin;
    private JLabel lblPassword;
	private JLabel lblCRM;
	private JLabel lblEspecialidade;
    private JTextField txtNome;
	private JFormattedTextField txtRG;
	private JFormattedTextField txtCPF;
    private JRadioButton optM;
    private JRadioButton optF;
	private JFormattedTextField txtTelefone;
	private JFormattedTextField txtDataNascimento;
    private JTextField txtLogin;
    private JPasswordField txtPassword;
    private JTextField txtCRM;
    private JComboBox<String> boxEspecialidade;
    private ButtonGroup grupo;
    private static final String titulo = "Cadastro Medico";
    private static final int altura = 760;
    private static final int largura = 760;
    private static final String especialidades[] = { "-- selecione --", "Imunologista",
                                                     "Anestesista", "Cardiologista", "Psicologo",
                                                     "Psiquiatra", "Dermatologista", "Endocrinologista",
                                                     "Gastronomista", "Infectologista", "Neurologista",
                                                     "Pediatra", "Toxicologista", "Reumatologista" };
    
    public ViewCadastroMedico(){
        initWindow();

        printForm();
        proximo();
        voltar();

        finalWindow();
    }

    public ViewCadastroMedico(Medico medico, Endereco endereco){
        initWindow();

        printForm(medico);
        proximo(endereco);
        voltar();

        finalWindow();
    }

    /* Inicialização da janela */
    private void initWindow(){
        frame = new JFrame();

        frame.setTitle(titulo);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);
    }

    /* Finalização da janela */
    private void finalWindow(){
        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Deixa a janela centralizada na tela
        frame.setVisible(true);
    }

    /* Mostra o formulario de
     * cadastro na tela */
    private void printForm(){
        lblNome = new JLabel("Nome:* ");
        lblNome.setBounds(10, 20, 80, 25);
        panel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(90, 20, 165, 25);
        panel.add(txtNome);

        lblLogin = new JLabel("Login:* ");
        lblLogin.setBounds(260, 20, 165, 25);
        panel.add(lblLogin);

        txtLogin = new JTextField();
        txtLogin.setBounds(320, 20, 165, 25);
        panel.add(txtLogin);

        lblPassword = new JLabel("Senha:* ");
        lblPassword.setBounds(505, 20, 165, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(570, 20, 165, 25);
        panel.add(txtPassword);

        lblRG = new JLabel("RG: ");
        lblRG.setBounds(10, 60, 80, 25);
        panel.add(lblRG);

        txtRG = new JFormattedTextField("");
        try {
            MaskFormatter rgMask = new MaskFormatter("##.###.###-#");
            rgMask.install(txtRG);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtRG.setBounds(90, 60, 165, 25);
        panel.add(txtRG);

        lblCPF = new JLabel("CPF:* ");
        lblCPF.setBounds(260, 60, 165, 25);
        panel.add(lblCPF);

        txtCPF = new JFormattedTextField();
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(txtCPF);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtCPF.setBounds(320, 60, 165, 25);
        panel.add(txtCPF);

        lblCRM = new JLabel("CRM:* ");
        lblCRM.setBounds(505, 60, 165, 25);
        panel.add(lblCRM);

        txtCRM = new JTextField();
        txtCRM.setBounds(570, 60, 165, 25);
        panel.add(txtCRM);
        
        lblTelefone = new JLabel("Telefone*: ");
        lblTelefone.setBounds(10, 90, 500, 25);
        panel.add(lblTelefone);

        txtTelefone = new JFormattedTextField();
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) ####-####");
            telefoneMask.install(txtTelefone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTelefone.setBounds(90, 90, 165, 25);
        panel.add(txtTelefone);

        lblSexo = new JLabel("Sexo:* ");
        lblSexo.setBounds(360, 90, 165, 25);
        panel.add(lblSexo);

        optM = new JRadioButton("M");
        optM.setBounds(420, 90, 40, 25);
        panel.add(optM);

        optF = new JRadioButton("F");
        optF.setBounds(480, 90, 40, 25);
        panel.add(optF);

        grupo = new ButtonGroup();
        grupo.add(optM);
        grupo.add(optF);

        lblEspecialidade = new JLabel("Especialidade:* ");
        lblEspecialidade.setBounds(10, 120, 165, 25);
        panel.add(lblEspecialidade);

        boxEspecialidade = new JComboBox<String>(especialidades);
        boxEspecialidade.setBounds(135, 120, 165, 25);
        panel.add(boxEspecialidade);

        lblDataNascimento = new JLabel("Data de nascimento*: ");
        lblDataNascimento.setBounds(320, 120, 165, 25);
        panel.add(lblDataNascimento);

        txtDataNascimento = new JFormattedTextField();
        try {
            MaskFormatter dataNascimentoMask = new MaskFormatter("##/##/####");
            dataNascimentoMask.install(txtDataNascimento);
        } catch (ParseException e){
            e.printStackTrace();
        }
        txtDataNascimento.setBounds(480, 120, 165, 25);
        panel.add(txtDataNascimento);
    }

    /* Printa o formulario quando o usuario
     * volta da tela de cadastro de endereços.
     * Neste metodo, os dados já inseridos
     * anteriormente permanecem */
    private void printForm(Medico medico){
        lblNome = new JLabel("Nome:* ");
        lblNome.setBounds(10, 20, 80, 25);
        panel.add(lblNome);

        txtNome = new JTextField(medico.getNome());
        txtNome.setBounds(90, 20, 165, 25);
        panel.add(txtNome);

        lblLogin = new JLabel("Login:* ");
        lblLogin.setBounds(260, 20, 165, 25);
        panel.add(lblLogin);

        txtLogin = new JTextField(medico.getLogin());
        txtLogin.setBounds(320, 20, 165, 25);
        panel.add(txtLogin);

        lblPassword = new JLabel("Senha:* ");
        lblPassword.setBounds(505, 20, 165, 25);
        panel.add(lblPassword);

        txtPassword = new JPasswordField(medico.getSenha());
        txtPassword.setBounds(570, 20, 165, 25);
        panel.add(txtPassword);

        lblRG = new JLabel("RG: ");
        lblRG.setBounds(10, 60, 80, 25);
        panel.add(lblRG);

        txtRG = new JFormattedTextField(medico.getRG());
        try {
            MaskFormatter rgMask = new MaskFormatter("##.###.###-#");
            rgMask.install(txtRG);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtRG.setBounds(90, 60, 165, 25);
        panel.add(txtRG);

        lblCPF = new JLabel("CPF:* ");
        lblCPF.setBounds(260, 60, 165, 25);
        panel.add(lblCPF);

        txtCPF = new JFormattedTextField(medico.getCPF());
        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.install(txtCPF);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtCPF.setBounds(320, 60, 165, 25);
        panel.add(txtCPF);

        lblCRM = new JLabel("CRM:* ");
        lblCRM.setBounds(505, 60, 165, 25);
        panel.add(lblCRM);

        txtCRM = new JTextField(medico.getCRM());
        txtCRM.setBounds(570, 60, 165, 25);
        panel.add(txtCRM);
        
        lblTelefone = new JLabel("Telefone*: ");
        lblTelefone.setBounds(10, 90, 500, 25);
        panel.add(lblTelefone);

        txtTelefone = new JFormattedTextField(medico.getTelefone());
        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) ####-####");
            telefoneMask.install(txtTelefone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        txtTelefone.setBounds(90, 90, 165, 25);
        panel.add(txtTelefone);

        lblSexo = new JLabel("Sexo:* ");
        lblSexo.setBounds(360, 90, 165, 25);
        panel.add(lblSexo);

        if(medico.getSexo() == 'M'){
            optM = new JRadioButton(String.valueOf(medico.getSexo()), true);
            optM.setBounds(420, 90, 40, 25);
            panel.add(optM);

            optF = new JRadioButton("F");
            optF.setBounds(480, 90, 40, 25);
            panel.add(optF);
        }
        else{
            optM = new JRadioButton("M");
            optM.setBounds(420, 90, 40, 25);
            panel.add(optM);

            optF = new JRadioButton(String.valueOf(medico.getSexo()), true);
            optF.setBounds(480, 90, 40, 25);
            panel.add(optF);
        }
        grupo = new ButtonGroup();
        grupo.add(optM);
        grupo.add(optF);

        lblEspecialidade = new JLabel("Especialidade:* ");
        lblEspecialidade.setBounds(10, 120, 165, 25);
        panel.add(lblEspecialidade);

        String especialidade = null;
        for(int count = 0; count < especialidades.length; count++){
            if(medico.getEspecialidade() == especialidades[count]){
                especialidade = especialidades[count];
            }
        }
        boxEspecialidade = new JComboBox<String>(especialidades);
        boxEspecialidade.setSelectedItem(especialidade);
        boxEspecialidade.setBounds(135, 120, 165, 25);
        panel.add(boxEspecialidade);

        lblDataNascimento = new JLabel("Data de nascimento*: ");
        lblDataNascimento.setBounds(320, 120, 165, 25);
        panel.add(lblDataNascimento);

        this.txtDataNascimento = new JFormattedTextField();
//        this.txtDataNascimento = new JFormattedTextField(String.valueOf(medico.getDataNascimento()));
        try {
            MaskFormatter dataNascimentoMask = new MaskFormatter("##/##/####");
//            MaskFormatter dataNascimentoMask = new MaskFormatter("####-##-##");
            dataNascimentoMask.install(this.txtDataNascimento);
        } catch (ParseException e){
            e.printStackTrace();
        }
        this.txtDataNascimento.setBounds(480, 120, 165, 25);
        this.txtDataNascimento.setText(medico.getDataNascimento().format(Pessoa.BRAZZILIAN_FORMATTER));
        panel.add(txtDataNascimento);
    }

    /* Primeiro botão próximo
     * a ser acionado */
    private void proximo(){
        btnProximo = new JButton("Proximo");
        btnProximo.setBounds(640, 690, 110, 25);
        btnProximo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnProximo){
                    if(txtLogin.getText().isEmpty() || txtPassword.getText().isEmpty() || txtNome.getText().isEmpty() ||
                       txtCPF.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtCRM.getText().isEmpty() || 
                       (!optM.isSelected() && !optF.isSelected()) || txtDataNascimento.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erro: cheque os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Medico medico = new Medico();
                        String dataNascimento = Pessoa.converteData(txtDataNascimento.getText());
                        char sexo = optM.isSelected() ? optM.getText().charAt(0) : optF.getText().charAt(0);
                        String especialidade = String.valueOf(boxEspecialidade.getSelectedItem());
/*                        medico = new Medico(txtLogin.getText(), String.valueOf(txtPassword.getPassword()),
                                                txtNome.getText(), txtRG.getText(), txtCPF.getText(), sexo,
                                                LocalDate.parse(dataNascimento), txtTelefone.getText(), txtCRM.getText(), especialidade);*/
                        frame.dispose();
                        new ViewCadastroEndereco(medico);
                    }
                }
            }
        });
        panel.add(btnProximo);
    }

    /* Botão próximo depois de voltar da tela
     * ViewCadastroEndereco.
     * Ele mantem salvo as informações do endereço
     * que o usuário já havia digitado; sendo assim,
     * quando este botão é apertado as informções do
     * cadastro de endereço permanecem */
    private void proximo(Endereco endereco){
        btnProximo = new JButton("Proximo");
        btnProximo.setBounds(640, 690, 110, 25);
        btnProximo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnProximo){
                    if(txtLogin.getText().isEmpty() || txtPassword.getText().isEmpty() || txtNome.getText().isEmpty() ||
                       txtCPF.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtCRM.getText().isEmpty() || 
                       (!optM.isSelected() && !optF.isSelected()) || txtDataNascimento.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erro: cheque os campos obrigatorios!", "ERRO!", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Medico medico = new Medico();
                        String dataNascimento = Pessoa.converteData(txtDataNascimento.getText());
                        char sexo = optM.isSelected() ? optM.getText().charAt(0) : optF.getText().charAt(0);
                        String especialidade = String.valueOf(boxEspecialidade.getSelectedItem());
/*                        medico = new Medico(txtLogin.getText(), String.valueOf(txtPassword.getPassword()),
                                            txtNome.getText(), txtRG.getText(), txtCPF.getText(), sexo,
                                            LocalDate.parse(dataNascimento), txtTelefone.getText(), txtCRM.getText(), especialidade);*/
                        frame.dispose();
                        new ViewCadastroEndereco(medico, endereco);
                    }
                }
            }
        });
        panel.add(btnProximo);

    }

    /* Botão usado para voltar
     * a tela ViewCadastrar
     * como administrador */
    private void voltar(){
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(10, 690, 110, 25);
        btnVoltar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnVoltar){
                    frame.dispose();
//                    new ViewCadastrar("Administrador");
                }
            }
        });
        panel.add(btnVoltar);
    }
}
