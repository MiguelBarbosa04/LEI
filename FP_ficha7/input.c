/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <stdlib.h>
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

void imprimirAluno(Aluno aluno) {
    printf("\n%3d %-30s %d-%d-%d", aluno.numero, aluno.nome, aluno.data_nascimento.dia,
            aluno.data_nascimento.mes, aluno.data_nascimento.ano);
}

void apagarDadosAluno(Aluno *aluno) {
    aluno->numero = 0;
    strcpy(aluno->nome, "");
    aluno->data_nascimento.dia = aluno->data_nascimento.mes = aluno->data_nascimento.ano = 0;
}

int procurarAluno(Alunos alunos, int numero) {
    int i;
    for (i = 0; i < alunos.contador; i++) {
        if (alunos.alunos[i].numero == numero) {
            return i;
        }
    }
    return -1;
}

int inserirAluno(Alunos *alunos) {
    int numero = obterInt(MIN_NUM_ALUNO, MAX_NUM_ALUNO, MSG_OBTER_NUM_ALUNO);
    if (procurarAluno(*alunos, numero) == -1) {
        alunos->alunos[alunos->contador].numero = numero;
        lerString(alunos->alunos[alunos->contador].nome, MAX_NOME_ALUNO, MSG_OBTER_NOME);
        alunos->alunos[alunos->contador].data_nascimento.dia = obterInt(MIN_DIA, MAX_DIA,
                OBTER_DIA_NASC);
        alunos->alunos[alunos->contador].data_nascimento.mes = obterInt(MIN_MES, MAX_MES,
                OBTER_MES_NASC);
        alunos->alunos[alunos->contador].data_nascimento.ano = obterInt(MIN_ANO, MAX_ANO,
                OBTER_ANO_NASC);
        return alunos->contador++;
    }
    return -1;
}

void atualizarAluno(Aluno *aluno) {
    lerString((*aluno).nome, MAX_NOME_ALUNO, MSG_OBTER_NOME);
    (*aluno).data_nascimento.dia = obterInt(MIN_DIA, MAX_DIA, OBTER_DIA_NASC);
    (*aluno).data_nascimento.mes = obterInt(MIN_MES, MAX_MES, OBTER_MES_NASC);
    (*aluno).data_nascimento.ano = obterInt(MIN_ANO, MAX_ANO, OBTER_ANO_NASC);
}

void inserirAlunos(Alunos *alunos) {
    if (alunos->contador < MAX_ALUNOS) {
        if (inserirAluno(alunos) == -1) {
            puts(ERRO_ALUNO_EXISTE);
        }
    } else {
        puts(ERRO_LISTA_CHEIA);
    }
}

void procurarAlunos(Alunos alunos) {
    int numero = procurarAluno(alunos, obterInt(MIN_NUM_ALUNO, MAX_NUM_ALUNO,
            MSG_OBTER_NUM_ALUNO));
    if (numero != -1) {
        imprimirAluno(alunos.alunos[numero]);
    } else {
        puts(ERRO_ALUNO_NAO_EXISTE);
    }
}

void atualizarAlunos(Alunos *alunos) {
    int numero = procurarAluno(*alunos, obterInt(MIN_NUM_ALUNO, MAX_NUM_ALUNO,
            MSG_OBTER_NUM_ALUNO));
    if (numero != -1) {
        atualizarAluno(&(*alunos).alunos[numero]);
    } else {
        puts(ERRO_ALUNO_NAO_EXISTE);
    }
}

void removerAlunos(Alunos *alunos) {
    int i, numero = procurarAluno(*alunos, obterInt(MIN_NUM_ALUNO, MAX_NUM_ALUNO,
            MSG_OBTER_NUM_ALUNO));
    if (numero != -1) {
        for (i = numero; i < alunos->contador - 1; i++) {
            alunos->alunos[i] = alunos->alunos[i + 1];
        }
        apagarDadosAluno(&alunos->alunos[i]);
        alunos->contador--;
    } else {
        puts(ERRO_ALUNO_NAO_EXISTE);
    }
}

void listarAlunos(Alunos alunos) {
    if (alunos.contador > 0) {
        int i;
        for (i = 0; i < alunos.contador; i++) {
            imprimirAluno(alunos.alunos[i]);
        }
    } else {
        puts(ERRO_LISTA_VAZIA);
    }
}
