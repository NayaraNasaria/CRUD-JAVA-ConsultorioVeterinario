/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.controller;

import backenddm20231n.model.bean.Pessoa;
import backenddm20231n.model.bean.Animal;
import backenddm20231n.model.bean.AnimalPessoas;
import backenddm20231n.model.dao.DaoAnimalPessoas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nayar
 */
public class ControllerAnimaisPessoas {
    ControllerAnimal contAnimal;
    ControllerPessoa contPes;
    DaoAnimalPessoas daoAnimalPes;
	    
	    public AnimalPessoas inserir(AnimalPessoas AnimalPesEnt) throws SQLException, ClassNotFoundException {
	        daoAnimalPes = new DaoAnimalPessoas();
	        AnimalPesEnt = daoAnimalPes.inserir(AnimalPesEnt);
	        return AnimalPesEnt;
	    }

	    public AnimalPessoas alterar(AnimalPessoas AnimalPesEnt) throws SQLException, ClassNotFoundException {
	        daoAnimalPes = new DaoAnimalPessoas();
	        AnimalPesEnt = daoAnimalPes.alterar(AnimalPesEnt);
	        return AnimalPesEnt;
	    }

	    public List<AnimalPessoas> listar(AnimalPessoas AnimalPesEnt) throws SQLException, ClassNotFoundException {
	        daoAnimalPes = new DaoAnimalPessoas();
	        List<AnimalPessoas> listaUsuPesRetornoAux = daoAnimalPes.listar(AnimalPesEnt);
	        List<AnimalPessoas> listaUsuPesRetorno = new ArrayList<>();
	               
	        for(AnimalPessoas usupes : listaUsuPesRetornoAux) {        
	            listaUsuPesRetorno.add(buscar(usupes));
	        }

	        return listaUsuPesRetorno;
	    }

	    public AnimalPessoas excluir(AnimalPessoas AnimalPesEnt) throws SQLException, ClassNotFoundException {
	        daoAnimalPes = new DaoAnimalPessoas();
	        AnimalPesEnt = daoAnimalPes.excluir(AnimalPesEnt);
	        return AnimalPesEnt;
	    }

	    public AnimalPessoas buscar(AnimalPessoas AnimalPesEnt) throws SQLException, ClassNotFoundException {

	        daoAnimalPes = new DaoAnimalPessoas();
	        AnimalPessoas AnimalPesSaida = daoAnimalPes.buscar(AnimalPesEnt);

	        Animal animalEnt = new Animal(AnimalPesSaida.getIdAnimal());
	        contAnimal = new ControllerAnimal();
	        AnimalPesSaida.setAnimal(contAnimal.buscar(animalEnt));
	        
	        Pessoa pes = new Pessoa(AnimalPesSaida.getIdPessoa());
	        contPes = new ControllerPessoa();
	        AnimalPesSaida.setPes(contPes.buscar(pes));

	        return AnimalPesSaida;
	    }
}
