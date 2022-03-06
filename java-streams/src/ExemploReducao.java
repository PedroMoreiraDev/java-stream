import model.Categoria;
import model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class ExemploReducao {

    public static void main(String[] args) {


        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Água 2l", Produto.Status.ATIVO, new BigDecimal(9.9)));
        produtos.add(new Produto("Picanha 1Kg", Produto.Status.ATIVO, new BigDecimal(109.5)));
        produtos.add(new Produto("Carvão", Produto.Status.INATIVO, new BigDecimal(34.2)));
        produtos.add(new Produto("Cerveja 600ml", Produto.Status.ATIVO, new BigDecimal(8.4)));
        produtos.add(new Produto("Cupim 2kg", Produto.Status.ATIVO, new BigDecimal(92)));

//        BigDecimal total = BigDecimal.ZERO;

//        for (Produto produto : produtos){
//            if(produto.getStatus().equals(Produto.Status.ATIVO)){
//                total = total.add(produto.getPreco());
//            }
//        }



        BigDecimal total = produtos.stream()
                        .filter(p -> p.getStatus().equals(Produto.Status.ATIVO))
                                .map(Produto::getPreco)
                                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(total);

    }


}
