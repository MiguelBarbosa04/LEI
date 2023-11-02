/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 11:53
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int num;
    
    
    printf("1 -- Criar \n");
    printf("\n2 -- Atualizar \n");
    printf("\n3 -- Eliminar \n");
    printf("\n4 -- Sair \n");
    
    
    printf("\n Escolha a opcção:");
    scanf("%d", &num);
    
    
    switch(num)
    {
        case 1:
            printf("Escolheu a opção 1");
            break;
        case 2:
            printf("Escolheu a opção 2");  
            break;
        case 3:
            printf("Escolheu a opção 3");  
            break;
        case 4:
            return (EXIT_SUCCESS);  
            break;
        default:
           printf("Inseriu uma opcção inválida");
    }
    
    return (EXIT_SUCCESS);
}

