package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Consulta;
import backenddm20231n.util.ConexaoDb;

public class DaoConsulta {
	private final Connection c;
    
    public DaoConsulta() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Consulta excluir(Consulta consEnt) throws SQLException{
        String sql = "delete from consultas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,consEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return consEnt;
    }
    
    public Consulta buscar(Consulta consEnt) throws SQLException{
        String sql = "select * from consultas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,consEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Consulta consSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                consSaida = new Consulta(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return consSaida;
   }

    public Consulta inserir(Consulta consEnt) throws SQLException{
        String sql = "insert into consultas" + " (dia_consulta, hora_consulta, clinica, idV, idAnimal, prontuario)" + " values (?,?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,consEnt.getDia());
        stmt.setString(2,consEnt.getHora());
        stmt.setString(3,consEnt.getClinica());
        stmt.setInt(4,consEnt.getVet());
        stmt.setInt(5,consEnt.getAnimal());
        stmt.setString(6,consEnt.getProntuario());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            consEnt.setId(id);
        }
        stmt.close();
        return consEnt;
    }

    public Consulta alterar(Consulta consEnt) throws SQLException{
        String sql = "UPDATE consultas SET dia_consulta = ?, hora_consulta = ?, clinica = ?, idV = ?, idAnimal = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,consEnt.getDia());
        stmt.setString(2,consEnt.getHora());
        stmt.setString(3,consEnt.getClinica());
        stmt.setInt(4,consEnt.getVet());
        stmt.setInt(5,consEnt.getAnimal());
        stmt.setString(6,consEnt.getProntuario());
        stmt.setInt(7,consEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return consEnt;
    }

   public List<Consulta> listar(Consulta consEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Consulta> listaconss = new ArrayList<>();
        
        String sql = "select * from consultas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + consEnt.getDia() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Consulta cons = new Consulta(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getInt(6),
                rs.getString(7)
            );
            // adiciona o usu à lista de usus
            listaconss.add(cons);
        }
        
        rs.close();
        stmt.close();
        return listaconss;
   
   }
}
