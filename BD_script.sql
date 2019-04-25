USE [master]
GO
/****** Object:  Database [Encuesta]    Script Date: 04/24/2019 22:12:04 ******/
CREATE DATABASE [Encuesta] ON  PRIMARY 
( NAME = N'Encuesta', FILENAME = N'E:\motoresBD\MicrosoftSQLServer\Instance\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Encuesta.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Encuesta_log', FILENAME = N'E:\motoresBD\MicrosoftSQLServer\Instance\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Encuesta_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Encuesta] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Encuesta].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Encuesta] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [Encuesta] SET ANSI_NULLS OFF
GO
ALTER DATABASE [Encuesta] SET ANSI_PADDING OFF
GO
ALTER DATABASE [Encuesta] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [Encuesta] SET ARITHABORT OFF
GO
ALTER DATABASE [Encuesta] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [Encuesta] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [Encuesta] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [Encuesta] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [Encuesta] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [Encuesta] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [Encuesta] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [Encuesta] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [Encuesta] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [Encuesta] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [Encuesta] SET  DISABLE_BROKER
GO
ALTER DATABASE [Encuesta] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [Encuesta] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [Encuesta] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [Encuesta] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [Encuesta] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [Encuesta] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [Encuesta] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [Encuesta] SET  READ_WRITE
GO
ALTER DATABASE [Encuesta] SET RECOVERY FULL
GO
ALTER DATABASE [Encuesta] SET  MULTI_USER
GO
ALTER DATABASE [Encuesta] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [Encuesta] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'Encuesta', N'ON'
GO
USE [Encuesta]
GO
/****** Object:  Table [dbo].[MarcaPCs]    Script Date: 04/24/2019 22:12:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MarcaPCs](
	[CodigoMarcaPC] [varchar](5) NOT NULL,
	[DescripcionMarcaPC] [varchar](20) NOT NULL,
 CONSTRAINT [PK_MarcaPCs] PRIMARY KEY CLUSTERED 
(
	[CodigoMarcaPC] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[MarcaPCs] ([CodigoMarcaPC], [DescripcionMarcaPC]) VALUES (N'APPLE', N'Machintosh')
INSERT [dbo].[MarcaPCs] ([CodigoMarcaPC], [DescripcionMarcaPC]) VALUES (N'DELL', N'Dell Computer')
INSERT [dbo].[MarcaPCs] ([CodigoMarcaPC], [DescripcionMarcaPC]) VALUES (N'HP', N'Hewlet Packard')
INSERT [dbo].[MarcaPCs] ([CodigoMarcaPC], [DescripcionMarcaPC]) VALUES (N'IBM', N'IBM Desktop')
/****** Object:  Table [dbo].[Usuarios]    Script Date: 04/24/2019 22:12:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Usuarios](
	[CodigoUsuario] [varchar](20) NOT NULL,
	[NombreUsuario] [varchar](50) NOT NULL,
	[ClaveUsuario] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Usuarios] PRIMARY KEY CLUSTERED 
(
	[CodigoUsuario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Usuarios] ([CodigoUsuario], [NombreUsuario], [ClaveUsuario]) VALUES (N'admin', N'administrador', N'12345')
INSERT [dbo].[Usuarios] ([CodigoUsuario], [NombreUsuario], [ClaveUsuario]) VALUES (N'user', N'usuario', N'54321')
/****** Object:  Table [dbo].[Sesiones]    Script Date: 04/24/2019 22:12:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sesiones](
	[Sesion] [varchar](50) NOT NULL,
	[CodigoUsuario] [varchar](20) NOT NULL,
	[EstadoSesion] [varchar](1) NULL,
 CONSTRAINT [PK_Sesiones] PRIMARY KEY CLUSTERED 
(
	[Sesion] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Sesiones] ([Sesion], [CodigoUsuario], [EstadoSesion]) VALUES (N'admin1556157803781', N'admin', N'A')
/****** Object:  Table [dbo].[Encuestas]    Script Date: 04/24/2019 22:12:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Encuestas](
	[NumeroDocumento] [numeric](20, 0) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Comentarios] [varchar](200) NOT NULL,
	[MarcaPC] [varchar](5) NOT NULL,
	[FechaRespuesta] [varchar](10) NOT NULL,
	[HoraRespuesta] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Encuestas] PRIMARY KEY CLUSTERED 
(
	[NumeroDocumento] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Encuestas] ([NumeroDocumento], [Email], [Comentarios], [MarcaPC], [FechaRespuesta], [HoraRespuesta]) VALUES (CAST(52899448 AS Numeric(20, 0)), N'luis@hotmail.com', N'prueba3', N'APPLE', N'2019/04/24', N'21:43:01')
INSERT [dbo].[Encuestas] ([NumeroDocumento], [Email], [Comentarios], [MarcaPC], [FechaRespuesta], [HoraRespuesta]) VALUES (CAST(79591610 AS Numeric(20, 0)), N'luis@hotmail.com', N'prueba2', N'HP', N'2019/04/24', N'21:42:21')
/****** Object:  ForeignKey [FK_Sesiones_Usuarios]    Script Date: 04/24/2019 22:12:05 ******/
ALTER TABLE [dbo].[Sesiones]  WITH CHECK ADD  CONSTRAINT [FK_Sesiones_Usuarios] FOREIGN KEY([CodigoUsuario])
REFERENCES [dbo].[Usuarios] ([CodigoUsuario])
GO
ALTER TABLE [dbo].[Sesiones] CHECK CONSTRAINT [FK_Sesiones_Usuarios]
GO
/****** Object:  ForeignKey [FK_Encuestas_MarcaPCs]    Script Date: 04/24/2019 22:12:05 ******/
ALTER TABLE [dbo].[Encuestas]  WITH CHECK ADD  CONSTRAINT [FK_Encuestas_MarcaPCs] FOREIGN KEY([MarcaPC])
REFERENCES [dbo].[MarcaPCs] ([CodigoMarcaPC])
GO
ALTER TABLE [dbo].[Encuestas] CHECK CONSTRAINT [FK_Encuestas_MarcaPCs]
GO
