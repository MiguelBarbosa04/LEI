/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 09:26
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

 float raio, pi, area_circunferencia;    
 float alturatriangulo, base, area_triangulo;
 pi = 3.14;
    
    
    printf("Insira o raio da circunferência: ");
    scanf("%f", &raio);
    area_circunferencia = pi * (raio*raio);
   
    printf("A área da circunferência é: %4.2f \n" ,area_circunferencia);

    printf("Insira a altura do trinângulo: ");
    scanf("%f", &alturatriangulo);
    printf("Insira a base do triangulo: ");
    scanf("%f", &base);
    area_triangulo = (base * alturatriangulo)/ 2;
            
    printf("A área do triângulo é: %4.2f", area_triangulo );
    return 0;
    
    
}