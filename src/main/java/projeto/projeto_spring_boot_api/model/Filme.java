package projeto.projeto_spring_boot_api.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_filme")
public class Filme {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String titulo;
    private int anoLancamento;
    private String[] generos;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Diretor diretor;
    private int duracaoMinutos;

    // Construtor
    public Filme(String titulo, int anoLancamento, String[] generos, Diretor diretor, int duracaoMinutos) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.generos = generos;
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }
    
    public Filme() {
    	
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    // Método para exibir informações do filme
    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Ano de Lançamento: " + anoLancamento);
        System.out.println("Gêneros: " + String.join(", ", generos));
        System.out.println("Diretor: " + diretor);
        System.out.println("Duração: " + duracaoMinutos + " minutos");
    }
}