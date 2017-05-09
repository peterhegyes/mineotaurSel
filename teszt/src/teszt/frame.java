/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teszt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 *
 * @author Peti
 */
public class frame extends JFrame implements ActionListener {
    
    File fajl;
    FileInputStream fis;
    byte[] tomb;
    ImageIcon img;
    JPanel tartalom;
    JLabel lbl;
    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    //FlowLayout flo;
    Font f = new Font("Arial", Font.PLAIN, 25);
    
    public frame(){
        this.setTitle("Keret");
        this.setSize(540,560);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        try{
            fajl = new File("C:\\Users\\Peti\\Desktop\\doksik\\szakdologzat\\logo_tr.png");
            fis = new FileInputStream(fajl);
            tomb = new byte[(int)fajl.length()];
            fis.read(tomb);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
        img = new ImageIcon(tomb);
        lbl = new JLabel(img);
        lbl.setBounds(190, 40, 200, 124);
        
        btn1 = new JButton("Gene-Wise Scatterplot");
        btn1.setBounds(110, 204, 300, 60);
        btn1.setFont(f);
        btn1.addActionListener(this);
        
        
        btn2 = new JButton("Gene-Wise Distribution");
        btn2.setBounds(110, 274, 300, 60);
        btn2.setFont(f);
        btn2.addActionListener(this);
        
        btn3 = new JButton("Cell-Wise Scatterplot");
        btn3.setBounds(110, 344, 300, 60);
        btn3.setFont(f);
        btn3.addActionListener(this);
        
        btn4 = new JButton("Cell-Wise Distribution");
        btn4.setBounds(110, 414, 300, 60);
        btn4.setFont(f);
        btn4.addActionListener(this);
        
        tartalom = (JPanel)this.getContentPane();
        //flo = new FlowLayout();
        tartalom.setLayout(null);
        
        tartalom.add(lbl);
        tartalom.add(btn1);
        tartalom.add(btn2);
        tartalom.add(btn3);
        tartalom.add(btn4);
        
        this.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String forras = e.getActionCommand();
        
        switch(forras){
            case "Gene-Wise Scatterplot":
        {
            try {
                Teszt.genewisescatterplot();
            } catch (InterruptedException ex) {
                Logger.getLogger(frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "Gene-Wise Distribution":
                Teszt.genewisedistribution();
                break;
            case "Cell-Wise Scatterplot":
                Teszt.cellwisescatterplot();
                break;
            case "Cell-Wise Distribution":
                Teszt.cellwisedistribution();
                break;
            default: 
                Teszt.cellwisedistribution();
        }
    }
}
