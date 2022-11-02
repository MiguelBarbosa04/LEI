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
    
    const char CODE_DESC='A';
    unsigned int NIF,nPar;
    int cont;
    float tot1,mObra,cAdi,mLucro,desc,tot2,valorf;
    char DescTent,tCli,tCal,lx;
    
    printf("Insira o seu NIF:\n");
    scanf("%u",&NIF);
    scanf("%c",&lx);
    
    do{
    printf("Insira o tipo de cliente(R-Revendedor ou C-Cliente final):\n");
    cont=0;
    scanf("%c",&tCli);
    scanf("%c",&lx);
    switch(tCli){
        case 'R':
            printf("Escolheu o tipo 'Revendedor'\n");
            desc=0.10;
            break;
        case 'C':
            printf("Escolheu o tipo'Cliente final'\n");
            printf("Insira o código promocional:\n");
            scanf("%c",&DescTent);
            
            if(DescTent==CODE_DESC){
                printf("Parabens! Ganhou 5%% de desconto!\n");
                desc=0.05;
            }else{
                printf("O código inserido estava incorreto!\n");
                desc=0.00;
            }
            break;
        default:
            printf("O tipo de cliente inserido não existe! Tente outra vez!\n");
            cont=1;
    }
    }while(cont!=0);//Cliente final ou revendedor//
    cont=0;

    do{ 
    printf("Insira o tipo de calcado a encomendar(B-Botas S-Sandalias O-Outros Tipos):\n");
    cont=0;
    scanf(" %c",&tCal);
    switch(tCal){
        case 'B':
            printf("Escolheu 'Botas'\n");
            
            mObra=7.00;
            cAdi=3.5;
            mLucro=0.40;
            break;
        case 'S':
            printf("Escolheu 'Sandalias'\n");
            
            mObra=4.00;
            cAdi=3.00;
            mLucro=0.25;
            desc=desc+0.15;
            break;
        case 'O':
            printf("Escolheu 'Outro Tipo'\n");
            
            mObra=5.00;
            cAdi=3.00;
            mLucro=0.30;
            break;
        default:
            printf("Tipo de calcado não disponivel. Por favor insira outra vez!\n");
            cont=1;
    }
    }while(cont!=0); //Sandálias Botas ou Outros//
    cont=0;
    
    printf("Insira o nº de pares:\n");
    scanf("%u",&nPar);
    scanf("%c",&lx);
    
    mObra=mObra*nPar;
    cAdi=cAdi*nPar;
    tot1=mObra+cAdi;
    mLucro=tot1*mLucro;
    tot2=tot1+mLucro;
    valorf= tot2-(tot2*desc);
    
    printf(" NIF: %u\n"
            " Cliente: %c\n"
            " Nº de pares: %u\n"
            " Nº de sapatos encomendados: %u\n"
            " Tipo de Calçado: %c\n"
            " Mao de obra: %.2f€\n"
            " Custos adicionais: %.2f€\n"
            " Margem de Lucro: %.2f€\n"
            " Desconto total: %.2f%%\n"
            " Valor final: %.2f€\n",NIF,tCli,nPar,(nPar*2),tCal,mObra,cAdi,mLucro,(desc*100),valorf);
    

    return (EXIT_SUCCESS);
}

