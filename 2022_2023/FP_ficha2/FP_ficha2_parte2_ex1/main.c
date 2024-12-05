/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 10:48
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    char operacao;
    double n1, n2;
    
    printf("Diga a operação que deseja fazer: soma(+), subtração(-), divisão(/) ou multiplicação(*): ");
    scanf("%c", &operacao);
    printf("Diga o primeiro valor: ");
    scanf("%lf",&n1);
    printf("Diga o segundo valor: ");
    scanf("%lf", &n2);
    printf("Por default vai ser realizada a soma");
    
    
    switch(operacao)
    {
        case '+':
            printf("%lf + %lf = %lf",n1, n2, n1+n2);
            break;
         case '-':
            printf("%lf - %lf = %lf",n1, n2, n1-n2);  
            break;
        case '*':
            printf("%lf * %lf = %lf",n1, n2, n1*n2);
            break;
        case '/':
            printf("%lf / %lf = %lf",n1, n2, n1/n2);
            break;
            
        default:
           printf("%lf + %lf = %lf",n1, n2, n1+n2);
    }
    return (EXIT_SUCCESS);
}

