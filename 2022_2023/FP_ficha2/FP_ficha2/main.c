/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 09:49
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int num1;
    int num2;
    
    printf("Diga um número inteiro: ");
    scanf("%d", &num1);
    
    printf("Diga outro número inteiro: ");
    scanf("%d", &num2);
    
    if (num1 > num2) {
        printf("A ordem do maior para o menor é: %d ,%d", num1, num2);
        
    }else {
        printf("A ordem do maior para o menor é: %d , %d", num2, num1);
        
     }
        
        
    
    
    return (EXIT_SUCCESS);
}

