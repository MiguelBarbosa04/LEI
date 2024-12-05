/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 10 de novembro de 2022, 11:05
 */

#include <stdio.h>
#include <stdlib.h>


void asterisco(int num1){
    
    do
    {
         printf("*");
         num1--;
    }
     while(num1 !=0);
     
     
    
}

int main(int argc, char** argv) {
    
    int num1;

    printf("Diga o número:");
    scanf("%d", &num1);
    
    asterisco(num1);

    return (EXIT_SUCCESS);
}

