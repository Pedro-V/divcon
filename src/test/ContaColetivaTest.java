package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import divcon.ContaColetiva;
import divcon.Participante;

public class ContaColetivaTest {
    String nomeConta = "Apê";
    String descricaoConta = "Apê dos cria";
    String infoEsperada = "Apê - Apê dos cria";
    @Test
    public void testAddParticipante() {
        ContaColetiva contaTeste = new ContaColetiva("Apê", "Apê dos cria");
        Participante novoParticipante = new Participante("José", "0.00");
        contaTeste.addParticipante(novoParticipante);
        assertEquals(novoParticipante, contaTeste.getParticipante("José"));
    }

    @Test
    public void testGetInfoConta() {
        ContaColetiva contaTeste = new ContaColetiva(nomeConta, descricaoConta);
        String info = contaTeste.getInfoConta();
        assertEquals(infoEsperada, info);
    }

    @Test
    public void testGetSaldoFormatado() {

    }

    @Test
    public void testGetStatusFormatado() {

    }

    @Test
    public void testListParticipantesCaso1() {
        // caso teste 1: Lista vazia
        ContaColetiva contaTeste = new ContaColetiva(nomeConta, descricaoConta);
        String listagemEsperada = "";
        assertEquals(listagemEsperada, contaTeste.listaParticipantes());
    }

    @Test
    public void testListParticipantesCaso2() {
        // caso teste 2: Lista preenchida
        ContaColetiva contaTeste = new ContaColetiva(nomeConta, descricaoConta);
        String listagemEsperada = "José\n";
        Participante novoParticipante = new Participante("José", "0.00");
        contaTeste.addParticipante(novoParticipante);
        assertEquals(listagemEsperada, contaTeste.listaParticipantes());
    }

    @Test
    public void testPagaServico() {

    }
}
