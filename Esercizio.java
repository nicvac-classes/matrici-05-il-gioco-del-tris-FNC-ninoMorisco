import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {

    //Input da tastiera
    static Scanner input = new Scanner(System.in);
    
    static boolean inserisciInGriglia(String[]G, int i, int j, String s){
        boolean ok=false;
        i=i-1;
        j=j-1;
        ok(0<=i && i<= 2, && 0 <= j && j<=2, && G[i][j] == "-" )
        if (ok) {
            G[i][j]= s;
        }
        return ok;
    }
    static void azzeraGriglia(String[]G, int r, int c){
        int i=0;
        for(int i=0, i<r, ++i){
            for(int j=0, j<c, ++j){
                G[i][j]= "-";
            }
        }           
    }

    static boolean controllaVincita(String []G, int i, int j, String s){
        boolean vince = false;
        if ( G[0][0].equals(s) && G[0][1].equals(s) && G[0][2].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[1][0].equals(s) && G[1][1].equals(s) && G[1][2].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[2][0].equals(s) && G[2][1].equals(s) && G[2][2].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[0][0].equals(s) && G[1][0].equals(s) && G[2][0].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[0][1].equals(s) && G[1][1].equals(s) && G[2][1].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[0][2].equals(s) && G[1][2].equals(s) && G[2][2].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[0][0].equals(s) && G[1][1].equals(s) && G[2][2].equals(s) ) {
            vince = true;
        }
        if ( !(vince) && G[0][2].equals(s) && G[1][1].equals(s) && G[2][0].equals(s) ) {
            vince = true;
        }
        return vince;
    }

    static int contaCaselleLibere(String[][] G) {
    int conto=0;
    for (int i=0; i<=2; i=i+1) {
        for (int j=0; j<=2; j=j+1) {
            if ( G[i][j].equals("-") ) {
                conto = conto + 1;
            }
        }
    } 
    return conto;
    }


    public static void main(String args[]) {
        String[][] griglia = new String[3][3];
        azzeraGriglia(griglia,3,3);
        System.out.println("Griglia di gioco:");
        UtilsMatrice.visualizza(griglia);

        String s = "X";
        boolean haiVinto = false;
        boolean pareggio = false;
        do {
            boolean mossaCorretta;
            int mossaI, mossaJ;
            do {
                System.out.println("Giocatore "+s+", inserisci la tua mossa (riga e colonna [1-3]):");
                mossaI = Integer.parseInt(input.nextLine());
                mossaJ = Integer.parseInt(input.nextLine());
                mossaCorretta = inserisciInGriglia(griglia, mossaI, mossaJ, s);
            } while( !(mossaCorretta) );

            System.out.println("Griglia di gioco:");
            UtilsMatrice.visualizza(griglia);

            haiVinto = controllaVincita(griglia, s);
            if (haiVinto) {
                System.out.println(s + " VINCE! ");
            }
      
            int caselleLibere = contaCaselleLibere(griglia);
            pareggio = !(haiVinto) && (caselleLibere == 0);
            if ( pareggio ) {
                System.out.println(" PAREGGIO! ");
            }

            if ( s.equals("X") ) {
                s = "O";
            } else {
                s = "X";
            }
        } while ( !(haiVinto) && !(pareggio) );
    }
}