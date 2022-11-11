/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cFiles/main.c to edit this template
 */

/* 
 * File:   main.c
 * Author: Escola
 *
 * Created on 11 de novembro de 2022, 15:45
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {
    
    
    int tCli ,NIF, pares, Tsapatos, tipo1,tipo2,tipo3;
    char lx, codigo = 'a', codigo_inserido;
    float desconto, mObra,cAdicional,mLucro, soma_obra = 0, soma_adicional = 0,total,totallucro=0,total_desconto, soma_desconto = 0;
    float total_obra, valor_final, valor_final2 = 0;
    int cont,i;
    
    printf("Insira o seu NIF:\n");
    scanf("%d",&NIF);
    scanf("%c",&lx);
    
    
        
    do {
        
    printf("Insira o tipo de cliente(1-Revendedor , 2-Cliente final , 3-Administrador):\n");
    
    scanf("%d",&tCli);
    scanf("%c",&lx);
    cont = 0;



    switch(tCli){
        case 1:
            printf("Escolheu o tipo 'Revendedor'\n");
            desconto = 0.10;
           
            break;
        case 2:
            printf("Escolheu o tipo'Cliente final'\n");
            printf("Insira o código promocional:\n");
            scanf("%c", &codigo_inserido);
            
            if (codigo_inserido == codigo){
                printf("Conseguiu um desconto de 5%%");
                desconto = 0.05;
            }else{
                printf("Codigo incorreto");
                desconto = 0.00;
            }
            break;
        case 3:
            printf("Escoheu o tipo Administrador\n");
        break;
        
        default:
            printf("O tipo de cliente inserido não existe! Tente outra vez!\n");
            cont = 1;
            
    }
    }while (cont != 0 );
    cont = 0;
    
    
    do {
        do{
            printf("Insira a quantidade de sapatos: ");
            i = scanf("%d", &pares);
            if (i != 1){
                printf("Insulto");
            }
        }while (i!= 1);
        if (pares > 0){
            
            do{  
            cont = 0;
            printf("Qual sapato voçê deseja?\n1- Botas\n2- Sandalias\n3- Outros\n");
            scanf("%d", &Tsapatos);
        
        switch(Tsapatos){
           
                
            
            
            case 1: 
                printf("Escolheu botas: ");
                mObra = 7.00 * pares;
                soma_obra += mObra;
                tipo1= pares;
                cAdicional = 3.5 * pares;
                soma_adicional += cAdicional;
                mLucro= (mObra + cAdicional) *0.40;
                totallucro += mLucro;
                total_obra = mObra + cAdicional;
                total_desconto = (total_obra + mLucro) * desconto;
                soma_desconto += total_desconto;
                valor_final =  (total_obra + mLucro) - total_desconto;
                valor_final2 += valor_final;
               /* soma += pares;*/
                
                
                break;
                
                
            case 2:
                printf("Escolheu sandalias");
                mObra = 4.00 * pares;
                soma_obra += mObra;
                tipo2 = pares;
                cAdicional = 3.00 * pares;
                soma_adicional += cAdicional;
                mLucro= (mObra + cAdicional) *0.25;
                totallucro += mLucro;
                desconto += 0.15;
                total_obra = mObra + cAdicional;
                total_desconto = ((total_obra)+ mLucro) * desconto;
                soma_desconto += total_desconto;
                valor_final =  (total_obra + mLucro) - total_desconto;
                valor_final2 += valor_final;
               /* soma += pares;*/
                
                break;
                
            case 3: 
                printf("Escolheu outros");
                mObra = 5.00 * pares;
                soma_obra += mObra;
                tipo3 = pares;
                cAdicional = 3.00 * pares;
                soma_adicional += cAdicional;
                mLucro= (mObra + cAdicional) *0.30;
                totallucro += mLucro;
                total_obra = mObra + cAdicional;
                total_desconto = (total_obra + mLucro) * desconto;
                soma_desconto += total_desconto;
                valor_final =  (total_obra + mLucro) - total_desconto;
                valor_final2 += valor_final;
                /*soma += pares;*/
                
                break;
                
                default:
                    printf("Opção incorreta! Tente novamente.\n");
                    cont = 1;
        
        }
                
        }while (cont != 0);
        cont = 0;

        }
    } while (pares > 0);
    printf("\nA sua ecomenda foi concluida no seguinte nif %d", NIF);
    printf("\nEncomendou %d pares de botas, %d pares de sandalias e %d pares de outros tipos, sendo o total de %d pares", tipo1, tipo2, tipo3, (tipo1+tipo2+tipo3));
    printf("\nO custo de mão obra foi %.2f ", soma_obra);
    printf("\nO custo adicional foi de %.2f", soma_adicional);
    printf("\n A margem de lucro foi de %.2f", totallucro);
    printf("\n Desconto:%.2f", soma_desconto);
    printf("\n Valor final da encomenda: %.2f", valor_final2);

    return (EXIT_SUCCESS);
}

