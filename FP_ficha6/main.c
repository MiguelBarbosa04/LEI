/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 23 de novembro de 2023, 11:19
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
//
// Created by tiago on 23/11/2023.
//

#include <stdio.h>
#include <stdio.h>

void foo(int a, int *aPtr) {
    // imprimir o valor de a
    printf("Variavel a: %d \n", a);
    // imprimir o endereço de a (local)
    printf("Endereco de a: %p \n", &a);
    // imprimir o valor de aPtr
    printf("Variavel aPtr: %d \n", *(aPtr));
    // imprimir o endereço de aPtr
    printf("Endereco de aPtr %p\n", &aPtr);
    // somar um ao valor de a
    printf("Soma de a + 1: %d \n", a + 1);
    // somar um ao valor apontado por de aPtr
    printf("Soma de aPtr + 1: %d \n", *(aPtr) + 1);
}

int ex2() {
    int a = 0;
    // imprimir o valor de a
    printf("Variavel a Inicial: %d \n", a);
    // imprimir o endereço de a
    printf("Endereco de a Inicial %p \n", &a);
    foo(a, &a);
    // imprimir o valor de a
    printf("%d", a);
    return 0;
}

void somar(int num1, int num2, long *resultado) {

    *resultado = num1 + num2;
}

void ex3() {
    int num1, num2;
    long resultado;

    printf("Insira valor de num1: \n");
    scanf("%d", &num1);

    printf("Insira valor de num2: \n");
    scanf("%d", &num2);

    somar(num1, num2, &resultado);

    printf("Resultado: %ld \n", resultado);
}

void ordenar(int *v1, int *v2, int *v3) {

    int temp = *v2;
    *v2 = *v3;
    *v3 = temp;

    printf("\nValor de V1: %d", *v1);
    printf("\nValor de V2: %d", *v2);
    printf("\nEndereço de V2: %p", &v2);
    printf("\nValor de V3: %d", *v3);
    printf("\nEndereço de V3: %p", &v3);
}

void ex4() {
    int v1 = 1, v2 = 2, v3 = 3;
    printf("\nEndereço de V2: %p", &v2);
    printf("\nEndereço de V3: %p", &v3);
    printf("\n______________________________");
    ordenar(&v1, &v2, &v3);
}

int len(char *str) {
    int length = 0;

    // Percorre a string até encontrar o caractere nulo '\0'
    while (*str != '\0') {
        length++;
        str++;
    }

    return length;

}

void ex5() {

    char minhaString[] = "Hello, World!";
    int comprimento = len(&minhaString);

    printf("O comprimento da string é: %d\n", comprimento);
}

int equal(char **str1, char **str2) {

    //usamos double pointers para passar as variaveis tipo char para strings, não o que o ex pede !!! O que está comentado é que é o ex e é preciso por  *str1 e *str2 na funcao 

    if (*str1 == *str2) {
        return 1;
    } else {
        return 0;
    }
    //    while (*str1 != '\0' && *str2 != '\0') {
    //
    //        if (*str1 != *str2) {
    //            return 0;
    //        }
    //
    //        str1++;
    //        str2++;
    //    }


    //    //Veririfica se as Strings não estão vazias
    //    if (*str1 == '\0' && *str2 == '\0') {
    //        return 1;
    //    } else {
    //        return 0;
    //    }
}

void P2ex1() {

    char *minhaString1 = "Hello, World!";
    char *minhaString2 = "Hello, World!";
    char *minhaString3 = "O Tiago é o rei!";

    int resultado1 = equal(&minhaString1, &minhaString2);
    int resultado2 = equal(&minhaString1, &minhaString3);


    printf("Resultado 1: %d\n", resultado1);
    printf("Resultado 2: %d\n", resultado2);


}

void printFirst(char *str, int n) {
    for (int i = 0; i < n; i++) {
        printf("%c", *str);
        str++;
    }
}

void P2ex2() {
    int n;
    int length = 0;
    char string[length];

    printf("Diga a string: ");
    scanf("%s", string);



    while (string[length] != '\0') {
        length++;
    }


    do {
        printf("Diga o número (deve ser menor ou igual ao comprimento da string): ");
        scanf("%d", &n);

        if (n > length) {
            printf("Erro: o número deve ser menor ou igual ao comprimento da string.\n");
        }
    } while (n > length || n < 0);

    printFirst(string, n);
}

char *strchar(char *str, char ch) {
    while (*str != '\0' && *str != ch) {
        str++;
    }
    return str;
}

void P2ex3() {
    char string[100];

    printf("Diga a palavra: ");
    scanf("%s", string);

    int length = 0;
    while (string[length] != '\0') {
        length++;
    }

    char alvo = 'd';

    char *result = strchar(string, alvo);

    if (*result == '\0') {
        printf("Caractere '%c' não encontrado na string.\n", alvo);
    } else {
        printf("Endereço do caractere '%c': %p\n", alvo, (void *) result);
    }
}

int *findMax(int data[], int size) {
    // Se o array estiver vazio, retorne NULL
    if (size == 0) {
        return NULL;
    }

    int *maxPtr = &data[0]; // Inicializa o ponteiro com o endereço do primeiro elemento

    for (int i = 1; i < size; i++) {
        // Verifica se o valor atual é maior que o valor no endereço armazenado em maxPtr
        if (data[i] > *maxPtr) {
            maxPtr = &data[i]; // Atualiza o ponteiro para o endereço do novo máximo
        }
    }

    return maxPtr; // Retorna o ponteiro para o valor máximo no array
}

void P2ex4() {
    int tam = 5;
    int array[tam];

    for (int i = 0; i < tam; i++) {
        printf("Digite o valor número %d: ", i + 1);
        scanf("%d", &array[i]);
    }

    printf("\nArray: ");
    for (int i = 0; i < tam; i++) {
        printf("%d, ", array[i]);
    }

    int *result = findMax(array, tam);

    if (result != NULL) {
        printf("\nO endereço do número maior é: %p\n", (void *) result);
        printf("O valor do número maior é: %d\n", *result);
    } else {
        printf("\nO array está vazio.\n");
    }
}

int main() {
    P2ex4();
    return 0;
}
