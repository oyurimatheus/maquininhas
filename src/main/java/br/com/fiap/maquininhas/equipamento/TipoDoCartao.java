package br.com.fiap.maquininhas.equipamento;

public enum  TipoDoCartao {
    CREDITO {
        @Override
        public Integer getPrazoDeRecebimentoEmDias() {
            return Integer.valueOf("30");
        }
    },
    DEBITO {
        @Override
        public Integer getPrazoDeRecebimentoEmDias() {
            return Integer.valueOf("1");
        }
    };

    public abstract Integer getPrazoDeRecebimentoEmDias();
}
