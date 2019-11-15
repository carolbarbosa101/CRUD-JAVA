package br.com.modelo;
import java.sql.SQLException;
public class TesteCon {
    public static  void main(String args[]) throws SQLException{
     DAO c1 = new DAO();
     c1.abrirBanco();
   } 
}
