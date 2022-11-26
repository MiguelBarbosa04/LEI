/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 09:57
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    int num1;
    int num2;
    int num3;
    
    printf("Diga o primeiro número inteiro: ");
    scanf("%d", &num1);
    
    printf("Diga o segundo número inteiro: ");
    scanf("%d", &num2);
    
    printf("Diga o terceiro número inteiro: ");
    scanf("%d", &num3);
    
    if (num1 < num2 && num1 < num3) {
        printf("O número menor é: %d", num1);

    }else if (num2 < num1 && num2 < num3){
        printf("O número menor é: %d", num2);
    
    }else{
        printf("O número menor é: %d", num3); 
       
    }    
    return (EXIT_SUCCESS);
}

