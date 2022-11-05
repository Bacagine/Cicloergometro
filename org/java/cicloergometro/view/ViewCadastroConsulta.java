package org.java.cicloergometro.view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
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

import org.java.cicloergometro.model.bean.Consulta;
import org.java.cicloergometro.model.bean.Endereco;
import org.java.cicloergometro.model.bean.Medico;
import org.java.cicloergometro.model.bean.Paciente;
import org.java.cicloergometro.model.bean.Pessoa;

public class ViewCadastroConsulta {
    private JFrame frame;
    private JPanel panel;
    private JButton btnCancelar;
    private JButton btnProximo;
    private JLabel lblPaciente;
    private JLabel lblIdade;
    private JLabel lblCPF;
    private JLabel lblMedico;
    private JLabel lblCRM;
    private JLabel lblEspecialidade;
    private JLabel lblValor;
    private JLabel lblData;
    private JLabel lblHora;
    private JLabel lblObservacoes;
    private JTextField txtPaciente;
    private JTextField txtIdade;
    private JTextField txtMedico;
    private JTextField txtObservacoes;
    private JFormattedTextField txtValor;
    private JFormattedTextField txtData;
    private JFormattedTextField txtHora;
    private JComboBox<String> boxCPF;
    private JComboBox<String> boxCRM;
    private JComboBox<String> boxEspecialidade;
    private static final String titulo = "Cadastar Consulta";
    private String CPFs[] = { "-- CPF --", "465.426.898-77" };
    private String CRMs[] = { "-- CRM --", "123456" };
    private static final String especialidades[] = { "-- selecione --", "Imunologista",
                                                     "Anestesista", "Cardiologista", "Psicologo",
                                                     "Psiquiatra", "Dermatologista", "Endocrinologista",
                                                     "Gastronomista", "Infectologista", "Neurologista",
                                                     "Pediatra", "Toxicologista", "Reumatologista" };
    private static final double valores[] = {};
    private static final int altura = 770;
    private static final int largura = 770;

    public ViewCadastroConsulta(){
        initWindow();

        printForm();
        next();
        cancel();

        finalWindow();
    }

    public ViewCadastroConsulta(Consulta consulta, Endereco endereco){
        initWindow();

        printForm(consulta);
        next(endereco);

        finalWindow();
        cancel();
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
        frame.setLocationRelativeTo(null); // Deixa a janela centralizada na tela
        frame.setVisible(true);
    }

