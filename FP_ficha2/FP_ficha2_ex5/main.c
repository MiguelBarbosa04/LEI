/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 10:39
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int a;
    
    printf("Diga o valor da variável a: ");
    scanf("%d", &a);
    switch (a) {
        
        case 1:
            a=1;
            printf("O valor é um");
            break;
        case 2:
            a=2;
            printf("O valor é dois");
            break;
        case 3:
            a=3;
            printf("O valor é três");
            break;
        default:    
            printf("Escolheu outro número");
    }
    return (EXIT_SUCCESS);
}


