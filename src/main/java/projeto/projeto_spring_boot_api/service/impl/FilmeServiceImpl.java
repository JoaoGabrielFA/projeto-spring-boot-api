package projeto.projeto_spring_boot_api.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import projeto.projeto_spring_boot_api.model.Filme;
import projeto.projeto_spring_boot_api.repository.FilmeRepository;
import projeto.projeto_spring_boot_api.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService{

	private final FilmeRepository filmeRepository;
	
	FilmeServiceImpl(FilmeRepository filmeRepository){
		this.filmeRepository = filmeRepository;
	}
	
	@Override
	public Filme findById(int id) {
		// TODO Auto-generated method stub
		return filmeRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Filme create(Filme filmeToCreate) {
		if(filmeRepository.existsById(filmeToCreate.getId())) {
			throw new IllegalArgumentException("ID do Filme já cadastrado!");
		}
		return filmeRepository.save(filmeToCreate);
	}

}
