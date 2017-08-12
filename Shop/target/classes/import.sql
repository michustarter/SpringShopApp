
insert into USER_ACCOUNT(login, name, surname, discount) values('zbyniu', 'zbigniew', 'stasik', 10);
insert into USER_ACCOUNT(login, name, surname, discount) values('kazik', 'Kazimierz', 'Gorski', 20);
insert into USER_ACCOUNT(login, name, surname, discount) values('kazach', 'Lukasz', 'Kek', 30);

insert into PRODUCT(name, price, unit) values('apple', 5, 'piece');
insert into PRODUCT(name, price, unit) values('banana', 15, 'kg');
insert into PRODUCT(name, price, unit) values('hammer', 51, 'piece');
insert into PRODUCT(name, price, unit) values('hat', 43, 'piece');
insert into PRODUCT(name, price, unit) values('water', 2, 'liter');
insert into PRODUCT(name, price, unit) values('concret', 500, 'm3');

insert into HISTORY(user_account, product, quantity) values(1, 1, 5);
insert into HISTORY(user_account, product, quantity) values(1, 2, 3);
insert into HISTORY(user_account, product, quantity) values(2, 1, 2);
insert into HISTORY(user_account, product, quantity) values(2, 6, 2);
insert into HISTORY(user_account, product, quantity) values(3, 1, 1);
insert into HISTORY(user_account, product, quantity) values(3, 2, 64);
insert into HISTORY(user_account, product, quantity) values(3, 3, 21);
insert into HISTORY(user_account, product, quantity) values(3, 4, 15);
insert into HISTORY(user_account, product, quantity) values(1, 5, 52);
insert into HISTORY(user_account, product, quantity) values(2, 5, 4);