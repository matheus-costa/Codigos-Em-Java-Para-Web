package ifsul.campusBage.cadastroDeCidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ifsul.campusBage.cadastroDeCidades.models.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    
	   
	   
	   @Query(value = "SELECT nome, estado FROM cidade WHERE id = :id", nativeQuery = true)
	   Cidade buscarCidadeEstadoPorId(@Param("id") Long id);
	   
	   
	   @Query(value = "SELECT * FROM public.cidade WHERE estado NOT IN ('RJ','SP', 'SC' )", nativeQuery = true)	
	   List<Cidade> listarTodasExcetoSP_RJ_SC();
	   
	   List<Cidade> findByEstado(String estado);
	   Cidade save(Cidade c);
	   void delete();
	   void deleteById(Long id);
}

