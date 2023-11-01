# ClienteSextoAndar

## Descrição do Projeto
<p align="justify">O projeto consiste em um sistema de cadastro de clientes, onde o usuário pode cadastrar, editar, excluir e visualizar os clientes cadastrados. O sistema foi desenvolvido utilizando a linguagem de programação Java, o framework Spring Boot e o banco de dados MongoDB.</p>

## Rotas e documentação
<p align="justify">O projeto pode ser acessado no endereço: http://34.210.87.17:8080.</p>
<p align="justify">Ele possui 4 rotas, sendo elas:</p>

- **GET** /clientes: Retorna todos os clientes cadastrados no banco de dados.

Exemplo de retorno:
```json
[
    {
        "nome" : "cliente1",
        "cpf" : "12345678910",
        "endereço" : "Rua exemplo1",
        "data de nascimento" : "31/12/2000",
        "renda" : 5000
    }, 
    {
        "nome" : "cliente2",
        "cpf" : "10987654321",
        "endereço" : "Rua exemplo2",
        "data de nascimento" : "01/01/2000",
        "renda" : 10000
    },
    {
        "nome" : "cliente3",
        "cpf" : "12345678910",
        "endereço" : "Rua exemplo3",
        "data de nascimento" : "31/12/2000",
        "renda" : 7000
    }
]
```

- **GET** /clientes/{cpf}: Retorna um cliente específico, de acordo com o cpf passado como parâmetro.

Exemplo de retorno:
```json
{
    "nome" : "cliente1",
    "cpf" : "12345678910",
    "endereço" : "Rua exemplo1",
    "data de nascimento" : "31/12/2000",
    "renda" : 5000,
    "alugueis" : [
        {
            "id" : "1",
            "id_imovel" : "54321",
            "data de término" : "31/12/2020",
            "cpf_corretor" : "12345678910",
        },
        {
            "id" : "2",
            "id_imovel" : "12345",
            "data de término" : "31/12/2020",
            "cpf_corretor" : "32145678910",
        }
    ],
    "vendas" : [
        {
            "id" : "1",
            "id_imovel" : "54321",
            "cpf_corretor" : "54123678910",
        },
        {
            "id" : "2",
            "id_imovel" : "12345",
            "cpf_corretor" : "32145678910",
        }
    ]
}
```

- **POST** /clientes: Cadastra um novo cliente no banco de dados.

Exemplo de requisição:  
Body (json):
```json
{
    "nome" : "cliente1",
    "cpf" : "12345678910",
    "endereço" : "Rua exemplo1",
    "data de nascimento" : "31/12/2000",
    "renda" : 5000
}
```


- **DELETE** /clientes/{cpf}: Exclui um cliente específico, de acordo com o cpf passado como parâmetro.



