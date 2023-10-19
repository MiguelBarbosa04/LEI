/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Miguel
 *
 * Created on 17 de novembro de 2022, 14:55
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
void asterisco (int num1) {
    do{
        printf("*");
        num1--; 
    }while (num1 != 0);
        
    
}

void validar (int  min, int max) {
    int num1;
    
    
    do{
         printf("Insira um valor inteiro:");
        scanf("%d", &num1);
        
    }while(num1 <= min || num1 >= max );
    asterisco(num1);
    
}
    


int main(int argc, char** argv) {
    int num1;
    int min, max;
    printf("Insira o minimo: ");
    scanf("%d", &min);
    printf("Insira o maximo:");
    scanf("%d", &max);
    
   
    validar(min, max);  
    
    
    return (EXIT_SUCCESS);
}
