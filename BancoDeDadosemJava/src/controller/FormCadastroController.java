/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UsuarioDao;
import dao.conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author usuario
 */
public class FormCadastroController {
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }
    public void salvaUsuario(){
     
     String usuario = view.getjTextFieldUsuario().getText();
     String senha = view.getjPasswordFieldSenha().getText();
        Usuario usuarioXandi = new Usuario(usuario,senha);
        try {
            Connection conexao = new conexao().getConnection();
            UsuarioDao usuarioDao = new UsuarioDao(conexao);
            usuarioDao.insert(usuarioXandi);
            
            JOptionPane.showMessageDialog(null,"Usuário salvo com sucesso");
        } catch (SQLException ex) {
            
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
