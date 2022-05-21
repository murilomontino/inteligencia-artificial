/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcomp.ufs.br.inteligencia.artificial.projeto_final;

import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Variable;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author muril
 */
public class Funcionario extends Variable {
    public Integer horasDeTrabalho;
    public String[] horasPreferenciais;
    
    
   Funcionario(
     String name,
     Integer horasDeTrabalho,
     String[] horasPreferenciais
   ){
       super(name);
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
    
    public boolean horarioPermitido(String horario) {
        List<String> lista = Arrays.asList(this.horasPreferenciais);
        return lista.contains(horario);
    }
    
    //overriding the toString() method
    @Override
    public String toString()
    {
            return 
                    "Nome: " + this.getName() 
                    + " HT: " + this.horasDeTrabalho
                    + " HP: " + Arrays.toString(horasPreferenciais)
                    + "\n";
    }
}
