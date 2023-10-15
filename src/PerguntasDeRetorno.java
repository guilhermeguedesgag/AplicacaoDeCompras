import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  PerguntasDeRetorno {
        private final static ArrayList<String> descricaoDasCompras = new ArrayList<>();
        private static ArrayList<Double> valorDasCompras = new ArrayList<>();
        private final static List<Integer> indices = new ArrayList<>();





        public static void perguntasDeRetorno() {


                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Digite a descrição da compra:");
                String descricaoDaCompra = scanner1.nextLine();
                System.out.println("Sua compra foi: " + descricaoDaCompra);
                System.out.println();


                DecimalFormat decimalFormat = new DecimalFormat("###,###,###,###.00");
                System.out.println("Digite o valor da compra:");
                double valorDaCompra = scanner1.nextDouble();


                PerguntasIniciais perguntasIniciais = new PerguntasIniciais();



                if (perguntasIniciais.getLimiteDoCartao() >= valorDaCompra && indices.size() > 0) {
                        int totalDosValoresAdicionados = 0; // Inicializa o total dos valores
                        boolean saldoSuficiente = true; // Inicializa a variável de saldo suficiente como verdadeira

                        for (int itensDesteFor : indices) {
                                double value = valorDasCompras.get(itensDesteFor);
                                totalDosValoresAdicionados += value;

                                if (perguntasIniciais.getLimiteDoCartao() < totalDosValoresAdicionados + valorDaCompra) {
                                        saldoSuficiente = false;
                                        break; // Se o limite for excedido, interrompe o loop
                                }
                        }

                        if (saldoSuficiente) {
                                descricaoDasCompras.add(descricaoDaCompra);
                                valorDasCompras.add(valorDaCompra);
                                indices.add(descricaoDasCompras.size() - 1);
                                System.out.println("Compra realizada!");
                                System.out.println("O valor desta compra foi de R$" +
                                        decimalFormat.format(valorDaCompra)+ " reais.");
                        } else {

                                System.out.println("Compra não adicionada, saldo insuficiente.");
                        }

                } else if (perguntasIniciais.getLimiteDoCartao()>= valorDaCompra ) {

                        descricaoDasCompras.add(descricaoDaCompra);
                        valorDasCompras.add(valorDaCompra);
                        indices.add(descricaoDasCompras.size() - 1);
                        // aqui ele adicionou um indice e o -1 seria o limite desse indice
                        // colocamos o -1 para o tamanho dele nunca zerar


                        System.out.println("Compra realizada!");
                        System.out.println("O valor desta compra foi de R$" +
                                decimalFormat.format(valorDaCompra)+ " reais.");
                        System.out.println();
                } else {
                        System.out.println("Compra não adicionada, saldo insuficiente.");

                        System.out.println();

                }

                PerguntaFinal perguntaFinal = new PerguntaFinal();
                perguntaFinal.perguntaFinal();// pergunta final tem que ser aqui, senão ele não irá adicionar no Array



        }

        public static ArrayList<String> getDescricaoDasCompras() {
                return descricaoDasCompras;
        }

        public static ArrayList<Double> getValorDasCompras() {
                return valorDasCompras;
        }

        public static List<Integer> getIndices() {
                return indices;
        }
}