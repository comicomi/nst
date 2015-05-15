-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2015 at 09:57 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nstbaza`
--

-- --------------------------------------------------------

--
-- Table structure for table `fajl`
--

CREATE TABLE IF NOT EXISTS `fajl` (
  `sifraFajla` int(11) NOT NULL AUTO_INCREMENT,
  `rb` int(11) NOT NULL,
  `sifraZavrsnogRada` int(20) NOT NULL DEFAULT '0',
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `putanja` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `velicina` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `sifraTipaFajla` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifraFajla`),
  KEY `sifraTipaFajla` (`sifraTipaFajla`),
  KEY `sifraZavrsnogRada` (`sifraZavrsnogRada`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Dumping data for table `fajl`
--

INSERT INTO `fajl` (`sifraFajla`, `rb`, `sifraZavrsnogRada`, `naziv`, `putanja`, `velicina`, `sifraTipaFajla`) VALUES
(1, 2, 1, 'crv.jpg', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/1', '99288', 3),
(2, 2, 1, 'P7120306.jpg', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/1', '693039', 2),
(3, 1, 2, 'pani.jpg', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/2', '14398', 1),
(4, 3, 2, 'sss.jpg', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/2', '89409', 3),
(5, 2, 2, 'life.jpg', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/2', '57280', 2),
(6, 1, 3, 'MASTER RAD Veljko Bogosavljevic.pdf', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/3', '2663208', 2),
(7, 2, 4, 'prezentacija.ppt', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/4', '54572', 1),
(8, 1, 4, 'sanja.pdf', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/4', '2637057', 2),
(9, 1, 5, 'MASTER RAD Veljko Bogosavljevic.pdf', 'C:\\Users\\MilicaJelica\\GlassFish_Server\\glassfish\\domains\\domain1/docroot/Zavrsni radovi/5', '2663208', 2);

-- --------------------------------------------------------

--
-- Table structure for table `grad`
--

CREATE TABLE IF NOT EXISTS `grad` (
  `ptt` int(20) NOT NULL DEFAULT '0',
  `naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `grad`
--

INSERT INTO `grad` (`ptt`, `naziv`) VALUES
(11000, 'Beograd'),
(21000, 'Novi Sad');

-- --------------------------------------------------------

--
-- Table structure for table `kandidat`
--

CREATE TABLE IF NOT EXISTS `kandidat` (
  `brojIndexa` varchar(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `ime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pol` tinyint(1) NOT NULL,
  `brojTelefona` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `mejl` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `adresa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ptt` int(20) NOT NULL,
  PRIMARY KEY (`brojIndexa`),
  KEY `ptt` (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `kandidat`
--

INSERT INTO `kandidat` (`brojIndexa`, `ime`, `prezime`, `pol`, `brojTelefona`, `mejl`, `adresa`, `ptt`) VALUES
('1201/11I', 'Sara', 'Darić', 0, '12131132', 'daric.sara@yahoo.com', 'Senjačla 15', 21000),
('1221/12I', 'Petar', 'Jović', 0, '1232132', 'jova@hotmail.com', 'Beogradska 12', 11000),
('1222/12I', 'Goica', 'Prokin', 1, '123123321', 'goga@gmail.com', 'Jovana Carića 12', 21000),
('1998/12I', 'Sava', 'Jokić', 0, '123213212', 'saki@gmail.com', 'Novogradska 12', 11000),
('2010/12I', 'Goran', 'Cokic', 0, '+132343432523543', 'gogi@yahoo.com', 'Srecnicka', 21000),
('2010/13I', 'Dragana', 'Stavric', 1, '+122332434243', 'gaga@gmail.com', 'Srednicka', 21000),
('2333de', 'Stefan', 'Milosavljević', 0, '23313221', 'mili@hotmail.com', 'Serdara Janka 134', 21000),
('hihohi21', 'Marko', 'Maric', 0, '12323123', 'marem@yahoo.com', 'Francuska 2', 11000);

-- --------------------------------------------------------

--
-- Table structure for table `komisija`
--

CREATE TABLE IF NOT EXISTS `komisija` (
  `sifraZavrsnogRada` int(20) NOT NULL DEFAULT '0',
  `sifraZaposlenog` int(20) NOT NULL DEFAULT '0',
  `sifraUloge` int(11) NOT NULL,
  PRIMARY KEY (`sifraZavrsnogRada`,`sifraZaposlenog`),
  KEY `sifraUloge` (`sifraUloge`),
  KEY `sifraZaposlenog` (`sifraZaposlenog`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `komisija`
--

INSERT INTO `komisija` (`sifraZavrsnogRada`, `sifraZaposlenog`, `sifraUloge`) VALUES
(1, 3, 1),
(2, 3, 1),
(1, 2, 2),
(1, 4, 2),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `sifarnik`
--

CREATE TABLE IF NOT EXISTS `sifarnik` (
  `sifraZavrsnogRada` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `sifarnik`
--

INSERT INTO `sifarnik` (`sifraZavrsnogRada`) VALUES
(6);

-- --------------------------------------------------------

--
-- Table structure for table `tipfajla`
--

CREATE TABLE IF NOT EXISTS `tipfajla` (
  `sifraTipaFajla` int(11) NOT NULL DEFAULT '0',
  `naziv` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `extenzija` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`sifraTipaFajla`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tipfajla`
--

INSERT INTO `tipfajla` (`sifraTipaFajla`, `naziv`, `extenzija`) VALUES
(1, 'prezentacija', 'ppt'),
(2, 'rad', 'pdf'),
(3, 'source kod', 'zip');

-- --------------------------------------------------------

--
-- Table structure for table `tipzavrsnograda`
--

CREATE TABLE IF NOT EXISTS `tipzavrsnograda` (
  `sifraTipaZavrsnogRada` int(11) NOT NULL DEFAULT '0',
  `naziv` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sifraTipaZavrsnogRada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `tipzavrsnograda`
--

INSERT INTO `tipzavrsnograda` (`sifraTipaZavrsnogRada`, `naziv`) VALUES
(1, 'diplomski rad'),
(2, 'master rad'),
(3, 'doktorski rad');

-- --------------------------------------------------------

--
-- Table structure for table `titula`
--

CREATE TABLE IF NOT EXISTS `titula` (
  `sifraTitule` int(11) NOT NULL DEFAULT '0',
  `naziv` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sifraTitule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `titula`
--

INSERT INTO `titula` (`sifraTitule`, `naziv`) VALUES
(1, 'master '),
(2, 'doktor'),
(3, 'diplomac');

-- --------------------------------------------------------

--
-- Table structure for table `ulogaclanakomisije`
--

CREATE TABLE IF NOT EXISTS `ulogaclanakomisije` (
  `sifraUloge` int(11) NOT NULL DEFAULT '0',
  `naziv` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sifraUloge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ulogaclanakomisije`
--

INSERT INTO `ulogaclanakomisije` (`sifraUloge`, `naziv`) VALUES
(1, 'mentor'),
(2, 'clan komisije');

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE IF NOT EXISTS `zaposleni` (
  `sifraZaposlenog` int(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `prezime` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adresa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ptt` int(20) NOT NULL,
  `korisnickoIme` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `korisnickaSifra` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifraTitule` int(11) NOT NULL,
  `sifraZvanja` int(11) NOT NULL,
  PRIMARY KEY (`sifraZaposlenog`),
  KEY `ptt` (`ptt`,`sifraTitule`,`sifraZvanja`),
  KEY `sifraTitule` (`sifraTitule`),
  KEY `sifraZvanja` (`sifraZvanja`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=8 ;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`sifraZaposlenog`, `ime`, `prezime`, `adresa`, `ptt`, `korisnickoIme`, `korisnickaSifra`, `sifraTitule`, `sifraZvanja`) VALUES
(1, 'Petar', 'Jovanic', 'Marka Subotica', 11000, 'pera', 'pera', 1, 2),
(2, 'Jovana', 'Arsenic', 'Cara Jovana', 21000, 'joca', 'joca', 2, 3),
(3, 'Srdjan', 'Stanic', 'Delijska', 11000, 'srki', 'srki', 3, 4),
(4, 'Dejan', 'Stanic', 'Arsenicka', 11000, 'deki', 'deki', 3, 1),
(5, 'Fedor', 'Cakić', 'Sretenička 12', 11000, 'feki', 'feki', 1, 1),
(6, 'Novak', 'Savić', 'Novosadska 2', 11000, 'nole', 'nole', 1, 1),
(7, 'Jovan', 'Jović', 'Jovićka 2', 11000, 'joca', 'joca', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `zavrsnirad`
--

CREATE TABLE IF NOT EXISTS `zavrsnirad` (
  `sifraZavrsnogRada` int(20) NOT NULL,
  `tema` varchar(80) COLLATE utf8_unicode_ci DEFAULT NULL,
  `datumPrijave` date NOT NULL,
  `datumOdbrane` date NOT NULL,
  `brojIndexa` varchar(12) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sifraTipaZavrsnogRada` int(11) DEFAULT NULL,
  PRIMARY KEY (`sifraZavrsnogRada`),
  KEY `brojIndexa` (`brojIndexa`,`sifraTipaZavrsnogRada`),
  KEY `sifraTipaZavrsnogRada` (`sifraTipaZavrsnogRada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zavrsnirad`
--

INSERT INTO `zavrsnirad` (`sifraZavrsnogRada`, `tema`, `datumPrijave`, `datumOdbrane`, `brojIndexa`, `sifraTipaZavrsnogRada`) VALUES
(1, 'Unapređenje prodaje primenom procedura sistema menadžmenta kvalitetom', '2015-02-08', '2015-02-23', '1201/11I', 1),
(2, 'Etički menadžment', '2015-02-18', '2015-02-26', '1201/11I', 1),
(3, 'Razvoj web aplikacije u Java okruženju na primeru advokatske kancelarije', '2015-03-10', '2015-03-24', '1998/12I', 1),
(4, 'Menadžment tehnologija i razvoja', '2015-03-08', '2015-03-23', '2010/12I', 1),
(5, 'Osnove organizacije - studijski primer "Mercator"', '2015-03-09', '2015-03-24', '2010/13I', 1);

-- --------------------------------------------------------

--
-- Table structure for table `zvanje`
--

CREATE TABLE IF NOT EXISTS `zvanje` (
  `sifraZvanja` int(11) NOT NULL DEFAULT '0',
  `naziv` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sifraZvanja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `zvanje`
--

INSERT INTO `zvanje` (`sifraZvanja`, `naziv`) VALUES
(1, 'vanredni profesor'),
(2, 'redovni profesor'),
(3, 'saradnik u nastavi'),
(4, 'docent');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fajl`
--
ALTER TABLE `fajl`
  ADD CONSTRAINT `fajl_ibfk_2` FOREIGN KEY (`sifraTipaFajla`) REFERENCES `tipfajla` (`sifraTipaFajla`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fajl_ibfk_3` FOREIGN KEY (`sifraZavrsnogRada`) REFERENCES `zavrsnirad` (`sifraZavrsnogRada`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kandidat`
--
ALTER TABLE `kandidat`
  ADD CONSTRAINT `kandidat_ibfk_1` FOREIGN KEY (`ptt`) REFERENCES `grad` (`ptt`) ON UPDATE CASCADE;

--
-- Constraints for table `komisija`
--
ALTER TABLE `komisija`
  ADD CONSTRAINT `komisija_ibfk_3` FOREIGN KEY (`sifraUloge`) REFERENCES `ulogaclanakomisije` (`sifraUloge`) ON UPDATE CASCADE,
  ADD CONSTRAINT `komisija_ibfk_5` FOREIGN KEY (`sifraZaposlenog`) REFERENCES `zaposleni` (`sifraZaposlenog`) ON UPDATE CASCADE,
  ADD CONSTRAINT `komisija_ibfk_6` FOREIGN KEY (`sifraZavrsnogRada`) REFERENCES `zavrsnirad` (`sifraZavrsnogRada`) ON UPDATE CASCADE;

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `zaposleni_ibfk_2` FOREIGN KEY (`sifraTitule`) REFERENCES `titula` (`sifraTitule`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zaposleni_ibfk_3` FOREIGN KEY (`sifraZvanja`) REFERENCES `zvanje` (`sifraZvanja`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zaposleni_ibfk_4` FOREIGN KEY (`ptt`) REFERENCES `grad` (`ptt`) ON UPDATE CASCADE;

--
-- Constraints for table `zavrsnirad`
--
ALTER TABLE `zavrsnirad`
  ADD CONSTRAINT `zavrsnirad_ibfk_1` FOREIGN KEY (`brojIndexa`) REFERENCES `kandidat` (`brojIndexa`) ON UPDATE CASCADE,
  ADD CONSTRAINT `zavrsnirad_ibfk_2` FOREIGN KEY (`sifraTipaZavrsnogRada`) REFERENCES `tipzavrsnograda` (`sifraTipaZavrsnogRada`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
