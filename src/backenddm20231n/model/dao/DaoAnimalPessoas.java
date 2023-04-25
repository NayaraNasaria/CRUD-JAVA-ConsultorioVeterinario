/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.dao;

import backenddm20231n.model.bean.AnimalPessoas;
import backenddm20231n.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nayar
 */
public class DaoAnimalPessoas {
    		private final Connection c;
		    
		    public DaoAnimalPessoas() throws SQLException, ClassNotFoundException{
		        this.c = ConexaoDb.getConexaoMySQL();
		    }

		    public AnimalPessoas excluir(AnimalPessoas animalpesEnt) throws SQLException{
		        String sql = "delete from animais_pessoas WHERE id = ?";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql);
		        // seta os valores
		        stmt.setInt(1,animalpesEnt.getId());
		        // executa
		        stmt.execute();
		        stmt.close();
		        c.close();
		        return animalpesEnt;
		    }
		    
		    public AnimalPessoas buscar(AnimalPessoas animalpesEnt) throws SQLException{
		        String sql = "select * from animais_pessoas WHERE id = ?";
		        PreparedStatement stmt = this.c.prepareStatement(sql);
		            // seta os valores
		            stmt.setInt(1,animalpesEnt.getId());
		            // executa
		            ResultSet rs = stmt.executeQuery();
		            AnimalPessoas animalpesSaida = null;
		            while (rs.next()) {      
		            // criando o objeto Usuario
		                animalpesSaida = new AnimalPessoas(
		                    rs.getInt(1),
		                    rs.getInt(2),
		                    rs.getInt(3),
		                    rs.getString(4));
		            // adiciona o usu à lista de usus
		            }
		            stmt.close();
		        return animalpesSaida;
		   }

		    public AnimalPessoas inserir(AnimalPessoas animalpesEnt) throws SQLException{
		        String sql = "insert into animais_pessoas" + " (idA, idP, obs)" + " values (?,?,?)";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

		        // seta os valores
		        stmt.setInt(1,animalpesEnt.getIdAnimal());
		        stmt.setInt(2,animalpesEnt.getIdPessoa());
		        stmt.setString(3,animalpesEnt.getObs());

		        // executa
		        stmt.executeUpdate();
		        ResultSet rs = stmt.getGeneratedKeys();
		        if (rs.next()) {
		            int id = rs.getInt(1);
		            animalpesEnt.setId(id);
		        }
		        stmt.close();
		        return animalpesEnt;
		    }

		    public AnimalPessoas alterar(AnimalPessoas animalpesEnt) throws SQLException{
		        String sql = "UPDATE animais_pessoas SET idA = ?, idP = ?, obs = ? WHERE id = ?";
		        // prepared statement para inserção
		        PreparedStatement stmt = c.prepareStatement(sql);
		        // seta os valores
		        stmt.setInt(1,animalpesEnt.getIdAnimal());
		        stmt.setInt(2,animalpesEnt.getIdPessoa());
		        stmt.setString(3,animalpesEnt.getObs());
		        stmt.setInt(4,animalpesEnt.getId());

		        // executa
		        stmt.execute();
		        stmt.close();
		        return animalpesEnt;
		    }

		   public List<AnimalPessoas> listar(AnimalPessoas animalpesEnt) throws SQLException{
		        // usus: array armazena a lista de registros

		        List<AnimalPessoas> pesanimals = new ArrayList<>();
		        
		        String sql = "select * from animais_pessoas where obs like ?";
		        PreparedStatement stmt = this.c.prepareStatement(sql);
		        // seta os valores
		        stmt.setString(1,"%" + animalpesEnt.getObs()+ "%");
		        
		        ResultSet rs = stmt.executeQuery();
		        
		        while (rs.next()) {      
		            // criando o objeto Usuario
		            AnimalPessoas pesanimal = new AnimalPessoas(
		                rs.getInt(1),
		                rs.getInt(2),
		                rs.getInt(3),
		                rs.getString(4));
		            // adiciona o usu à lista de usus
		            pesanimals.add(pesanimal);
		        }
		        
		        rs.close();
		        stmt.close();
		        return pesanimals;
		   
		   }
}
