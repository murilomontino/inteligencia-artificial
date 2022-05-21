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
		caso.put(CommonDomain.HORA_01, "-");
		caso.put(CommonDomain.HORA_02, "-");
		caso.put(CommonDomain.HORA_03, "-");
		caso.put(CommonDomain.HORA_04, "-");
		caso.put(CommonDomain.HORA_05, "-");
		caso.put(CommonDomain.HORA_06, "-");
		caso.put(CommonDomain.HORA_07, "-");
		caso.put(CommonDomain.HORA_08, "-");
		caso.put(CommonDomain.HORA_09, "-");
		caso.put(CommonDomain.HORA_10, "-");
		caso.put(CommonDomain.HORA_11, "-");
		caso.put(CommonDomain.HORA_12, "-");

		caso.put(CommonDomain.HORA_13, "-");
		caso.put(CommonDomain.HORA_14, "-");
		caso.put(CommonDomain.HORA_15, "-");
		caso.put(CommonDomain.HORA_16, "-");
		caso.put(CommonDomain.HORA_17, "-");
		caso.put(CommonDomain.HORA_18, "-");
		caso.put(CommonDomain.HORA_19, "-");
		caso.put(CommonDomain.HORA_20, "-");
		caso.put(CommonDomain.HORA_21, "-");
		caso.put(CommonDomain.HORA_22, "-");
		caso.put(CommonDomain.HORA_23, "-");
		caso.put(CommonDomain.HORA_24, "-");
	}
        
        public static void main(String[] args) {
            HashMap<String, Funcionario> Funcionarios = new HashMap<>();
            HashMap<Variable, String> caso = new LinkedHashMap<>();
            
            MapHorarioCspDemo map = new MapHorarioCspDemo();
            //List<Funcionario> funcionarios = scanner.scannerListFuncionarios();
            
            String[] horariosAlice = "4,13,19,21,22".split(",");
            
            Funcionario Alice = new Funcionario(
                    "Alice",
                    2,
                    horariosAlice
            );
            
            String[] horariosBob = "6,9,10,14,15,21".split(",");
            
            Funcionario Bob = new Funcionario(
                    "Bob",
                    3,
                    horariosBob
            );
            
            String[] horariosCharlie = "5,8,10,13,14,21,22,23".split(",");
            
            Funcionario Charlie = new Funcionario(
                    "Charlie",
                    1,
                    horariosCharlie
            );
            
             String[] horariosDavid = "1,3,4,5,6,7,19,23".split(",");
            
            Funcionario David = new Funcionario(
                    "David",
                    2,
                    horariosDavid
            );
            
            
            String[] horariosEve = "2,4,7,10,11,13,14,15,18,21".split(",");
            
            Funcionario Eve = new Funcionario(
                    "Eve",
                    4,
                    horariosEve
            );
            
            Funcionarios.put(David.getName(), David);
            Funcionarios.put(Eve.getName(), Eve);
            Funcionarios.put(Alice.getName(), Alice);
            Funcionarios.put(Charlie.getName(), Charlie);
            Funcionarios.put(Bob.getName(), Bob);
            //for (Funcionario funcionario: funcionarios) {
            //    Funcionarios.put(funcionario.getName(), funcionario);
            //} 
            
            setCasoDefault(caso);
            
            map.BackTracking(caso, Funcionarios);

        }
}
