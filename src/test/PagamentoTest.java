package test;

import static org.junit.Assert.*;

import org.junit.Test;

import divcon.*;

public class PagamentoTest {
    @Test
    public void testAtualizaSaldoParticipante() {
        ContaColetiva conta = new ContaColetiva("Teste", "Teste");
        Float saldoInicial = 10.99f;
        Float custo = 15f;
        Float valorPago = 10f;
        Participante participante = new Participante("Pedro", saldoInicial);
        Servico servico = new Servico("Teste", custo);
        conta.addServico(servico);
        Pagamento pagamento = new Pagamento(valorPago, conta, participante, servico);
        // Testamos no caso do troco ser nulo
        Float saldoEsperado = saldoInicial - valorPago;
        pagamento.atualizaSaldoParticipante(0f);

        assertEquals(saldoEsperado, participante.getSaldoIndividual());
    }

    @Test
    public void testPodePagarCasoUm() {
        // O caso 1 é onde de fato o participante pode pagar
        ContaColetiva conta = new ContaColetiva("Teste", "Teste");
        Float saldoInicial = 10.99f;
        Float custo = 15f;
        Float valorPago = 10f;
        Participante participante = new Participante("Pedro", saldoInicial);
        Servico servico = new Servico("Teste", custo);
        conta.addServico(servico);
        Pagamento pagamento = new Pagamento(valorPago, conta, participante, servico);
        // deve poder pagar pois seu saldo é maior que o valor pago
        assertTrue(pagamento.podePagar());
    }

    @Test
    public void testPodePagarCasoDois() {
        // O caso 2 é onde ele não pode pagar
        ContaColetiva conta = new ContaColetiva("Teste", "Teste");
        Float saldoInicial = 10.99f;
        Float custo = 15f;
        Float valorPago = 11f;
        Participante participante = new Participante("Pedro", saldoInicial);
        Servico servico = new Servico("Teste", custo);
        conta.addServico(servico);
        Pagamento pagamento = new Pagamento(valorPago, conta, participante, servico);

        assertFalse(pagamento.podePagar());
    }

    @Test
    public void testRetiraServicoPago() {
        ContaColetiva conta = new ContaColetiva("Teste", "Teste");
        Float saldoInicial = 10.99f;
        Float custo = 10f;
        Float valorPago = 10f;
        Participante participante = new Participante("Pedro", saldoInicial);
        String nomeServico = "Teste";

        Servico servico = new Servico(nomeServico, custo);
        conta.addServico(servico);
        Pagamento pagamento = new Pagamento(valorPago, conta, participante, servico);

        servico.setCusto(0f);
        pagamento.retiraServicoPago();
        assertNull(conta.getServico(nomeServico));
    }
}
