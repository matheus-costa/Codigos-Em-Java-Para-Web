package ifsul.campusBage.cadastroDeCidades.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ifsul.campusBage.cadastroDeCidades.models.Bairro;
import ifsul.campusBage.cadastroDeCidades.models.Cidade;

public interface BairroRepository extends CrudRepository<Bairro, Long> {
    
	   @Query(value = "SELECT * FROM public.cidade WHERE estado NOT IN ('RJ','SP', 'SC' )", nativeQuery = true)	
	   List<Bairro> listarTodasExcetoSP_RJ_SC();
	   
	    
}

