/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backenddm20231n;

import backenddm20231n.view.ManterAnimaisPessoas;
import backenddm20231n.view.ManterAnimal;
import backenddm20231n.view.ManterConsulta;
import backenddm20231n.view.ManterPessoa;
import backenddm20231n.view.ManterUsuario;
import backenddm20231n.view.ManterUsuariosPessoas;
import backenddm20231n.view.ManterVeterinario;
import backenddm20231n.view.ManterVeterinarioPessoas;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BackEndDm20231n {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = "Bem vindo à Clínica Dr. Do Little \n"
                    + " 0 - Sair \n 1 - Usuario \n 2 - Pessoa"
        		+ "\n 3 - Usuario - Pessoa \n 4 - Animal \n 5 - Consulta \n 6 - Veterinário \n 7 - Veterinario - Pessoa \n"
                + " 8 - Animal - Pessoas ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterPessoa.menu();
                break;
            case 3:
                ManterUsuariosPessoas.menu();
                break;
                
            case 4:
                ManterAnimal.menu();
                break;
                
            case 5:
                ManterConsulta.menu();
                break;
             
            case 6:
                ManterVeterinario.menu();
                break;
                
            case 7:
                ManterVeterinarioPessoas.menu();
                break;
                
            case 8:
                ManterAnimaisPessoas.menu();
                
            default:
                System.out.println("Opção inválido");
        }
    }
    
}
