/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 27 de outubro de 2022, 11:57
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    char opcao;
    
    
    do {
    printf("1. Criar");
    printf("\n2. Atualizar");
    printf("\n3. Eliminar");
    printf("\n4. Sair");
    printf("\nInsira a opção que deseja:");
    scanf(" %c", &opcao);
    
    switch (opcao){
        case '1':
            printf("Escolheu a primeira opção\n");
            break;
        case '2':
            printf("Escolheu a segunda opção\n");
            break;
        case '3':
            printf("Escolheu a terceira opção\n");
            break; 
        case '4':
            break;
        default:
           printf("Escolheu uma opção inválida\n");
    }
    
    }while (opcao != '4');
    printf("Saiu");
    
    
    
    return (EXIT_SUCCESS);
}

