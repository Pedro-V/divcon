package divcon;

public class Participante {
    private String nome;
    private Float saldoIndividual;

    public Participante(String nome, String saldoInicial) {
        this.nome = nome;
        // Formatamos de 10,9,9 para 10.99, por ex
        String saldoInicialFormatado = saldoInicial.replaceFirst(",", ".").replace(",", "");
        saldoIndividual = Float.parseFloat(saldoInicialFormatado);
    }

    public String getNome() {
        return nome;
    }

    public Float getSaldoIndividual() {
        return saldoIndividual;
    }
}
