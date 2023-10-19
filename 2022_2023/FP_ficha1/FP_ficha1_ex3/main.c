/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 09:23
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

   
    int num1, num2; 

    printf("Insira um número: " );
    scanf("%d", &num1);
    printf("Insira um número: " );
    scanf("%d", &num2);
    printf("A soma dos dois números é: %d\n", num1 + num2 );
    printf("A subtração dos dois números é: %d\n", num1 - num2 );
    printf("A multiplicação dos dois números é: %d\n", num1 * num2 );
    printf("A divisão dos dois números é: %d\n", num1 / num2 );
    return 0;
    
}