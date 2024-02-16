DROP TABLE IF EXISTS ServicesInTheContract;
DROP TABLE IF EXISTS Contracts;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Services;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS TheDeadMan;;


CREATE TABLE TheDeadMan (
     id SERIAL PRIMARY KEY,
     surname varchar(25) NOT NULL,
     name varchar(25)  NOT NULL,
     patronymic varchar(25)  NOT NULL,
     date_of_birthday DATE NOT NULL,
     date_of_death DATE NOT NULL
);

CREATE TABLE Customers(
    id SERIAL PRIMARY KEY,
    surname varchar(25)  NOT NULL,
    name varchar(25)  NOT NULL,
    patronymic varchar(25)  NOT NULL,
    address varchar(25)  NOT NULL,
    telephone varchar(25)  NOT NULL,
    email varchar(50)  NOT NULL
);

CREATE TABLE Services (
    id SERIAL PRIMARY KEY,
    name_services TEXT NOT NULL,
    description_services TEXT NOT NULL,
    cost_services INTEGER NOT NULL
);

CREATE TABLE Staff (
    id SERIAL PRIMARY KEY,
    surname varchar(25)  NOT NULL,
    name varchar(25)  NOT NULL,
    patronymic varchar(25)  NOT NULL,
    date_of_birthday DATE NOT NULL,
    post TEXT NOT NULL,
    contact_phone_number varchar(15)  NOT NULL
);

CREATE TABLE Contracts (
    id SERIAL PRIMARY KEY,
    id_the_dead_man INTEGER NOT NULL,
    id_customer INTEGER NOT NULL,
    id_staff INTEGER NOT NULL,
    date_conclusion_contract DATE NOT NULL,
    cost_service INTEGER NOT NULL,
    status_contract TEXT NOT NULL,
    FOREIGN KEY (id_the_dead_man) REFERENCES TheDeadMan(id),
    FOREIGN KEY (id_customer) REFERENCES Customers(id),
    FOREIGN KEY (id_staff) REFERENCES Staff(id)
);

CREATE TABLE ServicesInTheContract (
    id SERIAL PRIMARY KEY,
    id_contract INTEGER NOT NULL,
    id_service INTEGER NOT NULL,
    count_service INTEGER NOT NULL,
    FOREIGN KEY (id_contract) REFERENCES Contracts(id),
    FOREIGN KEY (id_service) REFERENCES Services(id)
);