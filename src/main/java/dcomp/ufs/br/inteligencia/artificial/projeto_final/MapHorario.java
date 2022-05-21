package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CSP;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Domain;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;

public class MapHorario extends CSP<Variable, String> {

	public static final Variable HORA_01 = new Variable("H1");
	public static final Variable HORA_02 = new Variable("H2");
	public static final Variable HORA_03 = new Variable("H3");
	public static final Variable HORA_04 = new Variable("H4");
	public static final Variable HORA_05 = new Variable("H5");
	public static final Variable HORA_06 = new Variable("H6");
	public static final Variable HORA_07 = new Variable("H7");
	public static final Variable HORA_08 = new Variable("H8");
	public static final Variable HORA_09 = new Variable("H9");
	public static final Variable HORA_10 = new Variable("H10");
	public static final Variable HORA_11 = new Variable("H11");
	public static final Variable HORA_12 = new Variable("H12");
	public static final Variable HORA_13 = new Variable("H13");
	public static final Variable HORA_14 = new Variable("H14");
	public static final Variable HORA_15 = new Variable("H15");
	public static final Variable HORA_16 = new Variable("H16");
	public static final Variable HORA_17 = new Variable("H17");
	public static final Variable HORA_18 = new Variable("H18");
	public static final Variable HORA_19 = new Variable("H19");
	public static final Variable HORA_20 = new Variable("H20");
	public static final Variable HORA_21 = new Variable("H21");
	public static final Variable HORA_22 = new Variable("H22");
	public static final Variable HORA_23 = new Variable("H23");
	public static final Variable HORA_24 = new Variable("H24");
	
	public static final String OCUPADO = "OCUPADO";
        public static final String HORARIO_PERMITIDO = "HORARIO_PERMITIDO";
	
	public Boolean ocupado;
        public Boolean horario_permitido;
       
	
	public HashMap<String, Integer> horasDeTrabalhoDosFuncionarios = new HashMap<>();

	public MapHorario(HashMap<String, Integer> horasDeTrabalhoDosFuncionarios) {

		super(Arrays.asList(
				HORA_01,
				HORA_02,
				HORA_03,
				HORA_04,
				HORA_05,
				HORA_06,
				HORA_07,
				HORA_08,
				HORA_09,
				HORA_10,
				HORA_11,
				HORA_12,
				HORA_13,
				HORA_14,
				HORA_15,
				HORA_16,
				HORA_17,
				HORA_18,
				HORA_19,
				HORA_20,
				HORA_21,
				HORA_22,
				HORA_23,
				HORA_24
				));

		this.horasDeTrabalhoDosFuncionarios = horasDeTrabalhoDosFuncionarios;
		
		List<String> tempoDeTrabalho = new ArrayList<>();
		
		for (String horas : horasDeTrabalhoDosFuncionarios.keySet()) {
			tempoDeTrabalho.add(horas);
		}

		Domain<String> horarios = new Domain<>(tempoDeTrabalho);

		for (Variable var : getVariables())
			setDomain(var, horarios);
		
		horasDeTrabalhoDosFuncionarios.put(OCUPADO, 24);

	}

}
