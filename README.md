# Projeto Final de POO - Dividindo as contas - DivCon

## Objetivo

A DivCon é uma aplicação que permite que os usuários criem contas coletivas para compartilharem e dividirem os gastos da melhor forma possível, abraçando a transparência nos gastos e nas atribuições. 

## Diagrama de Classes

<object data="./DiagramaDeClasses.pdf" type="application/pdf" width="700px" height="700px">
<embed src="./DiagramaDeClasses.pdf">
</embed>
</object>

## Como funciona

* A aplicação **DivCon** é responsável por administrar e verificar a entrada e ações dos usuários em relação às suas respectivas contas coletivas.
* Um participante nada mais é que um usuário que pode participar de diferentes contas coletivas. Ele pode adicionar valores ao seu saldo individual.
* A conta coletiva é composta de um ou mais participantes que juntam seus saldos individuais para dividirem o pagamento das contas ao final do mês de maneira transparente e fácil.
* A interface gráfica da DivCon permite que se divida os gastos de um serviço (como água, luz, etc) com os membros da conta coletiva, cada membro contribui com a quantia que desejar, sendo esta posteriormente subtraída do custo total do serrviço.

## COMO RODAR A APLICAÇÃO

### Linux/MacOS

```sh
# primeiro, clone esse repositório na sua máquina
git clone https://github.com/Pedro-V/proj-final-poo
# vá para o diretório dele
cd proj-final-poo
# mude as permissões dos scripts
sudo chmod +x *.sh
# rode os testes
./run-tests.sh
# rode a aplicação
./run-app.sh
```

### Windows

Basta clonar o repositório, mudar o diretório e executar os comandos java que estão no `run-tests.sh` e no `run-app.sh`, porém sem usar o `&&`.

## Desenvolvedores

* [Pedro Vinícius](https://github.com/Pedro-V)
* [Carlos Eduardo](https://github.com/Eduardocesn)
* [Lucas Gama](https://github.com/LucasGamaV)
