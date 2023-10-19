/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 21 de outubro de 2022, 10:51
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    char empregado, chefe, administrador;
    int cargo ,dias, ordenado_mes, subsidio;
    float ordenado_final ,irs, seguranca_social_funcionario, seguranca_social_patronal;
    
    printf("\n Opções: \n 1 - empregado\n 2 - chefe \n 3 - administrador\n Qual é o seu cargo:");
    scanf("%d", &cargo);
    printf("\n Quanto dias trabalhou este mês:");
    scanf("%d", &dias);
    
    
    switch (cargo)
    {
        case 1:
      

            ordenado_mes = dias*40;
            subsidio = dias*5;
            if (ordenado_mes < 1000){
                irs = ordenado_mes*0.1;  
                
                printf("Teste");
            }else if (ordenado_mes >= 1000){
                irs = ordenado_mes*0.2;
            }
            seguranca_social_funcionario = ordenado_mes * 0.11;
            seguranca_social_patronal = ordenado_mes * 0.2375;
            
            printf("O valor líquido a receber fruto do vencimento: %d", ordenado_mes);
            printf("Total subsídio de alimentação: %d", subsidio);
            printf("Valor da rentenção de IRS a entregar ao estado: %f", irs);
            printf("Valor total a entregar à Segurança Social por parte do funcionário é %f e da parte patronal é %f", seguranca_social_funcionario, seguranca_social_patronal );
            printf("Valor líquido a receber pelo funcionário: %f", ordenado_final);
            
            break;
            
        case 2:
           
            printf("Teste");
            break;
            
        case 3:
            printf("Escolheu a opção 3");  
            break;
        default:
           printf("Inseriu uma opcção inválida");
    }
    
    
    return (EXIT_SUCCESS);
}

