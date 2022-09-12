CREATE DATABASE QLQUANAN
GO

USE QLQUANAN
GO

CREATE TABLE [USER]
(
	Username NVARCHAR(50) PRIMARY KEY,
	Password NVARCHAR(50),
	Role NVARCHAR(15)
)
go

CREATE TABLE CATEGORY
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Tendanhmuc NVARCHAR(50),
	Trangthai NVARCHAR(15)
)
GO

CREATE TABLE PRODUCT
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Id_category INT,
	Tenmonan NVARCHAR(30),
	Dongia MONEY,
	Gioithieu NVARCHAR(100),
	Anh NVARCHAR(200),
	Trangthai NVARCHAR(15),
	FOREIGN KEY(Id_category) REFERENCES dbo.CATEGORY(Id)
)
GO 

CREATE TABLE STAFF
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Hoten NVARCHAR(50),
	Sdt NVARCHAR(15),
	Gioitinh BIT,
	Diachi NVARCHAR(150),
	Trangthai NVARCHAR(15),
	Taikhoan NVARCHAR(50),
	Matkhau NVARCHAR(50)
)
GO 

CREATE TABLE CUSTOMER
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Hoten NVARCHAR(50),
	Sdt NVARCHAR(15),
	Gioitinh BIT,
	Diachi NVARCHAR(150),
	Trangthai NVARCHAR(15)
)
GO 

CREATE TABLE BILL
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Ngayban DATETIME,
	Thanhtoan MONEY,
	Id_staff INT,
	Id_customer INT,
	FOREIGN KEY(Id_staff) REFERENCES dbo.STAFF(Id),
	FOREIGN KEY(Id_Customer) REFERENCES dbo.CUSTOMER(id)
)
GO 

CREATE TABLE BILLDETAIL
(
	Id INT IDENTITY(1,1) PRIMARY KEY,
	Soluong INT,
	Dongia MONEY,
	Tongtien MONEY,
	Id_bill INT,
	Id_product INT,
	FOREIGN KEY(Id_bill) REFERENCES dbo.BILL(Id),
	FOREIGN KEY(Id_product) REFERENCES dbo.PRODUCT(Id)
)
GO 


/*
SELECT * FROM dbo.STAFF
SELECT * FROM dbo.CUSTOMER
SELECT * FROM dbo.BILL
SELECT * FROM dbo.BILLDETAIL
SELECT * FROM dbo.CATEGORY
SELECT * FROM dbo.PRODUCT
*/
     --SELECT * FROM dbo.[USER]
	 --DELETE FROM dbo.[USER] WHERE Username = 'sangtm'
/*
DELETE FROM dbo.BILLDETAIL
DELETE FROM dbo.BILL
DELETE FROM dbo.CUSTOMER
DELETE FROM dbo.STAFF
DELETE FROM dbo.PRODUCT
DELETE FROM dbo.CATEGORY
DELETE FROM dbo.[USER]
*/





--thống kê tháng
IF OBJECT_ID('f_thongkethang') IS NOT NULL
DROP FUNCTION dbo.f_thongkethang
go
CREATE FUNCTION f_thongkethang(@nam int)
RETURNS @thongKeThang TABLE 
(Thang INT, Sohoadon INT, Tongtien INT)
AS
BEGIN
	--tháng 1 -> tháng 12
	DECLARE @i int = 0
	WHILE (@i != 12)
		BEGIN
		SET @i = @i + 1;

		--số hóa đơn hàng tháng
		DECLARE @sohoadon INT
		SELECT @sohoadon = COUNT(id) FROM dbo.BILL WHERE YEAR(Ngayban) = @nam AND MONTH(Ngayban) = @i

		--Tổng tiền hàng tháng
		DECLARE @tongtien INT 
		SELECT @tongtien = SUM(Thanhtoan) FROM dbo.BILL WHERE YEAR(Ngayban) = @nam AND MONTH(Ngayban) = @i
		IF (@tongtien IS NULL) 
			SET @tongtien = 0

			INSERT INTO @thongKeThang
			(
			    Thang,
			    Sohoadon,
			    Tongtien
			)
			VALUES
			(   
				@i,  -- Thang - int
			    @sohoadon,  -- Sohoadon - int
			    @tongtien
			)
        END
	RETURN
END
GO


SELECT * FROM dbo.f_thongkethang(2021)
GO

--thống kê năm
IF OBJECT_ID('f_thongkenam') IS NOT NULL
DROP FUNCTION f_thongkenam
GO
CREATE FUNCTION f_thongkenam(@batdau INT, @ketthuc INT)
RETURNs @bangmoi TABLE 
(nam INT, sohoadon INT, tongtien INT)
AS
BEGIN
	DECLARE @nam INT = @batdau
	
	WHILE (@nam != (@ketthuc + 1))
		BEGIN
			--số hóa đơn
			DECLARE @sohoadon INT
			SELECT @sohoadon = COUNT(Id) FROM dbo.BILL WHERE YEAR(Ngayban) = @nam

			--tổng tiền
			DECLARE @tongtien INT
			SELECT @tongtien = SUM(Thanhtoan) FROM dbo.BILL WHERE YEAR(Ngayban) = @nam

				IF (@tongtien IS NULL) 
					SET @tongtien = 0

			INSERT INTO @bangmoi
			(
				nam,
				sohoadon,
				tongtien
			)
			VALUES
			(  
				@nam, -- nam - int
				@sohoadon, -- sohoadon - int
				@tongtien  -- tongtien - int
			)

			SET @nam = @nam + 1;
        END
	RETURN
END
GO


