package br.com.abc.javacore.ZZIdefault.classes;

import br.com.abc.javacore.ZZIdefault.interfacess.MyList;

public class InterfaceTest implements MyList {
    public static void main(String[] args) {
        MyList.sort();
        // Para adicionar um método default a ao código
        new InterfaceTest().remove();

    }

    @Override
    public void add() {
        System.out.println("dentro do add");
    }
}
