package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExemploAnyMatch {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Água 2L", Produto.Status.ATIVO, new BigDecimal(9.9)));
        produtos.add(new Produto("Picanha 1kg", Produto.Status.ATIVO, new BigDecimal(109.5)));
        produtos.add(new Produto("Carvão", Produto.Status.INATIVO, new BigDecimal(34.2)));
        produtos.add(new Produto("Cerveja 600ml", Produto.Status.ATIVO, new BigDecimal(8.4)));
        produtos.add(new Produto("Cupim 2kg", Produto.Status.ATIVO, new BigDecimal(92)));

//        boolean temPicanha = false;
//
//        for (Produto produto : produtos) {
//            if(produto.getNome().equals("Picanha 1kg")){
//                temPicanha = true;
//                break;
//            }
//        }

        boolean temPicanha = produtos.stream()
                //anymath retorna se qualquer elemento da stream corresponde a afirmação que será feita (não percorre todos os elementos, acha, retorna true ou false)
                        .anyMatch(p -> p.getNome().equals("Picanha 1kg"));

        System.out.println(temPicanha);

    }
}
