
INSERT INTO images (id, url)VALUES (1, 'imagens/lacoste/lacoste1.jpg');

INSERT INTO images (id, url)VALUES (2, 'imagens/lacoste/lacoste2.jpg');

INSERT INTO images (id, url)VALUES (3, 'imagens/lacoste/lacoste3.jpg');

INSERT INTO images (id, url)VALUES (4, 'imagens/lacoste/lacoste4.jpg');

INSERT INTO images (id, url)VALUES (5, 'imagens/tommy1/tommy1.jpg');

INSERT INTO images (id, url)VALUES (6, 'imagens/tommy1/tommy2.jpg');

INSERT INTO images (id, url)VALUES (7, 'imagens/tommy1/tommy3.jpg');

INSERT INTO images (id, url)VALUES (8, 'imagens/tommy2/tommy2-1.webp');

INSERT INTO images (id, url)VALUES(9, 'imagens/tommy2/tommy2-4.webp');

INSERT INTO images (id, url)VALUES (10, 'imagens/tommy2/tommy2-3.webp');

INSERT INTO images (id, url)VALUES (11, 'imagens/tommy2/tommy2-5.webp');

INSERT INTO images (id, url) VALUES (12, 'imagens/tommy3/tommy3-1.webp');

INSERT INTO images (id, url)VALUES (13, 'imagens/tommy3/tommy3-2.webp');

INSERT INTO images (id, url)VALUES (14, 'imagens/tommy3/tommy3-3.webp');

INSERT INTO images (id, url)VALUES (15, 'imagens/tommy4/tommy4-1.webp');

INSERT INTO images (id, url)VALUES (16, 'imagens/tommy4/tommy4-2.webp');

INSERT INTO images (id, url) VALUES (17, 'imagens/tommy4/tommy4-3.webp');

INSERT INTO produtos (id, descricao, nome, preco, codigo_produto ) VALUES(7, 'Cor da Pulseira: Verde, Azul, Preto e Branco, Cor do Mostrador: Verde, Azul, Preto e Branco, Datador: Material da Pulseira: Borracha Material do Vidro: Cristal Mineral Tamanho da Caixa com a Pulseira: 42 mm Mecanismo: Quartzo Modelo da Caixa: Redonda Resistêcia: 05 ATM Tamanho da Caixa: 42 mm Cor da Caixa: Verde Modelo: 2011170 Garantia: 24 Sugestão: Para ele', 'Lacoste.12.12 Borracha', 490.00, '1668302698098');

INSERT INTO produtos (id, descricao, nome, preco, codigo_produto )VALUES(8, 'Datador: sim Material do Vidro: Cristal Mineral Tamanho da Caixa com a Pulseira: 44 mm Mecanismo: Quartzo Modelo da Caixa: Redonda Resistência: 05 ATM Tamanho da Caixa: 44 mm Modelo: 1710417 Garantia: 24 Sugestão: Para ele Material: Couro', 'Tommy Hilfiger Couro Preto', 890.00, '1668302735962');

INSERT INTO produtos (id, descricao, nome, preco, codigo_produto )VALUES(9, 'Cor da Pulseira: Preto  Datador: sim Material da Pulseira: Material do Vidro: Cristal Mineral Tamanho da Caixa com a Pulseira: 43 mm Mecanismo: Quartzo Modelo da Caixa: Redonda Resistencia: 03 ATM Tamanho da Caixa: 43 mm Cor da Caixa: Preto Modelo: 1791734 Garantia: 24 Sugestão: Para ele', 'Tommy Hilfiger Couro Marrom', 690.00, '1668302776692');

INSERT INTO produtos (id, descricao, nome, preco, codigo_produto )VALUES(10, 'Cor da Pulseira: Azul Cor do Mostrador: Azul Datador: Material da Pulseira: Couro Espessura da Caixa: 7,4 mm Material do Vidro: Cristal Mineral Tamanho da Caixa com a Pulseira: 43 mm Mecanismo: Quartzo Modelo da Caixa: Redonda Resistencia: 05 ATM Tamanho da Caixa: 43 mm Fecho: Fivela Cor da Caixa: Azul Modelo: 1791844 Garantia: 24 Sugestão: Para ele', 'Tommy Hilfiger Couro Azul', 550.00, '1668302800184');

INSERT INTO produtos (id, descricao, nome, preco, codigo_produto )VALUES(11,'Cor da Pulseira: Preto Datador: sim Material da Pulseira: Material do Vidro: Cristal Mineral Tamanho da Caixa com a Pulseira: 43 mm Mecanismo: Quartzo Modelo da Caixa: Redonda Resistencia: 03 ATM Tamanho da Caixa: 43 mm Cor da Caixa: Preto Modelo: 1791734 Garantia: 24 Sugestão: Para ele', 'Tommy Hilfiger Preto', 770.00, '1668302824483');

INSERT INTO produtos_imagens (produto_id, imagens_id) VALUES(7, 1);

INSERT INTO produtos_imagens (produto_id, imagens_id)VALUES(7, 2);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(7, 3);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(7, 4);
	
INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(8, 6);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(8, 7);
	
INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(9, 8);
	
INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(9, 9);
	
INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(9, 10);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(9, 11);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(10, 12);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(10, 13);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(10, 14);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(11, 15);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(11, 16);

INSERT INTO produtos_imagens(produto_id, imagens_id)VALUES(11, 17);

INSERT INTO cart(id)VALUES(1);

INSERT INTO usuario(id, regiao, id_cart)VALUES(1, 'NORTE', 1);
