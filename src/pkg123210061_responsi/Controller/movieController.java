/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210061_responsi.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import pkg123210061_responsi.Model.movieModel;
import pkg123210061_responsi.View.movieView;

/**
 *
 * @author Lab Informatika
 */
public class movieController {
    movieModel movieModel;
    movieView movieView;
    Object header[] = {"Judul","Alur","Penokohan","Akting","Nilai"};
    public movieController(movieModel movieModel,movieView movieView){
        this.movieModel = movieModel;
        this.movieView = movieView;
        if(movieModel.getMovieData()!=0){
            String dataMovie[][] = movieModel.readMovie();
            movieView.table.setModel((new JTable(dataMovie,header).getModel()));
        }
        else{
        JOptionPane.showMessageDialog(null, "no data");
        }
        movieView.buttonAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
            String judul = movieView.getJudul();
            String alur = movieView.getAlur();
            String penokohan = movieView.getPenokohan();
            String acting = movieView.getAkting();
                try {
                    movieModel.addMovie(judul, alur, penokohan, acting);
                } catch (Exception ex) {
                    Logger.getLogger(movieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie,header).getModel()));
            }
        } );
        movieView.buttonUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = movieView.getJudul();
            String alur = movieView.getAlur();
            String penokohan = movieView.getPenokohan();
            String acting = movieView.getAkting();
                try {
                    movieModel.updateMovie(judul, alur, penokohan, acting);
                } catch (Exception ex) {
                    Logger.getLogger(movieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie,header).getModel()));
            }
            }
           );
        movieView.buttonDelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 String judul = movieView.getJudul();
                try {
                    movieModel.deleteMovie(judul);
                } catch (Exception ex) {
                    Logger.getLogger(movieController.class.getName()).log(Level.SEVERE, null, ex);
                }
                String dataMovie[][] = movieModel.readMovie();
                movieView.table.setModel((new JTable(dataMovie,header).getModel()));
            }
        
        });
        movieView.buttonClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               movieView.setAll();
            }        
        });   
    }
    
}
