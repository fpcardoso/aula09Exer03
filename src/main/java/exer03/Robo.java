package exer03;

public class Robo {
    //ATRIBUTOS
    private int area;
    private int coordX;
    private int coordY;
    private char frente;

    //MÉTODOS CONSTRUTORES

    public Robo(){
        area =  4;
        coordX = 0;
        coordY = 0;
        frente = 'N';
    }

    public Robo(int a,int x,int y,char f){
        alterarArea(a);
        alterarCoordXY(x,y);
        alterarFrente(f);
    }

    //MÉTODOS

    public void alterarArea(int a){
        int lado = (int)Math.sqrt(a);
        area = (Math.pow(lado,2) == a && a >= 4) ? a : (area > 0 ? area : 4);
    }
    public void alterarCoordXY(int x,int y){
        int lado = (int)Math.sqrt(area);
        coordX = (x >= 0 && x <= lado) ? x : (coordX > 0 ? coordX : 0);
        coordY = (y >= 0 && y <= lado) ? y : (coordY > 0 ? coordY : 0);

    }
    public void alterarFrente(char f){
        frente = (f == 'N' || f == 'L' || f == 'S' || f == 'O') ? f : 'N';
    }
    public String posAtual(){
        return coordX + " " + coordY + " " + frente;
    }
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
