create database [ElevationSystem]
go

USE [ElevationSystem]
GO
/****** Object:  Table [dbo].[Admin]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[ID_Admin] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](100) NULL,
	[PassWord] [nvarchar](100) NULL,
	[FullName] [nvarchar](200) NULL,
	[Phone] [nvarchar](30) NULL,
	[Address] [nvarchar](500) NULL,
	[Email] [nvarchar](200) NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[ID_Admin] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Complaint]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Complaint](
	[ID_Complaint] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NULL,
	[ID_Order] [int] NULL,
	[Contents] [nvarchar](3000) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[ID_Complaint] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ContactInfor]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContactInfor](
	[ID_ContactInfor] [int] NOT NULL,
	[Address] [nvarchar](150) NULL,
	[MobilePhone] [nvarchar](30) NULL,
	[TelePhone] [nvarchar](30) NULL,
	[FAX] [nvarchar](30) NULL,
	[Email] [nvarchar](150) NULL,
	[Skype] [nvarchar](150) NULL,
	[Yahoo] [nchar](150) NULL,
 CONSTRAINT [PK_ContactInfo] PRIMARY KEY CLUSTERED 
(
	[ID_ContactInfor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ContactUs]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ContactUs](
	[ID_ContactUs] [int] NOT NULL,
	[Name] [nchar](10) NULL,
	[Telephone] [nvarchar](30) NULL,
	[CompanyName] [nvarchar](150) NULL,
	[Contents] [nvarchar](1000) NULL,
 CONSTRAINT [PK_ContactUs] PRIMARY KEY CLUSTERED 
(
	[ID_ContactUs] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[ID_Feebback] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Email] [nvarchar](150) NULL,
	[Description] [nvarchar](200) NULL,
	[Satisfying] [nvarchar](30) NULL,
	[Contents] [nvarchar](2000) NULL,
	[Problem] [nvarchar](300) NULL,
	[Improvement] [nvarchar](300) NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[ID_Feebback] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[ID_Order] [int] IDENTITY(1,1) NOT NULL,
	[ID_User] [int] NULL,
	[ProductName] [nvarchar](200) NULL,
	[Weight] [nvarchar](15) NULL,
	[FloorNumber] [nvarchar](25) NULL,
	[Speed] [nvarchar](15) NULL,
	[HoleSize] [nvarchar](50) NULL,
	[FullName] [nvarchar](100) NULL,
	[Address] [nvarchar](200) NULL,
	[Email] [nvarchar](100) NULL,
	[TelePhone] [nvarchar](30) NULL,
	[DateOrder] [date] NULL,
	[Status] [bit] NULL,
	[Cost] [int] NULL,
	[Payment] [nvarchar](100) NULL,
 CONSTRAINT [PK_Order_1] PRIMARY KEY CLUSTERED 
(
	[ID_Order] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[ID_OrderDetail] [int] IDENTITY(1,1) NOT NULL,
	[ID_Order] [int] NULL,
	[ID_Product] [int] NULL,
	[Cost] [int] NULL,
	[Quality] [int] NULL,
 CONSTRAINT [PK_BillDetail] PRIMARY KEY CLUSTERED 
(
	[ID_OrderDetail] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID_Product] [int] IDENTITY(1,1) NOT NULL,
	[ID_Type] [int] NULL,
	[Name] [nvarchar](200) NULL,
	[Images] [nvarchar](200) NULL,
	[Description] [nvarchar](1000) NULL,
	[Status] [bit] NULL,
	[Contents] [nvarchar](4000) NULL,
 CONSTRAINT [PK_Project] PRIMARY KEY CLUSTERED 
(
	[ID_Product] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Project]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Project](
	[ID_Project] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Contents] [nvarchar](3000) NULL,
 CONSTRAINT [PK_Project_1] PRIMARY KEY CLUSTERED 
(
	[ID_Project] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ReplyComplaint]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReplyComplaint](
	[ID_ReplyComplaint] [int] NOT NULL,
	[ID_Complaint] [int] NULL,
	[Contents] [nvarchar](3000) NULL,
 CONSTRAINT [PK_ReplyComplaint] PRIMARY KEY CLUSTERED 
(
	[ID_ReplyComplaint] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Type]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Type](
	[ID_Type] [int] IDENTITY(1,1) NOT NULL,
	[NameType] [nvarchar](200) NULL,
 CONSTRAINT [PK_Type] PRIMARY KEY CLUSTERED 
(
	[ID_Type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 10/7/2014 1:38:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID_User] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](100) NULL,
	[PassWord] [nchar](500) NULL,
	[FullName] [nvarchar](200) NULL,
	[Email] [nvarchar](200) NULL,
	[Address] [nvarchar](500) NULL,
	[Company] [nvarchar](200) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[ID_User] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([ID_Admin], [UserName], [PassWord], [FullName], [Phone], [Address], [Email]) VALUES (1, N'asasa', N'1234567', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[Admin] OFF
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([ID_User], [UserName], [PassWord], [FullName], [Email], [Address], [Company]) VALUES (1, N'minh', N'efee                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ', NULL, NULL, NULL, NULL)
INSERT [dbo].[User] ([ID_User], [UserName], [PassWord], [FullName], [Email], [Address], [Company]) VALUES (2, N'minh414', N'13141                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ', NULL, NULL, NULL, NULL)
INSERT [dbo].[User] ([ID_User], [UserName], [PassWord], [FullName], [Email], [Address], [Company]) VALUES (3, N'minh414fef', N'11313                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               ', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[User] OFF
ALTER TABLE [dbo].[Complaint]  WITH CHECK ADD  CONSTRAINT [FK_Complaint_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Complaint] CHECK CONSTRAINT [FK_Complaint_User]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([ID_User])
REFERENCES [dbo].[User] ([ID_User])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([ID_Order])
REFERENCES [dbo].[Order] ([ID_Order])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([ID_Product])
REFERENCES [dbo].[Product] ([ID_Product])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Type] FOREIGN KEY([ID_Type])
REFERENCES [dbo].[Type] ([ID_Type])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Type]
GO
ALTER TABLE [dbo].[ReplyComplaint]  WITH CHECK ADD  CONSTRAINT [FK_ReplyComplaint_Complaint] FOREIGN KEY([ID_Complaint])
REFERENCES [dbo].[Complaint] ([ID_Complaint])
GO
ALTER TABLE [dbo].[ReplyComplaint] CHECK CONSTRAINT [FK_ReplyComplaint_Complaint]
GO
