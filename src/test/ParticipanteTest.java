package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import divcon.Participante;

public class ParticipanteTest {
    Float saldoInicial = 10.99f;
    @Test
    public void testAddContaColetiva() {
        Participante novoParticipante = new Participante("João", saldoInicial);
        novoParticipante.addContaColetiva("Apê", "Conta dos amigos do apê");
        int quantidadeContas = novoParticipante.getQuantContas();
        assertEquals(quantidadeContas, 1);
    }

    @Test
    public void testAddSaldoIndividual() {
        Participante novoParticipante = new Participante("João", saldoInicial);
        novoParticipante.addSaldoIndividual(Float.valueOf(100.99f));
        Float novoSaldoIndiviual = novoParticipante.getSaldoIndividual();
        assertEquals(novoSaldoIndiviual, Float.valueOf(111.979996f));
    }

    @Test
    public void testGetNome() {
        String nome = "Joaozinho";
        Participante novoParticipante = new Participante(nome, saldoInicial);
        assertEquals(novoParticipante.getNome(), nome);
    }

    @Test
    public void testGetSaldoIndividual() {
        Participante novoParticipante = new Participante("João", saldoInicial);
        assertEquals(saldoInicial, novoParticipante.getSaldoIndividual());
    }

    @Test
    public void testListaContas() {
        Participante novoParticipante = new Participante("João", saldoInicial);
        novoParticipante.addContaColetiva("Apê", "Apê dos cria");
        String listagemEsperada = "Apê - Apê dos cria\n";
        assertEquals(listagemEsperada, novoParticipante.listaContas());
    }
}
