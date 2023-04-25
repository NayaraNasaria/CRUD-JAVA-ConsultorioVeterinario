/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.view;

import backenddm20231n.controller.ControllerAnimaisPessoas;
import backenddm20231n.model.bean.AnimalPessoas;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nayar
 */
public class ManterAnimaisPessoas {
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
        int idA = Integer.parseInt(JOptionPane.showInputDialog("ID Animal"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
        String obs = JOptionPane.showInputDialog("OBS");
        AnimalPessoas animalpesEnt = new AnimalPessoas(idA,idP,obs);
        ControllerAnimaisPessoas contPV = new ControllerAnimaisPessoas();
        AnimalPessoas paSaida = contPV.inserir(animalpesEnt);
        JOptionPane.showMessageDialog(null,paSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
    	int idA = Integer.parseInt(JOptionPane.showInputDialog("ID Animal"));
        int idP = Integer.parseInt(JOptionPane.showInputDialog("ID Pessoa"));
        String obs = JOptionPane.showInputDialog("OBS");
        AnimalPessoas animalpesEnt =  new AnimalPessoas(id,idA,idP,obs);
        ControllerAnimaisPessoas contPV = new ControllerAnimaisPessoas();
        AnimalPessoas paSaida = contPV.alterar(animalpesEnt);
        JOptionPane.showMessageDialog(null,paSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        AnimalPessoas animalpesEnt = new AnimalPessoas(id);
        ControllerAnimaisPessoas contPV = new ControllerAnimaisPessoas();
        AnimalPessoas paSaida = contPV.buscar(animalpesEnt);
        JOptionPane.showMessageDialog(null,paSaida.toString());
        JOptionPane.showMessageDialog(null,paSaida.getAnimal().toString());
        JOptionPane.showMessageDialog(null,paSaida.getPes().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        AnimalPessoas animalpesEnt = new AnimalPessoas(id);
        ControllerAnimaisPessoas contPV = new ControllerAnimaisPessoas();
        AnimalPessoas paSaida = contPV.excluir(animalpesEnt);
        JOptionPane.showMessageDialog(null,paSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        AnimalPessoas animalpesEnt = new AnimalPessoas(obs);
        ControllerAnimaisPessoas contPV = new ControllerAnimaisPessoas();
        List<AnimalPessoas> listaPessoasVeterinarios = contPV.listar(animalpesEnt);
        for (AnimalPessoas paSaida : listaPessoasVeterinarios) {
            JOptionPane.showMessageDialog(null,paSaida.toString());
            JOptionPane.showMessageDialog(null,paSaida.getAnimal().toString());
           JOptionPane.showMessageDialog(null,paSaida.getPes().toString());
        }
    }
}
