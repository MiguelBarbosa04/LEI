#ifndef MACHADO_H
#define MACHADO_H

#define ERRO_CLI_NAO_EXISTE "O cliente não existe na lista."
#define ERRO_LISTA_VAZIA "A lista de clientes está vazia."
#define ERRO_LISTA_CHEIA "A lista de clientes está cheia."
#define ERRO_CLI_EXISTE "O número de aluno já se encontra atribuído."

#define ERRO_ART_NAO_EXISTE "O artigo não existe na lista."
#define ERRO_LISTA_VAZIA_ART "A lista de artigos está vazia."
#define ERRO_LISTA_CHEIA_ART "A lista de artigos está cheia."
#define ERRO_ART_EXISTE "O número do artigo já se encontra atribuído."

#define MAX_CLI 50
#define MIN_COD_CLI 0
#define MAX_COD_CLI 100
#define MAX_NIF 9999 
#define MIN_NIF 1000
#define MSG_OBTER_COD_CLI "Insira um codigo de cliente: "
#define MSG_OBTER_PAIS "Insira a nacionalidade do cliente: "
#define MSG_OBTER_NIF "Insira o seu nif: "
#define MAX_PAIS_CLI 15
#define MAX_NOME_CLI 31
#define MAX_APELIDO_CLI 31
#define MSG_OBTER_APELIDO "Insira o apelido do cliente: "
#define MSG_OBTER_NOME "Insira o nome do cliente: "

#define MSG_OBTER_COD_ART "Insira o codigo do artigo: "
#define MSG_OBTER_TIP_CAL "Insira o tipo de calçado: "
#define MSG_OBTER_NOME_CAL "Insira o nome do calçado: "
#define MSG_OBTER_MIN "Insira o menor tamanho: "
#define MSG_OBTER_MAX "Insira o maior tamanho: "

#define MIN_NUM_CLIENTE 0
#define MAX_NUM_CLIENTE 100
#define MSG_OBTER_COD_CLIENTE "qual o seu codigo de cliente?"
#define MAX_NOME_CLIENTE 10
#define ERRO_CLI_EXISTE "O número de aluno já se encontra atribuído."

void menu_ini();
void menu_cli();
void menu_adm();
void menu_crud_cli();
void menu_crud_artigos();
void menu_crud_precos();
void msg_error();
void msg_adeus();

typedef struct {
    int Cod_Cli;
    char Nome[10];
    char Apelido[10];
    int Nif;
    char Pais[15];
} Cliente;

typedef struct {
    int contador;
    Cliente clientes[100];
} Clientes;

typedef struct {
    int Cod_Art;
    char Nome[15];
    char Tip_Cal[10];
    int Min;
    int Max;
    
} Artigo;

typedef struct {
    int contador;
    Artigo artigos[100];
} Artigos;

void inserirClientes(Clientes *clientes);
int procurarClientes(Clientes clientes);
void listarClientes(Clientes clientes);
void editarClientes(Clientes *clientes);
void eliminarClientes(Clientes *clientes);

void inserirArtigos(Artigos *artigos);
int procurarArtigos(Artigos artigos);
void listarArtigos(Artigos artigos);
void editarArtigos(Artigos *artigos);
void eliminarArtigos(Artigos *artigos);

#endif /* MACHADO_H */

