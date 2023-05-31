/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210061_responsi;

import pkg123210061_responsi.Controller.movieController;
import pkg123210061_responsi.Model.movieModel;
import pkg123210061_responsi.View.movieView;

/**
 *
 * @author Lab Informatika
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        movieView movieView = new movieView();
        movieModel movieModel = new movieModel();
        movieController movieController = new movieController(movieModel,movieView);
        // TODO code application logic here
    }
    
}
