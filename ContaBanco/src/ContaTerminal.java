import java.math.BigDecimal;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        var input = new Scanner(System.in);

        System.out.print("Informe seu nome: ");
        var name = input.next();
        input.nextLine();
        System.out.println();

        System.out.printf("Ola %s,\nAgora precisamos do numero de sua agencia: ", name);
        var agency = input.next();

        System.out.print("Agora informe o numero da sua conta: ");
        var account = input.next();
        clearConsole();

        var balance = new BigDecimal(0);

        var exit = false;
        while (!exit){
            showOperations(balance, name, agency, account);

            System.out.println("Qual operação deseja realizar?");
            var operation = input.nextShort();

            if (operation == 1)
                exit = true;
            else if (operation == 2)
                consult(balance, input);
            else if (operation == 3)
                balance = moveAccount(balance, input, "depositar", "deposito");
            else if (operation == 4 && balance.compareTo(BigDecimal.ONE) > 0)
                balance = moveAccount(balance, input, "retirar", "retirada");
            else
                operationError(input);
        }

    }

    private static void showOperations(BigDecimal balance, String userName, String agency, String account){
        System.out.printf("Cliente: %s\n", userName);
        System.out.printf("Agencia: %s\n", agency);
        System.out.printf("Conta: %s\n", account);
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("| Operação | Funcionalidade  |");
        System.out.println("------------------------------");
        System.out.println("|        1 | Sair            |");
        System.out.println("|        2 | Consultar saldo |");
        System.out.println("|        3 | Deposito        |");

        if(balance.compareTo(BigDecimal.ONE) > 0)
            System.out.println("|        4 | Saque           |");

        System.out.println("------------------------------");
    }

    private static void consult(BigDecimal balance, Scanner input){
        clearConsole();
        System.out.printf("Seu saldo atual é: R$ %s \n", balance);
        System.out.println();

        input.nextLine();
        System.out.print("Aperte 'ENTER' para voltar.");
        input.nextLine();

        clearConsole();
    }

    private static BigDecimal moveAccount(BigDecimal balance, Scanner input, String operationName, String action){
        var newValue = informationOperation(input, operationName);
        if (newValue.compareTo(BigDecimal.ONE) < 1
         || (operationName.equals("sacar") && newValue.compareTo(balance) > 0))
        {
            operationError(input);
            return balance;
        }

        return summarizeOperation(input, balance, newValue, action);
    }

    private static void operationError(Scanner input){
        input.nextLine();
        System.out.println("Valor informado não é permitido, aperte 'ENTER' para voltar a tela anterior.");
        input.nextLine();

        clearConsole();
    }

    private static BigDecimal informationOperation(Scanner input, String operationName){
        clearConsole();
        System.out.printf("Qual o valor que deseja %s?\n", operationName);
        System.out.println("Atenção, valores menores que R$ 1,00 serão desconsiderados.");
        var value = input.nextBigDecimal();
        System.out.println();
        return value;
    }

    private static BigDecimal summarizeOperation(Scanner input, BigDecimal balance, BigDecimal value, String operationName){
        System.out.printf("Saldo anterior: R$ %s\n", balance);
        System.out.printf("Valor de %s: R$ %s\n", operationName, value);

        var newBalance = operationName.equals("deposito")
                ? balance.add(value)
                    : balance.subtract(value);

        System.out.printf("Saldo atual: R$ %s\n", newBalance);
        System.out.println();

        input.nextLine();
        System.out.print("Aperte 'ENTER' para voltar.");
        input.nextLine();

        clearConsole();
        return newBalance;
    }

    private static void clearConsole(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}