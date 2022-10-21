package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import divcon.Participante;

public class ParticipanteTest {
    @Test
    public void testAddContaColetiva() {
        Participante novoParticipante = new Participante("João", "10.99");
        novoParticipante.addContaColetiva("Apê", "Conta dos amigos do apê");
        int quantidadeContas = novoParticipante.getContas().size();
        assertEquals(quantidadeContas, 1);
    }

    @Test
    public void testAddSaldoIndividual() {
        Participante novoParticipante = new Participante("João", "10.99");
        novoParticipante.addSaldoIndividual(Float.valueOf(100.99f));
        Float novoSaldoIndiviual = novoParticipante.getSaldoIndividual();
        assertEquals(novoSaldoIndiviual, Float.valueOf(111.979996f));
    }

    @Test
    public void testGetNome() {
        String nome = "Joaozinho";
        Participante novoParticipante = new Participante(nome, "10.99");
        assertEquals(novoParticipante.getNome(), nome);
    }

    @Test
    public void testGetSaldoIndividual() {
        Float saldoIndividual = Float.valueOf(10.99f);
        Participante novoParticipante = new Participante("João", saldoIndividual.toString());
        assertEquals(saldoIndividual, novoParticipante.getSaldoIndividual());
    }

    @Test
    public void testListaContas() {
        Participante novoParticipante = new Participante("João", "10.99");
        novoParticipante.addContaColetiva("Apê", "Apê dos cria");
        String listagemEsperada = "Apê - Apê dos cria\n";
        assertEquals(listagemEsperada, novoParticipante.listaContas());
    }
}
