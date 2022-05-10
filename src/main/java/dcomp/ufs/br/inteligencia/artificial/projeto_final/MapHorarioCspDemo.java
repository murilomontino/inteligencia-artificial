package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
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

	public static void main(String[] args) {
		HashMap<String, Integer> cargaHorariaDosFuncionarios = new HashMap<String, Integer>();
		HashMap<String, String> horariosDisponiveisDosFuncionarios = new HashMap<String, String>();
		HashMap<Variable, String> caso = new LinkedHashMap<Variable, String>();
		setCasoDefault(caso);

		Integer horasDeTrabalho;
		String nome;
		String horariosDisponiveis;	
		System.out.print("Quantas pessoas vão trabalhar no dia?");
		int quantidadeDeFuncionarios = input.nextInt();

		for (int i = 0; i < quantidadeDeFuncionarios; i++) {
			System.out.print("Nome do funcionário:");
			nome = input.nextLine();
			System.out.print("Horas de trabalho:");
			horasDeTrabalho = input.nextInt();
			System.out.print("Horários disponíveis:");
			horariosDisponiveis = input.nextLine();
			//TODO
		}
	
		CSP<Variable, String> csp = new MapHorario(cargaEstudos);

		CspListener.StepCounter<Variable, String> stepCounter = new CspListener.StepCounter<>();
		CspSolver<Variable, String> solver;
		Optional<Assignment<Variable, String>> solution;
		int cont = 0;

		solver = new FlexibleBacktrackingSolver<Variable, String>();
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
				if (v.getName().equals("2M1"))
					arquivoCsv.append("07:00 - 07:30").append(separador);
				else if (v.getName().equals("2M2"))
					arquivoCsv.append("07:30 - 08:00").append(separador);
				else if (v.getName().equals("2M3"))
					arquivoCsv.append("08:00 - 08:30").append(separador);
				else if (v.getName().equals("2M4"))
					arquivoCsv.append("08:30 - 09:00").append(separador);
				else if (v.getName().equals("2M5"))
					arquivoCsv.append("09:00 - 09:30").append(separador);
				else if (v.getName().equals("2M6"))
					arquivoCsv.append("09:30 - 10:00").append(separador);
				else if (v.getName().equals("2M7"))
					arquivoCsv.append("10:00 - 10:30").append(separador);
				else if (v.getName().equals("2M8"))
					arquivoCsv.append("10:30 - 11:00").append(separador);
				else if (v.getName().equals("2M9"))
					arquivoCsv.append("11:00 - 11:30").append(separador);
				else if (v.getName().equals("2M10"))
					arquivoCsv.append("11:30 - 12:00").append(separador);
				else if (v.getName().equals("2M11"))
					arquivoCsv.append("12:00 - 12:30").append(separador);
				else if (v.getName().equals("2M12"))
					arquivoCsv.append("12:30 - 13:00").append(separador);
				else if (v.getName().equals("2T1"))
					arquivoCsv.append("13:00 - 13:30").append(separador);
				else if (v.getName().equals("2T2"))
					arquivoCsv.append("13:30 - 14:00").append(separador);
				else if (v.getName().equals("2T3"))
					arquivoCsv.append("14:00 - 14:30").append(separador);
				else if (v.getName().equals("2T4"))
					arquivoCsv.append("14:30 - 15:00").append(separador);
				else if (v.getName().equals("2T5"))
					arquivoCsv.append("15:00 - 15:30").append(separador);
				else if (v.getName().equals("2T6"))
					arquivoCsv.append("15:30 - 16:00").append(separador);
				else if (v.getName().equals("2T7"))
					arquivoCsv.append("16:00 - 16:30").append(separador);
				else if (v.getName().equals("2T8"))
					arquivoCsv.append("16:30 - 17:00").append(separador);
				else if (v.getName().equals("2T9"))
					arquivoCsv.append("17:00 - 17:30").append(separador);
				else if (v.getName().equals("2T10"))
					arquivoCsv.append("17:30 - 18:00").append(separador);
				else if (v.getName().equals("2T11"))
					arquivoCsv.append("18:00 - 18:30").append(separador);
				else if (v.getName().equals("2T12"))
					arquivoCsv.append("18:30 - 19:00").append(separador);
				else if (v.getName().equals("2Z1"))
					arquivoCsv.append("19:00 - 19:30").append(separador);
				else if (v.getName().equals("2Z2"))
					arquivoCsv.append("19:30 - 20:00").append(separador);
				else if (v.getName().equals("2Z3"))
					arquivoCsv.append("20:00 - 20:30").append(separador);
				else if (v.getName().equals("2Z4"))
					arquivoCsv.append("20:30 - 21:00").append(separador);
				else if (v.getName().equals("2Z5"))
					arquivoCsv.append("21:00 - 21:30").append(separador);
				else if (v.getName().equals("2Z6"))
					arquivoCsv.append("21:30 - 22:00").append(separador);
				else if (v.getName().equals("2Z7"))
					arquivoCsv.append("22:00 - 22:30").append(separador);
				else if (v.getName().equals("2Z8"))
					arquivoCsv.append("22:30 - 23:00").append(separador);

				arquivoCsv.append(solution.get().getValue(v)).append(separador);

				cont++;

				if (cont == 6) {
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

	public static void setCasoDefault(HashMap<Variable, String> caso) {
		caso.put(MapHorario.SEGUNDA_07_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_07_30_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_08_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_08_30_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_09_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_09_30_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_10_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_10_30_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_11_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_11_30_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_12_MANHA, "-");
		caso.put(MapHorario.SEGUNDA_12_30_MANHA, "-");

		caso.put(MapHorario.SEGUNDA_13_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_13_30_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_14_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_14_30_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_15_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_15_30_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_16_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_16_30_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_17_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_17_30_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_18_TARDE, "-");
		caso.put(MapHorario.SEGUNDA_18_30_TARDE, "-");

		caso.put(MapHorario.SEGUNDA_19_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_19_30_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_20_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_20_30_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_21_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_21_30_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_22_NOITE, "-");
		caso.put(MapHorario.SEGUNDA_22_30_NOITE, "-");

		caso.put(MapHorario.TERCA_07_MANHA, "-");
		caso.put(MapHorario.TERCA_07_30_MANHA, "-");
		caso.put(MapHorario.TERCA_08_MANHA, "-");
		caso.put(MapHorario.TERCA_08_30_MANHA, "-");
		caso.put(MapHorario.TERCA_09_MANHA, "-");
		caso.put(MapHorario.TERCA_09_30_MANHA, "-");
		caso.put(MapHorario.TERCA_10_MANHA, "-");
		caso.put(MapHorario.TERCA_10_30_MANHA, "-");
		caso.put(MapHorario.TERCA_11_MANHA, "-");
		caso.put(MapHorario.TERCA_11_30_MANHA, "-");
		caso.put(MapHorario.TERCA_12_MANHA, "-");
		caso.put(MapHorario.TERCA_12_30_MANHA, "-");

		caso.put(MapHorario.TERCA_13_TARDE, "-");
		caso.put(MapHorario.TERCA_13_30_TARDE, "-");
		caso.put(MapHorario.TERCA_14_TARDE, "-");
		caso.put(MapHorario.TERCA_14_30_TARDE, "-");
		caso.put(MapHorario.TERCA_15_TARDE, "-");
		caso.put(MapHorario.TERCA_15_30_TARDE, "-");
		caso.put(MapHorario.TERCA_16_TARDE, "-");
		caso.put(MapHorario.TERCA_16_30_TARDE, "-");
		caso.put(MapHorario.TERCA_17_TARDE, "-");
		caso.put(MapHorario.TERCA_17_30_TARDE, "-");
		caso.put(MapHorario.TERCA_18_TARDE, "-");
		caso.put(MapHorario.TERCA_18_30_TARDE, "-");

		caso.put(MapHorario.TERCA_19_NOITE, "-");
		caso.put(MapHorario.TERCA_19_30_NOITE, "-");
		caso.put(MapHorario.TERCA_20_NOITE, "-");
		caso.put(MapHorario.TERCA_20_30_NOITE, "-");
		caso.put(MapHorario.TERCA_21_NOITE, "-");
		caso.put(MapHorario.TERCA_21_30_NOITE, "-");
		caso.put(MapHorario.TERCA_22_NOITE, "-");
		caso.put(MapHorario.TERCA_22_30_NOITE, "-");

		caso.put(MapHorario.QUARTA_07_MANHA, "-");
		caso.put(MapHorario.QUARTA_07_30_MANHA, "-");
		caso.put(MapHorario.QUARTA_08_MANHA, "-");
		caso.put(MapHorario.QUARTA_08_30_MANHA, "-");
		caso.put(MapHorario.QUARTA_09_MANHA, "-");
		caso.put(MapHorario.QUARTA_09_30_MANHA, "-");
		caso.put(MapHorario.QUARTA_10_MANHA, "-");
		caso.put(MapHorario.QUARTA_10_30_MANHA, "-");
		caso.put(MapHorario.QUARTA_11_MANHA, "-");
		caso.put(MapHorario.QUARTA_11_30_MANHA, "-");
		caso.put(MapHorario.QUARTA_12_MANHA, "-");
		caso.put(MapHorario.QUARTA_12_30_MANHA, "-");

		caso.put(MapHorario.QUARTA_13_TARDE, "-");
		caso.put(MapHorario.QUARTA_13_30_TARDE, "-");
		caso.put(MapHorario.QUARTA_14_TARDE, "-");
		caso.put(MapHorario.QUARTA_14_30_TARDE, "-");
		caso.put(MapHorario.QUARTA_15_TARDE, "-");
		caso.put(MapHorario.QUARTA_15_30_TARDE, "-");
		caso.put(MapHorario.QUARTA_16_TARDE, "-");
		caso.put(MapHorario.QUARTA_16_30_TARDE, "-");
		caso.put(MapHorario.QUARTA_17_TARDE, "-");
		caso.put(MapHorario.QUARTA_17_30_TARDE, "-");
		caso.put(MapHorario.QUARTA_18_TARDE, "-");
		caso.put(MapHorario.QUARTA_18_30_TARDE, "-");

		caso.put(MapHorario.QUARTA_19_NOITE, "-");
		caso.put(MapHorario.QUARTA_19_30_NOITE, "-");
		caso.put(MapHorario.QUARTA_20_NOITE, "-");
		caso.put(MapHorario.QUARTA_20_30_NOITE, "-");
		caso.put(MapHorario.QUARTA_21_NOITE, "-");
		caso.put(MapHorario.QUARTA_21_30_NOITE, "-");
		caso.put(MapHorario.QUARTA_22_NOITE, "-");
		caso.put(MapHorario.QUARTA_22_30_NOITE, "-");

		caso.put(MapHorario.QUINTA_07_MANHA, "-");
		caso.put(MapHorario.QUINTA_07_30_MANHA, "-");
		caso.put(MapHorario.QUINTA_08_MANHA, "-");
		caso.put(MapHorario.QUINTA_08_30_MANHA, "-");
		caso.put(MapHorario.QUINTA_09_MANHA, "-");
		caso.put(MapHorario.QUINTA_09_30_MANHA, "-");
		caso.put(MapHorario.QUINTA_10_MANHA, "-");
		caso.put(MapHorario.QUINTA_10_30_MANHA, "-");
		caso.put(MapHorario.QUINTA_11_MANHA, "-");
		caso.put(MapHorario.QUINTA_11_30_MANHA, "-");
		caso.put(MapHorario.QUINTA_12_MANHA, "-");
		caso.put(MapHorario.QUINTA_12_30_MANHA, "-");

		caso.put(MapHorario.QUINTA_13_TARDE, "-");
		caso.put(MapHorario.QUINTA_13_30_TARDE, "-");
		caso.put(MapHorario.QUINTA_14_TARDE, "-");
		caso.put(MapHorario.QUINTA_14_30_TARDE, "-");
		caso.put(MapHorario.QUINTA_15_TARDE, "-");
		caso.put(MapHorario.QUINTA_15_30_TARDE, "-");
		caso.put(MapHorario.QUINTA_16_TARDE, "-");
		caso.put(MapHorario.QUINTA_16_30_TARDE, "-");
		caso.put(MapHorario.QUINTA_17_TARDE, "-");
		caso.put(MapHorario.QUINTA_17_30_TARDE, "-");
		caso.put(MapHorario.QUINTA_18_TARDE, "-");
		caso.put(MapHorario.QUINTA_18_30_TARDE, "-");

		caso.put(MapHorario.QUINTA_19_NOITE, "-");
		caso.put(MapHorario.QUINTA_19_30_NOITE, "-");
		caso.put(MapHorario.QUINTA_20_NOITE, "-");
		caso.put(MapHorario.QUINTA_20_30_NOITE, "-");
		caso.put(MapHorario.QUINTA_21_NOITE, "-");
		caso.put(MapHorario.QUINTA_21_30_NOITE, "-");
		caso.put(MapHorario.QUINTA_22_NOITE, "-");
		caso.put(MapHorario.QUINTA_22_30_NOITE, "-");

		caso.put(MapHorario.SEXTA_07_MANHA, "-");
		caso.put(MapHorario.SEXTA_07_30_MANHA, "-");
		caso.put(MapHorario.SEXTA_08_MANHA, "-");
		caso.put(MapHorario.SEXTA_08_30_MANHA, "-");
		caso.put(MapHorario.SEXTA_09_MANHA, "-");
		caso.put(MapHorario.SEXTA_09_30_MANHA, "-");
		caso.put(MapHorario.SEXTA_10_MANHA, "-");
		caso.put(MapHorario.SEXTA_10_30_MANHA, "-");
		caso.put(MapHorario.SEXTA_11_MANHA, "-");
		caso.put(MapHorario.SEXTA_11_30_MANHA, "-");
		caso.put(MapHorario.SEXTA_12_MANHA, "-");
		caso.put(MapHorario.SEXTA_12_30_MANHA, "-");

		caso.put(MapHorario.SEXTA_13_TARDE, "-");
		caso.put(MapHorario.SEXTA_13_30_TARDE, "-");
		caso.put(MapHorario.SEXTA_14_TARDE, "-");
		caso.put(MapHorario.SEXTA_14_30_TARDE, "-");
		caso.put(MapHorario.SEXTA_15_TARDE, "-");
		caso.put(MapHorario.SEXTA_15_30_TARDE, "-");
		caso.put(MapHorario.SEXTA_16_TARDE, "-");
		caso.put(MapHorario.SEXTA_16_30_TARDE, "-");
		caso.put(MapHorario.SEXTA_17_TARDE, "-");
		caso.put(MapHorario.SEXTA_17_30_TARDE, "-");
		caso.put(MapHorario.SEXTA_18_TARDE, "-");
		caso.put(MapHorario.SEXTA_18_30_TARDE, "-");

		caso.put(MapHorario.SEXTA_19_NOITE, "-");
		caso.put(MapHorario.SEXTA_19_30_NOITE, "-");
		caso.put(MapHorario.SEXTA_20_NOITE, "-");
		caso.put(MapHorario.SEXTA_20_30_NOITE, "-");
		caso.put(MapHorario.SEXTA_21_NOITE, "-");
		caso.put(MapHorario.SEXTA_21_30_NOITE, "-");
		caso.put(MapHorario.SEXTA_22_NOITE, "-");
		caso.put(MapHorario.SEXTA_22_30_NOITE, "-");

		caso.put(MapHorario.SABADO_07_MANHA, "-");
		caso.put(MapHorario.SABADO_07_30_MANHA, "-");
		caso.put(MapHorario.SABADO_08_MANHA, "-");
		caso.put(MapHorario.SABADO_08_30_MANHA, "-");
		caso.put(MapHorario.SABADO_09_MANHA, "-");
		caso.put(MapHorario.SABADO_09_30_MANHA, "-");
		caso.put(MapHorario.SABADO_10_MANHA, "-");
		caso.put(MapHorario.SABADO_10_30_MANHA, "-");
		caso.put(MapHorario.SABADO_11_MANHA, "-");
		caso.put(MapHorario.SABADO_11_30_MANHA, "-");
		caso.put(MapHorario.SABADO_12_MANHA, "-");
		caso.put(MapHorario.SABADO_12_30_MANHA, "-");

		caso.put(MapHorario.SABADO_13_TARDE, "-");
		caso.put(MapHorario.SABADO_13_30_TARDE, "-");
		caso.put(MapHorario.SABADO_14_TARDE, "-");
		caso.put(MapHorario.SABADO_14_30_TARDE, "-");
		caso.put(MapHorario.SABADO_15_TARDE, "-");
		caso.put(MapHorario.SABADO_15_30_TARDE, "-");
		caso.put(MapHorario.SABADO_16_TARDE, "-");
		caso.put(MapHorario.SABADO_16_30_TARDE, "-");
		caso.put(MapHorario.SABADO_17_TARDE, "-");
		caso.put(MapHorario.SABADO_17_30_TARDE, "-");
		caso.put(MapHorario.SABADO_18_TARDE, "-");
		caso.put(MapHorario.SABADO_18_30_TARDE, "-");

		caso.put(MapHorario.SABADO_19_NOITE, "-");
		caso.put(MapHorario.SABADO_19_30_NOITE, "-");
		caso.put(MapHorario.SABADO_20_NOITE, "-");
		caso.put(MapHorario.SABADO_20_30_NOITE, "-");
		caso.put(MapHorario.SABADO_21_NOITE, "-");
		caso.put(MapHorario.SABADO_21_30_NOITE, "-");
		caso.put(MapHorario.SABADO_22_NOITE, "-");
		caso.put(MapHorario.SABADO_22_30_NOITE, "-");
	}

	public static void setCaso1(HashMap<Variable, String> caso1, HashMap<String, Double> cargaEstudos) {
		caso1.put(MapHorario.SEGUNDA_21_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.SEGUNDA_21_30_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.SEGUNDA_22_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.SEGUNDA_22_30_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.TERCA_15_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.TERCA_15_30_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.TERCA_16_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.TERCA_16_30_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.QUARTA_21_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.QUARTA_21_30_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.QUARTA_22_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.QUARTA_22_30_NOITE, MapHorario.COMP0408);
		caso1.put(MapHorario.QUINTA_15_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.QUINTA_15_30_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.QUINTA_16_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.QUINTA_16_30_TARDE, MapHorario.COMP0455);
		caso1.put(MapHorario.QUINTA_19_NOITE, MapHorario.COMP0481);
		caso1.put(MapHorario.QUINTA_19_30_NOITE, MapHorario.COMP0481);
		caso1.put(MapHorario.QUINTA_20_NOITE, MapHorario.COMP0481);
		caso1.put(MapHorario.QUINTA_20_30_NOITE, MapHorario.COMP0481);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0408: ");
		double cargaHorariaCOMP408 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0408, cargaHorariaCOMP408);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0455: ");
		double cargaHorariaCOMP0455 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0455, cargaHorariaCOMP0455);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0481: ");
		double cargaHorariaCOMP0481 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0481, cargaHorariaCOMP0481);
	}

	public static void setCaso2(HashMap<Variable, String> caso2, HashMap<String, Double> cargaEstudos) {
		caso2.put(MapHorario.SEGUNDA_13_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.SEGUNDA_13_30_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.SEGUNDA_14_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.SEGUNDA_14_30_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.SEGUNDA_17_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.SEGUNDA_17_30_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.SEGUNDA_18_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.SEGUNDA_18_30_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.SEGUNDA_21_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.SEGUNDA_21_30_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.SEGUNDA_22_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.SEGUNDA_22_30_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.TERCA_15_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.TERCA_15_30_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.TERCA_16_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.TERCA_16_30_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.QUARTA_13_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.QUARTA_13_30_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.QUARTA_14_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.QUARTA_14_30_TARDE, MapHorario.COMP0409);
		caso2.put(MapHorario.QUARTA_17_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.QUARTA_17_30_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.QUARTA_18_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.QUARTA_18_30_TARDE, MapHorario.COMP0408);
		caso2.put(MapHorario.QUARTA_21_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.QUARTA_21_30_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.QUARTA_22_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.QUARTA_22_30_NOITE, MapHorario.COMP0461);
		caso2.put(MapHorario.QUINTA_15_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.QUINTA_15_30_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.QUINTA_16_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.QUINTA_16_30_TARDE, MapHorario.COMP0412);
		caso2.put(MapHorario.SEXTA_13_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_13_30_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_14_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_14_30_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_15_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_15_30_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_16_TARDE, MapHorario.COMP0438);
		caso2.put(MapHorario.SEXTA_16_30_TARDE, MapHorario.COMP0438);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0408: ");
		double cargaHorariaCOMP408 = input.nextDouble();
		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0408, cargaHorariaCOMP408);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0409: ");
		double cargaHorariaCOMP409 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0409, cargaHorariaCOMP409);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0461: ");
		double cargaHorariaCOMP0461 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0461, cargaHorariaCOMP0461);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0412: ");
		double cargaHorariaCOMP0412 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0412, cargaHorariaCOMP0412);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0438: ");
		double cargaHorariaCOMP0438 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0438, cargaHorariaCOMP0438);
	}

	public static void setCaso3(HashMap<Variable, String> caso3, HashMap<String, Double> cargaEstudos) {
		caso3.put(MapHorario.SEGUNDA_13_TARDE, MapHorario.ELET0043);
		caso3.put(MapHorario.SEGUNDA_13_30_TARDE, MapHorario.ELET0043);
		caso3.put(MapHorario.SEGUNDA_14_TARDE, MapHorario.ELET0043);
		caso3.put(MapHorario.SEGUNDA_14_30_TARDE, MapHorario.ELET0043);
		caso3.put(MapHorario.SEGUNDA_15_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.SEGUNDA_15_30_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.SEGUNDA_16_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.SEGUNDA_16_30_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.SEGUNDA_17_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.SEGUNDA_17_30_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.SEGUNDA_18_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.SEGUNDA_18_30_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.TERCA_13_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.TERCA_13_30_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.TERCA_14_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.TERCA_14_30_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.TERCA_15_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.TERCA_15_30_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.TERCA_16_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.TERCA_16_30_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.TERCA_17_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.TERCA_17_30_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.TERCA_18_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.TERCA_18_30_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.QUARTA_13_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.QUARTA_13_30_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.QUARTA_14_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.QUARTA_14_30_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.QUARTA_15_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.QUARTA_15_30_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.QUARTA_16_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.QUARTA_16_30_TARDE, MapHorario.ESTAT0011);
		caso3.put(MapHorario.QUARTA_17_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.QUARTA_17_30_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.QUARTA_18_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.QUARTA_18_30_TARDE, MapHorario.COMP0415);
		caso3.put(MapHorario.QUINTA_13_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.QUINTA_13_30_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.QUINTA_14_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.QUINTA_14_30_TARDE, MapHorario.MAT0096);
		caso3.put(MapHorario.QUINTA_15_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.QUINTA_15_30_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.QUINTA_16_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.QUINTA_16_30_TARDE, MapHorario.COMP0409);
		caso3.put(MapHorario.QUINTA_17_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.QUINTA_17_30_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.QUINTA_18_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.QUINTA_18_30_TARDE, MapHorario.COMP0412);
		caso3.put(MapHorario.SEXTA_13_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.SEXTA_13_30_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.SEXTA_14_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.SEXTA_14_30_TARDE, MapHorario.MAT0154);
		caso3.put(MapHorario.SEXTA_17_TARDE, MapHorario.COMP0417);
		caso3.put(MapHorario.SEXTA_17_30_TARDE, MapHorario.COMP0417);
		caso3.put(MapHorario.SEXTA_18_TARDE, MapHorario.COMP0417);
		caso3.put(MapHorario.SEXTA_18_30_TARDE, MapHorario.COMP0417);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0415: ");
		double cargaHorariaCOMP0415 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0415, cargaHorariaCOMP0415);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0409: ");
		double cargaHorariaCOMP0409 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0409, cargaHorariaCOMP0409);

		System.out.print("Digite a carga horaria de estudo para a materia ELET0043: ");
		double cargaHorariaELET0043 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_ELET0043, cargaHorariaELET0043);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0417: ");
		double cargaHorariaCOMP0417 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0417, cargaHorariaCOMP0417);

		System.out.print("Digite a carga horaria de estudo para a materia COMP0438: ");
		double cargaHorariaCOMP0438 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_COMP0438, cargaHorariaCOMP0438);

		System.out.print("Digite a carga horaria de estudo para a materia ESTAT0011: ");
		double cargaHorariaESTAT0011 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_ESTAT0011, cargaHorariaESTAT0011);

		System.out.print("Digite a carga horaria de estudo para a materia MAT0096: ");
		double cargaHorariaMAT0096 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_MAT0096, cargaHorariaMAT0096);

		System.out.print("Digite a carga horaria de estudo para a materia MAT0154: ");
		double cargaHorariaMAT0154 = input.nextDouble();

		cargaEstudos.put(MapHorario.BLOCO_ESTUDO_MAT0154, cargaHorariaMAT0154);
	}
}
