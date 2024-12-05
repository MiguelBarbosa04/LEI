/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 11:51
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    float produto1, produto2, produto3;
    float total, total_desconto;
    
    
    printf("Diga o valor do primeiro produto: ");
    scanf("%f", &produto1);
    
    printf(" \n Diga o valor do segundo produto: ");
    scanf("%f", &produto2);
    
     printf(" \n Diga o valor do terceiro produto: ");
    scanf("%f", &produto3);
    
    total = produto1 + produto2 + produto3;
    total_desconto = total -(total * 0.1);
    
    printf("\n O valot total a pagar é: %.2f", total_desconto);
    
    return (EXIT_SUCCESS);
}

