/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */
public class Par<T1, T2> {

    private T1 primeiro;
    private T2 segundo;

    public Par(T1 primeiro, T2 segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public T1 getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(T1 primeiro) {
        this.primeiro = primeiro;
    }

    public T2 getSegundo() {
        return segundo;
    }

    public void setSegundo(T2 segundo) {
        this.segundo = segundo;
    }

    

   

}
