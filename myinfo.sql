-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 23, 2018 at 06:46 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myinfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `userlogin`
--

CREATE TABLE `userlogin` (
  `username` text NOT NULL,
  `password` text NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userlogin`
--

INSERT INTO `userlogin` (`username`, `password`, `uid`) VALUES
('nowshin', '12345', 1),
('nna01', '34567', 2),
('mm1', '34567', 13),
('abc5', '23456', 14),
('pqr2', '5678', 15),
('hij2', '5432', 16),
('wsd55', '6789', 17),
('harry77', '7890', 18),
('donal44', '2345', 19),
('sdad', '23456', 20),
('bmn', '45678', 21),
('ghi', '12345', 22),
('mohua', '23456', 23),
('user3', '12345', 27),
('user4', '12345', 28),
('user5', '12345', 29);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `userlogin`
--
ALTER TABLE `userlogin`
  ADD PRIMARY KEY (`uid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `userlogin`
--
--
-- Table structure for table `accomplishment`
--
CREATE TABLE `accomplishment` (
  `uid` int(11) DEFAULT NULL,
  `acc1` text,
  `acc2` text,
  `acc3` text,
  `acc4` text,
  `acc5` text,
  `acc6` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accomplishment`
--

INSERT INTO `accomplishment` (`uid`, `acc1`, `acc2`, `acc3`, `acc4`, `acc5`, `acc6`) VALUES
(16, NULL, NULL, NULL, NULL, NULL, NULL),
(17, NULL, NULL, NULL, NULL, NULL, NULL),
(18, NULL, NULL, NULL, NULL, NULL, NULL),
(19, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Project', 'Project', 'null', 'null', 'null', 'null'),
(20, NULL, NULL, NULL, NULL, NULL, NULL),
(21, NULL, NULL, NULL, NULL, NULL, NULL),
(22, NULL, NULL, NULL, NULL, NULL, NULL),
(23, NULL, NULL, NULL, NULL, NULL, NULL),
(27, NULL, NULL, NULL, NULL, NULL, NULL),
(28, NULL, NULL, NULL, NULL, NULL, NULL),
(29, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `basicinfo`
--

CREATE TABLE `basicinfo` (
  `uid` int(11) DEFAULT NULL,
  `email` text,
  `fname` text,
  `city` text,
  `country` text,
  `phone` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `basicinfo`
--

INSERT INTO `basicinfo` (`uid`, `email`, `fname`, `city`, `country`, `phone`) VALUES
(16, 'hjk@gmail.com', 'HJK', 'Rajshahi', 'Bangladesh', '145585960'),
(17, 'wsd@gmail.com', 'WSD', 'Khulna', 'Bangladesh', '12345678'),
(18, 'harry@yahoo.com', 'Harry Potter', 'London', 'England', '12345678'),
(19, 'donal@gmail.com', 'DONAL', 'New York', 'USA', '12345678'),
(1, 'n.nawar94@gmail.com', 'Nowshin', 'Dhaka', 'Bangladesh', '12345678'),
(20, 'sfsfsf@yahoo.com', 'sdgdgdgdg', 'Rangpur', 'Bangladesh', '12345678'),
(21, 'bmn@yahoo.com', 'bmn', 'Chittagong', 'Bangladesh', '12345678'),
(22, 'ghi@gmailcom', 'GHI', 'Comilla', 'Bangladesh', '12345678'),
(23, 'mohua@yahoo.com', 'Mohua', 'Hatia', 'Bangladesh', '12345678'),
(27, 'user3@yahoo.com', 'User 3', 'Faridpur', 'Bangladesh', '12345678'),
(28, 'user4@gmail.com', 'User 4', 'Canberra', 'Australia', '12345678'),
(29, 'user5@yahoo.com', 'User 5', 'Dhaka', 'Bangladesh', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `education`
--

CREATE TABLE `education` (
  `uid` int(11) DEFAULT NULL,
  `school` text,
  `schoolInfo` text,
  `hschool` text,
  `hschoolInfo` text,
  `university` text,
  `uniInfo` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `education`
--

INSERT INTO `education` (`uid`, `school`, `schoolInfo`, `hschool`, `hschoolInfo`, `university`, `uniInfo`) VALUES
(16, 'Manarat', NULL, NULL, NULL, 'DU', 'BSC in EEE'),
(17, 'Willes Little Flower', NULL, NULL, NULL, 'DU', 'BBA in Accounting'),
(18, 'VNS', NULL, NULL, NULL, 'Ahsanullah', 'MBBS'),
(19, 'Saint Joshep', NULL, NULL, NULL, 'BUET', 'BSC in MPE'),
(1, 'Ideal', 'SSC', 'Ideal', 'HSC', 'Ahsanullah', 'BSC'),
(20, 'Ideal', NULL, NULL, NULL, 'BUET', 'BSC in EEE'),
(21, 'Ideal', NULL, NULL, NULL, 'Ahsanullah', 'BSC in EEE'),
(22, 'Ideal', NULL, NULL, NULL, 'Bangladesh Medical', 'MBBS'),
(23, 'Ideal', NULL, NULL, NULL, 'Brac', 'BBA in Marketing'),
(27, 'Ideal', NULL, NULL, NULL, 'BUET', 'BSC in ME'),
(28, 'Ideal', NULL, NULL, NULL, 'NSU', 'BBA in Finance'),
(29, 'Ideal', NULL, NULL, NULL, 'Ahsanullah', 'BSC in IPE');

-- --------------------------------------------------------

--
-- Table structure for table `interest`
--

CREATE TABLE `interest` (
  `uid` int(11) DEFAULT NULL,
  `in1` text,
  `in2` text,
  `in3` text,
  `in4` text,
  `in5` text,
  `in6` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interest`
--

INSERT INTO `interest` (`uid`, `in1`, `in2`, `in3`, `in4`, `in5`, `in6`) VALUES
(16, NULL, NULL, NULL, NULL, NULL, NULL),
(17, NULL, NULL, NULL, NULL, NULL, NULL),
(18, NULL, NULL, NULL, NULL, NULL, NULL),
(19, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Singing', 'Drawing', 'Programming', 'null', 'null', 'null'),
(20, NULL, NULL, NULL, NULL, NULL, NULL),
(21, NULL, NULL, NULL, NULL, NULL, NULL),
(22, NULL, NULL, NULL, NULL, NULL, NULL),
(23, NULL, NULL, NULL, NULL, NULL, NULL),
(27, NULL, NULL, NULL, NULL, NULL, NULL),
(28, NULL, NULL, NULL, NULL, NULL, NULL),
(29, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `skillinfo`
--

CREATE TABLE `skillinfo` (
  `uid` int(11) DEFAULT NULL,
  `skill1` text,
  `skill2` text,
  `skill3` text,
  `skill4` text,
  `skill5` text,
  `skill6` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `skillinfo`
--

INSERT INTO `skillinfo` (`uid`, `skill1`, `skill2`, `skill3`, `skill4`, `skill5`, `skill6`) VALUES
(16, NULL, NULL, NULL, NULL, NULL, NULL),
(17, NULL, NULL, NULL, NULL, NULL, NULL),
(18, NULL, NULL, NULL, NULL, NULL, NULL),
(19, NULL, NULL, NULL, NULL, NULL, NULL),
(1, 'Programming', 'Software', 'Latex', '', 'null', 'null'),
(20, NULL, NULL, NULL, NULL, NULL, NULL),
(21, NULL, NULL, NULL, NULL, NULL, NULL),
(22, NULL, NULL, NULL, NULL, NULL, NULL),
(23, NULL, NULL, NULL, NULL, NULL, NULL),
(27, NULL, NULL, NULL, NULL, NULL, NULL),
(28, NULL, NULL, NULL, NULL, NULL, NULL),
(29, NULL, NULL, NULL, NULL, NULL, NULL);

ALTER TABLE `userlogin`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
