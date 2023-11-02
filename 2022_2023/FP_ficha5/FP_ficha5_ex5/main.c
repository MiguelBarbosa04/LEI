/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 13 de novembro de 2022, 21:41
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

int factorial(int valor){
    if(valor==0){
        return 1;
    }
    return valor * factorial(valor-1);
 
}
int main(int argc, char** argv) {

    int num, resultado;
    
    printf("Diga o valor:");
    scanf("%d", &num);
    
    resultado = factorial(num);
    
    printf("%d", resultado);
    
    
    
    return (EXIT_SUCCESS);
}

