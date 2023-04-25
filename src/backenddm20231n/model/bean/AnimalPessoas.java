/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddm20231n.model.bean;

/**
 *
 * @author nayar
 */
public class AnimalPessoas {
    private int id;
    private int idAnimal;
    private int idPessoa;
    private String obs;
    private Animal animal;
    private Pessoa pes;

    public AnimalPessoas(int id) {
        this.id = id;
    }

    public AnimalPessoas(String obs) {
        this.obs = obs;
    }

    public AnimalPessoas(int idAnimal, int idPessoa, String obs) {
        this.idAnimal = idAnimal;
        this.idPessoa = idPessoa;
        this.obs = obs;
    }

    public AnimalPessoas(int idAnimal, int idPessoa, String obs, Animal animal, Pessoa pes) {
        this.idAnimal = idAnimal;
        this.idPessoa = idPessoa;
        this.obs = obs;
        this.animal = animal;
        this.pes = pes;
    }

    public AnimalPessoas(int id, int idAnimal, int idPessoa, String obs, Animal animal, Pessoa pes) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.idPessoa = idPessoa;
        this.obs = obs;
        this.animal = animal;
        this.pes = pes;
    }

    public AnimalPessoas(int id, int idAnimal, int idPessoa, String obs) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.idPessoa = idPessoa;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(Pessoa pes) {
        this.pes = pes;
    }
    
    @Override
    public String toString() {
        return "AnimalPessoas{" + "id=" + id + ", idAnimal=" + idAnimal + ", idPessoa=" + idPessoa + ", obs=" + obs + '}';
    }
    
}
