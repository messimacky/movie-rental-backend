insert into customer(address, email, first_name, last_name, phone, username)
values
( 'AA', 'messay@gmial.com', 'mesay', 'Gebre','0956565467','mm' ),
('Adama', 'messay@gmial.com', 'mesay', 'Gebre','0912524658','mmmm' ),
('Bahirdar', 'lemen@gmail.com', 'mesay', 'Gebre','0957878887','mmak' );

insert into movie( genre, language, price, title, year)
values('comedy', 'Amharic',20.0,'Love', '2022-06-01'),
('romance', 'Endlish',25.0,'Yene', '2022-06-01'),
('Action', 'Arebic',15.0, 'Mnkey','2022-06-01'),
('romance', 'English',10.0,'sdds', '2022-06-01');

insert into rental( fk_customer, genre, rental_expiry, total_cost, fk_movie)
values(1, 'comedy', '2022-06-01',30, 1),
(2, 'romance', '2022-06-01',30, 1);
