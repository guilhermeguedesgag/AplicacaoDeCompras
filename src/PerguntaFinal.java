import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PerguntaFinal {
    private static int respostaPerguntaFinal;

    public static void perguntaFinal() {
        Scanner scanner2 = new Scanner(System.in);

        while (true) { // loopDevalidação
            System.out.println("Digite 0 para sair ou 1 para continuar:");
            String input = scanner2.nextLine();

            try {
                respostaPerguntaFinal = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                respostaPerguntaFinal = -1;
            }

            if (respostaPerguntaFinal == 0 || respostaPerguntaFinal == 1) {
                break; // Sai do loop se a entrada for válida
            }

            System.out.println("Ops... você inseriu uma opção inválida, digite 1 para continuar ou 0 para sair.");
        }

        if (respostaPerguntaFinal == 1) {
            PerguntasDeRetorno perguntasDeRetorno = new PerguntasDeRetorno();
            perguntasDeRetorno.perguntasDeRetorno();
        } else if (respostaPerguntaFinal == 0) {
            PerguntasDeRetorno perguntasDeRetorno = new PerguntasDeRetorno();
            Collections.sort(perguntasDeRetorno.getIndices(), Comparator.comparing(a ->
                    perguntasDeRetorno.getDescricaoDasCompras().get(a)));

            DecimalFormat formatar = new DecimalFormat("###,###,###,###.00");
            for (int i : perguntasDeRetorno.getIndices()) {
                System.out.println("Descrição da compra: " + perguntasDeRetorno.getDescricaoDasCompras().get(i) +
                        ", Valor da compra: R$" + formatar.format(perguntasDeRetorno.getValorDasCompras().get(i)));
            }
        }
    }
}
