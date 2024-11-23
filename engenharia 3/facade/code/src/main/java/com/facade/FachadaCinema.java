package com.facade;

public class FachadaCinema {
    private Assento assento;
    private Pagamento pagamento;
    private Notificacao notificacao;

    public FachadaCinema(Assento assento, Pagamento pagamento, Notificacao notificacao) {
        this.assento = assento;
        this.pagamento = pagamento;
        this.notificacao = notificacao;
    }

    public void comprarIngresso() {
        if (!assento.isOcupado()) {
            assento.reservar();
            pagamento.processar(assento.isPremium());
            notificacao.enviar(pagamento.isOperacaoAceita(), pagamento.getSaldo(), pagamento.getPreco());
        } else {
            System.out.println("Não foi possível realizar a compra. Assento já ocupado.");
        }
    }

    public Assento getAssento() {
        return this.assento;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public Notificacao getNotificacao() {
        return this.notificacao;
    }
}
