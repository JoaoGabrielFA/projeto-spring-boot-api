package projeto.projeto_spring_boot_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.projeto_spring_boot_api.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Integer>{

}
