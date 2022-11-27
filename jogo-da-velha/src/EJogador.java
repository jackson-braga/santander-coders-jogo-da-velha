public enum EJogador {
    JOGADOR_1("Jogador 1", "X"),
    JOGADOR_2("Jogador 2", "O");

    EJogador(String descricao, String marcador) {
        this.descricao = descricao;
        this.marcador = marcador;
    }

    private String descricao;
    private String marcador;

    public String getDescricao() {
        return descricao;
    }

    public String getMarcador(){
        return marcador;
    }
}
