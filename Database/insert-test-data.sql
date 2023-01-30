USE [CafeSanchez_v2]
GO

DELETE FROM Orderlines;
DELETE FROM Orders;

SET IDENTITY_INSERT [Orders] ON

insert into Orders ([Id], [Date], [Status], [CustomerName]) values (1, '2022-12-02 18:43:36', 'Active', 'Ethan');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (2, '2022-12-08 23:26:55', 'Active', 'Euphemia');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (3, '2022-12-02 16:54:20', 'Active', 'Randal');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (4, '2022-12-11 00:47:24', 'Active', 'Hyacinth');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (5, '2022-12-15 14:24:57', 'Active', 'Juanita');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (6, '2022-12-08 10:26:34', 'Active', 'Ursula');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (7, '2022-12-14 21:33:13', 'Active', 'Giselbert');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (8, '2022-12-15 13:59:34', 'Active', 'Shannen');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (9, '2022-12-02 02:08:28', 'Active', 'Brittni');
insert into Orders ([Id], [Date], [Status], [CustomerName]) values (10, '2022-12-08 15:55:38', 'Active', 'Dael');


insert into Orderlines (OrderId, ProductId, Quantity) values (1, 1, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (1, 3, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (2, 1, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (2, 2, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (2, 3, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (3, 4, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (3, 5, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (3, 6, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (4, 1, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (4, 4, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (4, 5, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (4, 7, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (5, 1, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (5, 2, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (5, 3, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (6, 1, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (6, 3, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (6, 4, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (6, 8, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (7, 1, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (8, 1, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (8, 2, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (8, 9, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (9, 3, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (9, 4, 4);
insert into Orderlines (OrderId, ProductId, Quantity) values (9, 8, 1);
insert into Orderlines (OrderId, ProductId, Quantity) values (9, 9, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (10, 2, 2);
insert into Orderlines (OrderId, ProductId, Quantity) values (10, 4, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (10, 5, 3);
insert into Orderlines (OrderId, ProductId, Quantity) values (10, 6, 4);
