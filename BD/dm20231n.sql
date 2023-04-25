-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 25-Abr-2023 às 03:11
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dm20231n`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `animais_pessoas`
--

CREATE TABLE `animais_pessoas` (
  `id` bigint(20) NOT NULL,
  `idA` int(11) NOT NULL,
  `idP` bigint(20) NOT NULL,
  `obs` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `animals`
--

CREATE TABLE `animals` (
  `id` int(11) NOT NULL,
  `animal` varchar(200) NOT NULL,
  `raca` varchar(200) NOT NULL,
  `peso` varchar(200) NOT NULL,
  `doenca` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `consultas`
--

CREATE TABLE `consultas` (
  `id` int(11) NOT NULL,
  `dia_consulta` date NOT NULL,
  `hora_consulta` time NOT NULL,
  `clinica` varchar(300) NOT NULL,
  `idV` bigint(20) NOT NULL,
  `idAnimal` int(11) NOT NULL,
  `prontuario` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoas`
--

CREATE TABLE `pessoas` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios_pessoas`
--

CREATE TABLE `usuarios_pessoas` (
  `id` bigint(20) NOT NULL,
  `idU` bigint(20) NOT NULL,
  `idP` bigint(20) NOT NULL,
  `obs` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veterinarios`
--

CREATE TABLE `veterinarios` (
  `id` bigint(20) NOT NULL,
  `tempo_atuacao` varchar(250) NOT NULL,
  `especialidade` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `veterinarios_pessoas`
--

CREATE TABLE `veterinarios_pessoas` (
  `id` bigint(20) NOT NULL,
  `idV` bigint(20) NOT NULL,
  `idP` bigint(20) NOT NULL,
  `obs` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `animais_pessoas`
--
ALTER TABLE `animais_pessoas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idA` (`idA`),
  ADD KEY `idP` (`idP`);

--
-- Índices para tabela `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `consultas`
--
ALTER TABLE `consultas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `veterinarios` (`idV`),
  ADD KEY `idAnimal` (`idAnimal`);

--
-- Índices para tabela `pessoas`
--
ALTER TABLE `pessoas`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuarios_pessoas`
--
ALTER TABLE `usuarios_pessoas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_PES_USU_ID` (`idP`),
  ADD KEY `FK_USU_PES_ID` (`idU`);

--
-- Índices para tabela `veterinarios`
--
ALTER TABLE `veterinarios`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `veterinarios_pessoas`
--
ALTER TABLE `veterinarios_pessoas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idP` (`idP`),
  ADD KEY `idV` (`idV`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `animais_pessoas`
--
ALTER TABLE `animais_pessoas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `animals`
--
ALTER TABLE `animals`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `consultas`
--
ALTER TABLE `consultas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `pessoas`
--
ALTER TABLE `pessoas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `usuarios_pessoas`
--
ALTER TABLE `usuarios_pessoas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `veterinarios`
--
ALTER TABLE `veterinarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `veterinarios_pessoas`
--
ALTER TABLE `veterinarios_pessoas`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `animais_pessoas`
--
ALTER TABLE `animais_pessoas`
  ADD CONSTRAINT `animais_pessoas_ibfk_1` FOREIGN KEY (`idA`) REFERENCES `animals` (`id`),
  ADD CONSTRAINT `animais_pessoas_ibfk_2` FOREIGN KEY (`idP`) REFERENCES `pessoas` (`id`);

--
-- Limitadores para a tabela `consultas`
--
ALTER TABLE `consultas`
  ADD CONSTRAINT `consultas_ibfk_1` FOREIGN KEY (`idV`) REFERENCES `veterinarios` (`id`),
  ADD CONSTRAINT `consultas_ibfk_2` FOREIGN KEY (`idAnimal`) REFERENCES `animals` (`id`);

--
-- Limitadores para a tabela `usuarios_pessoas`
--
ALTER TABLE `usuarios_pessoas`
  ADD CONSTRAINT `FK_PES_USU_ID` FOREIGN KEY (`idP`) REFERENCES `pessoas` (`id`),
  ADD CONSTRAINT `FK_USU_PES_ID` FOREIGN KEY (`idU`) REFERENCES `usuarios` (`id`);

--
-- Limitadores para a tabela `veterinarios_pessoas`
--
ALTER TABLE `veterinarios_pessoas`
  ADD CONSTRAINT `veterinarios_pessoas_ibfk_1` FOREIGN KEY (`idP`) REFERENCES `pessoas` (`id`),
  ADD CONSTRAINT `veterinarios_pessoas_ibfk_2` FOREIGN KEY (`idV`) REFERENCES `veterinarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
