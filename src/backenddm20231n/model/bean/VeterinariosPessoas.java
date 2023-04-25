package backenddm20231n.model.bean;

public class VeterinariosPessoas {
    private int id;
    private int idVeterinario;
    private int idPessoa;
    private String obs;
    private Veterinario vet;
    private Pessoa pes;
    
    
    public VeterinariosPessoas(int id) {
		super();
		this.id = id;
	}

    
	public VeterinariosPessoas(String obs) {
		super();
		this.obs = obs;
	}
	

	public VeterinariosPessoas(int idVeterinario, int idPessoa, String obs) {
		super();
		this.idVeterinario = idVeterinario;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}


	public VeterinariosPessoas(int idVeterinario, int idPessoa, String obs, Veterinario vet, Pessoa pes) {
		super();
		this.idVeterinario = idVeterinario;
		this.idPessoa = idPessoa;
		this.obs = obs;
		this.vet = vet;
		this.pes = pes;
	}

	public VeterinariosPessoas(int id, int idVeterinario, int idPessoa, String obs, Veterinario vet, Pessoa pes) {
		super();
		this.id = id;
		this.idVeterinario = idVeterinario;
		this.idPessoa = idPessoa;
		this.obs = obs;
		this.vet = vet;
		this.pes = pes;
	}

	public VeterinariosPessoas(int id, int idVeterinario, int idPessoa, String obs) {
		super();
		this.id = id;
		this.idVeterinario = idVeterinario;
		this.idPessoa = idPessoa;
		this.obs = obs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
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

	public Veterinario getVet() {
		return vet;
	}

	public void setVet(Veterinario vet) {
		this.vet = vet;
	}

	public Pessoa getPes() {
		return pes;
	}

	public void setPes(Pessoa pes) {
		this.pes = pes;
	}

	@Override
    public String toString() {
        return "UsuarioPessoa{" + "id=" + id + ", idVeterinario=" + idVeterinario + ", idPessoa=" + idPessoa + ", obs=" + obs + '}';
    }
}
