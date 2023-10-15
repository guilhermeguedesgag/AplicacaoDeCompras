import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PerguntaFinal {
    private static int respostaPerguntaFinal;


    public static void perguntaFinal(){
        System.out.println("Digite 0 para sair ou 1 para continuar:");
        Scanner scanner2 = new Scanner(System.in);
        respostaPerguntaFinal = scanner2.nextInt();
        scanner2.nextLine();// limpa buffer}

        if (respostaPerguntaFinal != 0 && respostaPerguntaFinal !=1) {
            System.out.println("Ops...você inseriu uma opção inválida, digite 1 continuar ou 0 para sair:");
            perguntaFinal();
        } else if (respostaPerguntaFinal == 1) {
            PerguntasDeRetorno perguntasDeRetorno = new PerguntasDeRetorno();
            perguntasDeRetorno.perguntasDeRetorno();

        } else if (respostaPerguntaFinal == 0) {

            PerguntasDeRetorno perguntasDeRetorno = new PerguntasDeRetorno();
            Collections.sort(perguntasDeRetorno.getIndices(), Comparator.comparing(a ->
                    perguntasDeRetorno.getDescricaoDasCompras().get(a)));




            for (int i : perguntasDeRetorno.getIndices()) {

                DecimalFormat formatar = new DecimalFormat("###,###,###,###.00");
                System.out.println("Descrição da compra: " + perguntasDeRetorno.getDescricaoDasCompras().get(i) +
                        ", Valor da compra: R$"
                        + formatar.format(perguntasDeRetorno.getValorDasCompras().get(i)));

            }




        }






    }
}
