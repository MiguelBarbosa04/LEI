#include <stdio.h>
#include <stdlib.h>

#define TAM 3

int obtemValor(char msg[]) {
    int valor;
    do {
        printf("%s: ", msg);
        scanf("%d", &valor);
    } while (valor < 0 || valor >= TAM);
    return valor;
}

void imprimeMatriz(int matriz[TAM][TAM]) {
    int linha, coluna;
    for (linha = 0; linha < TAM; linha++) {
        puts("");
        for (coluna = 0; coluna < TAM; coluna++) {
            printf("%3d", matriz[linha][coluna]);
        }
    }
}

int verificaPosicaoVazia(int matriz[TAM][TAM], int linha, int coluna) {
    return matriz[linha][coluna] == -1;
}

int verificaVitoria(int matriz[TAM][TAM], int jogador) {
    int i, j, contaL, contaC, contaD1 = 0, contaD2 = 0;

    for (i = 0; i < TAM; i++) {
        contaL = contaC = 0;

        for (j = 0; j < TAM; j++) {
            contaL += (matriz[i][j] == jogador);
            contaC += (matriz[j][i] == jogador);
        }

        if (contaC == TAM || contaL == TAM) {
            return 1;
        }

        contaD1 += (matriz[i][i] == jogador);
        contaD2 += (matriz[i][abs(i - TAM) - 1] == jogador);
    }

    if (contaD1 == TAM || contaD2 == TAM) {
        return 1;
    }

    return 0;
}

int main() {
    int linha, coluna, jogador = 0, jogada = 0, matriz[TAM][TAM], vitoria = 0;

    for (linha = 0; linha < TAM; linha++) {
        for (coluna = 0; coluna < TAM; coluna++) {
            matriz[linha][coluna] = -1;
        }
    }

    imprimeMatriz(matriz);

    while (jogada++ < (TAM * TAM) && !vitoria) {

        printf("\nJogador: %d (jogada: %d)\n", jogador, jogada);

        do {
            linha = obtemValor("linha: ");
            coluna = obtemValor("Coluna: ");
        } while (!verificaPosicaoVazia(matriz, linha, coluna));

        matriz[linha][coluna] = jogador;

        imprimeMatriz(matriz);

        vitoria = verificaVitoria(matriz, jogador);

        if (!vitoria) {
            jogador = jogador ? 0 : 1;
        }
    }

    if (vitoria) {
        printf("\n\nVencedor jogador %d em %d jogadas.", jogador, jogada - 1);
    } else {
        printf("\n\nEmpate.");
    }

    return 0;
}
