#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Machado.h"
#include "input.h"

void menu_ini() {
    printf("\n------------------\n");
    printf("0 - Sair\n");
    printf("1 - Cliente\n");
    printf("2 - Administrador\n");
    printf("------------------\n");
}

void menu_cli() {
    printf("\n------------------\n");
    printf("0 - Voltar atrás\n");
    printf("1 - Login\n");
    printf("2 - Criar Conta\n");
    printf("------------------\n");
}

void menu_adm() {
    printf("\n--------------------------------\n");
    printf("0 - Voltar atrás.\n");
    printf("1 - C.R.U.D. de clientes.\n");
    printf("2 - C.R.U.D. de artigos.\n");
    printf("3 - C.R.U.D. das tabelas de custo.\n");
    printf("--------------------------------\n");
}

void menu_crud_cli() {
    printf("\n--------------------------------\n");
    printf("0 - Voltar atrás.\n");
    printf("1 - Criar clientes.\n");
    printf("2 - Listar clientes.\n");
    printf("3 - Editar clientes.\n");
    printf("4 - Eleminar clientes.\n");
    printf("--------------------------------\n");
}

void menu_crud_artigos() {
    printf("\n--------------------------------\n");
    printf("0 - Voltar atrás.\n");
    printf("1 - Criar artigos.\n");
    printf("2 - Listar artigos.\n");
    printf("3 - Editar artigos.\n");
    printf("4 - Eleminar artigos.\n");
    printf("--------------------------------\n");
}

void menu_crud_precos() {
    printf("\n--------------------------------\n");
    printf("0 - Voltar atrás.\n");
    printf("1 - Editar precos.\n");
    printf("--------------------------------\n");
}

void msg_error() {
    printf("Digite novamente. Ocorreu um erro!\n");
}

void msg_adeus() {
    system("clear");
    printf("Obrigado e volte sempre.\nCalçado Machado - De manhã não abre, à tarde está fechado.");
}

int procurarCliente(Clientes clientes, int Cod_Cli) {
    int i;
    for (i = 0; i < clientes.contador; i++) {
        if (clientes.clientes[i].Cod_Cli == Cod_Cli) {
            return i;
        }
    }
    return -1;
}

int inserirCliente(Clientes *clientes) {
    int Cod_Cli = obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_CLI);
    int Nif = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_NIF);
    if (procurarCliente(*clientes, Cod_Cli) == -1) {
        clientes->clientes[clientes->contador].Cod_Cli = Cod_Cli;
        lerString(clientes->clientes[clientes->contador].Nome, MAX_NOME_CLI, MSG_OBTER_NOME);
        lerString(clientes->clientes[clientes->contador].Apelido, MAX_APELIDO_CLI, MSG_OBTER_APELIDO);
        clientes->clientes[clientes->contador].Nif = Nif;
        lerString(clientes->clientes[clientes->contador].Pais, MAX_PAIS_CLI, MSG_OBTER_PAIS);
        return clientes->contador++;
    }
    return -1;
}

void inserirClientes(Clientes *clientes) {
    if (clientes->contador < MAX_CLI) {
        if (inserirCliente(clientes) == -1) {
            puts(ERRO_CLI_EXISTE);
        }
    } else {
        puts(ERRO_LISTA_CHEIA);
    }
}

void atualizarAluno(Cliente *cliente) {
    lerString((*cliente).Nome, MAX_NOME_CLI, MSG_OBTER_NOME);
    lerString((*cliente).Apelido, MAX_NOME_CLI, MSG_OBTER_APELIDO);
    (*cliente).Nif = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_NIF);
    lerString((*cliente).Pais, MAX_PAIS_CLI, MSG_OBTER_PAIS);
}

void editarClientes(Clientes *clintes) {
    int numero = procurarCliente(*clintes, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_CLI));
    if (numero != -1) {
        atualizarAluno(&(*clintes).clientes[numero]);
    } else {
        puts(ERRO_CLI_NAO_EXISTE);
    }
}

void apagarDadosCliente(Cliente *cliente) {
    cliente->Cod_Cli = 0;
    strcpy(cliente->Nome, "");
    strcpy(cliente->Apelido, "");
    cliente->Nif = 0;
    strcpy(cliente->Pais, "");
}

void eliminarClientes(Clientes *clientes) {
    int i, numero = procurarCliente(*clientes, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_CLI));
    if (numero != -1) {
        for (i = numero; i < clientes->contador - 1; i++) {
            clientes->clientes[i] = clientes->clientes[i + 1];
        }
        apagarDadosCliente(&clientes->clientes[i]);
        clientes->contador--;
    } else {
        puts(ERRO_CLI_NAO_EXISTE);
    }
}

