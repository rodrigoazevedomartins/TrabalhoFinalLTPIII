-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.24-log
-- Versão do PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `serr`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursos`
--

CREATE TABLE IF NOT EXISTS `cursos` (
  `CodCurso` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(250) NOT NULL,
  `Duracao` int(11) NOT NULL,
  `Ativo` int(11) NOT NULL,
  PRIMARY KEY (`CodCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE IF NOT EXISTS `disciplinas` (
  `CodDisciplina` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodDisciplina`),
  KEY `CodCurso` (`CodCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `emails`
--

CREATE TABLE IF NOT EXISTS `emails` (
  `CodEmail` int(11) NOT NULL AUTO_INCREMENT,
  `Endereco` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEmail`),
  KEY `CodPessoa` (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `enderecos`
--

CREATE TABLE IF NOT EXISTS `enderecos` (
  `CodEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `Rua` varchar(250) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Bairro` varchar(250) NOT NULL,
  `Cidade` varchar(250) NOT NULL,
  `Estado` varchar(250) NOT NULL,
  `Complemento` varchar(250) NOT NULL,
  `CEP` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodEndereco`),
  KEY `CodPessoa` (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE IF NOT EXISTS `funcionarios` (
  `CodFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `SIAPE` varchar(20) NOT NULL,
  `Cargo` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodFuncionario`),
  KEY `CodPessoa` (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `locatarios`
--

CREATE TABLE IF NOT EXISTS `locatarios` (
  `CodLocatario` int(11) NOT NULL AUTO_INCREMENT,
  `CodProfessor` int(11) DEFAULT NULL,
  `CodFuncionario` int(11) DEFAULT NULL,
  `Ativo` int(11) NOT NULL,
  PRIMARY KEY (`CodLocatario`),
  KEY `CodProfessor` (`CodProfessor`),
  KEY `CodFuncionario` (`CodFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoas`
--

CREATE TABLE IF NOT EXISTS `pessoas` (
  `CodPessoa` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(250) NOT NULL,
  `CPF` varchar(12) NOT NULL,
  `RG` varchar(12) NOT NULL,
  `DataNasc` date NOT NULL,
  `Ativo` int(11) NOT NULL,
  PRIMARY KEY (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professores`
--

CREATE TABLE IF NOT EXISTS `professores` (
  `CodProfessor` int(11) NOT NULL AUTO_INCREMENT,
  `Titulacao` varchar(250) NOT NULL,
  `Nivel` int(11) NOT NULL,
  `Ativo` int(11) DEFAULT NULL,
  `CodPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodProfessor`),
  KEY `CodPessoa` (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_disciplinas`
--

CREATE TABLE IF NOT EXISTS `professor_disciplinas` (
  `CodProfessor` int(11) DEFAULT NULL,
  `CodDisciplina` int(11) DEFAULT NULL,
  `Ativo` int(11) NOT NULL,
  KEY `CodProfessor` (`CodProfessor`),
  KEY `CodDisciplina` (`CodDisciplina`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `recursos`
--

CREATE TABLE IF NOT EXISTS `recursos` (
  `CodRecurso` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodTipoRecurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodRecurso`),
  KEY `CodTipoRecurso` (`CodTipoRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `reservarecursos`
--

CREATE TABLE IF NOT EXISTS `reservarecursos` (
  `codrecurso` int(11) NOT NULL DEFAULT '0',
  `codreserva` int(11) NOT NULL DEFAULT '0',
  `ativo` int(11) NOT NULL,
  PRIMARY KEY (`codrecurso`,`codreserva`),
  KEY `codreserva` (`codreserva`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `reservas`
--

CREATE TABLE IF NOT EXISTS `reservas` (
  `CodReserva` int(11) NOT NULL AUTO_INCREMENT,
  `DataInicio` datetime NOT NULL,
  `DataFinal` datetime NOT NULL,
  `Situacao` int(11) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodRecurso` int(11) DEFAULT NULL,
  `CodLocatario` int(11) DEFAULT NULL,
  `CodSecao` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodReserva`),
  KEY `CodLocatario` (`CodLocatario`),
  KEY `CodRecurso` (`CodRecurso`),
  KEY `CodSecao` (`CodSecao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `secoes`
--

CREATE TABLE IF NOT EXISTS `secoes` (
  `CodSecao` int(11) NOT NULL AUTO_INCREMENT,
  `Inicio` datetime NOT NULL,
  `Final` datetime NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodSecao`),
  KEY `CodUsuario` (`CodUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `telefones`
--

CREATE TABLE IF NOT EXISTS `telefones` (
  `CodTelefone` int(11) NOT NULL AUTO_INCREMENT,
  `DDD` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`CodTelefone`),
  KEY `CodPessoa` (`CodPessoa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tiposrecurso`
--

CREATE TABLE IF NOT EXISTS `tiposrecurso` (
  `CodTipoRecurso` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  PRIMARY KEY (`CodTipoRecurso`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `Codusuario` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(250) NOT NULL,
  `Senha` varchar(250) NOT NULL,
  `Ativo` int(11) NOT NULL,
  `CodFuncionario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Codusuario`),
  KEY `CodFuncionario` (`CodFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD CONSTRAINT `disciplinas_ibfk_1` FOREIGN KEY (`CodCurso`) REFERENCES `cursos` (`CodCurso`);

--
-- Restrições para a tabela `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `emails_ibfk_1` FOREIGN KEY (`CodPessoa`) REFERENCES `pessoas` (`CodPessoa`);

--
-- Restrições para a tabela `enderecos`
--
ALTER TABLE `enderecos`
  ADD CONSTRAINT `enderecos_ibfk_1` FOREIGN KEY (`CodPessoa`) REFERENCES `pessoas` (`CodPessoa`);

--
-- Restrições para a tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD CONSTRAINT `funcionarios_ibfk_1` FOREIGN KEY (`CodPessoa`) REFERENCES `pessoas` (`CodPessoa`);

--
-- Restrições para a tabela `locatarios`
--
ALTER TABLE `locatarios`
  ADD CONSTRAINT `locatarios_ibfk_1` FOREIGN KEY (`CodProfessor`) REFERENCES `professores` (`CodProfessor`),
  ADD CONSTRAINT `locatarios_ibfk_2` FOREIGN KEY (`CodFuncionario`) REFERENCES `funcionarios` (`CodFuncionario`);

--
-- Restrições para a tabela `professores`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `professores_ibfk_1` FOREIGN KEY (`CodPessoa`) REFERENCES `pessoas` (`CodPessoa`);

--
-- Restrições para a tabela `professor_disciplinas`
--
ALTER TABLE `professor_disciplinas`
  ADD CONSTRAINT `professor_disciplinas_ibfk_1` FOREIGN KEY (`CodProfessor`) REFERENCES `professores` (`CodProfessor`),
  ADD CONSTRAINT `professor_disciplinas_ibfk_2` FOREIGN KEY (`CodDisciplina`) REFERENCES `disciplinas` (`CodDisciplina`);

--
-- Restrições para a tabela `recursos`
--
ALTER TABLE `recursos`
  ADD CONSTRAINT `recursos_ibfk_1` FOREIGN KEY (`CodTipoRecurso`) REFERENCES `tiposrecurso` (`CodTipoRecurso`);

--
-- Restrições para a tabela `reservarecursos`
--
ALTER TABLE `reservarecursos`
  ADD CONSTRAINT `reservarecursos_ibfk_1` FOREIGN KEY (`codrecurso`) REFERENCES `recursos` (`CodRecurso`),
  ADD CONSTRAINT `reservarecursos_ibfk_2` FOREIGN KEY (`codreserva`) REFERENCES `reservas` (`CodReserva`);

--
-- Restrições para a tabela `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`CodLocatario`) REFERENCES `locatarios` (`CodLocatario`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`CodRecurso`) REFERENCES `recursos` (`CodRecurso`),
  ADD CONSTRAINT `reservas_ibfk_3` FOREIGN KEY (`CodSecao`) REFERENCES `secoes` (`CodSecao`);

--
-- Restrições para a tabela `secoes`
--
ALTER TABLE `secoes`
  ADD CONSTRAINT `secoes_ibfk_1` FOREIGN KEY (`CodUsuario`) REFERENCES `usuarios` (`Codusuario`);

--
-- Restrições para a tabela `telefones`
--
ALTER TABLE `telefones`
  ADD CONSTRAINT `telefones_ibfk_1` FOREIGN KEY (`CodPessoa`) REFERENCES `pessoas` (`CodPessoa`);

--
-- Restrições para a tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`CodFuncionario`) REFERENCES `funcionarios` (`CodFuncionario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
