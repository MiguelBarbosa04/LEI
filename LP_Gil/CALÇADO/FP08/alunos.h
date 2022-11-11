#ifndef ALUNOS_H
#define ALUNOS_H

#include "input.h"

#define ALUNOS_TAM_INICIAL      5

#define ERRO_CLIENTE_NAO_EXISTE   "O cliente não existe na lista."
#define ERRO_CLIENTE_EXISTE       "O número de cliente já se encontra atribuído."
#define ERRO_LISTA_VAZIA "A lista esta vazia."

#define MIN_NUM_ALUNO           0
#define MAX_NUM_ALUNO           1000
#define MSG_OBTER_NUM_ALUNO     "Insira um número de aluno [0-1000]: "

#define MAX_NOME_ALUNO          31
#define MSG_OBTER_NOME          "Insira o nome do aluno: "
#define MSG_OBTER_PAIS          "Insira o seu pais: "

#define MIN_NIF 100000000
#define MAX_NIF 999999999
#define MSG_OBTER_NIF "Insira o seu nif(9 digitos): "

#define MAX_NOME_ARTIGO 15
#define MSG_OBTER_NOME_ARTIGO "Insira o nome do artigo: "

#define MIN_MIN 34
#define MAX_MIN 48
#define MSG_OBTER_MIN "Insira o menor tamanho: "
#define MAX_MAX 55
#define MSG_OBTER_MAX "Insira o maior tamanho: "

#define MSG_OBTER_MAO_OBRA "Insira o preço da mao de obra: "
#define MSG_OBTER_CUSTO_FIXO "Insira o preço do custo fixo: "
#define MSG_OBTER_LUCRO "Insira o lucro: "
#define MSG_OBTER_TAMANHO "Insira a nova percentagem: "

typedef struct {
    int cod_cli;
    char nome[10];
    int nif;
    char pais[15];
    int ativa;
} Cliente;

typedef struct {
    int contador, tamanho;
    Cliente *clientes;
} Clientes;

void reclamar(char *ficheiro);

int carregarClientes(Clientes *clientes, char* ficheiro);

void inserirClientes(Clientes *clientes, char *ficheiro);
void procurarClientes(Clientes clientes);
int procurarClientesLog(Clientes clientes);
void atualizarClientes(Clientes *clientes, char *ficheiro);
void removerClientes(Clientes *clientes, char *ficheiro);
void listarClientes(Clientes clientes);

void libertarClientes(Clientes *clientes);

typedef struct {
    int cod_art;
    char nome[15];
    int tip_cal;
    int min;
    int max;
    int mao_obra;
    int custo_fix;
    float lucro;
    float tamanhos[15];
} Artigo;

typedef struct {
    int contador, tamanho;
    Artigo *artigos;
} Artigos;

int carregarArtigos(Artigos *artigos, char* ficheiro);

void carrega_val(Artigos *artigos);

void inserirArtigos(Artigos *artigos, char *ficheiro);
void procurarArtigos(Artigos artigos);
void atualizarArtigos(Artigos *artigos, char *ficheiro);
void listarArtigos(Artigos artigos);

void atualizarMao_obra(Artigos *artigos, char *ficheiro);
void atualizarCusto_fixo(Artigos *artigos, char *ficheiro);
void atualizarLucro(Artigos *artigos, char *ficheiro);
void listarArtigos_precos(Artigos artigos);
void alteraTamanho(Artigos *artigos, char *ficheiro, int opcao);

void libertarArtigos(Artigos *artigos);

typedef struct {
    int cod_enc;
    char nome_cli[15];
    int nif_cli;
    int contador;
    int enc;
    int enc_art;
} Encomenda;

typedef struct {
    int contador, tamanho;
    Encomenda *encomendas;
} Encomendas;

int carregarEncomendas(Encomendas *encomendas, char *ficheiro);

void inserirEncomendas(Encomendas *encomendas, char *ficheiro, Clientes *clientes, Artigos *artigos, int verificar, char *vis);
void listarEncomendas(Encomendas encomendas, char *ficheiro);
void removerArtigos(Artigos *artigos, char *ficheiro, Encomendas *encomendas);

#endif /* ALUNOS_H */