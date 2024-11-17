package projeto.projeto_spring_boot_api.service;

import projeto.projeto_spring_boot_api.model.Filme;

public interface FilmeService {
	Filme findById(int id);
	Filme create(Filme filmeToCreate);
}
