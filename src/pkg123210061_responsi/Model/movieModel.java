/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg123210061_responsi.Model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Lab Informatika
 */
public class movieModel implements hitungan {
    Connection connection;
    Statement statement;
    
    public movieModel() throws ClassNotFoundException{       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","");
            System.out.println("Koneksi Berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(movieModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal");
        }}
    @Override
    public double nilai(double nilaiAlur,double nilaiPenokohan,double nilaiAkting){
        return (nilaiAlur+nilaiPenokohan+nilaiAkting)/3;
    }
    public int getMovieData(){
    try{
        int totalData = 0;
        String query = "SELECT * FROM `movie`";
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
        totalData++;
        }
        statement.close();
        return totalData;
    }
    catch(Exception e){
        System.out.println("Error :" + e.getMessage());
        return 0;
    }} 
    public void addMovie(String judul, String alur, String penokohan, String akting) throws Exception{
    try{
        double nilaiAlur, nilaiPenokohan, nilaiAkting, nilai;
        nilaiAlur = Double.parseDouble(alur);
        nilaiPenokohan = Double.parseDouble(penokohan);
        nilaiAkting = Double.parseDouble(akting);
        
        if(nilaiAlur <0.0 || nilaiAlur > 5.0){
            throw new Exception("Out");
        }
        if(nilaiPenokohan <0.0 || nilaiPenokohan > 5.0){
            throw new Exception("Out");
        }
        if(nilaiAkting <0.0 || nilaiAkting > 5.0){
            throw new Exception("Out");
        }
        nilai = nilai(nilaiAlur,nilaiPenokohan,nilaiAkting);
        
        String query = "INSERT `movie`(`judul`,`alur`,`penokohan`,`akting`,`nilai`)" +
                "VALUES ('" + judul+ "'," + alur +"," +penokohan+"," +akting+ ","+ nilai + ")";
        statement = connection.createStatement();
        statement.executeUpdate(query);
        
    }   catch (SQLException ex) {
            Logger.getLogger(movieModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String[][] readMovie(){
        try{
            int totalData = 0;
            String data[][] = new String[getMovieData()][5];
            String query = "SELECT * FROM `movie`";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                data[totalData][0] = rs.getString("judul");
                data[totalData][1] = rs.getString("alur");
                data[totalData][2] = rs.getString("penokohan");
                data[totalData][3] = rs.getString("akting");
                data[totalData][4] = rs.getString("nilai");
                totalData++;
            }
            statement.close();
            return data;
            
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage() );
            return null;
        }
    }
    public void deleteMovie(String judul){
         try{
            String query = "DELETE FROM `movie` WHERE `judul` = '"+judul+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage() );
        }
    }

    public void updateMovie(String judul, String alur, String penokohan, String akting) {
         try{
        double nilaiAlur, nilaiPenokohan, nilaiAkting, nilai;
        nilaiAlur = Double.parseDouble(alur);
        nilaiPenokohan = Double.parseDouble(penokohan);
        nilaiAkting = Double.parseDouble(akting);
        
        if(nilaiAlur <0.0 || nilaiAlur > 5.0){
            throw new Exception("Out");
        }
        if(nilaiPenokohan <0.0 || nilaiPenokohan > 5.0){
            throw new Exception("Out");
        }
        if(nilaiAkting <0.0 || nilaiAkting > 5.0){
            throw new Exception("Out");
        }
        nilai = nilai(nilaiAlur,nilaiPenokohan,nilaiAkting);
        
        String query = "UPDATE `movie`" + "SET" 
                + "`alur`=" + alur + "," +
                "`penokohan`=" + penokohan + "," +
                "`akting`=" + akting + "," +
                "`nilai`=" + nilai + "," +
                "WHERE `judul` = '" + judul + "'";
        statement = connection.createStatement();
        statement.executeUpdate(query);
        
    }   catch (SQLException ex) {
            Logger.getLogger(movieModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(movieModel.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }

    
}

