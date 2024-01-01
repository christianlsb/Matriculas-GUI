# Projeto de matrículas

liste, cadastre, atualize e remova matrículas.

## Índice

- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Usar](#como-usar)

## Configuração do Ambiente

1. Certifique-se de ter o Java instalado em sua máquina.
2. Execute o script SQL `alunos.sql` localizado em `resources/alunos.sql` para criar e configurar o banco de dados necessário.
3. Em `ConexaoFactory.java` configure conforme seu banco de dados (port, user e password).

## Como Usar

```bash
javac *.java (compila todos os arquivos)

java -cp ".;./mysql-connector-j-8.2.0.jar" Main (executa o programa)
