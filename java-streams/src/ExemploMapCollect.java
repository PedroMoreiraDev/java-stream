import model.Categoria;
import model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploMapCollect {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();

        Categoria categoriaBebidas = new Categoria("Bebidas");
        Categoria categoriaCarnes = new Categoria("Carnes");
        Categoria categoriaOutros = new Categoria("Outros");

        produtos.add(new Produto("Água 2l", Produto.Status.ATIVO, new BigDecimal(9.9), categoriaBebidas));
        produtos.add(new Produto("Picanha 1Kg", Produto.Status.ATIVO, new BigDecimal(109.5), categoriaCarnes));
        produtos.add(new Produto("Carvão", Produto.Status.INATIVO, new BigDecimal(34.2), categoriaOutros));
        produtos.add(new Produto("Cerveja 600ml", Produto.Status.ATIVO, new BigDecimal(8.4), categoriaBebidas));
        produtos.add(new Produto("Cupim 2kg", Produto.Status.ATIVO, new BigDecimal(92), categoriaCarnes));

//        List<Categoria> categorias = new ArrayList<>();
//
//        for (Produto produto: produtos){
//            if (produto.getStatus().equals(Produto.Status.ATIVO)){
//                Categoria categoria = produto.getCategoria();
//
//                //if verifica se há categoria repetida dentro da list categorias
//                if (!categorias.contains(categoria)){
//                    categorias.add(categoria);
//                }
//            }
//        }

        List<Categoria> categorias = produtos.stream().filter(p -> p.getStatus().equals(Produto.Status.ATIVO))
                //o map irá retornar um stream de categorias, e não de produtos
                .map(Produto::getCategoria)
                //distinct retorna stream com elemeentos unicos/distintos
                .distinct()
                //o coletor acumula os elementos dentro de uma nova lista (de categorias, pois o map transformou em categorias)
                        .collect(Collectors.toList());

        System.out.println(categorias);


    }
}
