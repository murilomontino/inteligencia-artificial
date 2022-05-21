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
                HashMap<String, Funcionario> cargaDoFuncionario
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

				if (cont == 23) {
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

	static void setCasoDefault(
                HashMap<Variable, String> caso
        ) {
		caso.put(MapHorario.HORA_01, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_02, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_03, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_04, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_05, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_06, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_07, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_08, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_09, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_10, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_11, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_12, "HORARIO_LIVRE");

		caso.put(MapHorario.HORA_13, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_14, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_15, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_16, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_17, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_18, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_19, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_20, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_21, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_22, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_23, "HORARIO_LIVRE");
		caso.put(MapHorario.HORA_24, "HORARIO_LIVRE");
	}
        
        public static void main(String[] args) {
            HashMap<String, Funcionario> Funcionarios = new HashMap<>();
            HashMap<Variable, String> caso = new LinkedHashMap<>();
            
            MapHorarioCspDemo map = new MapHorarioCspDemo();
            //List<Funcionario> funcionarios = scanner.scannerListFuncionarios();
            
            String[] horariosMateus = "1,2,3,4".split(",");
            
            Funcionario mateus = new Funcionario(
                    "Mateus",
                    1,
                    horariosMateus
            );
            
            String[] horariosMurilo = "4,5,6,7".split(",");
            
            Funcionario murilo = new Funcionario(
                    "Murilo",
                    3,
                    horariosMurilo
            );
            
            String[] horariosGUI = "10,12,13,14".split(",");
            
            Funcionario gui = new Funcionario(
                    "GUI",
                    4,
                    horariosGUI
            );
            Funcionarios.put(gui.getName(), gui);
            Funcionarios.put(murilo.getName(), murilo);
            Funcionarios.put(mateus.getName(), mateus);
            //for (Funcionario funcionario: funcionarios) {
            //    Funcionarios.put(funcionario.getName(), funcionario);
            //} 
            
            setCasoDefault(caso);
            
            map.BackTracking(caso, Funcionarios);

        }
}
