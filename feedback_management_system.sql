-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 09, 2021 at 09:39 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feedback_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `Department_No` int(11) NOT NULL,
  `Department_Name` varchar(50) NOT NULL,
  `Head_Desk_Contacts` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`Department_No`, `Department_Name`, `Head_Desk_Contacts`) VALUES
(2233, 'National Manpower Development secretariat', 22328756),
(2244, 'National Curriculum Development', 22321856),
(2255, 'National Environment Secretariat', 22325641),
(2265, 'High Court', 26264650),
(2266, 'Correctional Services', 22335467),
(2276, 'Global Fund Coordinating National Development', 26745106),
(2277, 'Department of Water Affairs', 23565106),
(2287, 'District Administration Office', 29741065),
(2288, 'Directorate of Dispute Prevention', 23546010),
(2299, 'Directorate on Corruption', 28976526);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `Feedback_No` int(11) NOT NULL,
  `Feedback_Title` varchar(50) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `Date_Created` date NOT NULL,
  `Department_Responsible` varchar(50) NOT NULL,
  `Type_Of_Feedback` varchar(30) NOT NULL,
  `Person_Responsible` varchar(30) NOT NULL,
  `Description` varchar(150) NOT NULL,
  `UserID` varchar(8) NOT NULL,
  `Response` varchar(100) DEFAULT NULL,
  `Reason_For_Escalation` varchar(100) DEFAULT NULL,
  `Remarks_On_Actions_Done` varchar(50) DEFAULT NULL,
  `Date_Of_Response` datetime DEFAULT NULL,
  `Department_No` int(11) NOT NULL,
  `Ministry_No` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`Feedback_No`, `Feedback_Title`, `Status`, `Date_Created`, `Department_Responsible`, `Type_Of_Feedback`, `Person_Responsible`, `Description`, `UserID`, `Response`, `Reason_For_Escalation`, `Remarks_On_Actions_Done`, `Date_Of_Response`, `Department_No`, `Ministry_No`) VALUES
(2301, 'Complaint against Policemen', 'Under Review', '2021-11-08', 'Directorate on corruption', 'Complaint', 'Clerk', 'It is becoming a norm for them to bully citizens\nin giving them bribes for no reason. Please do something', '1234567A', 'We are currently reviewing your complaint. Please\nwait for a reply', 'none', 'Done Accordingly', '2021-11-08 12:03:12', 2299, 85451),
(2302, 'Complaint against clerk', 'Closed', '2021-11-08', 'Directorate of dispute prevention', 'Complaint', 'Departmental Supervisor', 'He does not take action against our complaing', '1234567A', 'We have reported your complaint to the \nappropriate supervisors.', 'Citizen not satisfied with Clerk customer service', 'Need to refer to supervisor', '2021-11-09 05:14:47', 2288, 85451),
(2399, 'Complaint about the trash pile at Naleli', 'Closed', '2021-11-09', 'National environment secretariat', 'Complaint', 'Departmental Supervisor', 'The trash that has accumulated at that area seems\nlike it has never left. Please do something', '8765432A', 'We currently discussing plans to remove this\nproblem. Thank you', 'Only supervisor can do actions', 'We have made an initiative towards it', '2021-11-09 21:18:01', 2255, 95917),
(2414, 'Global funds needed to improve nation', 'Closed', '2021-11-09', 'Global fund coordinating national aids', 'Suggestion', 'Departmental Supervisor', 'Funds are better spend helping the sick especially\npeople who have aids', 'ABCD1234', 'Thank you for suggesting this. We have sent\nit to the department', 'None', 'The feedback was forwarded to department', '2021-11-09 18:22:43', 2276, 65564),
(2675, 'Complaint against clerk', 'Escalated', '2021-11-08', 'Directorate of dispute prevention', 'Complaint', 'Departmental Supervisor', 'He does not take action against our complaing', '1234567A', 'Your complaint is currently being reviewed by superior. Please wait for a respond', 'Citizen not satisfied with Clerk customer service', 'Currently handling it', '2021-11-09 03:21:32', 2288, 85451);

-- --------------------------------------------------------

--
-- Table structure for table `ministries`
--

