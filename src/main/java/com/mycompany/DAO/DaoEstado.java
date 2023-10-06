/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import static com.mycompany.ferramentas.BancoDadosMySQL.getConexao;
import static com.mycompany.ferramentas.BancoDadosMySQL.getResultado;
import static com.mycompany.ferramentas.BancoDadosMySQL.getStatement;
import static com.mycompany.ferramentas.BancoDadosMySQL.setResultado;
import static com.mycompany.ferramentas.BancoDadosMySQL.setStatement;
import java.sql.ResultSet;

/**
 *
 * @author romario.2919
 */
public class DaoEstado {
    
    String sql;
    
    public ResultSet listarTodos(){
        try{
            sql = 
                "SELECT ID, ID_PAIS, NOME, UF FROM ESTADO";
            
            setStatement(getConexao().prepareStatement(sql));
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
    
    public ResultSet listarPorNome(String nome){
        try{
            sql = 
                "SELECT ID, ID_PAIS, NOME, UF FROM ESTADO WHERE NOME LIKE ?";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setString(1, nome + "%");
            
            setResultado(getStatement().executeQuery());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return getResultado();
    }
}