int procurarClientes(Clientes clientes) {
    int numero = procurarCliente(clientes, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_CLI));
    if (numero != -1) {
        return 1;
    } else {
        puts(ERRO_CLI_NAO_EXISTE);
        return 0;
    }
}

void imprimirCliente(Cliente cliente) {
    printf("\n%d %s %s %d %s", cliente.Cod_Cli, cliente.Nome, cliente.Apelido, cliente.Nif, cliente.Pais);
}

void listarClientes(Clientes clientes) {
    if (clientes.contador > 0) {
        int i;
        for (i = 0; i < clientes.contador; i++) {
            imprimirCliente(clientes.clientes[i]);
        }
    } else {
        puts(ERRO_LISTA_VAZIA);
    }
}




int procurarArtigo(Artigos artigos, int Cod_Art) {
    int i;
    for (i = 0; i < artigos.contador; i++) {
        if (artigos.artigos[i].Cod_Art == Cod_Art) {
            return i;
        }
    }
    return -1;
}

int inserirArtigo(Artigos *artigos) {
    int Cod_Art = obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_ART);
    if (procurarArtigo(*artigos, Cod_Art) == -1) {
        artigos->artigos[artigos->contador].Cod_Art = Cod_Art;
        lerString(artigos->artigos[artigos->contador].Nome, MAX_NOME_CLI, MSG_OBTER_NOME_CAL);
        lerString(artigos->artigos[artigos->contador].Tip_Cal, MAX_APELIDO_CLI, MSG_OBTER_TIP_CAL);
        artigos->artigos[artigos->contador].Min = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_MIN);
        artigos->artigos[artigos->contador].Max = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_MAX);
        return artigos->contador++;
    }
    return -1;
}

void inserirArtigos(Artigos *artigos) {
    if (artigos->contador < MAX_CLI) {
        if (inserirArtigo(artigos) == -1) {
            puts(ERRO_ART_EXISTE);
        }
    } else {
        puts(ERRO_LISTA_CHEIA_ART);
    }
}

void atualizarArtigo(Artigo *artigo) {
    lerString((*artigo).Nome, MAX_NOME_CLI, MSG_OBTER_NOME_CAL);
    lerString((*artigo).Tip_Cal, MAX_NOME_CLI, MSG_OBTER_TIP_CAL);
    (*artigo).Max = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_MAX);
    (*artigo).Min = obterInt(MIN_NIF, MAX_NIF, MSG_OBTER_MIN);
}

void editarArtigos(Artigos *artigos) {
    int numero = procurarArtigo(*artigos, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_ART));
    if (numero != -1) {
        atualizarArtigo(&(*artigos).artigos[numero]);
    } else {
        puts(ERRO_ART_NAO_EXISTE);
    }
}

void apagarDadosArtigo(Artigo *artigo) {
    artigo->Cod_Art = 0;
    strcpy(artigo->Nome, "");
    strcpy(artigo->Tip_Cal, "");
    artigo->Max = 0;
    artigo->Min = 0;
}

void eliminarArtigos(Artigos *artigos) {
    int i, numero = procurarArtigo(*artigos, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_ART));
    if (numero != -1) {
        for (i = numero; i < artigos->contador - 1; i++) {
            artigos->artigos[i] = artigos->artigos[i + 1];
        }
        apagarDadosArtigo(&artigos->artigos[i]);
        artigos->contador--;
    } else {
        puts(ERRO_ART_NAO_EXISTE);
    }
}

int procurarArtigos(Artigos artigos) {
    int numero = procurarArtigo(artigos, obterInt(MIN_COD_CLI, MAX_COD_CLI, MSG_OBTER_COD_ART));
    if (numero != -1) {
        return 1;
    } else {
        puts(ERRO_ART_NAO_EXISTE);
        return 0;
    }
}

void imprimirArtigo(Artigo artigo) {
    printf("\n%d %-30s %-30s %d %d", artigo.Cod_Art, artigo.Nome, artigo.Tip_Cal, artigo.Max, artigo.Min);
}

void listarArtigos(Artigos artigos) {
    if (artigos.contador > 0) {
        int i;
        for (i = 0; i < artigos.contador; i++) {
            imprimirArtigo(artigos.artigos[i]);
        }
    } else {
        puts(ERRO_LISTA_VAZIA_ART);
    }
}