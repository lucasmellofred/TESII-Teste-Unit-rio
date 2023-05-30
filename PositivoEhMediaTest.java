import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositivoEhMediaTest {
    @Test
    public void testContarPositivos() {
        int[] numeros = { 1, -2, 3, -4, 5 };
        int countPositivos = PositivoEhMedia.contarPositivos(numeros);
        Assertions.assertEquals(3, countPositivos);
    }

    @Test
    public void testContarNegativos() {
        int[] numeros = { 1, -2, 3, -4, 5 };
        int countNegativos = PositivoEhMedia.contarNegativos(numeros);
        Assertions.assertEquals(2, countNegativos);
    }

    @Test
    public void testSomarPositivos() {
        int[] numeros = { 1, 2, -3, 4, -5, 6, -7, 8, 9, -10 };
        int somaEsperada = 1 + 2 + 4 + 6 + 8 + 9;
        int somaObtida = PositivoEhMedia.somarPositivos(numeros);
        Assertions.assertEquals(somaEsperada, somaObtida);
    }

    @Test
    public void testSomarNegativos() {
        int[] numeros = { 1, 2, -3, 4, -5, 6, -7, 8, 9, -10 };
        int somaEsperada = -3 - 5 - 7 - 10;
        int somaObtida = PositivoEhMedia.somarNegativos(numeros);
        Assertions.assertEquals(somaEsperada, somaObtida);
    }

    @Test
    public void testMediaPositivos() {
        int[] numeros = { 1, 2, 3, 4, 5 };
        double mediaPositivos = PositivoEhMedia.calcularMedia(PositivoEhMedia.somarPositivos(numeros),
                PositivoEhMedia.contarPositivos(numeros));

        Assertions.assertEquals(3.0, mediaPositivos);
    }

    @Test
    public void testMediaNegativos() {
        int[] numeros = { -1, -2, -3, -4, -5 };
        double mediaNegativos = PositivoEhMedia.calcularMedia(PositivoEhMedia.somarNegativos(numeros),
                PositivoEhMedia.contarNegativos(numeros));

        Assertions.assertEquals(-3.0, mediaNegativos);
    }

    @Test
    public void testMediaGeral() {
        int[] numeros = { 1, 2, -3, 4, -5 };
        double mediaGeral = PositivoEhMedia.calcularMedia(PositivoEhMedia.somarPositivos(numeros)
                + PositivoEhMedia.somarNegativos(numeros), numeros.length);

        Assertions.assertEquals(-0.2, mediaGeral, 0.00001);
    }
}
