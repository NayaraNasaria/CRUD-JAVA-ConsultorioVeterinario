package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Animal;
import backenddm20231n.model.dao.daoAnimal;

public class ControllerAnimal {

	daoAnimal daoAnimal;

    public Animal inserir(Animal animalEnt) throws SQLException, ClassNotFoundException {
        daoAnimal = new daoAnimal();
        return daoAnimal.inserir(animalEnt);
    }

    public Animal alterar(Animal animalEnt) throws SQLException, ClassNotFoundException {
        daoAnimal = new daoAnimal();
        return daoAnimal.alterar(animalEnt);
    }

    public Animal buscar(Animal animalEnt) throws SQLException, ClassNotFoundException {
        daoAnimal = new daoAnimal();
        return daoAnimal.buscar(animalEnt);
    }

    public Animal excluir(Animal animalEnt) throws SQLException, ClassNotFoundException {
        daoAnimal = new daoAnimal();
        return daoAnimal.excluir(animalEnt);
    }

     public List<Animal> listar(Animal animalEnt) throws SQLException, ClassNotFoundException {
        daoAnimal = new daoAnimal();
        List<Animal> listaLog = daoAnimal.listar(animalEnt);
        return listaLog;
     }
}
