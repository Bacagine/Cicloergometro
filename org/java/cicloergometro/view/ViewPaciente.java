/* ViewPaciente.java: Tela principal do paciente
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 16/06/2022
 */

package org.java.cicloergometro.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ViewPaciente{
    private JFrame frame;
    private JPanel panel;
    private JButton btnConsultas;
    private JButton btnExames;
    private JButton btnMinhaConta;
    private JButton btnSair;
    private static final String titulo = "Clinica Medica";
    private static final int altura = 500;
    private static final int largura = 500;

    public ViewPaciente(){
        this.frame = new JFrame(titulo);

        this.panel = new JPanel();
        this.frame.add(this.panel);

        this.panel.setLayout(null);

        btnConsultas = new JButton("Minhas Consultas");
        btnConsultas.setBounds(150, 20, 200, 25);
        btnConsultas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnConsultas){
                    frame.dispose();
//                    new ViewConsultasPaciente();
                }
            }
        });
        this.panel.add(btnConsultas);

        btnExames = new JButton("Meus exames");
        btnExames.setBounds(150, 50, 200, 25);
        btnExames.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnExames){
                    frame.dispose();
//                    new ViewExamesPaciente();
                }
            }
        });
        this.panel.add(btnExames);

        btnMinhaConta = new JButton("Minha conta");
        btnMinhaConta.setBounds(150, 80, 200, 25);
        btnMinhaConta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnMinhaConta){
                    frame.dispose();
                    new ViewContaPaciente();
                }
            }
        });
        this.panel.add(btnMinhaConta);

        btnSair = new JButton("Sair");
        btnSair.setBounds(150, 110, 200, 25);
        btnSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnSair){
                    System.exit(0);
                }
            }
        });
        this.panel.add(btnSair);

        this.frame.setSize(largura, altura);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

}
