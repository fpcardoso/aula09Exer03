package exer03;

/**
 * Classe que representa um Robô de exploração espacial.
 * Possui como atributos uma area de exploração (obrigatotiamente um quadrado).
 * Coordenadas x,y e sentido para qual está sua frente(Norte, Sul, Leste ou Oeste)
 */
public class Robo {

    //---ATRIBUTOS---
    private int area;
    private int coordX;
    private int coordY;
    private char frente;

    //---MÉTODOS CONSTRUTORES---

    /**
     * Método construtor padrão que inicializa o Robô nas coordenadas (0,0)
     * com frente para o Norte e área de exploração igual a 4.
     */
    public Robo(){
        area =  4;
        coordX = 0;
        coordY = 0;
        frente = 'N';
    }

    /**
     * Método construtor que inicializa o Robô com uma área de exploração passada como parâmetro.
     * Coordenadas (0,0) e frente para Norte.
     * @param a área de exploração.
     */
    public Robo(int a){
        alterarArea(a);
        coordX = 0;
        coordY = 0;
        frente = 'N';
    }

    /**
     * Método construtor que inicializa os atributos com valores passado como parâmetro.
     * @param a area de exploração (obrigatotiamente um quadrado). E.: 4, 9, 16, etc...
     * @param x valor da coordenada x inicial
     * @param y valor da coordenada y inicial
     * @param f frente inicial do Robô (N, S, L ou O)
     */
    public Robo(int a,int x,int y,char f){
        alterarArea(a);
        alterarCoordXY(x,y);
        alterarFrente(f);
    }

    //---MÉTODOS---

    /**
     * Método para alterar a área de exploração para o valor passado como parâmetro.
     * Caso a área informada não represente um quadrado, mantém a área atual.
     * @param a área de exploração
     */
    public void alterarArea(int a){
        int lado = (int)Math.sqrt(a);
        area = (Math.pow(lado,2) == a && a >= 4) ? a : (area > 0 ? area : 4);
    }

    /**
     * Método para alterar as coordenadas do Robô para valores passados como parâmetros.
     * Caso uma das coordenadas seja inválida, mantém a anterior.
     * @param x coordenada x.
     * @param y coordenada y.
     */
    public void alterarCoordXY(int x,int y){
        int lado = (int)Math.sqrt(area);
        coordX = (x >= 0 && x <= lado) ? x : (coordX > 0 ? coordX : 0);
        coordY = (y >= 0 && y <= lado) ? y : (coordY > 0 ? coordY : 0);

    }

    /**
     * Método para alterar a frente do Robô para sentido passado como parâmetro.
     * @param f sentido que aponta a frente do Robô.
     */
    public void alterarFrente(char f){
        frente = (f == 'N' || f == 'L' || f == 'S' || f == 'O') ? f : 'N';
    }

    /**
     * Método para retornar a posição atual do Robô
     * @return retorna uma string com as coordenadas x e y atuais e o sentido que aponta sua frente.
     */
    public String posAtual(){
        return coordX + " " + coordY + " " + frente;
    }

    /**
     * Método que altera posição do Robô conforme plano de exploração passado como parâmetro.
     * Plano composto pelos seguintes comandos:
     * E - girar no próprio eixo para esquerda.
     * D - girar no próprio eixo para direita.
     * M - Mover uma coordenada para frente
     * @param plano String composta pela sequência de comandos do plano de explorção.
     * @return retorna uma String com a posição do Robô logo após executado o plano de exploração.
     */
    public String planoExp(String plano){
        int tam = plano.length();
        for(int i = 0;i < tam;i++){
            char comando = plano.charAt(i);
            switch(comando){
                case 'E' :
                case 'D' : girar(comando);
                    break;
                case 'M' : mover();
            }
        }
        return posAtual();
    }

    /**
     * Método privado que faz o Robô girar para esquerda ou direita conforme comando passado como parâmetro
     * @param lado lado para qual o Robô irar girar sobre o próprio eixo.
     */
    private void girar(char lado){
        switch(frente){
            case 'N' : alterarFrente((lado == 'E') ? 'O' : 'L');
                break;
            case 'L' : alterarFrente((lado == 'E') ? 'N' : 'S');
                break;
            case 'S' : alterarFrente((lado == 'E') ? 'L' : 'O');
                break;
            case 'O' : alterarFrente((lado == 'E') ? 'S' : 'N');
                break;
        }
    }

    /**
     * Método privado que faz o Robô mover uma unidade para frente.
     */
    private void mover(){
        switch(frente){
            case 'N' : if((coordY + 1) <= area/2){coordY++;}
                break;
            case 'L' : if((coordX + 1) <= area/2){coordX++;}
                break;
            case 'S' : if((coordY - 1) >= 0){coordY--;}
                break;
            case 'O' : if((coordX - 1) >= 0){coordX--;}
                break;
        }
    }
}
