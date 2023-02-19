
CREATE TABLE `cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `images` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `regiao` varchar(255) DEFAULT NULL,
  `id_cart` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKe87jgv5dshpl7sjvouupve61q` (`id_cart`),
  CONSTRAINT `FKe87jgv5dshpl7sjvouupve61q` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_produto` varchar(255) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `produtos_imagens` (
  `produto_id` bigint NOT NULL,
  `imagens_id` bigint NOT NULL,
  UNIQUE KEY `UK_hpxqmpfa5gecv9jugbya7fa6` (`imagens_id`),
  KEY `FKr9dtbwq1nfxorowts6hlukbrb` (`produto_id`),
  CONSTRAINT `FKk9k79hx1hn11sq5trvwvgpegl` FOREIGN KEY (`imagens_id`) REFERENCES `images` (`id`),
  CONSTRAINT `FKr9dtbwq1nfxorowts6hlukbrb` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `item_cart` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantidade` int DEFAULT NULL,
  `produto_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK49hafprv3iy61rrdlssqgjkp9` (`produto_id`),
  CONSTRAINT `FK49hafprv3iy61rrdlssqgjkp9` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart_cart_itens` (
  `cart_id` bigint NOT NULL,
  `cart_itens_id` bigint NOT NULL,
  UNIQUE KEY `UK_p5bkov5scxbkqvc4mb3adphuo` (`cart_itens_id`),
  KEY `FKo6t0cph4uiw1ff1sikcegij63` (`cart_id`),
  CONSTRAINT `FKcs9nnsirh9oaqavg3ut01lgoe` FOREIGN KEY (`cart_itens_id`) REFERENCES `item_cart` (`id`),
  CONSTRAINT `FKo6t0cph4uiw1ff1sikcegij63` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `checkout` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `frete` decimal(19,2) DEFAULT NULL,
  `sub_total` decimal(19,2) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `cart_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs4p1r23jcw3r43psmma1enoe8` (`cart_id`),
  CONSTRAINT `FKs4p1r23jcw3r43psmma1enoe8` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





