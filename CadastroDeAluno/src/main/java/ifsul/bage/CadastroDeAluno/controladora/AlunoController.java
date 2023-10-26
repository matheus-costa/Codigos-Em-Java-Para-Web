package ifsul.bage.CadastroDeAluno.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlunoController {

	@GetMapping("/calcular-media")

	public String calcularmedia(Model model,
			                   @RequestParam("notaP1") double valor1,
			                   @RequestParam("notaP2") double valor2) {
		double media = (valor1+valor2)/2;

		model.addAttribute("mediaCalculada",media);

		return "media.jsp";
	}
	@GetMapping("/validar-frequencia")

	public String calcularfrequencia(Model model,
            @RequestParam("nome") String nome,
            @RequestParam("faltas") int qntdfaltas) {

        String reprovado = "";

             if(qntdfaltas > 5) {
        	  reprovado = "reprovado";

        }
		model.addAttribute("nome",nome);
		model.addAttribute("qntdfaltas",qntdfaltas);
		model.addAttribute("calcularfrequencia",reprovado);




	    return "frequencia.jsp";
}
}