package backenddm20231n.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.VeterinariosPessoas;
import backenddm20231n.util.ConexaoDb;

public class DaoVeterinariosPessoas {

		private final Connection c;
		    
		    public DaoVeterinariosPessoas() throws SQLException, ClassNotFoundException{
		        this.c = ConexaoDb.getConexaoMySQL();
		    }

		    public VeterinariosPessoas excluir(VeterinariosPessoas vetpesEnt) throws SQLException{
		        String sql = "delete from veterinarios_pessoas WHERE id = ?";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql);
		        // seta os valores
		        stmt.setInt(1,vetpesEnt.getId());
		        // executa
		        stmt.execute();
		        stmt.close();
		        c.close();
		        return vetpesEnt;
		    }
		    
		    public VeterinariosPessoas buscar(VeterinariosPessoas vetpesEnt) throws SQLException{
		        String sql = "select * from veterinarios_pessoas WHERE id = ?";
		        PreparedStatement stmt = this.c.prepareStatement(sql);
		            // seta os valores
		            stmt.setInt(1,vetpesEnt.getId());
		            // executa
		            ResultSet rs = stmt.executeQuery();
		            VeterinariosPessoas usupesSaida = null;
		            while (rs.next()) {      
		            // criando o objeto Usuario
		                usupesSaida = new VeterinariosPessoas(
		                    rs.getInt(1),
		                    rs.getInt(2),
		                    rs.getInt(3),
		                    rs.getString(4));
		            // adiciona o usu à lista de usus
		            }
		            stmt.close();
		        return usupesSaida;
		   }

		    public VeterinariosPessoas inserir(VeterinariosPessoas vetpesEnt) throws SQLException{
		        String sql = "insert into veterinarios_pessoas" + " (idV, idP, obs)" + " values (?,?,?)";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

		        // seta os valores
		        stmt.setInt(1,vetpesEnt.getIdVeterinario());
		        stmt.setInt(2,vetpesEnt.getIdPessoa());
		        stmt.setString(3,vetpesEnt.getObs());

		        // executa
		        stmt.executeUpdate();
		        ResultSet rs = stmt.getGeneratedKeys();
		        if (rs.next()) {
		            int id = rs.getInt(1);
		            vetpesEnt.setId(id);
		        }
		        stmt.close();
		        return vetpesEnt;
		    }

		    public VeterinariosPessoas alterar(VeterinariosPessoas vetpesEnt) throws SQLException{
		        String sql = "UPDATE veterinarios_pessoas SET idV = ?, idP = ?, obs = ? WHERE id = ?";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql);
		        // seta os valores
		        stmt.setInt(1,vetpesEnt.getIdVeterinario());
		        stmt.setInt(2,vetpesEnt.getIdPessoa());
		        stmt.setString(3,vetpesEnt.getObs());
		        stmt.setInt(4,vetpesEnt.getId());

		        // executa
		        stmt.execute();
		        stmt.close();
		        return vetpesEnt;
		    }

		   public List<VeterinariosPessoas> listar(VeterinariosPessoas vetpesEnt) throws SQLException{
		        // usus: array armazena a lista de registros

		        List<VeterinariosPessoas> pesvets = new ArrayList<>();
		        
		        String sql = "select * from veterinarios_pessoas where obs like ?";
		        PreparedStatement stmt = this.c.prepareStatement(sql);
		        // seta os valores
		        stmt.setString(1,"%" + vetpesEnt.getObs()+ "%");
		        
		        ResultSet rs = stmt.executeQuery();
		        
		        while (rs.next()) {      
		            // criando o objeto Usuario
		            VeterinariosPessoas pesvet = new VeterinariosPessoas(
		                rs.getInt(1),
		                rs.getInt(2),
		                rs.getInt(3),
		                rs.getString(4));
		            // adiciona o usu à lista de usus
		            pesvets.add(pesvet);
		        }
		        
		        rs.close();
		        stmt.close();
		        return pesvets;
		   
		   }
}
