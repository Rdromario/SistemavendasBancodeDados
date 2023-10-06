/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.ferramentas.BancoDadosMySQL;
import java.sql.ResultSet;

/**
 *
 * @author romario.2919
 */
public class DaoCategoria extends BancoDadosMySQL{
    
    private String sql;
    
    public ResultSet inserir(int id, String nome, String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE NOME LIKE";
            setStatement(getConexao().prepareStatement(sql));
            
              setResultado(getStatement().executeQuery());
              
              setResultado(getStatement().executeQuery());
        }catch(Exception e){
         System.out.println(e.getMessage());
        }
        return  getResultado();
   
    }
     public ResultSet listarPorDescricao(String descricao){
        try{
            sql = "SELECT ID, NOME, IFNULL(DESCRICAO, '') FROM CATEGORIA WHERE DESCRICAO LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, descricao + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public int buscarProximoId(){
        int id = -1;
        
        try{
            sql = "SELECT MAX(ID) + 1 FROM CATEGORIA";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
            
            getResultado().next(); //Move para o primeiro registro.
            
            id = getResultado().getInt(1); //Pega o valor retornado na consulta
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return id;
}
}