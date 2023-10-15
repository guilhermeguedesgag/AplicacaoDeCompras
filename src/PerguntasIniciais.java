import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PerguntasIniciais {

    private static double limiteDoCartao;

    public void perguntasIniciais() {
        try {


            Scanner scanner1 = new Scanner(System.in);
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.00");

            System.out.println("Digite o limite do seu cartão:");
            limiteDoCartao = scanner1.nextDouble();
            System.out.println("Você inseriu o limite R$" + decimalFormat.format(limiteDoCartao)+ " reais");
            System.out.println();


            PerguntasDeRetorno perguntasDeRetorno = new PerguntasDeRetorno();
            perguntasDeRetorno.perguntasDeRetorno();

        } catch (InputMismatchException e) {
            System.out.println("Ops...digite uma informação numérica.");
            perguntasIniciais();


        }




    }


    public static double getLimiteDoCartao() {
        return limiteDoCartao;
    }
}