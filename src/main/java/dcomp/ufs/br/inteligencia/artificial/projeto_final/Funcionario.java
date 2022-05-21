/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;
import java.util.Arrays;
/**
 *
 * @author muril
 */
public class Funcionario extends Variable {
    public String nome;
    public Integer horasDeTrabalho;
    public String[] horasPreferenciais;
    
    
   Funcionario(
     String nome,
     Integer horasDeTrabalho,
     String[] horasPreferenciais
   ){
       super(nome);
       this.horasDeTrabalho = horasDeTrabalho;
       this.horasPreferenciais = horasPreferenciais;
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
     * @return the horasPreferenciais
     */
    public String[] getHorasDisponiveis() {
        return horasPreferenciais;
    }

    /**
     * @param horasPreferenciais the horasPreferenciais to set
     */
    public void setHorasDisponiveis(String[] horasPreferenciais) {
        this.horasPreferenciais = horasPreferenciais;
    }
    
    //overriding the toString() method
    @Override
    public String toString()
    {
            return 
                    "Nome: " + this.nome + "\n" 
                    + "Horas de Trabalho: " + this.horasDeTrabalho  + "\n"
                    + "Horas Disponíveis: " + Arrays.toString(horasPreferenciais);
    }
}
