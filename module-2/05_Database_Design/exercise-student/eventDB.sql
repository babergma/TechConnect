BEGIN TRANSACTION;

DROP TABLE IF EXISTS member_info, interest_group, member_group, event, member_event CASCADE;

CREATE TABLE member_info
(
         member_id serial,
         last_name varchar(64) not null,
         first_name varchar(64) not null,
         email varchar(200),
         phone_number varchar(12) null,
         birthday varchar(10),
         wants_emails boolean,
 
        constraint pk_members primary key (member_id)
);

CREATE TABLE interest_group
(
        group_id serial,
        group_name varchar(64),
        UNIQUE(group_name),
        group_count int NULL,

        constraint pk_interest_group primary key (group_id)
);

CREATE TABLE member_group
(
        member_group serial,
        member_id int,
        group_id int,

        constraint pk_member_group primary key (member_id, group_id),
        constraint fk_member_id foreign key(member_id) references member_info (member_id),
        constraint fk_member_group_id foreign key(group_id) references interest_group (group_id)
);

CREATE TABLE event
(
        event_id serial,
        event_name varchar(64),
        event_description varchar(200),
        start_date varchar(10),
        start_time varchar(5),
        event_duration int,
        group_id int,
        event_member_count int NULL,

        constraint pk_event_id primary key (event_id),
        constraint fk_event_group foreign key (group_id) references interest_group(group_id)

);

CREATE TABLE member_event
(
        member_event serial,
        member_id int,
        event_id int,

        constraint pk_member_event primary key (member_id, event_id),
        constraint fk_member_event_member foreign key(member_id) references member_info (member_id), 
        constraint fk_member_event_event foreign key(event_id) references event (event_id) 
);



INSERT INTO member_info(first_name, last_name, birthday, wants_emails)
VALUES('Bridgette', 'Bergman', '08-05-1998', true),
        ('Bree', 'Pod', '05-05-2000', true),
        ('Tar', 'Abott', '08-23-1990', false),
        ('Leah', 'Rud', '10-05-1955', true),
        ('Judy', 'Rubert', '11-25-1967', false),
        ('Paige', 'Stone', '08-01-1982', true),
        ('Nicole', 'Bergman', '01-09-1997', true),
        ('Hal', 'Smert', '04-11-1978', false),
        ('Betty', 'Crow', '12-17-1966', true);
        
INSERT INTO interest_group(group_name, group_count)
VALUES('Java Dogs', 5),
('SQL Starter Club', 8),
('Computer Group', 4);

INSERT INTO member_group(member_id, group_id)
VALUES (1, 1),
        (1,2),
        (2,1),
        (2,2),
        (3,1),
        (3,2),
        (4,1),
        (4,2),
        (5,1),
        (5,2),
        (5,3),
        (6,2),
        (6,3),
        (7,2),
        (7,3),
        (8,2),
        (8,3);
        

INSERT INTO event(event_name, event_description, start_date, start_time, event_duration, group_id)
VALUES ('Party', 'Friends getting together', '09-09-2021', '12:30', 5, 1),
('Coding', 'Learning how to code SQL', '10-09-2021', '13:30', 5, 2);
 
INSERT INTO member_event(member_id, event_id)
VALUES(1,1),
        (1,2),
        (2,1),
        (2,2),
        (3,1),
        (3,2),
        (4,1),
        (4,2),
        (5,1),
        (5,2),
        (6,1),
        (6,2),
        (7,1),
        (7,2),
        (8,1),
        (8,2);

       
COMMIT TRANSACTION;

