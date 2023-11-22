package ex3;

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de discos: ");
        int numDiscos = scanner.nextInt();

        // Chama o método para resolver as Torres de Hanói
        resolverTorresDeHanoi(numDiscos, 'A', 'C', 'B');

        scanner.close();
    }

    public static void resolverTorresDeHanoi(int numDiscos, char origem, char destino, char auxiliar) {
        if (numDiscos == 1) {
            // Caso base: mover o disco da origem para o destino
            System.out.println("Mover disco 1 de " + origem + " para " + destino);
        } else {
            // Mover n-1 discos da origem para o auxiliar, usando o destino como auxiliar
            resolverTorresDeHanoi(numDiscos - 1, origem, auxiliar, destino);

            // Mover o disco restante da origem para o destino
            System.out.println("Mover disco " + numDiscos + " de " + origem + " para " + destino);

            // Mover os n-1 discos do auxiliar para o destino, usando a origem como auxiliar
            resolverTorresDeHanoi(numDiscos - 1, auxiliar, destino, origem);
        }
    }
}
// PARTE 2
// 1 - Quais as componentes que compõem uma definição recursiva?

    //   Uma definição recursiva geralmente inclui os seguintes componentes:
////
    //    Caso Base:
    //   Uma condição que estabelece o ponto de parada para a recursão. É a situação mais simples ou trivial que pode ser resolvida sem a necessidade de chamadas recursivas. O caso base evita que a recursão continue indefinidamente.
    //   Caso Recursivo:
    ////    Uma ou mais chamadas recursivas que reduzem o problema original a instâncias menores do mesmo problema. Cada chamada recursiva deve tender em direção ao caso base para garantir a convergência.
    //  Condição de Convergência:
    //   Uma garantia de que as chamadas recursivas eventualmente atingirão o caso base, garantindo a convergência e evitando recursão infinita.
//    A estrutura básica de uma definição recursiva pode ser representada pela seguinte forma genérica:
//     plaintext
//    Copy code
//    Se (condição de caso base é verdadeira)
//    Resolva diretamente (caso base)
//    Senão
//     Reduza o problema original a instâncias menores
//    Chame recursivamente para resolver os problemas menores
//    Combine as soluções dos problemas menores para obter a solução do problema original
//    É importante projetar uma definição recursiva de modo que, a cada chamada recursiva, o problema original seja reduzido progressivamente até atingir o caso base. Além disso, a convergência deve ser garantida para evitar recursão infinita. Cada instância menor do problema deve ser de natureza semelhante à instância original, mas mais simples, para que a recursão possa progredir.


// 2 - Devo usar sempre a recursividade para resolver os mais diversos problemas?


//Não, a recursividade não é sempre a melhor abordagem para resolver todos os problemas.
  //      A escolha entre a recursividade e outras técnicas depende da natureza do problema, da estrutura de dados envolvida e das características da linguagem de programação.