package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CSP;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Domain;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;

public class MapHorario extends CSP<Variable, String> {

	public static final String TRABALHA = "TRABALHA";
        
	public Boolean trabalha;
       
	public HashMap<String, Funcionario> Funcionarios = new HashMap<>();
       
        public ArrayList<String> nomeDosFuncionarios = new ArrayList();
       
	public MapHorario(
                HashMap<String, Funcionario> funcionarios
        ) {
                super(CommonDomain.generateCommonDomainHorarios());

                ArrayList communDomain = CommonDomain.generateCommonDomainHorarios();
                
		this.Funcionarios = funcionarios;
               	
                List<Domain> list = new ArrayList<>();
                
                for (Funcionario funcionario : funcionarios.values()) {
                    Domain DomainFuncionario = new DomainFuncionarios(
                            funcionario.getName(),
                            communDomain,
                            funcionario.horasDeTrabalho,
                            funcionario.horasPreferenciais
                    );
                    
                    for (Variable var : getVariables()){
                        setDomain(var, DomainFuncionario);
                    }
                    
                }

                List<String> nomeDosEmpregados = new ArrayList<>();
		
		for (String name : funcionarios.keySet()) {
			nomeDosEmpregados.add(name);
		}

		Domain<String> nomes = new Domain<>(nomeDosEmpregados);

		for (Variable var : getVariables())
			setDomain(var, nomes);
                
	}

}
