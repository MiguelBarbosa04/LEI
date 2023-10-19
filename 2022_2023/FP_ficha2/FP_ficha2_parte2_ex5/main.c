/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 21 de outubro de 2022, 10:43
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int co1,co2;

    printf("Diga o valor da coordenada X e da Y: ");
    scanf("%d %d",&co1,&co2);

    if( co1 > 0 && co2 > 0)
    printf("As coordenadas (%d,%d) situam-se no primeiro quadrante.\n",co1,co2);
    else if( co1 < 0 && co2 > 0)
    printf("As coordenadas (%d,%d) situam-se no segundo quadrante.\n",co1,co2);
    else if( co1 < 0 && co2 < 0)
    printf("As coordenadas (%d,%d) situam-se no terceiro quadrante.\n",co1,co2);
    else if( co1 > 0 && co2 < 0)
    printf("As coordenadas (%d,%d) situam-se no quarto quadrante.\n",co1,co2);
    else if( co1 == 0 && co2 == 0)
    printf("As coordenadas (%d,%d) stuam-se na origem.\n",co1,co2);
    return (EXIT_SUCCESS);
}

