package divcon;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * A classe {@code Checadora} tem o papel de checar se as strings
 * que ela recebe estão na forma apropriadas para serem tratadas
 * como texto ou como {@code Float}.
 * 
 * Ela é composta por métodos estáticos a serem chamados através 
 * das várias classes GUI do DivCon. Decidimos fazer assim por ser
 * uma abordagem funcional da qualidade das strings capturadas pelas
 * classes de GUI. Buscamos, assim, evitar o acoplamento e aumentar
 * a coesão do código como um todo.
 */

public class Checadora {

    /**
     * Checa se o par é uma representação de texto e {@code Float},
     * nessa ordem
     * @param s1 a string que queremos testar se representa texto
     * @param s2 a string que queremos testar se representa {@code Float}
     * não negativo
     * @return retorna true se ambas as condições se verificarem, caso
     * contrário false
     */
    public static boolean checaPar(String s1, String s2) {
        return stringOk(s1) && floatOk(s2);
    }

    /**
     * Verifica se a string de entrada representa uma palavra/texto
     * sem dígitos/caracteres ilegais e se está vazia
     * @param s a string a verificar
     * @return um booleano indicando true se a string esta "ok", caso
     * contrario false
     */
    public static boolean stringOk(String s) {
        return stringNaoContemCharsIlegais(s) && !s.isBlank();
    }

    /**
     * Checa se uma dada string é uma representação de um {@code Float}
     * não-negativo
     * @param s a string que queremos checar
     * @return booleano indicando se a string é uma representação de um
     * {@code Float} não-negativo
     */
    public static boolean floatOk(String s) {
        return representaFloat(s) && Float.valueOf(s) >= 0;
    }

    /**
     * Checa se uma dada string é uma representação possível de 
     * um {@code Float}, ou seja, não contêm letras e outros dígitos
     * ilegais
     * @param s a string que queremos checar
     * @return um booleano indicando se representa ou não {@code Float}
     */
    private static boolean representaFloat(String s) {
        boolean resultado = true;
        try {
            Float.valueOf(s);
        } catch (Exception e) {
            resultado = false;
        }

        return resultado;
    }

    /**
	 * Checa se uma string não contêm nenhum caractere ilegal 
	 * como substring
	 * @param s string original a testar
	 * @return um booleano indicando {@code true} se não contém
	 * nenhum caractere ilegal, caso contrário {@code false}
	 */
	private static boolean stringNaoContemCharsIlegais(String s) {
		CharacterIterator it = new StringCharacterIterator(s);
		String charsIlegais = "0123456789!@#$%¨&*()-=+";
		while (it.current() != CharacterIterator.DONE)
        {
			String atual = String.valueOf(it.current());
            if (charsIlegais.contains(atual)) {
				return false;
			}
			it.next();
        }
		return true;
	}
}
