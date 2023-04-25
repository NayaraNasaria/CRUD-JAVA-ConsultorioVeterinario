package backenddm20231n.model.bean;

public class Veterinario {
	private int id;
    private String tempo;
    private String especialidade;
    
    
    public Veterinario(int id) {
		super();
		this.id = id;
	}

	public Veterinario(String tempo) {
		super();
		this.tempo = tempo;
	}

	public Veterinario(String tempo, String especialidade) {
		super();
		this.tempo = tempo;
		this.especialidade = especialidade;
	}

	public Veterinario(int id, String tempo, String especialidade) {
		super();
		this.id = id;
		this.tempo = tempo;
		this.especialidade = especialidade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	@Override
    public String toString() {
        return "Veterinario{" + "id=" + id + ", Tempo de Atuação=" + tempo + ", Especialidade=" + especialidade + '}';
    }
}
