/*
Cafe Sanchez v2 - Case Study
*/

USE [master]
GO


/****** Database [CafeSanchez] ******/
CREATE DATABASE [CafeSanchez_v2]
GO

USE [CafeSanchez_v2]
GO

/****** Table [Orders] ******/
CREATE TABLE [Orders](
	[Id] int IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	[CustomerName] [nvarchar](50) NOT NULL,
	[Date] [datetime] NOT NULL,
	[Discount] [int] NOT NULL DEFAULT (0),
	[Status] [nvarchar](50) DEFAULT (N'New') NOT NULL
) 
GO

/****** Table [Products] n******/
CREATE TABLE [Products](
	[Id] int IDENTITY(1,1) PRIMARY KEY NOT NULL, 
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](max) NULL,
	[Price] [decimal](18, 2) NULL
) 
GO

/****** Table [OrderLines] ******/
CREATE TABLE [OrderLines](
	[OrderId] [int] FOREIGN KEY REFERENCES [Orders] ([Id]) NOT NULL,
	[ProductId] [int] FOREIGN KEY REFERENCES [Products] ([Id]) NOT NULL,
	[Quantity] [int] NOT NULL,
	CONSTRAINT [PK_OrderLines] PRIMARY KEY CLUSTERED 
	(
		[OrderId] ASC,
		[ProductId] ASC
	)
) 
GO