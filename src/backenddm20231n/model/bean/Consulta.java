package backenddm20231n.model.bean;

public class Consulta {
    private int id;
    private String dia;
    private String hora;
    private String clinica;
    private int vet;
    private int animal;
    private String prontuario;

    public Consulta(int id) {
		super();
		this.id = id;
	}

	public Consulta(String dia) {
		super();
		this.dia = dia;
	}


    public Consulta(int id, String dia, String hora, String clinica, int vet, int animal, String prontuario) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
        this.clinica = clinica;
        this.vet = vet;
        this.animal = animal;
        this.prontuario = prontuario;
    }

    public Consulta(String dia, String hora, String clinica, int vet, int animal, String prontuario) {
        this.dia = dia;
        this.hora = hora;
        this.clinica = clinica;
        this.vet = vet;
        this.animal = animal;
        this.prontuario = prontuario;
    }
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public int getVet() {
		return vet;
	}

	public void setVet(int vet) {
		this.vet = vet;
	}

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

        
    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
        
        

	@Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", Dia da Consulta=" + dia + 
        		", Hora da Consulta=" + hora + ", Clínica=" + clinica + ", Dr. Veterinário=" + vet + '}'
               + ", Animal=" + animal + '}' + ", Prontuário=" + prontuario + '}';
    }
}
