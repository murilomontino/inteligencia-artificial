package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Scanner;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Assignment;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CSP;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CspListener;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.CspSolver;
import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;
import java.util.List;

public class MapHorarioCspDemo {
	static Scanner input = new Scanner(System.in);
        static ScannerListFuncionarios scanner = new ScannerListFuncionarios();
        
        // caso Horario -> Nome do Funcionario
        // carga do Funcionario -> Nome do Funcionario -> Carga Horário
        public void BackTracking(
                HashMap<Variable, String> caso, 
                HashMap<String, Integer> cargaDoFuncionario
        ){
	
		CSP<Variable, String> csp = new MapHorario(cargaDoFuncionario);
                
		CspListener.StepCounter<Variable, String> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, String> solver;
		Optional<Assignment<Variable, String>> solution;
		int cont = 0;

		solver = new FlexibleBacktrackingSolver<>();
		solver.addCspListener(stepCounter);
		stepCounter.reset();
		solution = solver.solve(csp, caso);

		if (solution.isPresent()) {
			String separador = ";";
			StringBuilder arquivoCsv = new StringBuilder();
			arquivoCsv.append("HORARIOS").append(separador);
			arquivoCsv.append("H1").append(separador);
			arquivoCsv.append("H2").append(separador);
			arquivoCsv.append("H3").append(separador);
			arquivoCsv.append("H4").append(separador);
			arquivoCsv.append("H5").append(separador);
			arquivoCsv.append("H6").append(separador);
                        arquivoCsv.append("H7").append(separador);
			arquivoCsv.append("H8").append(separador);
			arquivoCsv.append("H9").append(separador);
			arquivoCsv.append("H10").append(separador);
			arquivoCsv.append("H11").append(separador);
			arquivoCsv.append("H12").append(separador);
                        arquivoCsv.append("H13").append(separador);
			arquivoCsv.append("H14").append(separador);
			arquivoCsv.append("H15").append(separador);
			arquivoCsv.append("H16").append(separador);
			arquivoCsv.append("H17").append(separador);
			arquivoCsv.append("H18").append(separador);
                        arquivoCsv.append("H19").append(separador);
			arquivoCsv.append("H20").append(separador);
			arquivoCsv.append("H21").append(separador);
			arquivoCsv.append("H22").append(separador);
			arquivoCsv.append("H23").append(separador);
			arquivoCsv.append("H24").append(separador);
			arquivoCsv.append("\n");

			for (Variable v : solution.get().getVariables()) {
			
				arquivoCsv.append(solution.get().getValue(v)).append(separador);

				cont++;

				if (cont == 24) {
					arquivoCsv.append("\n");
					cont = 0;
				}
			}

			PrintWriter writer = null;

			try {
				writer = new PrintWriter(new File("horario.csv"));

				writer.write(arquivoCsv.toString());
				
				System.out.print("Planilha gerada com sucesso!!!");
				
				writer.flush();
				writer.close();
			} catch (IOException e) {
				System.out.print(e.getMessage());
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		} else {
			System.out.println(
					"ERRO: carga horaria livre menor que carga horaria necessaria para realizar as atividades.");
		}

	}

	static void setCasoDefault(HashMap<Variable, String> caso) {
		caso.put(MapHorario.HORA_01, "-");
		caso.put(MapHorario.HORA_02, "-");
		caso.put(MapHorario.HORA_03, "-");
		caso.put(MapHorario.HORA_04, "-");
		caso.put(MapHorario.HORA_05, "-");
		caso.put(MapHorario.HORA_06, "-");
		caso.put(MapHorario.HORA_07, "-");
		caso.put(MapHorario.HORA_08, "-");
		caso.put(MapHorario.HORA_09, "-");
		caso.put(MapHorario.HORA_10, "-");
		caso.put(MapHorario.HORA_11, "-");
		caso.put(MapHorario.HORA_12, "-");

		caso.put(MapHorario.HORA_13, "-");
		caso.put(MapHorario.HORA_14, "-");
		caso.put(MapHorario.HORA_15, "-");
		caso.put(MapHorario.HORA_16, "-");
		caso.put(MapHorario.HORA_17, "-");
		caso.put(MapHorario.HORA_18, "-");
		caso.put(MapHorario.HORA_19, "-");
		caso.put(MapHorario.HORA_20, "-");
		caso.put(MapHorario.HORA_21, "-");
		caso.put(MapHorario.HORA_22, "-");
		caso.put(MapHorario.HORA_23, "-");
		caso.put(MapHorario.HORA_24, "-");
	}
        
        public static void main(String[] args) {
            HashMap<String, Integer> cargaDoFuncionario = new HashMap<>();
            HashMap<Variable, String> caso = new LinkedHashMap<>();
            setCasoDefault(caso);
            
            MapHorarioCspDemo map = new MapHorarioCspDemo();
            List<Funcionario> funcionarios = scanner.scannerListFuncionarios();
            
            // nome, carga horaria
            
            for (Funcionario funcionario: funcionarios) {
                cargaDoFuncionario.put(funcionario.nome, funcionario.horasDeTrabalho);
            } 
            
            
            map.BackTracking(caso, cargaDoFuncionario);

        }
}
