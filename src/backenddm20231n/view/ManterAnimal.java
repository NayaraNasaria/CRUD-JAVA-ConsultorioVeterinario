package backenddm20231n.view;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import backenddm20231n.controller.ControllerAnimal;
import backenddm20231n.model.bean.Animal;
import java.util.Random;

public class ManterAnimal {
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
    	String animal = JOptionPane.showInputDialog("ANIMAL");
        String raca = JOptionPane.showInputDialog("RAÇA");
        String peso = JOptionPane.showInputDialog("PESO");
        String doenca = JOptionPane.showInputDialog("DOENÇA");
        Animal animalEnt = new Animal(animal,raca,peso,doenca);
        ControllerAnimal contAnimal = new ControllerAnimal();
        Animal animalSaida = contAnimal.inserir(animalEnt);
        JOptionPane.showMessageDialog(null,animalSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String animal = JOptionPane.showInputDialog("ANIMAL");
        String raca = JOptionPane.showInputDialog("RAÇA");
        String peso = JOptionPane.showInputDialog("PESO");
        String doenca = JOptionPane.showInputDialog("DOENÇA");
        Animal animalEnt = new Animal(id,animal,raca,peso,doenca);
        ControllerAnimal contAnimal = new ControllerAnimal();
        Animal animalSaida = contAnimal.alterar(animalEnt);
        JOptionPane.showMessageDialog(null,animalSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Animal animalEnt = new Animal(id);
        ControllerAnimal contAnimal = new ControllerAnimal();
        Animal animalSaida = contAnimal.buscar(animalEnt);
        JOptionPane.showMessageDialog(null,animalSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Animal animalEnt = new Animal(id);
        ControllerAnimal contAnimal = new ControllerAnimal();
        Animal animalSaida = contAnimal.excluir(animalEnt);
        JOptionPane.showMessageDialog(null,animalSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String animal = JOptionPane.showInputDialog("ANIMAL");
        Animal animalEnt = new Animal(animal);
        ControllerAnimal animalUsu = new ControllerAnimal();
        List<Animal> listalogs = animalUsu.listar(animalEnt);
        for (Animal animalSaida : listalogs) {
            JOptionPane.showMessageDialog(null,animalSaida.toString());
        }
    }
}
