# <center>RestricList API 🗃️</center>

Este projeto é um serviço de controle de CPFs em uma api restrita, onde realiza a validação e ajuda no controle dos mesmos.

---
## 📝 Requisitos
* Java 11
* Docker
* Postman
* IDE de preferência

## 📄 Documentação 
Foi utilizado Swagger para realizar a documentação e modelagem dos endpoints do projeto, pensando em ajudar futuramente a utilização da API. Onde pode ser acessado na URI:
```
/swagger-ui/index.html
```

## 🧑‍💻 Como rodar o projeto
Após clonar o repositório em sua máquina rode o comando abaixo:
```
mvn spring-boot:run
```

## ⚗️ Build do projeto com Docker
Caso prefira é possível utilizar o docker para realizar o **build** do projeto, utilizando o arquivo Dockerfile no projeto para gerar a imagem, ou então utilizar o **maven** com o comando abaixo: 
```
mvn spring-boot:build-image
```
Após gerar a imagem, rode o comando:
```
docker run -p 8080:8080 restrict-list:0.0.1 .
```

## ✨ Postman
Utilize a collection _restrictlist-api.postman_ presente no projeto, para importar e testar os endpoints no Postman. 

___
🌐 [André Almeida](https://github.com/andreluas)