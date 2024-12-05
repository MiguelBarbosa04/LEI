/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 27 de outubro de 2022, 10:17
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int contador = 0;
    float num, soma = 0, med;
    
    
    do {
    printf("\nDigite um número: ");
    scanf("%f", &num);
    contador++;
    soma +=num;
  
    } while (num != 0);
    med = soma/(contador-1);
    printf("A média é:%f ", med);
    
    

    
    return (EXIT_SUCCESS);
}

