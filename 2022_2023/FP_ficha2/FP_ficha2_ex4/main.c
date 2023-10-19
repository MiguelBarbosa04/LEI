/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 10:25
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int num1;

    printf("Diga um número:");
    scanf("%d", &num1);
    
    if ((num1 % 2) == 0){
        printf("\n O número é par");
    }else{
        printf("\n O número é ímpar");
    }
    
    return (EXIT_SUCCESS);
}

