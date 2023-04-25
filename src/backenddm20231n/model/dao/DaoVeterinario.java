package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Veterinario;
import backenddm20231n.util.ConexaoDb;

public class DaoVeterinario {
	private final Connection c;
    
    public DaoVeterinario() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Veterinario excluir(Veterinario vetEnt) throws SQLException{
        String sql = "delete from Veterinarios WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,vetEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return vetEnt;
    }
    
    public Veterinario buscar(Veterinario vetEnt) throws SQLException{
        String sql = "select * from veterinarios WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,vetEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Veterinario vetSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                vetSaida = new Veterinario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return vetSaida;
   }

    public Veterinario inserir(Veterinario vetEnt) throws SQLException{
        String sql = "insert into veterinarios" + " (tempo_atuacao, especialidade)" + " values (?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,vetEnt.getTempo());
        stmt.setString(2,vetEnt.getEspecialidade());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            vetEnt.setId(id);
        }
        stmt.close();
        return vetEnt;
    }

    public Veterinario alterar(Veterinario vetEnt) throws SQLException{
        String sql = "UPDATE veterinarios SET tempo_atuacao = ?, especialidade = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,vetEnt.getTempo());
        stmt.setString(2,vetEnt.getEspecialidade());
        stmt.setInt(3,vetEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return vetEnt;
    }

   public List<Veterinario> listar(Veterinario vetEnt) throws SQLException{
        // usus: array armazena a lista de registros

        List<Veterinario> listavets = new ArrayList<>();
        
        String sql = "select * from veterinarios where tempo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + vetEnt.getTempo() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Veterinario vet = new Veterinario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3)
            );
            // adiciona o usu à lista de usus
            listavets.add(vet);
        }
        
        rs.close();
        stmt.close();
        return listavets;
   
   }
}
