import java.util.Scanner;


public class Transaction {
    public static void main(String[] args) {
        boolean b = true;
        while (b) {

            Scanner t = new Scanner(System.in);

            System.out.println("Пожалуйста задайте сумму транзакции:");
            System.out.println("Пример : 27.69 ");
            System.out.println("Ваша сумма :");


            String transaction;
            try {
                transaction = t.nextLine();

                transaction = transaction + " UAH ";
                System.out.println("Ваша сумма : " + transaction); // Разделение строки

                String[] str = transaction.split(" ");


                String transactionSum = str[0];
                double sum = Double.parseDouble(transactionSum);


                double commission;

                commission = (sum * 0.02) + 3;     // комиссия 2%+3 грн

                if (commission <= 5.00) commission = 5.00;
                if (commission >= 20.00) commission = 20.00;


                System.out.println("Комиссия:" + String.format("%.2f", commission));
            } catch (NumberFormatException ex) {
                System.out.println("Неправильный формат, пожалуйста задайте сумму корректно - Пример: 27.69 ");
            } catch (NullPointerException e) {
                System.out.println("Пожалуйста задайте сумму транзакции");
            }
        }
    }
}
