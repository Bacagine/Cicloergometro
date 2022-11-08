/* ViewMedico.java: Tela principal do medico
 * 
 * Desenvolvido por Gustavo Bacagine <gustavo.bacagine@protonmail.com>
 * 
 * Data da última modificação: 16/06/2022
 */

package org.java.cicloergometro.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ViewMedico {
    private JFrame frame;
    private JPanel panel;
    private JButton btnConsultas;
    private JButton btnExames;
    private JButton btnMinhaConta;
    private JButton btnSair;
    private static final String titulo = "Clinica Medica";
    private static final int altura = 500;
    private static final int largura = 500;

    public ViewMedico(){
        frame = new JFrame(titulo);
        
        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(null);

        btnConsultas = new JButton("Minhas Consultas");
        btnConsultas.setBounds(150, 20, 200, 25);
        btnConsultas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == btnConsultas){
                    frame.dispose();
//                    new ViewConsultasMedico();
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
//                    new ViewExamesMedico();
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
                    new ViewContaMedico();
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

        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
