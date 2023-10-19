/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 27 de outubro de 2022, 09:49
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
/**
 * Imprime o alfabeto em maiúsculas ou minúsculas
 * Valida input do utilizador
 * Exemplo de resolver com while ou for
*/
int main() {
 
    char c;
    do {
    printf("\nDigite M ou m: ");
    c = getchar();
    getchar();
    }while (c != 'M' && c != 'm');

    int start = 'a';
    if (c == 'M')
    start = 'A';

    int lim = 'Z' - 'A';
    int i = 0;
    while(i < lim)
    printf("%c ", start + (i++));

    //ou
    printf("\n");
    for (i=0;i<lim;i++)
    printf("%c ", start + i);
   }