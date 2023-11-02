/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 10:01
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    char c, mais, menos;
        
    
    printf("Diga um caracter: " );
    scanf("%c", &c);
    mais = c -1;
    menos = c + 1; 
    
    printf("O antecessor é: %c", menos );
    printf("\n O sucessor é: %c", mais );

    return 0;
}
