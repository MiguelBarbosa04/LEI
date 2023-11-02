/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 10:43
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    float valor1, valor2, valor3;
    float media, vinte, trinta, cinquenta, media_ponderada;
    
    printf("Insira o primeiro valor: ");
    scanf("%f", &valor1);
    printf("Insira o segundo valor: ");
    scanf("%f", &valor2);
    printf("Insira o terceiro valor: ");
    scanf("%f", &valor3);
    
    media = (valor1 + valor2 + valor3)/3.0;
    printf(" A média é: %.2f", media);
  
    
    
    vinte = valor1 * 0.2;
    printf(" \n Vinte porcento do primeiro valor é: %.2f ", vinte);
    
    trinta = valor2 * 0.3;
    printf(" \n Trinta porcento do segundo valor é: %.2f ", trinta);
    
    cinquenta = valor3 * 0.5;
    printf(" \n Cinquenta porcento do terceiro valor é: %.2f ", cinquenta);
    
    media_ponderada = vinte + trinta + cinquenta;
    printf("\n A média ponderada é: %.2f", media_ponderada);
    
    

    return 0;
}

