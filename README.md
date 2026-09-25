# Camada de Acesso a Dados com RowData Gateway

O objetivo deste projeto é ilustrar o funcionamento do padrão **Row Data Gateway** no sistema de vendas SaleSys. Este padrão atua como um intermediário entre a aplicação e a base de dados, onde cada objeto corresponde exatamente a uma linha de uma tabela.

Nesta aula, o seu foco é implementar a camada de acesso a dados (`Data Access Layer`).
A aplicação já consegue gerir `Customers`. A sua tarefa é completar o código que permite à aplicação guardar e ler informações sobre `Product`, uma `Sale` e os `SaleProduct`.

**Ficheiros a modificar:**
*   `src/main/java/dataaccess/ProductRowDataGateway.java`
*   `src/main/java/dataaccess/SaleRowDataGateway.java`
*   `src/main/java/dataaccess/SaleProductRowDataGateway.java`

**O que precisa de fazer:**
1.  Perceber como funciona o DataSource e completar as componentes que estão em falta.
2.  Definir as constantes SQL nos ficheiros.
3.  Criar os construtores necessários para criar novos objetos (ex: um `ProductRowDataGateway` com `prodcod`, `description`, etc.).
4.  Implementar o método `insert()` para guardar um novo registo na base de dados.
5.  Implementar os métodos `find()` (ou `findWith...()`) para ler registos da base de dados.

## Arquitetura
O projeto está dividido em três camadas, mas nesta aula focamo-nos apenas numa:
* `presentation` Layer: Ignorada nesta aula.
* `business` Layer: Ignorada nesta aula. (**Será implementada na próxima aula**).
* `dataaccess` Layer: Responsável pela comunicação com a base de dados.

## Componentes importantes da Camada de Dados (Não Alterar)
Sua tarefa é implementar os Gateways. Para isso, fará uso de classes de suporte. Não precisa de alterar estes ficheiros. 
* `dataaccess/DataSource.java` → Classe *Singleton* responsável pela ligação à base de dados. Fornece métodos para criar `PreparedStatement` e para gerir transações (`beginTransaction`, `commit`, `rollback`).
* `dbutils/SetupDatabase.java ` → Classe que inicializa a base de dados. Executa o script `resources/schema-postgres.sql` para criar as tabelas e inserir dados iniciais.


## Como testar o seu código
Nesta aula, deve começar a trabalhar no ficheiro `src/main/java/client/SimpleClient.java`.

Este cliente foi preparado para interagir **diretamente** com a camada de acesso a dados. Use o método `main` para invocar os métodos que implementou e verificar se funcionam como esperado.

**Exemplo de como pode testar o seu `ProductRowDataGateway`:**
Adicione o seguinte bloco de código dentro do `try-catch` principal do `SimpleClient.java`:

```java
// Adicione este bloco em SimpleClient.java para testar a sua implementação
try {
    System.out.println("A testar a sua implementação de ProductRowDataGateway...");

    // Terá de criar um construtor público no seu ProductRowDataGateway
    // para que a linha seguinte funcione!
    ProductRowDataGateway newProduct = new ProductRowDataGateway(999, "O Meu Produto de Teste", 19.99, 50);
    newProduct.insert();
    System.out.println("Produto inserido com sucesso com o ID: " + newProduct.getProductId());

    System.out.println("\nA procurar o produto com o código 999...");
    ProductRowDataGateway foundProduct = ProductRowDataGateway.findWithProdCod(999);
    System.out.println("Produto encontrado: " + foundProduct.getDescription());

} catch (PersistenceException e) {
    System.err.println("Erro ao testar o ProductRowDataGateway!");
    e.printStackTrace();
}
```

## Exemplo de implementação
Abaixo está o método `insert()` do `CustomerRowDataGateway.java`:
``` Java
// Exemplo retirado de dataaccess/CustomerRowDataGateway.java
public void insert () throws PersistenceException {
    // "try-with-resources" para garantir que o PreparedStatement é fechado
    try (PreparedStatement statement = DataSource.INSTANCE.prepareGetGenKey(INSERT_CUSTOMER_SQL)) {
        
        // Define os parâmetros (?) da query SQL com os valores do objeto
        statement.setInt(1, vat);
        statement.setString(2, designation);
        statement.setInt(3, phoneNumber);
        statement.setInt(4, discountId);
        
        // Executa o comando de inserção
        statement.executeUpdate();
        
        // Carrega a chave primária gerada automaticamente pela base de dados
        try (ResultSet rs = statement.getGeneratedKeys()) {
            rs.next(); 
            id = rs.getInt(1); // Atualiza o ID do objeto com o valor da BD
        }
    } catch (SQLException e) {
        throw new PersistenceException ("Internal error!", e);
    }
}
```
### Como executar o projeto
Dentro da pasta do projeto (com o Docker Engine a correr), execute o seguinte comando no terminal:
``` Bash
docker-compose up --build
```

## Visualizar a base de dados
Para verificar se os seus métodos funcionaram, pode utilizar uma ferramenta com interface gráfica para verificar a base de dados. Neste disciplina vamos recomendar o uso do [DBeaver](https://dbeaver.io/)

#### Detalhes da ligação:
    Host: localhost
    Porta: 5432
    Base de Dados: postgres
    Utilizador: user
    Palavra-passe: password