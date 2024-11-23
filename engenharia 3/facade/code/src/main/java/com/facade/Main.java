package com.facade;

public class Main {
    public static void main(String[] args) {
        Assento assento = new Assento(1, false, true);
        Pagamento pagamento = new Pagamento(50.0, 30.0);
        Notificacao notificacao = new Notificacao();

        FachadaCinema cinema = new FachadaCinema(assento, pagamento, notificacao);

        cinema.comprarIngresso();

        cinema.comprarIngresso();
    }
}
