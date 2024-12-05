/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 29 de novembro de 2022, 18:05
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

void somar(int num1, int num2, long int *resultado){ //2º Aponta pra o valor do endereço que recebeu//
    
    
    *resultado = num1 +num2;
    
   
    
}
int main(int argc, char** argv) {

    int num1, num2;
    long resultado;
    
    
    
    scanf(" %d", &num1);
    scanf(" %d", &num2);

    somar(num1, num2, &resultado); //1º Manda o endereço//
    
    printf("%ld", resultado);
    
    return (EXIT_SUCCESS);
}

