/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210061_responsi.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lab Informatika
 */
public class movieView extends JFrame{
    JLabel labelJudul = new JLabel("Judul");
    JLabel labelAlur = new JLabel("Alur");
    JLabel labelPenokohan = new JLabel("Penokohan");
    JLabel labelAkting = new JLabel("Akting");
    
    public JTextField inputJudul = new JTextField();
    public JTextField inputAlur = new JTextField();
    public JTextField inputPenokohan = new JTextField();
    public JTextField inputAkting = new JTextField();
    
    public JButton buttonAdd = new JButton("Add");
    public JButton buttonUpdate = new JButton("Update");
    public JButton buttonDelete = new JButton("Delete");
    public JButton buttonClear = new JButton("Clear");
    
    public JTable table;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    
    public Object[] columnName = {"Judul", "Alur","Penokohan","Akting", "Nilai"};
    
    public movieView(){
    dtm = new DefaultTableModel(columnName,0);
    table = new JTable(dtm);
    scrollPane = new JScrollPane(table);
    setTitle("Data Movie");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setVisible(true);
    setResizable(false);
    setLayout(null);
    setSize(700,400);
    add(scrollPane);
    scrollPane.setBounds(20, 20, 480, 300);
    add(labelJudul);
    labelJudul.setBounds(510, 20, 90, 20);
    add(inputJudul);
    inputJudul.setBounds(510, 40, 90, 20);
    add(labelAlur);
    labelAlur.setBounds(510, 60, 90, 20);
    add(inputAlur);
    inputAlur.setBounds(510, 80, 90, 20);
    add(labelPenokohan);
    labelPenokohan.setBounds(510, 100, 90, 20);
    add(inputPenokohan);
    inputPenokohan.setBounds(510, 120, 90, 20);
    add(labelAkting);
    labelAkting.setBounds(510, 140, 90, 20);
    add(inputAkting);
    inputAkting.setBounds(510, 160, 90, 20);
    
    add(buttonAdd);
    buttonAdd.setBounds(510, 190, 90, 20);
    add(buttonUpdate);
    buttonUpdate.setBounds(510, 220, 90, 20);
    add(buttonDelete);
    buttonDelete.setBounds(510, 250, 90, 20);
    add(buttonClear);
    buttonClear.setBounds(510, 280, 90, 20);
    }

    public String getJudul(){
        return inputJudul.getText();
    }
    public String getAlur(){
        return inputAlur.getText();
    }
    public String getPenokohan(){
        return inputPenokohan.getText();
    }
    public String getAkting(){
        return inputAkting.getText();
    }
    public void setAll(){
     inputJudul.setText("");
     inputAlur.setText("");
     inputPenokohan.setText("");
     inputAkting.setText("");
    }
}
