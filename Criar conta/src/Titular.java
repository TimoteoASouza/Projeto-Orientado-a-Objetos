public class Titular {
    private String nome;
    private String cpf;
    private String telefone;

    public Titular(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

        public Titular(String nome2, String cpf2) {
            this.nome = nome2;
            this.cpf = cpf2;
            this.telefone = "";
        }
    

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Titular{" +"nome='" + nome + '\'' +", cpf='" + cpf + '\'' +", telefone='" + telefone + '\'' +'}';
    }

}
