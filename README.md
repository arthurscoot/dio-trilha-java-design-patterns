# Projeto de Recomendação de Filmes

## Descrição
Este projeto consiste em um sistema de recomendação de filmes baseado em gênero, classificação indicativa e popularidade. Ele recebe parâmetros via requisição HTTP e retorna uma lista de filmes filtrados conforme os critérios informados.

## Design Patterns Utilizados
Este projeto foi desenvolvido utilizando alguns padrões de projeto (Design Patterns) para garantir maior organização e manutenibilidade do código. Algumas anotações do **Spring Boot** e **JPA** desempenham papel essencial na implementação desses padrões:

- **Factory Method**: Utilizado para criar instâncias de recomendação de filmes com base nos parâmetros informados pelo usuário.  
  - Implementado na classe `RecomendacaoFactory`, que recebe os critérios e retorna um objeto adequado de recomendação.  

- **Strategy**: Implementado para definir diferentes estratégias de filtragem de filmes de acordo com os critérios do usuário.  
  - A anotação `@Service` no Spring define classes de serviço que encapsulam a lógica de negócio, permitindo a troca dinâmica das estratégias de recomendação.  

- **Singleton**: Aplicado no serviço de busca de filmes para garantir uma única instância compartilhada no sistema.  
  - O Spring gerencia automaticamente o ciclo de vida das classes anotadas com `@Service` e `@Repository`, garantindo que apenas uma instância seja criada e reutilizada.  

- **Repository (DAO Pattern)**: O JPA utiliza `@Repository` para criar um padrão de acesso a dados, abstraindo a interação com o banco de dados.  
  - A interface `FilmeRepository` estende `JpaRepository`, permitindo consultas eficientes sem a necessidade de implementação manual.  

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- REST API
- Banco de Dados H2 (Banco em memória)

## Como Funciona
1. O sistema armazena uma lista de filmes contendo informações como:
   - Gênero
   - Classificação indicativa
   - Popularidade (avaliação média)
2. O endpoint de recomendação recebe parâmetros via query string:

"http://localhost:8080/filmes?genero=Action&idade=18&popularidade=6.5"
