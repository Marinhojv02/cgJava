package org.example.transformacoes;

public enum TransformaEnum {
    TRANSLACAO(1),
    ROTACAO(2),
    ESCALA(3),
    CISALHAMENTO(4),
    REFLEXAO(5);

    private final int ID;
    TransformaEnum(int ID){
        this.ID = ID;
    }

    public static TransformaEnum getTransformacaoById(int id) {
        for (TransformaEnum transformacao : TransformaEnum.values()) {
            if (transformacao.getID() == id) {
                return transformacao;
            }
        }
        return null;
    }
    public int getID() {
        return ID;
    }
}
