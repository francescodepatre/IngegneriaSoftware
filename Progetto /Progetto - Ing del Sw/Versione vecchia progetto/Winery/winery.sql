-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 16, 2022 alle 19:06
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `winery`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `IDAdmin` int(6) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Code` varchar(16) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `customer`
--

CREATE TABLE `customer` (
  `IDCustomer` int(6) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Code` varchar(16) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `purchase`
--

CREATE TABLE `purchase` (
  `IDOrder` int(6) NOT NULL,
  `ID_wine` int(6) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Total_price` float NOT NULL,
  `ID_customer` int(6) NOT NULL,
  `ID_seller` int(6) NOT NULL,
  `ID_admin` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `seller`
--

CREATE TABLE `seller` (
  `IDSeller` int(6) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Code` varchar(16) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Address` varchar(40) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `wine`
--

CREATE TABLE `wine` (
  `IDWine` int(6) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Year` int(11) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`IDAdmin`);

--
-- Indici per le tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`IDCustomer`);

--
-- Indici per le tabelle `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`IDOrder`),
  ADD KEY `Customer_foreignkey` (`ID_customer`),
  ADD KEY `Seller_foreignkey` (`ID_seller`),
  ADD KEY `Wine_foreignkey` (`ID_wine`),
  ADD KEY `Admin_foreignkey` (`ID_admin`);

--
-- Indici per le tabelle `seller`
--
ALTER TABLE `seller`
  ADD PRIMARY KEY (`IDSeller`);

--
-- Indici per le tabelle `wine`
--
ALTER TABLE `wine`
  ADD PRIMARY KEY (`IDWine`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `purchase`
--
ALTER TABLE `purchase`
  ADD CONSTRAINT `Admin_foreignkey` FOREIGN KEY (`ID_admin`) REFERENCES `admin` (`IDAdmin`),
  ADD CONSTRAINT `Customer_foreignkey` FOREIGN KEY (`ID_customer`) REFERENCES `customer` (`IDCustomer`),
  ADD CONSTRAINT `Seller_foreignkey` FOREIGN KEY (`ID_seller`) REFERENCES `seller` (`IDSeller`),
  ADD CONSTRAINT `Wine_foreignkey` FOREIGN KEY (`ID_wine`) REFERENCES `wine` (`IDWine`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
