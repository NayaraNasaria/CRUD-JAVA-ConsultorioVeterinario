package backenddm20231n.model.bean;

public class Animal {
    private int id;
    private String animal;
    private String raca;
    private String peso;
    private String doenca;

    public Animal(int id) {
		super();
		this.id = id;
	}
    
    public Animal(String animal) {
		super();
		this.animal = animal;
	}
    
	public Animal(String animal, String raca, String peso, String doenca) {
		super();
		this.animal = animal;
		this.raca = raca;
		this.peso = peso;
		this.doenca = doenca;
	}

	public Animal(int id, String animal, String raca, String peso, String doenca) {
		super();
		this.id = id;
		this.animal = animal;
		this.raca = raca;
		this.peso = peso;
		this.doenca = doenca;
	}

 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}


	@Override
    public String toString() {
        return "Animal{" + "id=" + id + ", animal=" + animal + ", raca=" + raca + ", peso=" + peso 
        		+ ", doenca=" + doenca;
    }
}
