/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import java.util.Arrays;
/**
 *
 * @author muril
 */
public class Funcionario {
    private String nome;
    private Integer horasDeTrabalho;
    private String[] horasDisponiveis;
    
    
   Funcionario(
     String nome,
     Integer horasDeTrabalho,
     String[] horasDisponiveis
   ){
       this.horasDeTrabalho = horasDeTrabalho;
       this.nome = nome;
       this.horasDisponiveis = horasDisponiveis;
   }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the horasDeTrabalho
     */
    public Integer getHorasDeTrabalho() {
        return horasDeTrabalho;
    }

    /**
     * @param horasDeTrabalho the horasDeTrabalho to set
     */
    public void setHorasDeTrabalho(Integer horasDeTrabalho) {
        this.horasDeTrabalho = horasDeTrabalho;
    }

    /**
     * @return the horasDisponiveis
     */
    public String[] getHorasDisponiveis() {
        return horasDisponiveis;
    }

    /**
     * @param horasDisponiveis the horasDisponiveis to set
     */
    public void setHorasDisponiveis(String[] horasDisponiveis) {
        this.horasDisponiveis = horasDisponiveis;
    }
    
    //overriding the toString() method
    @Override
    public String toString()
    {
            return 
                    "Nome: " + this.nome + "\n" 
                    + "Horas de Trabalho: " + this.horasDeTrabalho  + "\n"
                    + "Horas Disponíveis: " + Arrays.toString(horasDisponiveis);
    }
}
