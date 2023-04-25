package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.Veterinario;
import backenddm20231n.model.bean.VeterinariosPessoas;
import backenddm20231n.model.dao.DaoVeterinariosPessoas;

	public class ControllerVeterinariosPessoas {
	    
	    ControllerVeterinario contVet;
	    ControllerPessoa contPes;
	    DaoVeterinariosPessoas daoVetPes;
	    
	    public VeterinariosPessoas inserir(VeterinariosPessoas vetPesEnt) throws SQLException, ClassNotFoundException {
	        daoVetPes = new DaoVeterinariosPessoas();
	        vetPesEnt = daoVetPes.inserir(vetPesEnt);
	        return vetPesEnt;
	    }

	    public VeterinariosPessoas alterar(VeterinariosPessoas vetPesEnt) throws SQLException, ClassNotFoundException {
	        daoVetPes = new DaoVeterinariosPessoas();
	        vetPesEnt = daoVetPes.alterar(vetPesEnt);
	        return vetPesEnt;
	    }

	    public List<VeterinariosPessoas> listar(VeterinariosPessoas vetPesEnt) throws SQLException, ClassNotFoundException {
	        daoVetPes = new DaoVeterinariosPessoas();
	        List<VeterinariosPessoas> listaUsuPesRetornoAux = daoVetPes.listar(vetPesEnt);
	        List<VeterinariosPessoas> listaUsuPesRetorno = new ArrayList<>();
	               
	        for(VeterinariosPessoas usupes : listaUsuPesRetornoAux) {        
	            listaUsuPesRetorno.add(buscar(usupes));
	        }

	        return listaUsuPesRetorno;
	    }

	    public VeterinariosPessoas excluir(VeterinariosPessoas vetPesEnt) throws SQLException, ClassNotFoundException {
	        daoVetPes = new DaoVeterinariosPessoas();
	        vetPesEnt = daoVetPes.excluir(vetPesEnt);
	        return vetPesEnt;
	    }

	    public VeterinariosPessoas buscar(VeterinariosPessoas vetPesEnt) throws SQLException, ClassNotFoundException {

	        daoVetPes = new DaoVeterinariosPessoas();
	        VeterinariosPessoas vetpesSaida = daoVetPes.buscar(vetPesEnt);

	        Veterinario vetEnt = new Veterinario(vetpesSaida.getIdVeterinario());
	        contVet = new ControllerVeterinario();
	        vetpesSaida.setVet(contVet.buscar(vetEnt));
	        
	        Pessoa pes = new Pessoa(vetpesSaida.getIdPessoa());
	        contPes = new ControllerPessoa();
	        vetpesSaida.setPes(contPes.buscar(pes));

	        return vetpesSaida;
	    }
}
