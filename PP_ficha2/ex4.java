public class ex4 {
    public static void main(String[] args) {

        char[] nome = {'A', 'n', 'a', ' ', 'S', 'a', 'n', 't', 'o', 's', '\n'};

        int pos = 0;
        int count = 0;
        int count2 = 0;
        while ( pos < nome.length && nome[pos] != ' '){
            pos++;
        }

        for (int i = pos; i < nome.length; i++) {

            System.out.print(nome[i]);
        }

        for (int i = 0; i < pos; i++) {

            System.out.print(nome[i]);
        }


        for (int i = 0; i < nome.length; i++) {
            if(nome[i] == 'a' || nome[i] == 'e' || nome[i] == 'i' || nome[i] == 'o' || nome[i] == 'u' || nome[i] == 'A' || nome[i] == 'E' || nome[i] == 'I'
            || nome[i] == 'O' || nome[i] == 'U'){
                count++;       
        }else if(nome[i]>= 'a' && nome[i] <= 'z' || nome[i]>= 'A' && nome[i] <= 'Z'){
                count2++;
            }
        }

        System.out.println(count);
        System.out.println(count2);
    }
}

