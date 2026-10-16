
CREATE TABLE dados_coletados (
    dado_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sonda_nome VARCHAR(100) NOT NULL,
    agencia_espacial VARCHAR(100) NOT NULL,
    data_coleta DATE NOT NULL,
    tipo_dado VARCHAR(30) NOT NULL,
    valor_medido DECIMAL(15,4) NOT NULL,
    unidade_medida VARCHAR(100) NOT NULL
);
