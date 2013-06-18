/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maike Jordan
 */
public class CursoDAO {

    private BD bd;

    public CursoDAO() {
        bd = new BD();
    }

    public boolean Salvar(Curso curso) {
        try {
            if (curso.getCodcurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into cursos(codcurso, nome, duracao, ativo) values(?, ?, ?, ?)");
                comando.setInt(1, curso.getCodcurso());
                comando.setString(1, curso.getNome());
                comando.setInt(3, curso.getDuracao());
                comando.setInt(4, 1);
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update cursos set nome = ? where codcurso = ?");
                comando.setString(1, curso.getNome());
                comando.setInt(2, curso.getDuracao());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Curso> Abrir(int cod) {
        List<Curso> cursos = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from cursos where codcurso = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Curso curso = new Curso();
                curso.setCodcurso(resultado.getInt("codcurso"));
                curso.setNome(resultado.getString("nome"));
                curso.setDuracao(resultado.getInt("duracao"));
                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(int cod) {
        try {
            PreparedStatement comando = bd
                    .getConexao().prepareStatement("update cursos set ativo = 0 where codcurso = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
