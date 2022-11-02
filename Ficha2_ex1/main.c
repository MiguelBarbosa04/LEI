/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cFiles/main.c to edit this template
 */

/* 
 * File:   main.c
 * Author: Escola
 *
 * Created on 28 de outubro de 2022, 09:19
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    int nif, numeros_pares, perfil, tipo;
    float desconto_revendedor,codigo_promocional, desconto_adicional, custo_obra, custo_asocciado, lucro, valor_final_lucro;
    float valor_total, valor_final, valor_apos_adicional;
   
    
    
    printf("Qual é o seu nif: ");
    scanf("%d", &nif);
    
    printf("\nTipos de perfil\nRevendedores\nClientes Finais.");
    printf("\nQual é o seu tipo de perfil?: ");
    scanf("%d", &perfil);
    
    printf("1- Botas\n2- Sandalias\n3- Outros");
    printf("\nQual é o tipo do calçado: ");
    scanf("%d", &tipo);
    
    printf("\nQuantos pares deseja encomendar: ");
    scanf("%d", &numeros_pares);
    
   
    
    
    switch(perfil){
        case 1 :
            if (tipo == 1){
                custo_obra = numeros_pares * 14;
                custo_asocciado = numeros_pares * 3.5;
                valor_total = custo_obra + custo_asocciado;
                lucro = valor_total * 0.40;
                valor_final_lucro = valor_total + lucro;
                desconto_revendedor = valor_final_lucro * 0.10;
                valor_final = valor_final_lucro - desconto_revendedor;
                
                printf("A encomenda de %d pares de botas está feita no seguinte nif %d com o perfil de revendedor.",numeros_pares, nif);
                printf("\nO valor final da encomenda foi de %.2f euros", valor_final);
                printf("\nO custo da obra foi de %.2f$\nO custo adicional foi de %.2f euros", custo_obra, custo_asocciado);
                printf("\nA margem de lucro foi de 40 por cento e foi de %.2f euros", lucro);
                printf("\nO desconto incluido foi de 10 por cento por causa do perfil revendedor e foi de %.2f euros", desconto_revendedor);
               
            } else if(tipo == 2){
                custo_obra = numeros_pares * 8;
                custo_asocciado = numeros_pares * 3;
                valor_total = custo_obra + custo_asocciado;
                desconto_adicional = valor_total * 0.15;
                valor_apos_adicional = valor_total - desconto_adicional;
                lucro = valor_apos_adicional * 0.25;
                valor_final_lucro = valor_apos_adicional + lucro;
                desconto_revendedor = valor_final_lucro * 0.10;
                valor_final = valor_final_lucro - desconto_revendedor;
                
                printf("A encomenda de %d pares de sandalias está feita no seguinte nif %d com o perfil de revendedor.",numeros_pares, nif);
                printf("\nO valor final da encomenda foi de %.2f euros", valor_final);
                printf("\nO custo da obra foi de %.2f$\nO custo adicional foi de %.2f euros", custo_obra, custo_asocciado);
                printf("\n Como escolheu sandalias teve um desconto de %.2f", desconto_adicional);
                printf("\nA margem de lucro foi de 25 por cento e foi de %.2f euros", lucro);
                printf("\nO desconto incluido foi de 10 por cento por causa do perfil revendedor e foi de %.2f euros", desconto_revendedor);
                
            }else if(tipo == 3)custo_obra = numeros_pares * 10;
                custo_obra = numeros_pares * 10;
                custo_asocciado = numeros_pares * 3;
                valor_total = custo_obra + custo_asocciado;
                lucro = valor_total * 0.3;
                valor_final_lucro = valor_total + lucro;
                desconto_revendedor = valor_final_lucro * 0.10;
                valor_final = valor_final_lucro - desconto_revendedor;
                
                printf("A encomenda de %d pares de sandalias está feita no seguinte nif %d com o perfil de revendedor.",numeros_pares, nif);
                printf("\nO valor final da encomenda foi de %.2f euros", valor_final);
                printf("\nO custo da obra foi de %.2f$\nO custo adicional foi de %.2f euros", custo_obra, custo_asocciado);
                printf("\nA margem de lucro foi de 25 por cento e foi de %.2f euros", lucro);
                printf("\nO desconto incluido foi de 10 por cento por causa do perfil revendedor e foi de %.2f euros", desconto_revendedor);
            ;
            
    }
            

    return (EXIT_SUCCESS);
}

