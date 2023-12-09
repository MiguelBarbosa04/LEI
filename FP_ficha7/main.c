/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: migue
 *
 * Created on 7 de dezembro de 2023, 09:40
 */

#include <stdio.h>
#include <stdlib.h>
#include "Aluno.h"

/*
 * 
 */


int main(int argc, char** argv) {

    int op, numProcura;
    Alunos alunos = {.contador = 0};


    do {

        printf("\n-------------------------------------------");
        printf("\n 1 - INSERIR");
        printf("\n 2 - PROCURAR");
        printf("\n 3 - ATUALIZAR");
        printf("\n 4 - REMOVER");
        printf("\n 5 - LISTAR");
        printf("\n 0 - SAIR");



        printf("\n Alunos : %d/%d", alunos.contador, MAX_ALUNOS);

        printf("\n-------------------------------------------\n");
        printf("\n Diga a opcao: ");
        scanf("\n%d", &op);


        switch (op) {

            case 0:

                break;

            case 1:
                inserirAlunos(&alunos);
                break;
            case 2:
                procurarAlunos(&alunos);
                break;

            case 3:
                atualizarAlunos(&alunos);
                break;
            case 4:
                removerAlunos(&alunos);
                break;
            case 5:
                listarAlunos(&alunos);
                break;
            default:
                printf("1nInseriu uma opcao invalida");
                break;
        }
    } while (op != 0);

    return (EXIT_SUCCESS);
}

