/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 21 de outubro de 2022, 09:17
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int n_sapatos_final, custo_obra, custo_sapatos, nif, n_sapatos,  valor_final;
    float  margem_lucro, desconto, custo_total;
    
    
    
    printf("Por favor digite o seu NIF: " );
    scanf("%d" , &nif);
    
    printf("\n Quantos pares de sapatos deseja? ");
    scanf("%d" , &n_sapatos);
  
    n_sapatos_final = n_sapatos *2;
    custo_obra = n_sapatos * 10;
    custo_sapatos = custo_obra + (n_sapatos * 3);
    margem_lucro = custo_sapatos*0.3;
    custo_total = custo_sapatos + margem_lucro;
    desconto = custo_total*0.1;   
    valor_final = custo_total - desconto;
    
    
    printf("\n O seu NIF é %d e o número de sapatos é %d", nif, n_sapatos_final);
    printf("\n O custo da mao obra é: %d", custo_obra);
    printf("\n O custo total é: %d",custo_sapatos );
    printf("\n A margem é %.2f", margem_lucro);
    printf("\n O desconto é de: %.2f", desconto);
    printf("\n O valor inteiro é: %d", valor_final);
    
    
        
    
    
        
            
    
    return (EXIT_SUCCESS);
}

