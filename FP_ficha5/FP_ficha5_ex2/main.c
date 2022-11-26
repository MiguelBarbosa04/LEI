/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 10 de novembro de 2022, 12:05
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */

long soma(float num1, float num2) {
    return  num1 + num2; 
}

long subtracao(float num1, float num2){

     return  num1- num2; 
}

long multiplicacao (float num1, float num2){
    return num1*num2;   
}

long divisao (float num1, float num2){
    return num1/num2;  
}

int main(int argc, char** argv) {

    float num1, num2, resultado;
    char sinal;
    
    printf("Diga o primeiro valor:");
    scanf("%f", &num1);
    printf("Diga o primeiro valor:");
    scanf("%f", &num2);
    printf("Diga que operação pretende utilizar: ( + - somar , - - subtração, * - multiplicação, / - divisão) : ");
    scanf(" %c", &sinal);
    
    switch(sinal)
    {
        case '+':
            resultado = soma(num1, num2);
            printf("O resultado é:%f", resultado);
            
            break;
            
        case '-':
            resultado = subtracao(num1, num2);
            printf("O resultado é:%f", resultado);
            break;
            
            case '*':
            resultado = multiplicacao(num1, num2);
            printf("O resultado é:%f", resultado);
            break;
            
            case '/':
            resultado = divisao(num1, num2);
            printf("O resultado é:%f", resultado);
            break;
            
        default:
            printf("Introduziu um caracter errado");
            break;
    }
   
    
    
    return 0;
}

