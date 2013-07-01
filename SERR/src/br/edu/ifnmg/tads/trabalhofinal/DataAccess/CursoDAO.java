/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.trabalhofinal.DataAccess;

import br.edu.ifnmg.tads.trabalhofinal.DoMainModel.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public int Consultacodcurso() {
        int codcurso = 0;
        try {

            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select max(codcurso) as codcurso from cursos");
            ResultSet resultado = comando.executeQuery();
            resultado.first();
            codcurso = (resultado.getInt("codcurso"));
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return codcurso;
    }

    public boolean Salvar(Curso curso) {
        try {
            if (curso.getCodcurso() == 0) {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("insert into cursos(nome, duracao, ativo) values(?, ?, ?)");
                comando.setString(1, curso.getNome());
                comando.setInt(2, curso.getDuracao());
                comando.setInt(3, 1);
                comando.executeUpdate();

            } else {
                PreparedStatement comando = bd.getConexao().
                        prepareStatement("update cursos set nome = ?, duracao = ? where codcurso = ?");
                comando.setString(1, curso.getNome());
                comando.setInt(2, curso.getDuracao());
                comando.setInt(3, curso.getCodcurso());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Curso> BuscarCurso(Curso filtro) {
        try {
            List<Curso> cursos = new LinkedList<>();
            String sql = "select * from cursos";
            String where = "";
            String order = " order by codcurso asc";

            if (filtro.getCodcurso() > 0) {
                where = "codcurso = " + filtro.getCodcurso();
            }

            if (filtro.getNome().length() > 0) {
                where = "nome like '%" + filtro.getNome() + "%'";
            }

            if (filtro.getDuracao() > 0) {
                where = "duracao = " + filtro.getDuracao();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where + " and ativo = 1";
            } else {
                sql = sql + " where ativo = 1";
            }

            sql = sql + order;

            Statement comando = bd.getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);
            while (resultado.next()) {

                Curso curso = new Curso();
                curso.setCodcurso(resultado.getInt("codcurso"));
                curso.setNome(resultado.getString("nome"));
                curso.setDuracao(resultado.getInt("duracao"));
                cursos.add(curso);
            }
            return cursos;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Curso Abrir(int cod) {
        try {
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from cursos where codcurso = ?");
            comando.setInt(1, cod);
            ResultSet resultado = comando.executeQuery();
            resultado.first();
                Curso curso = new Curso();
                curso.setCodcurso(resultado.getInt("codcurso"));
                curso.setNome(resultado.getString("nome"));
                curso.setDuracao(resultado.getInt("duracao"));
            return curso;
        } catch (SQLException ex) {
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Curso> ListarTodos() {
        try {
            List<Curso> cursos = new LinkedList<>();
            PreparedStatement comando = bd.getConexao().
                    prepareStatement("select * from cursos where ativo = 1 ORDER BY codcurso ASC");
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
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
