package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Veterinario;
import backenddm20231n.model.dao.DaoVeterinario;

public class ControllerVeterinario {
	DaoVeterinario daoVet;
    
    public Veterinario inserir(Veterinario vetEnt) throws SQLException, ClassNotFoundException {
        daoVet = new DaoVeterinario();
        Veterinario vetSaida = daoVet.inserir(vetEnt);
        return vetSaida;
    }

    public Veterinario alterar(Veterinario vetEnt) throws SQLException, ClassNotFoundException {
        daoVet = new DaoVeterinario();
        Veterinario vetSaida = daoVet.alterar(vetEnt);
        return vetSaida;
    }

    public Veterinario buscar(Veterinario vetEnt) throws SQLException, ClassNotFoundException {
        daoVet = new DaoVeterinario();
        Veterinario vetSaida = daoVet.buscar(vetEnt);
        return vetSaida;
    }

    public Veterinario excluir(Veterinario vetEnt) throws SQLException, ClassNotFoundException {
        daoVet = new DaoVeterinario();
        Veterinario vetSaida = daoVet.excluir(vetEnt);
        return vetSaida;
    }

    public List<Veterinario> listar(Veterinario vetEnt) throws SQLException, ClassNotFoundException {
        daoVet = new DaoVeterinario();
        List<Veterinario> listaVeterinario = daoVet.listar(vetEnt);
        return listaVeterinario;


    }
}
