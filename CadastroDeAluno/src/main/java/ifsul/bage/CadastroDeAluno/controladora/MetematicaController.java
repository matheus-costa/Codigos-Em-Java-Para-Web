package ifsul.bage.CadastroDeAluno.controladora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MetematicaController {
	
	
	@GetMapping("/matematica")
	public String calcularmaior(Model model,
			                   @RequestParam("n1") double valor1,
			                   @RequestParam("n2") double valor2) {
		double maior = 0;
	    String iguais ="";

	   

		if(valor1 > valor2) {
			maior = valor1;
			
		}else if (valor1 < valor2) {
			maior = valor2;
			
	    }else {
	    	
              iguais = "Estes valores são iguais";
	    }
		
		
		 model.addAttribute("n1",valor1);
		    model.addAttribute("n2",valor2);
		    model.addAttribute("maiornum",maior);
		    model.addAttribute("iguais",iguais);
		    
		    
		return "matematica.jsp";
	}
}
