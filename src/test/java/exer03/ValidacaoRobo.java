package exer03;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class ValidacaoRobo {

    @Test
    public void testRobo(){

        //construtores
        assertEquals("0 0 N",new Robo().posAtual()); //padrão
        assertEquals("1 1 L",new Robo(-5,1,1,'L').posAtual()); //área inválida
        assertEquals("0 0 L",new Robo(4,3,3,'L').posAtual()); //coordenadas fora da área

        //métodos para alterar
        Robo r1 = new Robo(25);
        r1.alterarCoordXY(-3,5);
        assertEquals("0 5 N",r1.posAtual());
        r1.alterarArea(9);
        assertEquals("0 0 N",r1.posAtual());
        r1.alterarFrente('S');
        assertEquals("0 0 S",r1.posAtual());


        //método plano de exploração
        Robo r2 = new Robo(25,2,1,'O');
        assertEquals("0 3 O",r2.planoExp("MDMMEM"));
        assertEquals("1 5 N",r2.planoExp("DDMEMMMMM"));
        r2.alterarArea(36);
        assertEquals("6 2 S",r2.planoExp("MDMMMMMDMMMM"));




    }
}
