package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerVeterinario;
import backenddm20231n.model.bean.Veterinario;

public class ManterVeterinario {
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
        String tempo = JOptionPane.showInputDialog("TEMPO DE ATUAÇÃO");
        String especialidade = JOptionPane.showInputDialog("ESPECIALIDADE");
        Veterinario vetEnt = new Veterinario(tempo,especialidade);
        ControllerVeterinario contVet = new ControllerVeterinario();
        Veterinario vetSaida = contVet.inserir(vetEnt);
        JOptionPane.showMessageDialog(null,vetSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String tempo = JOptionPane.showInputDialog("TEMPO DE ATUAÇÃO");
        String especialidade = JOptionPane.showInputDialog("ESPECIALIDADE");
        Veterinario vetEnt = new Veterinario(id,tempo,especialidade);
        ControllerVeterinario contVet = new ControllerVeterinario();
        Veterinario vetSaida = contVet.alterar(vetEnt);
        JOptionPane.showMessageDialog(null,vetSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veterinario vetEnt = new Veterinario(id);
        ControllerVeterinario contVet = new ControllerVeterinario();
        Veterinario vetSaida = contVet.buscar(vetEnt);
        JOptionPane.showMessageDialog(null,vetSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Veterinario vetEnt = new Veterinario(id);
        ControllerVeterinario contVet = new ControllerVeterinario();
        Veterinario vetSaida = contVet.excluir(vetEnt);
        JOptionPane.showMessageDialog(null,vetSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String tempo = JOptionPane.showInputDialog("TEMPO DE ATUAÇÃO");
        Veterinario vetEnt = new Veterinario(tempo);
        ControllerVeterinario contVet = new ControllerVeterinario();
        List<Veterinario> listaVeterinario = contVet.listar(vetEnt);
        for (Veterinario vetSaida : listaVeterinario) {
            JOptionPane.showMessageDialog(null,vetSaida.toString());
        }
    }
}
