/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: gleao
 *
 * Created on 26 de outubro de 2021, 20:45
 */

#include <stdio.h>
#include <stdlib.h>
#include "biblio.h"

/*
 * 
 */

int main() {
    
int desc = 0;
const int codSecr = 123;
int nif = 0;
int menuAdm = 1, menu = 0, menu2;

    for(j = 0; j < 12; j++){
        sap[j] = 0;
        bot[j] = 0;
        san[j] = 0;
        if(j<=3){
            pre[j] = 0.1;
            pre1[j] = 0.2;
        }else if(j>=9){
            pre[j] = 0.0;
            pre1[j] = 0.0;
        }else{
            pre[j] = 0.15;
            pre1[j] = 0.25;
        }
    }
    
    while(menu != 5) {
        switch (menu) {
            default:
                menu = menuInicial(menuAdm);
                break;
                
            case 0:
                menu = menuInicial(menuAdm);
                for(l = 0; l < 12; l++){
                    sap[l] = 0;
                    bot[l] = 0;
                    san[l] = 0;
                }
                break;
                
            case 1:
                nif = funNif(nif);
                menu = 0;
                break;
                
            case 2:
                desc = codDesc(desc);
                menu = 0;
                break;
                
            case 3:
                if(clie == 1) {
                    printf("tipo de cliente atual: revendedor \n");
                } else if(clie == 2) {
                    printf("tipo de cliente atual: cliente final \n");
                }else if(clie == 3){
                    printf("tipo de cliente atual: administrador \n");
                }
                printf("1-revendedor \n2-cliente final \n3-administrador");
                scanf("%d",&clie);
                if(clie == 3){
                    menuAdm = 0;
                }else{
                    menuAdm = 1;
                }
                printf("\e[1;1H\e[2J");
                printf("Tipo de cliente atualizado.\n");
                menu = 0;
                break;
                
            case 4:
                if(menuAdm != 0){
                while(op != 5){
                printf("1-comprar sapatos \n2-comprar sandalias \n3-comprar botas \n4-terminar pedido \n5-voltar ao menu");
                scanf("%d",&op);
                if(op < 3){
                    for(j = 1; j < 13; j++){
                        printf("%d-%d \n",j,j+34);
                    }
                    scanf("%d",&opp);
                    printf("quantos pares quer encomendar? ");
                    scanf("%d", &enc);
                }
                
                funConta(op,opp,enc);
                
                }
                }else{
                    printf("Nao pode efetuar compras como administrador\n");
                }
                op = 0;
                printf("\n");
                menu = 0;
                break;
            case 6:
                if(menuAdm == 0){
                    while(menu2 != 6){
                    printf("1-alterar lucro \n2-alterar custos de mao de obra \n3-alterar descontos \n4-alterar custos adicionais \n5-alterar descontos de calçado \n6-voltar atras");
                    scanf("%d",&menu2);
                    printf("\e[1;1H\e[2J");
                    
                    switch(menu2){
                        case 0:
                            printf("1-alterar lucro \n2-alterar custos de mao de obra \n3-alterar descontos \n4-alterar custos adicionais \n5-alterar descontos de calçado \n6-voltar atras");
                            scanf("%d",&menu2);
                            printf("\e[1;1H\e[2J");
                            break;
                        case 1:
                            printf("1-lucro botas \n2-lucro sandalias \n3-lucro outros \n4-voltar atras");
                            scanf("%d",&menuLucro);
                            while(menuLucro != 4){
                                printf("\e[1;1H\e[2J");
                                switch(menuLucro){
                                    case 0:
                                        printf("1-lucro botas \n2-lucro sandalias \n3-lucro outros \n4-voltar atras");
                                        scanf("%d",&menuLucro);
                                        printf("\e[1;1H\e[2J");
                                        break;
                                    case 1:
                                        printf("desconto atual: %f",lucroBotas);
                                        scanf("%f",&lucroBotas);
                                        printf("\e[1;1H\e[2J");
                                        printf("lucro das botas alterado para: %f\n",lucroBotas);
                                        menuLucro = 0;
                                        break;
                                    case 2:
                                        printf("desconto atual: %f",lucroSandalias);
                                        scanf("%f",&lucroSandalias);
                                        printf("\e[1;1H\e[2J");
                                        printf("lucro das sandalias alterado para: %f\n",lucroSandalias);
                                        menuLucro = 0;
                                        break;
                                    case 3:
                                        printf("desconto atual: %f",lucroOutros);
                                        scanf("%f",&lucroOutros);
                                        printf("\e[1;1H\e[2J");
                                        printf("lucro dos sapatos alterado para: %f\n",lucroOutros);
                                        menuLucro = 0;
                                        break;   
                                }
                            }
                            printf("\e[1;1H\e[2J");
                            menu2 = 0;
                            break;
                        case 2:
                            printf("Custo de mao de obra: \n1-botas \n2-sandalias \n3-outros \n4-voltar atras");
                            scanf("%d",&menuObra);
                            printf("\e[1;1H\e[2J");
                            while(menuObra != 4){
                                switch(menuObra){
                                    case 0:
                                        printf("Custo de mao de obra: \n1-botas \n2-sandalias \n3-outros \n4-voltar atras");
                                        scanf("%d",&menuObra);
                                        printf("\e[1;1H\e[2J");
                                        break;
                                    case 1:
                                        printf("desconto atual: %d",obraBotas);
                                        scanf("%d",&obraBotas);
                                        printf("\e[1;1H\e[2J");
                                        printf("Custo de mao de obra das botas alterado para: %d\n",obraBotas);
                                        menuObra = 0;
                                        break;
                                    case 2:
                                        printf("desconto atual: %d",obraSandalias);
                                        scanf("%d",&obraSandalias);
                                        printf("\e[1;1H\e[2J");
                                        printf("Custo de mao de obra das sandalias alterado para: %d\n",obraSandalias);
                                        menuObra = 0;
                                        break;
                                    case 3:
                                        printf("desconto atual: %d",obraOutros);
                                        scanf("%d",&obraOutros);
                                        printf("\e[1;1H\e[2J");
                                        printf("Custo de mao de obra dos sapatos alterado para: %d\n",obraOutros);
                                        menuObra = 0;
                                        break;   
                                }
                            }
                            break;
                        case 3:
                            printf("descontos: \n1-sandalias \n2-revendedor \n3-codigo \n4-voltar atras");
                            scanf("%d",&menuDesc);
                            printf("\e[1;1H\e[2J");
                            while(menuDesc != 4){
                                switch(menuDesc){
                                    case 0:
                                        printf("descontos: \n1-sandalias \n2-revendedor \n3-codigo \n4-voltar atras");
                                        scanf("%d",&menuDesc);
                                        printf("\e[1;1H\e[2J");
                                        break;
                                    case 1:
                                        printf("desconto atual: %f",DescSandalias);
                                        scanf("%f",&DescSandalias);
                                        printf("\e[1;1H\e[2J");
                                        printf("desconto das sandalias alterado para: %f\n",DescSandalias);
                                        menuDesc = 0;
                                        break;
                                    case 2:
                                        printf("desconto atual: %f",DescRevendedor);
                                        scanf("%f",&DescRevendedor);
                                        printf("\e[1;1H\e[2J");
                                        printf("desconto de revendedor alterado para: %f\n",DescRevendedor);
                                        menuDesc = 0;
                                        break;
                                    case 3:
                                        printf("desconto atual: %f",DescCodigo);
                                        scanf("%f",&DescCodigo);
                                        printf("\e[1;1H\e[2J");
                                        printf("desconto de codigo alterado para: %f\n",DescCodigo);
                                        menuDesc = 0;
                                        break;   
                                }
                            }
                            break;
                        case 4:
                            printf("Custos adicionais: \n1-botas \n2-sandalias \n3-outros \n4-voltar atras");
                            scanf("%d",&menuAdc);
                            printf("\e[1;1H\e[2J");
                            while(menuAdc != 4){
                                switch(menuAdc){
                                    case 0:
                                        printf("Custos adicionais: \n1-botas \n2-sandalias \n3-outros \n4-voltar atras");
                                        scanf("%d",&menuAdc);
                                        printf("\e[1;1H\e[2J");
                                        break;
                                    case 1:
                                        printf("Custo adicional atual: %f",AdcBotas);
                                        scanf("%f",&AdcBotas);
                                        printf("\e[1;1H\e[2J");
                                        printf("O custo adicional das botas foi alterado para: %f\n",AdcBotas);
                                        menuAdc = 0;
                                        break;
                                    case 2:
                                        printf("Custo adicional atual: %f",AdcSandalias);
                                        scanf("%f",&AdcSandalias);
                                        printf("\e[1;1H\e[2J");
                                        printf("O custo adicional das sandalias foi alterado para: %f\n",AdcSandalias);
                                        menuAdc = 0;
                                        break;
                                    case 3:
                                        printf("Custo adicional atual: %f",AdcOutros);
                                        scanf("%f",&AdcOutros);
                                        printf("\e[1;1H\e[2J");
                                        printf("O custo adicional dos sapatos foi alterado para: %f\n",AdcOutros);
                                        menuAdc = 0;
                                        break;   
                                }
                            }
                            break;
                        case 5:
                            
                            printf("alterar: \n1-custos de mao de obra \n2-custos associados \n3-voltar atras");
                            scanf("%d",&menuNum);
                            printf("\e[1;1H\e[2J");
                            while(menuNum != 3){
                                switch(menuNum){
                                    case 0:
                                        printf("alterar: \n1-custos de mao de obra \n2-custos associados \n3-voltar atras");
                                        scanf("%d",&menuNum);
                                        printf("\e[1;1H\e[2J");
                                        break;
                                    case 1:
                                        while(menuNum1 != 13){
                                            for(j=1;j<13;j++){
                                                printf("%d-%d\n",j,j+34);
                                            }
                                            printf("13-voltar atras\n");
                                            scanf("%d",&menuNum1);
                                            printf("\e[1;1H\e[2J");
                                                for(j=1;j<13;j++){
                                                if(menuNum1 == j){
                                                    printf("Desconto atual: %f",pre[w]);
                                                    scanf("%f",&pre[w]);
                                                    printf("\e[1;1H\e[2J");
                                                    printf("A mao de obra dos sapatos, numero %d, foi alterada para: %.2f\n",j+34,pre[w]);
                                                    menuNum1 = 0;
                                                }
                                            }
                                            }
                                        printf("\e[1;1H\e[2J");
                                        menuNum1 = 0;
                                        menuNum = 0;
                                        break;
                                        case 2:
                                            while(menuNum2 != 13){
                                            for(j=1;j<13;j++){
                                                printf("%d-%d\n",j,j+34);
                                            }
                                            printf("13-voltar atras\n");
                                            scanf("%d",&menuNum2);
                                            printf("\e[1;1H\e[2J");
                                                for(j=1;j<13;j++){
                                                if(menuNum2 == j){
                                                    printf("Desconto atual: %f",pre1[w]);
                                                    scanf("%f",&pre1[w]);
                                                    printf("\e[1;1H\e[2J");
                                                    printf("O custo adicional dos sapatos, numero %d, foi alterado para: %.2f\n",j+34,pre1[w]);
                                                    menuNum2 = 0;
                                                }
                                            }
                                            }
                                        printf("\e[1;1H\e[2J");
                                        menuNum = 0;
                                        menuNum2 = 0;
                                        break;
                                }
                            }
                    }
                    printf("\e[1;1H\e[2J");
                    menu = 0;
                    }
                }else{
                    printf("\e[1;1H\e[2J");
                    menu = 0;
                    printf("caracter invalido!\n");
                    break;
                }
        }
    }
    printf("Bye Bye :(");
    return (EXIT_SUCCESS);
}