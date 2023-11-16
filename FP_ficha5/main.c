/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 16 de novembro de 2023, 09:27
 */

#include <stdio.h>
#include <stdlib.h>
#include "myIntLib.h"

/*
 * 
 */



void ex4() {

    int m1[3][3];
    int m2[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Fila[%d]Coluna[%d] Numero: ", i, j);
            scanf("%d", &m1[i][j]);
        }
    }
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("Fila[%d]Coluna[%d] Numero: ", i, j);
            scanf("%d", &m2[i][j]);
        }
    }
    somarm(m1, m2);
    somarElementos(m1, m2);
}

void ex3() {

    int n1, n2;

    printf("Diga o n1: ");
    scanf("%d", &n1);
    printf("Diga o n2: ");
    scanf("%d", &n2);

    somar(n1, n2);
    sub(n1, n2);
    multi(n1, n2);
    divi(n1, n2);
}

void ex1() {

    int n;

    printf("Diga um número: ");
    scanf("%d", &n);
    imprimir(n);

}

void P2ex1() {

    int n;
    int inferior, superior;

    printf("Diga o limite inferior: ");
    scanf("%d", &inferior);
    printf("Diga o limite superior: ");
    scanf("%d", &superior);


    imprimir(limites(inferior, superior));
}

void P2ex2() {

    int tamanho;
    int notas[tamanho];
    int inferior = 0;
    int superior = 20;
    float soma = 0;

    printf("Diga o tamanho da turma: ");
    scanf(" %d", &tamanho);

    for (int i = 0; i < tamanho; i++) {
        notas[i] = limites(inferior, superior);
        soma += notas[i];
    }



    printf("\nSoma -> %.2f", soma);
    printf("\nMedia -> %.2f", media(soma, tamanho));

}

void P2ex3() {

    int n1, n2;

    printf("Diga o valor de n1: ");
    scanf("%d", &n1);
    printf("Diga o valor de n2: ");
    scanf("%d", &n2);

    valorMinAndMax(n1, n2);

}

void P2ex4() {

    int base;
    int expoente;

    printf("Diga a base : ");
    scanf("%d", &base);
    printf("Diga a expoente : ");
    scanf("%d", &expoente);

    int resultado = potencia(base, expoente);

    printf("%d elevado a %d é igual a %d\n", base, expoente, resultado);

}

void P2ex5() {


    int op;
    int n1, n2;


    printf("Bem-vindo á melhor calculadora do mundo!");
    printf("Diga o num1: ");
    scanf("%d", &n1);
    printf("Diga o num2: ");
    scanf("%d", &n2);
    printf("1 - SOMA");
    printf("2 - SUBTRACAO");
    printf("3 - MULTIPLICACAO");
    printf("4 - DIVISAO");

    switch (op) {
        case 1:
            imprimir(somar(int n1, int n2));
        case 2:
            imprimir(sub(int n1, int n2));
        case 3:
            imprimir(multi(int n1, int n2));
        case 4:
            imprimir(divi(int n1, int n2));
        default:
            printf("Inseriu uma opcao invalida");
    }
}

int main(int argc, char** argv) {


    P2ex5();
    return 0;
}

