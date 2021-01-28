package io.github.heltonricardo.exerciciossb.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import io.github.heltonricardo.exerciciossb.model.entities.Produto;

/* 
 * Um repositório pode ser um arquivo texto, uma planilha, um banco de dados
 * etc. O padrão Repository tem a ideia de criar métodos de alto nível que irão
 * abstrair todo acesso aos dados. Semelhante ao DAO que é mais voltado para a
 * implementação, o Repository se preocupa mais em criar as interfaces para
 * abstração.
 * 
 * Essa interface é responsável por fazer a persistência de um produto.
 * Ela extende outra interface que já possui implementações necessárias por
 * fazer essa persistência. Nos generics de CrudRepository inserimos a classe
 * dos objetos que serão persistidos e o tipo Wrapper do identificador. Como em
 * produto usando "int", aqui usaremos "Integer".
 * 
 * public interface ProdutoRepository extends CrudRepository<Produto, Integer>
 * {}
 */

/* 
 * Alteramos de CrudRepository para PagingAndSortingRepository para que seja
 * possível usar, além das funcionalidades do CRUD, resultados por paginação.
 * 
 * O método declarado é implementado automaticamente pelo framework pois está
 * usando uma nomenclatura da convensão do springboot. Ele já interpreta que
 * quando é usando "findBy" no início, o método é de busca, então basta usar
 * o nome do atributo corretamente, nesse caso "Nome", que ele implementará.
 * Esses métodos são conhecidos como "derived query methods".
 */

public interface ProdutoRepository extends
	PagingAndSortingRepository<Produto, Integer> {
	
	public Iterable<Produto> findByNomeContainingIgnoreCase(String str);
}