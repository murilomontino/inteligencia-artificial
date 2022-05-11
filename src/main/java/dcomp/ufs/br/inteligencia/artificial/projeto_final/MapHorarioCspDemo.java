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

public class MapHorarioCspDemo {
	static Scanner input = new Scanner(System.in);
        public ScannerListFuncionarios scanner = new ScannerListFuncionarios();
        
        public void BackTracking(HashMap<Variable, String> caso){
                HashMap<String, Integer> cargaEstudos = new HashMap<>(); 
	
		CSP<Variable, String> csp = new MapHorario(cargaEstudos);

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
			arquivoCsv.append("SEGUNDA").append(separador);
			arquivoCsv.append("TERCA").append(separador);
			arquivoCsv.append("QUARTA").append(separador);
			arquivoCsv.append("QUINTA").append(separador);
			arquivoCsv.append("SEXTA").append(separador);
			arquivoCsv.append("SABADO").append(separador);
			arquivoCsv.append("\n");

			for (Variable v : solution.get().getVariables()) {
                            switch (v.getName()) {
                                case "2M1":
                                    arquivoCsv.append("07:00 - 07:30").append(separador);
                                    break;
                                case "2M2":
                                    arquivoCsv.append("07:30 - 08:00").append(separador);
                                    break;
                                case "2M3":
                                    arquivoCsv.append("08:00 - 08:30").append(separador);
                                    break;
                                case "2M4":
                                    arquivoCsv.append("08:30 - 09:00").append(separador);
                                    break;
                                case "2M5":
                                    arquivoCsv.append("09:00 - 09:30").append(separador);
                                    break;
                                case "2M6":
                                    arquivoCsv.append("09:30 - 10:00").append(separador);
                                    break;
                                case "2M7":
                                    arquivoCsv.append("10:00 - 10:30").append(separador);
                                    break;
                                case "2M8":
                                    arquivoCsv.append("10:30 - 11:00").append(separador);
                                    break;
                                case "2M9":
                                    arquivoCsv.append("11:00 - 11:30").append(separador);
                                    break;
                                case "2M10":
                                    arquivoCsv.append("11:30 - 12:00").append(separador);
                                    break;
                                case "2M11":
                                    arquivoCsv.append("12:00 - 12:30").append(separador);
                                    break;
                                case "2M12":
                                    arquivoCsv.append("12:30 - 13:00").append(separador);
                                    break;
                                case "2T1":
                                    arquivoCsv.append("13:00 - 13:30").append(separador);
                                    break;
                                case "2T2":
                                    arquivoCsv.append("13:30 - 14:00").append(separador);
                                    break;
                                case "2T3":
                                    arquivoCsv.append("14:00 - 14:30").append(separador);
                                    break;
                                case "2T4":
                                    arquivoCsv.append("14:30 - 15:00").append(separador);
                                    break;
                                case "2T5":
                                    arquivoCsv.append("15:00 - 15:30").append(separador);
                                    break;
                                case "2T6":
                                    arquivoCsv.append("15:30 - 16:00").append(separador);
                                    break;
                                case "2T7":
                                    arquivoCsv.append("16:00 - 16:30").append(separador);
                                    break;
                                case "2T8":
                                    arquivoCsv.append("16:30 - 17:00").append(separador);
                                    break;
                                case "2T9":
                                    arquivoCsv.append("17:00 - 17:30").append(separador);
                                    break;
                                case "2T10":
                                    arquivoCsv.append("17:30 - 18:00").append(separador);
                                    break;
                                case "2T11":
                                    arquivoCsv.append("18:00 - 18:30").append(separador);
                                    break;
                                case "2T12":
                                    arquivoCsv.append("18:30 - 19:00").append(separador);
                                    break;
                                case "2Z1":
                                    arquivoCsv.append("19:00 - 19:30").append(separador);
                                    break;
                                case "2Z2":
                                    arquivoCsv.append("19:30 - 20:00").append(separador);
                                    break;
                                case "2Z3":
                                    arquivoCsv.append("20:00 - 20:30").append(separador);
                                    break;
                                case "2Z4":
                                    arquivoCsv.append("20:30 - 21:00").append(separador);
                                    break;
                                case "2Z5":
                                    arquivoCsv.append("21:00 - 21:30").append(separador);
                                    break;
                                case "2Z6":
                                    arquivoCsv.append("21:30 - 22:00").append(separador);
                                    break;
                                case "2Z7":
                                    arquivoCsv.append("22:00 - 22:30").append(separador);
                                    break;
                                case "2Z8":
                                    arquivoCsv.append("22:30 - 23:00").append(separador);
                                    break;
                                default:
                                    break;
                            }

				arquivoCsv.append(solution.get().getValue(v)).append(separador);

				cont++;

				if (cont == 6) {
					arquivoCsv.append("\n");
					cont = 0;
				}
			}

			try (PrintWriter writer = new PrintWriter(new File("horario.csv"))) {

				writer.write(arquivoCsv.toString());
				
				System.out.print("Planilha gerada com sucesso!!!");
				
				writer.flush();
				writer.close();
			} catch (IOException e) {
				System.out.print(e.getMessage());
			}
		} else {
			System.out.println(
					"ERRO: carga horaria livre menor que carga horaria necessaria para realizar as atividades.");
		}

	}

	public void setCasoDefault(HashMap<Variable, String> caso) {
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
            HashMap<String, Integer> cargaHorariaDosFuncionarios = new HashMap<>();
            HashMap<String, String> horariosDisponiveisDosFuncionarios = new HashMap<>();
            HashMap<Variable, String> caso = new LinkedHashMap<>();

            MapHorarioCspDemo CspDemo = new MapHorarioCspDemo();
                
            CspDemo.setCasoDefault(caso);
            
            CspDemo.scanner.scannerListFuncionarios();
             
        }
}
