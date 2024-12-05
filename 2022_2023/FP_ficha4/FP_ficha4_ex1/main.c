/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 3 de novembro de 2022, 10:16
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

 
    int precos[10], i , size, sum = 0;
    double resultado;
    
    
    printf("Diga o número de produtos:");
    scanf("%d", &size);
    
    
    printf("Diga os precos:");
    for (i = 0; i < size; i++){
        scanf("%d", &precos[i]);
    
     sum += precos[i];
    }
    
    
    resultado = sum;
    printf("A soma é: %.2lf", resultado);
    
    return (EXIT_SUCCESS);
}

