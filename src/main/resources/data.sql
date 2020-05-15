insert into CAR (brand, model, power, year_of_issue)
values ('bmw', 'X5', 300.0, 2010),
       ('bmw', '750Li', 100.0, 2008),
       ('chevrolet', 'lachetti', 120.0, 2015);

insert into CAR_RATING(car_id, date_of_evaluation, assessed_value)
values (1, '2016-03-03', 7000000),
       (1, '2016-04-04', 7500000),
       (2, '2020-03-03', 5000000),
       (2, '2020-04-04', 7000000),
       (3, '2020-04-04', 7500000);

insert into AIRPLANE (brand, model, manufacturer, year_of_issue, fuel_capacity, seats)
values ('Boeing', '777', 'USA', 1992, 20000, 200),
       ('TU', '137', 'Russia', 1995, 10000, 100),
       ('Boeing', '747', 'USA', 1998, 20000, 300);
insert into AIRPLANE_RATING(airplane_id, date_of_evaluation, assessed_value)
values (1, '2016-03-03', 700000000),
       (1, '2020-04-04', 500000000),
       (2, '2016-03-03', 300000000),
       (2, '2020-04-04', 250000000),
       (3, '2020-04-04', 750000000);