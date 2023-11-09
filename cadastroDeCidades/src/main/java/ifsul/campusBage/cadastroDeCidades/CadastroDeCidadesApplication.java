package ifsul.campusBage.cadastroDeCidades;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ifsul.campusBage.cadastroDeCidades.models.Cidade;
import ifsul.campusBage.cadastroDeCidades.repositories.CidadeRepository;

@SpringBootApplication
public class CadastroDeCidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeCidadesApplication.class, args);
	}

	/*
	 * @Bean public CommandLineRunner demo(CidadeRepository cidadeRepository) {
	 * return (args) -> { // Inserindo 3 cidades no banco de dados Cidade cidade1 =
	 * new Cidade("Bagé", "RS"); Cidade cidade2 = new Cidade("Porto Alegre", "RS");
	 * Cidade cidade3 = new Cidade("Florianópolis", "SC"); Cidade cidade4 = new
	 * Cidade("Boston", "Massachusetts"); Cidade cidade5 = new
	 * Cidade("Philadelphia", "Pensilvania"); cidadeRepository.save(cidade1);
	 * cidadeRepository.save(cidade2); cidadeRepository.save(cidade3);
	 * cidadeRepository.save(cidade4); cidadeRepository.save(cidade5);
	 * System.out.println("Cidades inseridas no banco de dados!"); }; }
	 **/

	/*
	 * @Bean public CommandLineRunner demo(CidadeRepository cidadeRepository) {
	 * return (args) -> { // Consultando a cidade de id=2 do banco de dados
	 * Optional<Cidade> cidadeOpt = cidadeRepository.findById(4L); if
	 * (cidadeOpt.get() != null) { Cidade cidade = cidadeOpt.get();
	 * System.out.println("cidade: id = " + cidade.getId());
	 * System.out.println(cidade.getNome() + " de " + cidade.getEstado()); } else {
	 * System.out.println("cidade não encontrada para este id"); } }; }
	 **/
	/*
	 * @Bean public CommandLineRunner demo(CidadeRepository cidadeRepository) {
	 * return (args) -> { // Consultando a cidade de id=1 do banco de dados
	 * Optional<Cidade> cidadeOpt = cidadeRepository.findById(1L); if
	 * (cidadeOpt.get() != null) { Cidade cidade = cidadeOpt.get();
	 * cidade.setNome("Bagé - Rainha da Fronteira"); cidadeRepository.save(cidade);
	 * } else { System.out.println("cidade não encontrada para este id"); } }; }
	 **/
	/*@Bean
	public CommandLineRunner demo(CidadeRepository cidadeRepository) {
		return (args) -> {

			List<Cidade> listaCidades = (List<Cidade>) cidadeRepository.findAll();

			for (Cidade c : listaCidades) {
				System.out.println("id: " + c.getId() + " - nome: " + c.getNome());
			}
		};
	}**/
	/*@Bean public CommandLineRunner demo(CidadeRepository cidadeRepository) {
		 return (args) -> { // Consultando a cidade de id=1 do banco de dados
			 cidadeRepository.deleteById(2L);
			 
			 System.out.println("cidade apagada!");
			 
          
	     };
    }**/
	/*@Bean 
	public CommandLineRunner demo(CidadeRepository cidadeRepository) {
		return (args) -> {
			
			System.out.println("xtrou");
			Optional<Cidade> cidadeOpt = cidadeRepository.findById(4L);
			Cidade cidade = cidadeOpt.get();
			cidadeRepository.delete(cidade);
			System.out.println("Cidade apagada");
		};
	}**/
	@Bean
	public CommandLineRunner demo(CidadeRepository cidadeRepository) {
		return (args) -> {

			List<Cidade> listaCidades = (List<Cidade>) cidadeRepository.listarTodasExcetoSP_RJ_SC();

			for (Cidade c : listaCidades) {
				System.out.println("id: " + c.getId() + " - nome: " + c.getNome());
			}
		};
	}
}