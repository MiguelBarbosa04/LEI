/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 27 de outubro de 2022, 10:53
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int num, impar;
    
    do {
        printf("\nIntroduza um número positivo: ");
        scanf("%d", &num);
        printf("%d", num);
    
    } while (num <= 0);
    
    while (num >=0){
        
       
        impar = num%2;
        if (impar!=0){
            
            printf("\n%d ", num);
            
        }
        num--;
    }
    
       
   
    
    return (EXIT_SUCCESS);
}

