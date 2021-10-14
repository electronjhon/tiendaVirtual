-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-10-2021 a las 18:46:46
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendavirtual`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(100) NOT NULL,
  `nombreCliente` varchar(255) NOT NULL,
  `correoCliente` varchar(255) NOT NULL,
  `direccionCliente` varchar(255) NOT NULL,
  `telefonoCliente` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nombreCliente`, `correoCliente`, `direccionCliente`, `telefonoCliente`) VALUES
(77, 'Jhon', 'jhon@correo.com', 'Av. 7', '454545454'),
(111, 'Juan Diaz', 'juan@correo.com', 'Calle 11', '2335544'),
(222, 'Angel', 'pilar@tienda.com.co', 'Calle 2', '789555'),
(333, 'Pilar', 'pilar@correo.com', 'calle 35', '1122'),
(444, 'Carlos', 'carlos@correo.com', 'calle222', '888'),
(555, 'Jose', 'jose@correo.com', 'Av. 1', '454545454'),
(888, 'Felipe', 'felipe@correo.com', 'Calle 88', '644961');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `cod_detalle` int(20) NOT NULL,
  `codigo` int(20) NOT NULL,
  `cod_venta` int(20) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `valorTotal` double NOT NULL,
  `valorVenta` double NOT NULL,
  `valorIva` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `detalleventa`
--

INSERT INTO `detalleventa` (`cod_detalle`, `codigo`, `cod_venta`, `cantidadProducto`, `valorTotal`, `valorVenta`, `valorIva`) VALUES
(1, 12, 4, 7, 123367, 103670, 19697),
(2, 6, 4, 1, 30184, 25365, 4819),
(3, 18, 4, 3, 127242, 106926, 20316),
(4, 5, 5, 3, 54118, 45477, 8641),
(5, 7, 5, 1, 27258, 22906, 4352),
(6, 10, 5, 7, 209658, 176183, 33475),
(7, 10, 6, 3, 89853, 75507, 14346),
(8, 12, 6, 6, 105743, 88860, 16883),
(9, 4, 6, 1, 42183, 35448, 6735),
(10, 7, 7, 1, 27258, 22906, 4352);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `NitProveedor` int(100) NOT NULL,
  `precio_compra` double NOT NULL,
  `iva_compra` double NOT NULL,
  `precio_venta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `NitProveedor`, `precio_compra`, `iva_compra`, `precio_venta`) VALUES
(1, ' Melocotones ', 1, 25505, 19, 30351),
(2, ' Manzanas  ', 3, 18108, 19, 21549),
(3, ' Plátanos  ', 4, 29681, 19, 35320),
(4, ' Lechuga  ', 3, 29788, 19, 35448),
(5, ' Tomates  ', 1, 12739, 19, 15159),
(6, ' Calabaza  ', 1, 21315, 19, 25365),
(7, ' Apio  ', 2, 19249, 19, 22906),
(8, ' Pepino  ', 2, 10958, 19, 13040),
(9, ' Champiñones  ', 2, 11046, 19, 13145),
(10, ' Leche  ', 5, 21150, 19, 25169),
(11, ' Queso  ', 5, 26571, 19, 31619),
(12, ' Huevos  ', 2, 12445, 19, 14810),
(13, ' Requesón  ', 1, 14329, 19, 17052),
(14, ' Crema agria  ', 1, 14856, 19, 17679),
(15, ' Yogur  ', 5, 14941, 19, 17780),
(16, ' Ternera  ', 5, 29335, 19, 34909),
(17, ' Salmón salvaje  ', 5, 11878, 19, 14135),
(18, ' Patas de cangrejo  ', 1, 29951, 19, 35642);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `nombreProveedor` varchar(100) NOT NULL,
  `direccionProveedor` varchar(100) NOT NULL,
  `telefonoProveedor` varchar(100) NOT NULL,
  `ciudadProveedor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombreProveedor`, `direccionProveedor`, `telefonoProveedor`, `ciudadProveedor`) VALUES
(158, 'Casas & CIA', 'Carrera 5', '33333', 'facatativá'),
(333, 'Hugo& LTDA', 'calle7', '9999', 'Cali-Colombia'),
(569, 'Marcos & CIA', 'calle4', '123', 'Bogota');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(100) NOT NULL,
  `nombreCompleto` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `nombreUsuario` varchar(100) NOT NULL,
  `clave` varchar(255) NOT NULL,
  `tipoUsuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreCompleto`, `correo`, `nombreUsuario`, `clave`, `tipoUsuario`) VALUES
(1, 'Administrador inicial', 'admininicial@tienda.com', 'admininicial', 'admin123456', 'Administrador'),
(3, ' kkk bbb ', 'jhghhv@gsdbs.com', 'kkk', '123', 'Vendedor'),
(5, ' Maria ', 'maria@correo', 'maria', '123', 'Vendedor'),
(7, ' Angel', 'angel@gmail.com', 'angel', '123', 'Administrador'),
(8, ' Ana ', 'ana@correo.com', 'ana', '123', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `cod_venta` int(20) NOT NULL,
  `idCliente` int(100) NOT NULL,
  `idUsuario` int(100) NOT NULL,
  `ivaVenta` double NOT NULL,
  `totalVenta` double NOT NULL,
  `valorVenta` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`cod_venta`, `idCliente`, `idUsuario`, `ivaVenta`, `totalVenta`, `valorVenta`) VALUES
(1, 333, 7, 64968, 406904, 341936),
(2, 77, 7, 46814, 293200, 246386),
(3, 222, 7, 20703, 129663, 108960),
(4, 333, 7, 44832, 280793, 235961),
(5, 888, 1, 46468, 291034, 244566),
(6, 888, 1, 37964, 237779, 199815),
(7, 555, 1, 4352, 27258, 22906);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`cod_detalle`),
  ADD KEY `FK_VENTA_DETALLE` (`cod_venta`),
  ADD KEY `FK_PRODUCTO_DETALLE` (`codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`cod_venta`),
  ADD KEY `FK_CLIENTE_VENTA` (`idCliente`),
  ADD KEY `FK_USUARIO_VENTA` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `cod_detalle` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `FK_PRODUCTO_DETALLE` FOREIGN KEY (`codigo`) REFERENCES `productos` (`codigo`),
  ADD CONSTRAINT `FK_VENTA_DETALLE` FOREIGN KEY (`cod_venta`) REFERENCES `venta` (`cod_venta`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_CLIENTE_VENTA` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  ADD CONSTRAINT `FK_USUARIO_VENTA` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
