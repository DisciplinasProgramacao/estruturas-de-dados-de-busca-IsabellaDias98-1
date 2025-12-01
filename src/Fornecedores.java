import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private static int ultimoID = 10000;
    private final int documento;
    private final String nome;

    private final List<Produto> produtos;

    public Fornecedor(String nome) {

        if (nome == null || nome.trim().isEmpty() || nome.trim().split("\\s+").length < 2) {
            throw new IllegalArgumentException("O nome deve conter, pelo menos, duas palavras.");
        }
        this.nome = nome.trim();

        Fornecedor.ultimoID++;
        this.documento = Fornecedor.ultimoID;


        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto novo) {
        if (novo == null) {
            throw new IllegalArgumentException("Não podem ser adicionados produtos nulos.");
        }

        this.produtos.add(novo);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nome: ").append(nome).append("\n");
        string.append("Documento: ").append(documento).append("\n");

        string.append("Histórico - Total de Produtos: ").append(produtos.size()).append(") ---\n");

        if (produtos.isEmpty()) {
            string.append("Registros inexistentes.\n");
        } else {

            for (Produto produto : produtos) {
                string.append("* ").append(produto.toString()).append("\n");
            }
        }
        return string.toString();
    }

    @Override
    public int hashCode() {
        return this.documento;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fornecedor outro = (Fornecedor) obj;
        return documento == outro.documento;
    }
}
