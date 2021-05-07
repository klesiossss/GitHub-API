# O Back End dessa API esta rodando na Google Cloud Platform pelo seguinte Endereco:  
http://34.72.199.87/dev


# Este eh o endpoint base para retornar todos, salvar, atualizar e deletar desenvolvedores, pode utilizar o PostMan para teste
 http://34.72.199.87/dev

# Este endpoint busca por id; basta substituir {id} por um numero inteiro:
http://34.72.199.87/dev/{id}

# Este endpoint busca developers por quantidade de repositorios; substitua {numOfRepos} por um numero inteiro. 
# Foi a maneira pratica de achar bons programadores, pelo numero de repositorios, variando para mais e para menos 10% dado um valor de entrada. 
# Por exemplo 20, retornara desenvolvedores em um range dos que possuem entre 18 e 22 repositorios:
   http://34.72.199.87/dev/repos/{numOfRepos}

# este endpoint busca developers por quantidade de seguidores; substitua {numOfFollowers} por um numero inteiro. 
# Foi a maneira pratica de achar bons programadores, pelo numero de seguidores, variando para mais e para menos 10% dado um valor de entrada. 
# Por exemplo 100, retornara desenvolvedores em um range dos que possuem entre 90 e 110 seguidores:   
  http://34.72.199.87/dev/followers/{numOfFollowers}
