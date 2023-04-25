package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerVeterinariosPessoas;
import backenddm20231n.model.bean.VeterinariosPessoas;

public class ManterVeterinarioPessoas {
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        String obs = JOptionPane.showInputDialog("OBS");
        VeterinariosPessoas pvEnt = new VeterinariosPessoas(idV,idP,obs);
        ControllerVeterinariosPessoas contPV = new ControllerVeterinariosPessoas();
        VeterinariosPessoas pvSaida = contPV.inserir(pvEnt);
        JOptionPane.showMessageDialog(null,pvSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
    	int idV = Integer.parseInt(JOptionPane.showInputDialog("IDV"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("IDP"));
        String obs = JOptionPane.showInputDialog("OBS");
        VeterinariosPessoas pvEnt = new VeterinariosPessoas(id, idV,idP,obs);
        ControllerVeterinariosPessoas contPV = new ControllerVeterinariosPessoas();
        VeterinariosPessoas pvSaida = contPV.alterar(pvEnt);
        JOptionPane.showMessageDialog(null,pvSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        VeterinariosPessoas pvEnt = new VeterinariosPessoas(id);
        ControllerVeterinariosPessoas contPV = new ControllerVeterinariosPessoas();
        VeterinariosPessoas pvSaida = contPV.buscar(pvEnt);
        JOptionPane.showMessageDialog(null,pvSaida.toString());
        JOptionPane.showMessageDialog(null,pvSaida.getVet().toString());
        JOptionPane.showMessageDialog(null,pvSaida.getPes().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        VeterinariosPessoas pvEnt = new VeterinariosPessoas(id);
        ControllerVeterinariosPessoas contPV = new ControllerVeterinariosPessoas();
        VeterinariosPessoas pvSaida = contPV.excluir(pvEnt);
        JOptionPane.showMessageDialog(null,pvSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        VeterinariosPessoas pvEnt = new VeterinariosPessoas(obs);
        ControllerVeterinariosPessoas contPV = new ControllerVeterinariosPessoas();
        List<VeterinariosPessoas> listaPessoasVeterinarios = contPV.listar(pvEnt);
        for (VeterinariosPessoas pvSaida : listaPessoasVeterinarios) {
            JOptionPane.showMessageDialog(null,pvSaida.toString());
            JOptionPane.showMessageDialog(null,pvSaida.getVet().toString());
           JOptionPane.showMessageDialog(null,pvSaida.getPes().toString());
        }
    }
}
