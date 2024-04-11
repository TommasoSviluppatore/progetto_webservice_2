-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Apr 11, 2024 alle 15:56
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `websrvjavaxml`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda_generica`
--

CREATE TABLE `azienda_generica` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `valore` float DEFAULT NULL,
  `proprietario` varchar(20) CHARACTER SET latin1 COLLATE latin1_bin DEFAULT NULL,
  `settore` enum('primario','secondario','terziario','altro') DEFAULT NULL,
  `tipo_azienda` varchar(20) DEFAULT NULL,
  `id_proprietario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `azienda_generica`
--

INSERT INTO `azienda_generica` (`id`, `nome`, `valore`, `proprietario`, `settore`, `tipo_azienda`, `id_proprietario`) VALUES
(3, 'riparazioniacaso', 32.25, 'tommaso', 'terziario', 'socio_unico', 1);

-- --------------------------------------------------------

--
-- Struttura della tabella `persona_generica`
--

CREATE TABLE `persona_generica` (
  `id` int(11) NOT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `codice_fiscale` varchar(16) DEFAULT NULL,
  `partita_iva` bigint(20) DEFAULT NULL CHECK (octet_length(cast(`partita_iva` as char(16) charset cp850)) = 16),
  `telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dump dei dati per la tabella `persona_generica`
--

INSERT INTO `persona_generica` (`id`, `nome`, `codice_fiscale`, `partita_iva`, `telefono`) VALUES
(1, 'tommaso', '1010101010101010', 9223372036854775807, 10395960);

-- --------------------------------------------------------

--
-- Struttura della tabella `stockdata`
--

CREATE TABLE `stockdata` (
  `id` int(11) NOT NULL,
  `information` varchar(200) DEFAULT NULL,
  `symbol` varchar(5) DEFAULT NULL,
  `last_refreshed` datetime DEFAULT NULL,
  `interval_value` int(11) DEFAULT NULL,
  `output_size` varchar(8) DEFAULT NULL,
  `time_zone` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `timeseries`
--

CREATE TABLE `timeseries` (
  `id` int(11) NOT NULL,
  `stock_data_id` int(11) DEFAULT NULL,
  `time_stamp` datetime DEFAULT NULL,
  `open_price` decimal(10,4) DEFAULT NULL,
  `high_price` decimal(10,4) DEFAULT NULL,
  `low_price` decimal(10,4) DEFAULT NULL,
  `close_price` decimal(10,4) DEFAULT NULL,
  `volume` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `azienda_generica`
--
ALTER TABLE `azienda_generica`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_persona` (`id_proprietario`);

--
-- Indici per le tabelle `persona_generica`
--
ALTER TABLE `persona_generica`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `limiteUnicoPIVA` (`codice_fiscale`),
  ADD UNIQUE KEY `limiteUnicoCD` (`partita_iva`);

--
-- Indici per le tabelle `stockdata`
--
ALTER TABLE `stockdata`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `timeseries`
--
ALTER TABLE `timeseries`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stock_data_id` (`stock_data_id`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `azienda_generica`
--
ALTER TABLE `azienda_generica`
  ADD CONSTRAINT `fk_id_persona` FOREIGN KEY (`id_proprietario`) REFERENCES `persona_generica` (`id`);

--
-- Limiti per la tabella `timeseries`
--
ALTER TABLE `timeseries`
  ADD CONSTRAINT `timeseries_ibfk_1` FOREIGN KEY (`stock_data_id`) REFERENCES `stockdata` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
