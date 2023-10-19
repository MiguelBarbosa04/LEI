/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 10:57
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int valor1, valor2;
    
    printf("Diga o primeiro valor: ");
    scanf("%d", &valor1);
    
    printf(" \n Diga o segundo valor: ");
    scanf("%d", &valor2);
    
    
    valor1 = (valor1 + valor2) - valor2;
    valor2 = (valor2 + valor1) - valor1;
    printf("O valor do primeiro valor trocado é: %d", valor2);
    printf("\n O valor do segundo valor trocado é: %d", valor1);
    
    
    
    return (EXIT_SUCCESS);
}