    private void printForm(){
        lblPaciente = new JLabel("Paciente: ");
        lblPaciente.setBounds(10, 20, 560, 25);
        panel.add(lblPaciente);

        txtPaciente = new JTextField();
        txtPaciente.setBounds(90, 20, 250, 25);
        panel.add(txtPaciente);

        lblCPF = new JLabel("CPF: ");
        lblCPF.setBounds(350, 20, 160, 25);
        panel.add(lblCPF);

        boxCPF = new JComboBox<String>(CPFs);
        boxCPF.setBounds(390, 20, 100, 25);
        panel.add(boxCPF);

        lblIdade = new JLabel("Idade: ");
        lblIdade.setBounds(555, 20, 160, 25);
        panel.add(lblIdade);

        txtIdade = new JTextField();
        txtIdade.setBounds(610, 20, 150, 25);
        panel.add(txtIdade);

        lblMedico = new JLabel("Medico: ");
        lblMedico.setBounds(10, 50, 160, 25);
        panel.add(lblMedico);

        txtMedico = new JTextField();
        txtMedico.setBounds(90, 50, 250, 25);
        panel.add(txtMedico);

        lblCRM = new JLabel("CRM: ");
        lblCRM.setBounds(350, 50, 160, 25);
        panel.add(lblCRM);

        boxCRM = new JComboBox<String>(CRMs);
        boxCRM.setBounds(390, 50, 100, 25);
        panel.add(boxCRM);

        lblEspecialidade = new JLabel("Especialidade: ");
        lblEspecialidade.setBounds(500, 50, 160, 25);
        panel.add(lblEspecialidade);

        boxEspecialidade = new JComboBox<String>(especialidades);
        boxEspecialidade.setBounds(610, 50, 150, 25);
        panel.add(boxEspecialidade);

        lblValor = new JLabel("Valor: ");
        lblValor.setBounds(10, 80, 160, 25);
        panel.add(lblValor);

        txtValor = new JFormattedTextField();
        try {
            MaskFormatter valorMask = new MaskFormatter("####.##");
            valorMask.install(txtValor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtValor.setBounds(90, 80, 115, 25);
        panel.add(txtValor);

        lblData = new JLabel("Data: ");
        lblData.setBounds(350, 80, 100, 25);
        panel.add(lblData);

        txtData = new JFormattedTextField();
        try {
            MaskFormatter dataNascimentoMaks = new MaskFormatter("##/##/####");
            dataNascimentoMaks.install(txtData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtData.setBounds(390, 80, 100, 25);
        panel.add(txtData);

        lblHora = new JLabel("Hora: ");
        lblHora.setBounds(555, 80, 100, 25);
        panel.add(lblHora);
        
        txtHora = new JFormattedTextField();
        try {
            MaskFormatter horaMask = new MaskFormatter("##:##");
            horaMask.install(txtHora);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtHora.setBounds(610, 80, 100, 25);
        panel.add(txtHora);
     
        lblObservacoes = new JLabel("Observações");
        lblObservacoes.setBounds(10, 120, 160, 25);
        panel.add(lblObservacoes);
        
        txtObservacoes = new JTextField();
        txtObservacoes.setBounds(10, 140, 750, 500);
        panel.add(txtObservacoes);
    }

    private void printForm(Consulta consulta){
        lblPaciente = new JLabel("Paciente: ");
        lblPaciente.setBounds(10, 20, 560, 25);
        panel.add(lblPaciente);

        txtPaciente = new JTextField(consulta.getPaciente().getNome());
        txtPaciente.setBounds(90, 20, 250, 25);
        panel.add(txtPaciente);

        lblCPF = new JLabel("CPF: ");
        lblCPF.setBounds(350, 20, 160, 25);
        panel.add(lblCPF);

        boxCPF = new JComboBox<String>(CPFs);
        boxCPF.setSelectedItem(consulta.getPaciente().getCPF());
        boxCPF.setBounds(390, 20, 100, 25);
        panel.add(boxCPF);

        lblIdade = new JLabel("Idade: ");
        lblIdade.setBounds(555, 20, 160, 25);
        panel.add(lblIdade);

        txtIdade = new JTextField(String.valueOf(consulta.getPaciente().getIdade()));
        txtIdade.setBounds(610, 20, 150, 25);
        panel.add(txtIdade);

        lblMedico = new JLabel("Medico: ");
        lblMedico.setBounds(10, 50, 160, 25);
        panel.add(lblMedico);

        txtMedico = new JTextField(consulta.getMedico().getNome());
        txtMedico.setBounds(90, 50, 250, 25);
        panel.add(txtMedico);

        lblCRM = new JLabel("CRM: ");
        lblCRM.setBounds(350, 50, 160, 25);
        panel.add(lblCRM);

        boxCRM = new JComboBox<String>(CRMs);
        boxCRM.setSelectedItem(consulta.getMedico().getCRM());
        boxCRM.setBounds(390, 50, 100, 25);
        panel.add(boxCRM);

        lblEspecialidade = new JLabel("Especialidade: ");
        lblEspecialidade.setBounds(500, 50, 160, 25);
        panel.add(lblEspecialidade);

        boxEspecialidade = new JComboBox<String>(especialidades);
        boxEspecialidade.setSelectedItem(consulta.getEspecializacaoMedica());
        boxEspecialidade.setBounds(610, 50, 150, 25);
        panel.add(boxEspecialidade);

        lblValor = new JLabel("Valor: ");
        lblValor.setBounds(10, 80, 160, 25);
        panel.add(lblValor);

        txtValor = new JFormattedTextField();
        try {
            MaskFormatter valorMask = new MaskFormatter("####.##");
            valorMask.install(txtValor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtValor.setBounds(90, 80, 115, 25);
        txtValor.setText(String.valueOf(consulta.getValor()));
        panel.add(txtValor);

        lblData = new JLabel("Data: ");
        lblData.setBounds(350, 80, 100, 25);
        panel.add(lblData);

        txtData = new JFormattedTextField();
        try {
            MaskFormatter dataNascimentoMaks = new MaskFormatter("##/##/####");
            dataNascimentoMaks.install(txtData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtData.setBounds(390, 80, 100, 25);
        txtData.setText(consulta.getData().format(Pessoa.BRAZZILIAN_FORMATTER));
        panel.add(txtData);

        lblHora = new JLabel("Hora: ");
        lblHora.setBounds(555, 80, 100, 25);
        panel.add(lblHora);
        
        txtHora = new JFormattedTextField();
        try {
            MaskFormatter horaMask = new MaskFormatter("##:##");
            horaMask.install(txtHora);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        txtHora.setBounds(610, 80, 100, 25);
        txtHora.setText(String.valueOf(consulta.getHora()));
        panel.add(txtHora);
     
        lblObservacoes = new JLabel("Observações");
        lblObservacoes.setBounds(10, 120, 160, 25);
        panel.add(lblObservacoes);
        
        txtObservacoes = new JTextField(consulta.getObservacoes());
        txtObservacoes.setBounds(10, 140, 750, 500);
        panel.add(txtObservacoes);
    }

    private void next(){
        btnProximo = new JButton("Proximo");
        btnProximo.setBounds(640, 690, 110, 25);
        btnProximo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnProximo){
                    if(txtPaciente.getText().isEmpty() ||
                       boxCPF.getSelectedItem().equals(CPFs[0]) ||
                       txtIdade.getText().isEmpty() || txtMedico.getText().isEmpty() ||
                       boxCRM.getSelectedItem().equals(CRMs[0]) || boxEspecialidade.getSelectedItem().equals(especialidades[0]) ||
                       txtValor.getText().isEmpty() || txtData.getText().isEmpty() || txtHora.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erro: Cheque os campos obrigatorios!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Consulta consulta = new Consulta();
                        String dataConsulta = Pessoa.converteData(txtData.getText());
                        String especialidade = String.valueOf(boxEspecialidade.getSelectedItem());
                        String CPF = String.valueOf(boxCPF.getSelectedItem());
                        String CRM = String.valueOf(boxCRM.getSelectedItem());
                        Medico medico = new Medico(txtMedico.getText(), CRM, especialidade);
//                        Paciente paciente = new Paciente(txtPaciente.getText(), CPF);
//                        paciente.setIdade(Integer.parseInt(txtIdade.getText()));
//                        consulta = new Consulta(medico, paciente, LocalDate.parse(dataConsulta), LocalTime.parse(txtHora.getText()), especialidade, txtObservacoes.getText(), Double.parseDouble(txtValor.getText()));
                        frame.dispose();
                        new ViewCadastroEndereco(consulta);
                    }

                }
            }
        });
        panel.add(btnProximo);  
    }

    private void next(Endereco endereco){
        btnProximo = new JButton("Proximo");
        btnProximo.setBounds(640, 690, 110, 25);
        btnProximo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnProximo){
                    if(txtPaciente.getText().isEmpty() ||
                       boxCPF.getSelectedItem().equals(CPFs[0]) ||
                       txtIdade.getText().isEmpty() || txtMedico.getText().isEmpty() ||
                       boxCRM.getSelectedItem().equals(CRMs[0]) || boxEspecialidade.getSelectedItem().equals(especialidades[0]) ||
                       txtValor.getText().isEmpty() || txtData.getText().isEmpty() || txtHora.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null, "Erro: Cheque os campos obrigatorios!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        Consulta consulta = new Consulta();
                        String dataConsulta = Pessoa.converteData(txtData.getText());
                        String especialidade = String.valueOf(boxEspecialidade.getSelectedItem());
                        String CPF = String.valueOf(boxCPF.getSelectedItem());
                        String CRM = String.valueOf(boxCRM.getSelectedItem());
                        Medico medico = new Medico(txtMedico.getText(), CRM, especialidade);
//                        Paciente paciente = new Paciente(txtPaciente.getText(), CPF);
//                        consulta = new Consulta(medico, paciente, LocalDate.parse(dataConsulta), LocalTime.parse(txtHora.getText()), especialidade, txtObservacoes.getText(), Double.parseDouble(txtValor.getText()));
                        frame.dispose();
                        new ViewCadastroEndereco(consulta, endereco);
                    }

                }
            }
        });
        panel.add(btnProximo);  
    }

    private void cancel(){

    }

}
