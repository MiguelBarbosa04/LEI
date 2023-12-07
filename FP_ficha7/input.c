/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
#include <stdio.h>
#include <string.h>
#include "Aluno.h"
#define VALOR_INVALIDO "O valor inserido é inválido."

void cleanInputBuffer() {
    char ch
            ;

    while ((ch = getchar()) != '\n' && ch != EOF);
}

int obterInt
(int minValor, int maxValor, char
        *msg) {
    int valor;
    printf
            (msg);
    while
        (scanf("%d", &valor) != 1 || valor < minValor || valor > maxValor) {
        puts(VALOR_INVALIDO);
        cleanInputBuffer();
        printf
                (msg);
    }
    cleanInputBuffer();

    return valor;
}

float obterFloat
(float minValor, float maxValor, char
        *msg) {
    float valor;
    printf
            (msg);
    while
        (scanf("%f", &valor) != 1 || valor < minValor || valor > maxValor) {
        puts(VALOR_INVALIDO);
        cleanInputBuffer();
        printf
                (msg);
    }
    cleanInputBuffer();

    return valor;
}

double obterDouble
(double minValor, double maxValor, char
        *msg) {
    double valor;
    printf
            (msg);
    while
        (scanf("%lf", &valor) != 1 || valor < minValor || valor > maxValor) {
        puts(VALOR_INVALIDO);
        cleanInputBuffer();
        printf
                (msg);
    }
    cleanInputBuffer();

    return valor;
}

char obterChar
(char
        *msg) {
    char valor;
    printf
            (msg);
    valor = getchar();
    cleanInputBuffer();

    return valor;
}

void lerString(char *string, unsigned int tamanho, char *msg) {
    printf(msg);
    if
        (fgets(string, tamanho, stdin) != NULL) {
        unsigned int len = strlen
                (string)
                - 1;
        if
            (string[len] == '\n') {
            string [len] = '\0';
        } else {

            cleanInputBuffer();
        }
    }
}

void imprimir(Aluno aluno) {

    printf("\nNúmero: %d | Nome: %-30s | Data: %d-%d-%d", aluno.numero, aluno.nome, aluno.data_de_nascimento.dia, aluno.data_de_nascimento.mes, aluno.data_de_nascimento.ano);
}

void listar(Alunos alunos) {
    if (alunos.contador <= 0) {
        printf("Não há alunos registados");
    } else {
        for (int i = 0; i < alunos.contador; i++) {

            imprimir(alunos.alunos[i]);
        }
    }
}

//void inserir(Aluno *aluno) {
//
//    Alunos alunos = {.contador = 0};
//    if (alunos.contador < MAX_ALUNOS) {
//        printf("\nInsira o nome: ");
//        scanf("%s", aluno->nome);
//        printf("\nInsira a nova data de nascimento (Dia): ");
//        scanf("%d", (*aluno).data_de_nascimento.dia);
//        printf("\nInsira a nova data de nascimento (Mes): ");
//        scanf("%d", (*aluno).data_de_nascimento.mes);
//        printf("\nInsira a nova data de nascimento (Anos): ");
//        scanf("%d", (*aluno).data_de_nascimento.ano);
//        printf("O número do aluno é %d", alunos.contador++);
//
//    } else {
//        printf("Capacidade chegou ao fim");
//    }
//
//}

void inserir(Alunos *alunos) {

    int dia, mes, ano;


    if (alunos->contador < MAX_ALUNOS) {

        dia = 0;
        mes = 0;
        ano = 0;
        printf("\nInsira o nome: ");
        scanf("%s", (*alunos).alunos[alunos->contador].nome);

        do {
            printf("\nInsira a nova data de nascimento (Dia): ");
            scanf("%d", &dia);
        } while (dia > 31 || dia < 0);

        do {
            printf("\nInsira a nova data de nascimento (Mes): ");
            scanf("%d", &mes);
        } while (mes > 13 || mes < 0);

        do {
            printf("\nInsira a nova data de nascimento (Anos): ");
            scanf("%d", &ano);
        } while (ano > 2023 || ano < 0);
        printf("\nO número do aluno é %d", ++(*alunos).alunos[alunos->contador].numero);

        (*alunos).alunos[alunos->contador].data_de_nascimento.dia = dia;
        (*alunos).alunos[alunos->contador].data_de_nascimento.mes = mes;
        (*alunos).alunos[alunos->contador].data_de_nascimento.ano = ano;

        alunos->contador++;
    }
}

int atualizarAluno(Aluno *aluno) {

    printf("\nInsira o nome: ");
    scanf("%s", (*aluno).nome);
    printf("\nInsira a nova data de nascimento (Dia): ");
    scanf("% d", (*aluno).data_de_nascimento.dia);
    printf("\nInsira a nova data de nascimento (Mes): ");
    scanf("% d", (*aluno).data_de_nascimento.mes);
    printf("\nInsira a nova data de nascimento (Anos): ");
    scanf("% d", (*aluno).data_de_nascimento.ano);
}

void atualizar(Alunos *alunos) {

    if (alunos->contador <= 0) {
        printf("\nNÃO HÁ ALUNOS");
    }
    for (int i = 0; i < alunos->contador; i++) {
        if (alunos->alunos[i].numero == i) {
            atualizarAluno(&(*alunos).alunos[i]);
        } else {
            printf("\nAluno não existe.\n");
        }
    }
}