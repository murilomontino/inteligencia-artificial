/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author muril
 */
public class ScannerListFuncionarios {
    static Scanner input = new Scanner(System.in);
    
        public List<Funcionario> scannerListFuncionarios(){

         List<Funcionario> funcionarios = new ArrayList();

         System.out.printf("Quantas pessoas vão trabalhar no dia?\n");
         int quantidadeDeFuncionarios = input.nextInt();

         for (int i = 0; i < quantidadeDeFuncionarios; i++) {

            System.out.printf("Nome do funcionário:\n");
            String nome = input.next();

            System.out.printf("Horas de trabalho:\n");
            Integer horasDeTrabalho = input.nextInt();

            System.out.printf("Horários disponíveis (separe os horarios por virgulas):\n");
            String horariosDisponiveis = input.next();

            String[] arrayHorarios = horariosDisponiveis.split(",");

            Funcionario empregado = new Funcionario(
                    nome,
                    horasDeTrabalho,
                    arrayHorarios
            );

            funcionarios.add(empregado);

         }
                  
         return funcionarios;
     }
            
}