CREATE TABLE `ministries` (
  `Ministry_No` int(11) NOT NULL,
  `Ministry_Name` varchar(50) NOT NULL,
  `Head_Desk_Contacts` int(8) NOT NULL,
  `Head_Office_Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ministries`
--

INSERT INTO `ministries` (`Ministry_No`, `Ministry_Name`, `Head_Desk_Contacts`, `Head_Office_Address`) VALUES
(56410, 'Ministry of Home Affairs', 26246260, 'Maseru Mall, Room 2, Maseru'),
(56654, 'Ministry of Finance', 26211400, 'Industrial Area, Leribe'),
(64165, 'Ministry of Justice Human Rights and Correctional ', 22650204, 'Manthabiseng Convention Centre, Maseru'),
(64561, 'Ministry of Public Service', 52145414, 'Thetsane Office Park, Maseru'),
(65564, 'Ministry of Development Planning', 62614654, 'Pioneer mall, room 9, Maseru'),
(84651, 'Ministry of Water Affairs', 6551010, 'Naledi, WASA, Maseru'),
(85451, 'Ministry of Law and Justice', 95514601, 'Lesotho High Court, Maseru'),
(95917, 'Ministry of Tourism, Environment and Culture', 51263487, 'Maseru East, Stadium, Maseru');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `PassportID` varchar(8) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `Nationality` varchar(30) NOT NULL,
  `Phone_Number` int(8) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Date_Of_Birth` date NOT NULL,
  `Gender` char(1) NOT NULL,
  `Date_Created` date NOT NULL DEFAULT current_timestamp(),
  `Educational_Qualification` varchar(60) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`PassportID`, `Name`, `Surname`, `Nationality`, `Phone_Number`, `Address`, `City`, `Date_Of_Birth`, `Gender`, `Date_Created`, `Educational_Qualification`, `Type`, `Password`) VALUES
('112233AB', 'Pearl', 'Motheo', 'Mosotho', 65120901, 'Hillsview', 'Maseru', '1975-12-02', 'M', '2021-11-08', 'CertED', 'clerk', '112233AB'),
('11AA22BB', 'Ellaine', 'Fontamillas', 'Filipino', 63130128, 'Maseru West', 'Maseru', '2001-04-19', 'F', '2021-11-08', 'B.L in Criminal Law Studies', 'admin', '11AA22BB'),
('1234567A', 'Austin', 'Moon', 'American', 68976124, 'White City', 'Maseru', '1962-10-29', 'M', '2021-11-08', 'BSc in Computing', 'citizen', '1234567A'),
('123A456B', 'Sofia', 'Vergara', 'Columbian', 55428701, 'Maseru East', 'Maseru', '1970-03-13', 'F', '2021-11-08', 'MHS ', 'ministerial supervisor', '123A456B'),
('8765432A', 'Silvia', 'Mane', 'Portuguese', 13943434, 'Upper Thamae	', 'Maseru', '1987-05-06', 'F', '2021-11-09', 'BA in Psychology', 'citizen', '8765432A'),
('AB123456', 'Miriam', 'Webster', 'Sudanese', 51197116, 'Qoaling', 'Maseru', '1985-08-10', 'F', '2021-11-08', 'MA and Society ', 'departmental supervisor', 'AB123456'),
('ABCD1234', 'Nthatisi ', 'Hlalele', 'Mosotho', 58930121, 'Thetsane Ha-Tsolo', 'Maseru', '2000-02-06', 'F', '2021-11-09', 'MSc in Computing', 'citizen', 'ABCD1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`Department_No`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`Feedback_No`),
  ADD UNIQUE KEY `Feedback_No` (`Feedback_No`,`UserID`),
  ADD KEY `UserID` (`UserID`),
  ADD KEY `Department_No` (`Department_No`),
  ADD KEY `Ministry_No` (`Ministry_No`);

--
-- Indexes for table `ministries`
--
ALTER TABLE `ministries`
  ADD PRIMARY KEY (`Ministry_No`),
  ADD UNIQUE KEY `Ministry_No` (`Ministry_No`,`Head_Desk_Contacts`),
  ADD UNIQUE KEY `Ministry_No_2` (`Ministry_No`,`Head_Desk_Contacts`),
  ADD UNIQUE KEY `Ministry_No_3` (`Ministry_No`,`Head_Desk_Contacts`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`PassportID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `Department_No` FOREIGN KEY (`Department_No`) REFERENCES `department` (`Department_No`),
  ADD CONSTRAINT `Ministry_No` FOREIGN KEY (`Ministry_No`) REFERENCES `ministries` (`Ministry_No`),
  ADD CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `users` (`PassportID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
