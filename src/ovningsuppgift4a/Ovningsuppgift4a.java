/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ovningsuppgift4a;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Lukas test
 */
public class Ovningsuppgift4a extends JFrame implements ActionListener{
    JLabel labelTextfält = new JLabel("Filnamn: ");
    JTextField textfält = new JTextField();
    JButton öppna = new JButton("Öppna");
    JButton spara = new JButton("Spara");
    JButton skrivUt = new JButton("Skriv ut");
    JButton avsluta = new JButton("Avsluta");
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea(20, 50);
    JScrollPane scrollPane = new JScrollPane(textArea);
    
    
    public Ovningsuppgift4a(){
        panel.setLayout(new GridLayout(1, 6));
        panel.add(labelTextfält);
        panel.add(textfält);
        panel.add(öppna);
        panel.add(spara);
        panel.add(skrivUt);
        panel.add(avsluta);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        textfält.addActionListener(this);
        öppna.addActionListener(this);
        spara.addActionListener(this);
        skrivUt.addActionListener(this);
        avsluta.addActionListener(this);
        
    }
    
    
    
    public static void main(String[] args) {
        Ovningsuppgift4a o = new Ovningsuppgift4a();
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == öppna || e.getSource() == textfält){
            läsFil(textfält.getText());
        }
        else if(e.getSource() == spara){
            sparaFil(textfält.getText());
        }
        else if(e.getSource() == skrivUt){
            try {
                textArea.print();
            } catch (PrinterException ex) {
                
            }
        }
        else if(e.getSource() == avsluta){
            System.exit(0);
        }
    }
    
    public void läsFil(String namn){
        try{
        FileReader fr = new FileReader(namn);
        textArea.read(fr, null);
        }
        catch(IOException e){
            textArea.setText("Nått gick fel med inläsningen av filen");
        }
    }
    
    public void sparaFil(String namn){
        try{
            FileWriter fw = new FileWriter(namn);
            textArea.write(fw);
        }
        catch(IOException e){
            textArea.setText("Nått gick fel med sparningen av texten" + textArea.getText());
        }
    }

}
