/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.DAO;

import com.mycompany.ferramentas.BancoDadosMySQL;
import com.mysql.cj.protocol.x.MessageConstants;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author romario.2919
 */
public class DaoCidade extends BancoDadosMySQL{
    private String sql;
    
    public Boolean inserir(int id, int idEstado, String descricao){
        try{
            sql = "INSERT INTO CIDADE (ID, ID_ESTADO, NOME) VALUES (?, ?, ?)";
            
            setStatement(getConexao().prepareStatement(sql));
            
            getStatement().setInt(1, id);
            getStatement().setInt(2, idEstado);
            getStatement().setString(3, descricao);
            
            getStatement().executeUpdate();
        
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage()); 
            return false;
            
        }
        
    }
    public Boolean excluir(int id){
    try{
    }
    }
}
