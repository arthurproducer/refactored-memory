USE [master]
GO
/****** Object:  Database [Controle_do_Estoque]    Script Date: 04/09/2016 23:52:45 ******/
CREATE DATABASE [Controle_do_Estoque]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Controle_do_Estoque', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLSERVER\MSSQL\DATA\Controle_do_Estoque.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Controle_do_Estoque_log', FILENAME = N'c:\Program Files (x86)\Microsoft SQL Server\MSSQL11.SQLSERVER\MSSQL\DATA\Controle_do_Estoque_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Controle_do_Estoque] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Controle_do_Estoque].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Controle_do_Estoque] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET ARITHABORT OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Controle_do_Estoque] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Controle_do_Estoque] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Controle_do_Estoque] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Controle_do_Estoque] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Controle_do_Estoque] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Controle_do_Estoque] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Controle_do_Estoque] SET  MULTI_USER 
GO
ALTER DATABASE [Controle_do_Estoque] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Controle_do_Estoque] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Controle_do_Estoque] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Controle_do_Estoque] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Controle_do_Estoque]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 04/09/2016 23:52:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[id_Cliente] [int] NOT NULL,
	[Nome] [varchar](40) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Email]    Script Date: 04/09/2016 23:52:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Email](
	[id_usuario] [int] NOT NULL,
	[email] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC,
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Fone]    Script Date: 04/09/2016 23:52:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Fone](
	[id_usuario] [int] NOT NULL,
	[fone] [char](11) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC,
	[fone] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Pedido]    Script Date: 04/09/2016 23:52:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pedido](
	[id_produto] [int] NOT NULL,
	[id_cliente] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_produto] ASC,
	[id_cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Produto]    Script Date: 04/09/2016 23:52:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Produto](
	[id_Produto] [int] NOT NULL,
	[Nome] [varchar](40) NULL,
	[Descrição] [varchar](50) NULL,
	[Preço] [decimal](7, 2) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_Produto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Email]  WITH CHECK ADD  CONSTRAINT [fk_clienteemail] FOREIGN KEY([id_usuario])
REFERENCES [dbo].[Cliente] ([id_Cliente])
GO
ALTER TABLE [dbo].[Email] CHECK CONSTRAINT [fk_clienteemail]
GO
ALTER TABLE [dbo].[Fone]  WITH CHECK ADD  CONSTRAINT [fk_clientefone] FOREIGN KEY([id_usuario])
REFERENCES [dbo].[Cliente] ([id_Cliente])
GO
ALTER TABLE [dbo].[Fone] CHECK CONSTRAINT [fk_clientefone]
GO
ALTER TABLE [dbo].[Pedido]  WITH CHECK ADD  CONSTRAINT [fk_cliente] FOREIGN KEY([id_cliente])
REFERENCES [dbo].[Cliente] ([id_Cliente])
GO
ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [fk_cliente]
GO
ALTER TABLE [dbo].[Pedido]  WITH CHECK ADD  CONSTRAINT [fk_produto] FOREIGN KEY([id_produto])
REFERENCES [dbo].[Produto] ([id_Produto])
GO
ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [fk_produto]
GO
USE [master]
GO
ALTER DATABASE [Controle_do_Estoque] SET  READ_WRITE 
GO
