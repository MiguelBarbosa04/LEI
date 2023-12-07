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
    


typedef struct {
    int dia, mes, ano;
} Data;

typedef struct {
    int numero;
    char nome[MAX_NOME_TAM];
    Data data_de_nascimento;
} Aluno;

typedef struct{
    
    int contador;
    Aluno alunos[MAX_ALUNOS];
    
}Alunos;

#ifdef __cplusplus
}
#endif

#endif /* ALUNO_H */

