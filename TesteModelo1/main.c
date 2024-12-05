/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.c
 * Author: Miguel
 *
 * Created on 28 de novembro de 2023, 20:23
 */

#include <stdio.h>
#include <stdlib.h>

/*
 *
 */

int obtemValor()
{

    int r1;
    do
    {
        printf("Diga o valor de 0 a 2:");
        scanf("%d", &r1);
    } while (r1 != 1 && r1 != 0 && r1 != 2);

    return r1;
}

void imprimeMatriz(int matriz[3][3])
{

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            printf("%d", matriz[i][j]);
        }
        printf("\n");
    }
}

int verificaPosicaoVazia(int matriz[3][3], int linha, int coluna)
{

    if (matriz[linha][coluna] == -1)
    {
        printf("Disponivel");
        return 1;
    }
    else
    {
        printf("Não Disponivel");
        return 0;
    }
}

int verificaVitoria(int matriz[3][3], int numJogador)
{

    int i = 0;
    int j = 0;
    int count = 0;

    // Verifica diagonais 1
    for (int i = 0; i < 3; i++)
    {
        if (matriz[i][j] == numJogador)
        {

            count++;
            j++;
            if (count == 3)
            {
                printf("O jogador %d GANHOUUUUUUU", numJogador);
            }
        }
    }

    count = 0;
    // Verifica diagonais 21
    for (int i = 3; i > -1; i--)
    {
        if (matriz[i][j] == numJogador)
        {

            count++;
            j++;
            if (count == 3)
            {
                printf("O jogador %d GANHOUUUUUUU", numJogador);
            }
        }
    }
    count = 0;
    // Verifica linha
    for (int i = 0; i < 3; i++)
    {
        count++;
        for (int j = 0; j < 3; j++)
        {
            if (matriz[i][j] == numJogador)
            {

                if (count == 3)
                {
                    printf("O jogador %d GANHOUUUUUUU", numJogador);
                }
            }
        }
    }
    count = 0;
    // Verifica coluna
    for (int j = 0; j < 3; j++)
    {
        count++;
        for (int i = 0; i < 3; i++)
        {
            if (matriz[i][j] == numJogador)
            {

                if (count == 3)
                {
                    printf("O jogador %d GANHOUUUUUUU", numJogador);
                }
            }
        }
    }
}

int verificaVitoria2(int matriz[3][3], int jogador) {
    //Verificar as linhas
    for (int i = 0; i < 3; i++) {
        if (matriz[i][0] == jogador && matriz[i][1] == jogador &&matriz[i][2] == jogador) {
            return 1;
        }
    }
    //Verificar as colunas
    for (int j = 0; j < 3; j++) {
        if (matriz[0][j] == jogador && matriz[1][j] == jogador &&matriz[2][j] == jogador) {
            return 1;
        }
    }

    //Verificar a diagonal
    if (matriz[0][0] == jogador && matriz[1][1] == jogador &&matriz[2][2] == jogador) {
        return 1;
    }

    //Verificar a digonal secundaria
    if (matriz[0][2] == jogador && matriz[1][1] == jogador &&matriz[2][0] == jogador) {
        return 1;
    }

    return 0;
}

int main(int argc, char **argv)
{

    int linhas = 3, colunas = 3;
    int matriz[linhas][colunas];

    for (int i = 0; i < linhas; i++)
    {
        for (int j = 0; j < colunas; j++)
        {
            matriz[i][j] = -1;
        }
        printf("\n");
    }

    imprimeMatriz(matriz);
    int linhaJogada = obtemValor();
    int colunaJogada = obtemValor();
    verificaPosicaoVazia(matriz, linhaJogada, colunaJogada);
    verificaVitoria(matriz, 1);

    return (EXIT_SUCCESS);
}
