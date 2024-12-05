/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   input.h
 * Author: migue
 *
 * Created on 7 de dezembro de 2023, 10:02
 */

#ifndef INPUT_H
#define INPUT_H

#ifdef __cplusplus
extern "C" {
#endif

    void imprimir(Aluno &aluno); //
    void apagar(Aluno &aluno);
    int procurar(Aluno &aluno, int numero);
    void inserir(Aluno &aluno);//
    void atualizar(Aluno &aluno);//
    int atualizarAluno(Aluno &aluno); //
    void remover(Aluno &aluno);
    void listar(Aluno &aluno); //

    int obterInt(int minValor, int maxValor, char *msg);
    float obterFloat(float minValor, float maxValor, char *msg);
    double obterDouble(double minValor, double maxValor, char *msg);
    char obterChar(char *msg);
    void lerString(char *string, unsigned int tamanho, char *msg);



#ifdef __cplusplus
}
#endif

#endif /* INPUT_H */

