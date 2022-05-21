package dcomp.ufs.br.inteligencia.artificial.projeto_final;


import dcomp.ufs.br.inteligencia.artificial.projeto_final.aima.core.Domain;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author muril
 */
public class DomainFuncionarios extends Domain<Object> {
    public String name;
    public Integer horasDeTrabalho;
    public String[] horasPreferenciais;
    
 
    public DomainFuncionarios (
            String name,
            ArrayList<String> domain,
            Integer horasDeTrabalho,
            String[] horasPreferenciais
    ){
       super(domain);
       this.name = name;
       this.horasDeTrabalho = horasDeTrabalho;
       this.horasPreferenciais = horasPreferenciais;
    }
   
 }
