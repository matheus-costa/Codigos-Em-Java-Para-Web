package ifsul.campusBage.cadastroDeCidades.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifsul.campusBage.cadastroDeCidades.models.Bairro;
import ifsul.campusBage.cadastroDeCidades.models.Cidade;
import ifsul.campusBage.cadastroDeCidades.repositories.BairroRepository;
import ifsul.campusBage.cadastroDeCidades.repositories.CidadeRepository;

@Controller
public class BairroController {

	@Autowired   //instancia e injeta neste atributo um objeto CidadeRepository
	BairroRepository bairroRepository;

	
	@GetMapping("/formBairro")
	public String exibirFormCadastrarBairro(Model model) {
		
		Bairro bairroAux = new Bairro();
		bairroAux.setNome("digite aqui");
		bairroAux.setPopulacao(0.0f);
		model.addAttribute("umBairro", bairroAux);
		
		return "form-bairro.jsp";
	}
	
	@PostMapping("/cadastrarBairro")
	public String inserirBairroNoBD(Model model, Bairro bairro) {
	    if (bairro != null && bairro.getPopulacao() != null) {
	        bairroRepository.save(bairro);
	        model.addAttribute("mensagem", "Bairro cadastrado com sucesso");
	    } else {
	        model.addAttribute("mensagem", "Erro ao cadastrar o bairro. A população não pode ser nula.");
	    }
	    return "form-bairro.jsp";
	}

	
	@GetMapping("/listarBairros")
	public String buscarTodosBairros(Model model) {
		
		List<Bairro> listaDeBairros = (List<Bairro>) bairroRepository.findAll();
		
		model.addAttribute("listaBairr", listaDeBairros);
		
		return "ListaBairro.jsp";
	}
}
