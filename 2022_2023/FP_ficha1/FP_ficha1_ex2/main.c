/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: Utilizador
 *
 * Created on 14 de outubro de 2022, 09:22
 */

#include <stdio.h>
#include <stdlib.h>

/*
 * 
 */
int main(int argc, char** argv) {

    int aluno1, aluno2, aluno3;

printf("Insira a idade do aluno 1: ");
scanf("%d", &aluno1);
printf("Insira a idade do aluno 2: ");
scanf("%d", &aluno2);
printf("Insira a idade do aluno 3: ");
scanf("%d", &aluno3);
printf("A média de idades é: %f", (aluno1 + aluno2 + aluno3) / 3.0);
return 0;
}

