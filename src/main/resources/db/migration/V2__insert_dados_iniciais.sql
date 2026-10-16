
INSERT INTO dados_coletados
    (sonda_nome, agencia_espacial, data_coleta,
     tipo_dado, valor_medido, unidade_medida)
VALUES
    ('Voyager 1', 'NASA', '2026-01-10',
     'TEMPERATURA', -120.5000, 'graus Celsius'),
    ('Mars Express', 'ESA', '2026-02-15',
     'PRESSAO', 0.0065, 'bar'),
    ('Parker Solar Probe', 'NASA', '2026-03-20',
     'VELOCIDADE_VENTO', 450.2500, 'km/s');
