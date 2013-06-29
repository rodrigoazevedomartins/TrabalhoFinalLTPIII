/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Curso;
import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class DisciplinaDAO {
    private BD bd;

    public DisciplinaDAO() {
        this.bd = new BD();
    }
    
    public boolean Salvar(Disciplina disciplina) {
        try {
            if (disciplina.getCoddisciplina() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into disciplinas(nome, ementa, codcurso, ativo) values(?, ?, ?, ?)");
                comando.setString(1, disciplina.getNome());
                comando.setString(2, disciplina.getEmenta());
                comando.setInt(3, disciplina.getCurso().getCodcurso());
                comando.setInt(4, 1);
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update disciplinas set nome = ?, ementa = ?, codcurso = ? where coddisciplina = ?");
                comando.setString(1, disciplina.getNome());
                comando.setString(2, disciplina.getEmenta());
                comando.setInt(3, disciplina.getCurso().getCodcurso());
                comando.setInt(4, disciplina.getCoddisciplina());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Disciplina> ListarDisciplina(int cod) {
        List<Disciplina> disciplinas = new LinkedList<>();
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from disciplinas where codcurso = ? and ativo = 1");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Disciplina disc = new Disciplina();
                Curso curso = new Curso();
                disc.setCoddisciplina(resultado.getInt("coddisciplina"));
                disc.setNome(resultado.getString("nome"));
                disc.setEmenta(resultado.getString("ementa"));
                curso.setCodcurso(resultado.getInt("codcurso"));
                disc.setCurso(curso);
                
                disciplinas.add(disc);
            }
            return disciplinas;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean Apagar(int cod){
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("update disciplinas set ativo = 0 where coddisciplina = ?");
            comando.setInt(1, cod);
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DisciplinaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
