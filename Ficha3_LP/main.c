/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cFiles/main.c to edit this template
 */

/* 
 * File:   main.c
 * Author: Escola
 *
 * Created on 4 de novembro de 2022, 10:32
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int nif, Tcliente,cont,Tcal,pares;
    float desconto,custo_obra,custo_associado,lucro, Mlucro, total, total2, valor_final;
    char lx, codigo_inserido, codigo = 'a'; 
    
   
    
    
    
    
    printf("Insira o seu nif: ");
    scanf("%d", &nif);
    
    do{
    printf("Insira o tipo do cliente:\n1- Revendedores\n2- Clientes Finais\n3- Administrador");
    scanf("%d", &Tcliente);
    scanf("%c", &lx);
    cont = 0;
        
    switch(Tcliente){
        case 1 :
            printf("\nEscolheu o perfil Revendedor ");
            desconto = 0.10;
            break;
         
        
        case 2 :
            printf("\nEscolheu o perfil Clientes Finais");
            printf("\nInsira o codigo promocional: ");
            scanf("%c", &codigo_inserido);
            
            if (codigo_inserido == codigo){
                printf("Parabens teve um desconto de 5%%");
                desconto = 0.05;
                
            }else{
                printf("O codigo inserido está incorreto");
                desconto = 0.00;
            }
            break;
         
        case 3 :
            printf("\nEscolheu o perfil administrador");
            break;
            
            
        default:
            printf("O tipo de cliente nao existe. Tente novamente\n");
            cont = 1;
        
    }
    }while (cont!= 0);
    cont= 0; 
    
    
    do {
    printf("Insira o tipo de calçado.\n1-Botas\n2- Sandalias\n3- Outros\n0 - Terminar");
    scanf("%d", &Tcal);
        
    printf ("Quantos pares deseja: ");
    scanf("%d", &pares);
    } 
    while(Tcal != 0 );
    
    switch(Tcal) {
        
        
 
        case 1:
            printf("Escolheu botas ");
            custo_obra = 14.00;
            custo_associado = 3.5;
            lucro = 0.40;
            break;
            
        case 2:
            printf("Escolheu sandalias ");
            custo_obra = 8.00;
            custo_associado = 3.00;
            lucro = 0.25;
            desconto = desconto + 0.15;
            break;
            
    
    
        case 3:
            printf("Escolheu outros");
            custo_obra = 10.00;
            custo_associado = 3.00;
            lucro = 0.30;
            break;
            
        default: 
            printf("Tipo de calçado incorreto. Tente novamente");
            
    }
    
       
    
   

    
    custo_obra =custo_obra * pares;
    custo_associado= custo_associado* pares ;
    total = custo_associado + custo_obra;
    Mlucro =total * lucro;
    total2=total  +lucro;
    valor_final = total2-(total2*desconto);
    
    printf(" NIF: %d\n"
            " Cliente: %d\n"
            " Nº de pares: %d\n"
            " Tipo de Calçado: %d\n"
            " Mao de obra: %.2f€\n"
            " Custos adicionais: %.2f€\n"
            " Margem de Lucro: %.2f€\n"
            " Desconto total: %.2f%%\n"
            " Valor final: %.2f€\n",nif,Tcliente,pares,Tcal,custo_obra,custo_associado,lucro,(desconto*100),valor_final);
          
    return (EXIT_SUCCESS);
}

