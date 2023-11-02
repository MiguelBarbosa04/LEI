/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 27 de outubro de 2022, 11:20
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

   
    float num1, num2, resultado;
    char operador, escolha;
    
    do{
    printf("Insira o primeiro valor: ");
    scanf("%f", &num1);
    printf("Insira o operador (+, -, *, /): ");
    scanf(" %c", &operador);
    printf("Insira o segundo valor: ");
    scanf("%f", &num2);
   
    
    switch(operador)
    {
        case 1:
            resultado = num1 + num2;
            printf("O resultado é:%.2f", resultado);
            break;
            
        case 2:
            resultado = num1 - num2;
            printf("O resultado é:%.2f", resultado);
            break;
        case 3:
            resultado = num1 * num2;
            printf("O resultado é:%.2f", resultado);
            break;
        case 4:
            resultado = num1 / num2;
            printf("O resultado é:%.2f", resultado);
            break;
        default : 
            resultado = num1 + num2;
            printf("O resultado é:%.2f", resultado);
           
        
    }
    
            printf("Deseja continuar= (s/n)");
            scanf(" %c", &escolha);
    
}
    while ( escolha == 's');


      

   
    return (EXIT_SUCCESS);
}

