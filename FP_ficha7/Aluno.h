/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Aluno.h
 * Author: migue
 *
 * Created on 7 de dezembro de 2023, 09:47
 */

#define DATA_TAM 30
#define MAX_NOME_TAM 200
#define MAX_ALUNOS 30
#ifndef ALUNO_H
#define ALUNO_H

#ifdef __cplusplus
extern "C" {
#endif

#define ERRO_ALUNO_NAO_EXISTE "O aluno não existe na lista."
#define ERRO_LISTA_VAZIA "A lista de alunos está vazia."
#define ERRO_LISTA_CHEIA "A lista de alunos está cheia."
#define ERRO_ALUNO_EXISTE "O número de aluno já se encontra atribuido."
#define MIN_NUM_ALUNO 0
#define MAX_NUM_ALUNO 1000
#define MSG_OBTER_NUM_ALUNO "Insira um número de aluno [0-1000]: "
#define MAX_NOME_ALUNO 31
#define MSG_OBTER_NOME "Insira o nome do aluno: "
#define MIN_DIA 1
#define MAX_DIA 31
#define OBTER_DIA_NASC "Insira o dia de nascimento: "
#define MIN_MES 1
#define MAX_MES 12
#define OBTER_MES_NASC "Insira o mes de nascimento: "
#define MIN_ANO 1990
#define MAX_ANO 2021
#define OBTER_ANO_NASC "Insira o ano de nascimento: "

    typedef struct {
        int dia, mes, ano;
    } Data;

    typedef struct {
        int numero;
        char nome[MAX_NOME_TAM];
        Data data_nascimento;
    } Aluno;

    typedef struct {
        int contador;
        Aluno alunos[MAX_ALUNOS];

    } Alunos;

#ifdef __cplusplus
}
#endif

#endif /* ALUNO_H */

