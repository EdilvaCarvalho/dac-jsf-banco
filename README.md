# dac-jsf-banco

Com o terminal aberto no diretório do projeto, execute os comandos abaixo:

docker build -t cliente/banco ./postgres

docker build -t cliente/app .

docker run -p 5433:5432 -d --name banco cliente/banco

docker run -p 8081:8080 --name app --link banco:banco cliente/app

