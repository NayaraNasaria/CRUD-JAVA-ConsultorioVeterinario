package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerConsulta;
import backenddm20231n.model.bean.Consulta;
import javax.swing.JDialog;

public class ManterConsulta {
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
        String dia = JOptionPane.showInputDialog("DIA DA CONSULTA");
        String hora = JOptionPane.showInputDialog("HORA DA CONSULTA");
        JDialog.setDefaultLookAndFeelDecorated(true);
        Object[] selectionValues = { "Vila Mariana", "Vila Madalena", "Paraíso", "Tatuapé" };
        String initialSelection = "Tatuapé";
        Object clinica = JOptionPane.showInputDialog(null, "Qual clínica?",
        "CLÍNICA", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
        int vet = Integer.parseInt(JOptionPane.showInputDialog("QUAL O ID DO VETERINÁRIO"));
        int animal = Integer.parseInt(JOptionPane.showInputDialog("QUAL O ID DO ANIMAL"));
        String prontuario = JOptionPane.showInputDialog("PRONTUÁRIO");
        Consulta consEnt = new Consulta(dia,hora,(String) clinica,vet,animal, prontuario);
        ControllerConsulta contCons = new ControllerConsulta();
        Consulta consSaida = contCons.inserir(consEnt);
        JOptionPane.showMessageDialog(null,consSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String dia = JOptionPane.showInputDialog("DIA DA CONSULTA");
        String hora = JOptionPane.showInputDialog("HORA DA CONSULTA");
        String clinica = JOptionPane.showInputDialog("CLÍNICA");
        int vet = Integer.parseInt(JOptionPane.showInputDialog("QUAL O ID DO VETERINÁRIO"));
        int animal = Integer.parseInt(JOptionPane.showInputDialog("QUAL O ID DO ANIMAL"));
        String prontuario = JOptionPane.showInputDialog("PRONTUÁRIO");
        Consulta consEnt = new Consulta(id, dia,hora,(String) clinica,vet, animal, prontuario);
        ControllerConsulta contCons = new ControllerConsulta();
        Consulta consSaida = contCons.alterar(consEnt);
        JOptionPane.showMessageDialog(null,consSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Consulta consEnt = new Consulta(id);
        ControllerConsulta contCons = new ControllerConsulta();
        Consulta consSaida = contCons.buscar(consEnt);
        JOptionPane.showMessageDialog(null,consSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Consulta consEnt = new Consulta(id);
        ControllerConsulta contCons = new ControllerConsulta();
        Consulta consSaida = contCons.excluir(consEnt);
        JOptionPane.showMessageDialog(null,consSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String dia = JOptionPane.showInputDialog("DIA DA CONSULTA");
        Consulta consEnt = new Consulta(dia);
        ControllerConsulta contCons = new ControllerConsulta();
        List<Consulta> listaConsulta = contCons.listar(consEnt);
        for (Consulta consSaida : listaConsulta) {
            JOptionPane.showMessageDialog(null,consSaida.toString());
        }
    }
}
