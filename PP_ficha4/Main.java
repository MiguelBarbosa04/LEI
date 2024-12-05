package PP_ficha4;


public class Main {
    

   
    public static void main(String[] args){


double total;

        User.id[0] = 'A';
        User.id[1] = 'B';
        User.id[2] = 'C';
        User.name = new char[]{'B','r','u','n','o'};
        User.email = new char[]{'b','m','o','@','e','s','t','g','f','.','i','p','p','.','p','t'};
       
       User.expenses.carValues[0] = 200;
       User.expenses.foodValues[0] = 300;
       User.expenses.carValues[1] = 250;
       User.expenses.foodValues[1] = 400;
       User.expenses.carValues[2] = 500;
       User.expenses.foodValues[2] = 900;

        System.out.println("-----User 1-----");
        System.out.print("ID:");
        System.out.println(User.id);
        System.out.print("Name:");
        System.out.println(User.name);
        System.out.print("Email");
        System.out.println(User.email);
        System.out.print("Carro:");
        System.out.println(User.expenses.carValues[0]);
        System.out.print("Comida");
        System.out.println(User.expenses.foodValues[0]);




System.out.println("TOTAL CARRO: " + totalDespesas(User.expenses.carValues));
System.out.println("Média carro: " + totalDespesas(User.expenses.carValues)/31);



System.out.println("TOTAL f0od: " + totalDespesas(User.expenses.foodValues));
System.out.println("Média food: " + totalDespesas(User.expenses.foodValues)/31);

        

    }

    public static double totalDespesas(double[] despesas){
        double soma=0;
        for (int i = 0; i < despesas.length; i++) {
            soma += despesas[i];
        }

        return soma;

    }

}
