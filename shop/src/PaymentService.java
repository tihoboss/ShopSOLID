//Принцип разделения интерфейса
interface Card {

    void pay(int amount);
}

interface PayPal {
    void pay(int amount);
}

interface Cash {
    void pay(int amount);
}

class CardPayment implements Card {
    public void pay(int amount) {
        System.out.println("Оплачено кредитной картой: " + amount);
    }
}

class PayPalPayment implements PayPal {
    public void pay(int amount) {
        System.out.println("Оплачено через PayPal: " + amount);
    }
}

class CashPayment implements Cash {
    public void pay(int amount) {
        System.out.println("Оплачено наличкой: " + amount);
    }
}

public class PaymentService {
    public boolean processPayment(String paymentMethod, int amount) {
        switch (paymentMethod.toLowerCase()) {
            case "карта": {
                Card card = new CardPayment();
                card.pay(amount);
                break;
            }
            case "paypal": {
                PayPal paypal = new PayPalPayment();
                paypal.pay(amount);
                break;
            }
            case "наличка": {
                Cash cash = new CashPayment();
                cash.pay(amount);
                break;
            }
            default:
                System.out.println("Неподдерживаемый способ оплаты: " + paymentMethod);
                return false;
        }
        return true;
    }
}