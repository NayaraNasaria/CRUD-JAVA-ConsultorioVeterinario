package backenddm20231n.controller;

import java.sql.SQLException;
import java.util.List;

import backenddm20231n.model.bean.Consulta;
import backenddm20231n.model.dao.DaoConsulta;

public class ControllerConsulta {
	DaoConsulta daoCons;
    
    public Consulta inserir(Consulta consEnt) throws SQLException, ClassNotFoundException {
        daoCons = new DaoConsulta();
        Consulta consSaida = daoCons.inserir(consEnt);
        return consSaida;
    }

    public Consulta alterar(Consulta consEnt) throws SQLException, ClassNotFoundException {
        daoCons = new DaoConsulta();
        Consulta consSaida = daoCons.alterar(consEnt);
        return consSaida;
    }

    public Consulta buscar(Consulta consEnt) throws SQLException, ClassNotFoundException {
        daoCons = new DaoConsulta();
        Consulta consSaida = daoCons.buscar(consEnt);
        return consSaida;
    }

    public Consulta excluir(Consulta consEnt) throws SQLException, ClassNotFoundException {
        daoCons = new DaoConsulta();
        Consulta consSaida = daoCons.excluir(consEnt);
        return consSaida;
    }

    public List<Consulta> listar(Consulta consEnt) throws SQLException, ClassNotFoundException {
        daoCons = new DaoConsulta();
        List<Consulta> listaConsulta = daoCons.listar(consEnt);
        return listaConsulta;


    }
}
