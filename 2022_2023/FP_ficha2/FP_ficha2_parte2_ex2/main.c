/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 20 de outubro de 2022, 11:08
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    char operacao, x;
    float saldo, quantidade;
    
    
    printf("Insira o seu saldo da conta bancária: ");
    scanf("%f", &saldo);
    scanf("%c", &x);
    printf("Quantidade: ");
    scanf("%f", &quantidade);
    scanf("%c", &x);
    printf("Deseja creditar ou debitar?(Insira 'C' para creditar e 'D' para debitar): ");
    scanf("%c", &operacao);
    scanf("%c", &x);
    
    switch(operacao)
    {
        case 'C':
            printf("%f + %f = %f",saldo, quantidade, saldo+quantidade);
            break;
        case 'D':
            if (saldo < quantidade){
            printf("Operação impossível");  
            break;
            }else{
                printf("%f - %f = %f",saldo, quantidade, saldo-quantidade);
            break;
            }
        default:
           printf("ERRO");
    }
    
    
    return (EXIT_SUCCESS);
}

