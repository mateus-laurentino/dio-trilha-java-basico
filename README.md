# DESAFIO DIO - Trilha Java Básico

### Sobre

Neste desafio, o objetivo é colocar em prática tudo o que foi apresentado no módulo [**Fundamentos da Linguagem de Programação Java**](https://web.dio.me/track/santander-2025-java-back-end/course/fundamentos-da-linguagem-de-programacao-java/learning/19451f79-b808-4284-bdc1-90ab09e7926d?autoplay=1).

---

### Identidade

Segui as recomendações de tipagem e uso de inputs, mas, como forma de aperfeiçoar o projeto, criei um console que permite realizar operações para o cliente. As operações disponíveis são:

* Consulta de saldo
* Depósito
* Saque

---

### Como funciona

Ao iniciar o console, será solicitado o nome, o número da agência e o número da conta. Esta parte foi feita com recursos simples como **println** para exibir as mensagens e **Scanner** para capturar os inputs do usuário.

Após esses dados serem informados, as informações fornecidas anteriormente são exibidas, junto com uma tabela de opções disponíveis para o usuário. São elas:

| Operação | Funcionalidade  |
| -------: | :-------------- |
|        1 | Sair            |
|        2 | Consultar saldo |
|        3 | Depósito        |
|        4 | Saque           |

**Observação**: A operação **"4 - Saque"** só será exibida se o saldo do usuário for maior que 0.
