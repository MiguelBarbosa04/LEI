/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "myIntLib.h"

int somar(int n1, int n2) {

    int resultado;

    resultado = n1 + n2;
    printf("\nO resultado é : %d", resultado);

}

int sub(int n1, int n2) {

    int resultado;

    resultado = n1 - n2;

    printf("\nO resultado é : %d ", resultado);

}

int multi(int n1, int n2) {
    int r;

    r = n1*n2;

    printf("\nO resultado é :  %d", r);

}

int divi(int n1, int n2) {
    int r;
    r = n1 / n2;
    printf("\nO resultado é :  %d", r);
}

int limites(int inferior, int superior) {

    int n;

    do {
        printf("\nDiga um número: ");
        scanf("%d", &n);


        if (n < inferior || n > superior) {
            printf("\nDiga um número entre os intervalos que definiu");
        }
    } while (n < inferior || n > superior);

    return n;

}

void imprimir(int n) {

    for (int i = 0; i < n; i++) {
        printf("*");
    }

}

void somarElementos(int m1[3][3], int m2[3][3]) {

    int cont = 0;
    int newm[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            newm[i][j] = m1[i][j] + m2[i][j];
            cont += newm[i][j];
        }
    }

    printf("A soma dos elementos é : %d", cont);


}

void somarm(int m1[3][3], int m2[3][3]) {

    int newm[3][3];
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            newm[i][j] = m1[i][j] + m2[i][j];
        }
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%d", newm[i][j]);
        }
        printf("\n");
    }

}

float media(int soma, int tamanho) {

    float mediaTeste;

    mediaTeste = (float) soma / (float) tamanho;

    return mediaTeste;
}

void valorMinAndMax(int n1, int n2) {

    if (n1 == n2) {
        do{
        printf("Os valores não podem ser iguais por favor muda as variaveis");

        printf("\n Novo valor do n1:");
        scanf("%d", &n1);

        printf("\n Novo valor do n2:");
        scanf("%d", &n2);
        }while(n1 == n2);
    }
    
    if (n1 > n2) {
        printf("\nO valor máximo é: %d", n1);
        printf("\nO valor minino é : %d ", n2);
    } else {
        printf("\nO valor máximo é: %d", n2);
        printf("\nO valor minino é :%d ", n1);
    }

}

int potencia(int x, int y) {

    if (y == 0) {
        return 1;
    }

    else {
        return x * potencia(x, y - 1);
    }
}


