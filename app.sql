-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-08-19 16:02:07
-- 服务器版本： 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `app`
--

-- --------------------------------------------------------

--
-- 表的结构 `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `time` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `lucky_money` int(11) DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=79 ;

--
-- 转存表中的数据 `agenda`
--

INSERT INTO `agenda` (`id`, `content`, `user_id`, `time`, `lucky_money`, `status`) VALUES
(66, '周杰伦发布：80元', 11, '2017-08-19 20:34:31', 80, -10086),
(67, '周杰伦发布：70元', 11, '2017-08-19 20:37:35', 70, -10086),
(69, '周杰伦发布：50元', 11, '2017-08-19 20:39:04', 50, -10086),
(75, '周杰伦发布：70元', 11, '2017-08-19 21:53:10', 70, -10086),
(76, '帮我拿杯咖啡过来', 11, '2017-08-19 21:53:27', 0, 0),
(77, '周杰伦发布：帮我拿杯咖啡过来', 11, '2017-08-19 21:53:39', 100000, 0),
(78, '周杰伦发布：请帮我拿杯咖啡', 11, '2017-08-19 21:54:13', 20, 0);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(255) DEFAULT NULL,
  `TRUENAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=16 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `USERNAME`, `TRUENAME`, `PASSWORD`, `status`) VALUES
(11, 'liujunting', '周杰伦', '123456', 0),
(12, 'liyang', '周润发', '123456', 0),
(13, 'zhangshuyuan', '刘德华', '123456', 0),
(14, 'wangpeiqiang', '潘玮珀', '123456', 0),
(15, 'chenjing', '范冰冰', '123456', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
