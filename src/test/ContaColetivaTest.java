package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import divcon.*;

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
    public void testgetInfoFormatada() {
        ContaColetiva contaTeste = new ContaColetiva(nomeConta, descricaoConta);
        String info = contaTeste.getInfoFormatada();
        assertEquals(infoEsperada, info);
    }

}
