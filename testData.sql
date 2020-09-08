
create table users
(
    id       varchar not null
             constraint users_pk
             primary key,
    login    varchar not null,
    password varchar not null
);

alter table users
    owner to postgres;

create unique index users_login_uindex
    on users (login);

create table tasks
(
    id          varchar   not null
                constraint tasks_pk
                primary key,
    name        varchar   not null,
    description varchar,
    date        timestamp not null,
    complete    boolean default false,
    user_id     varchar   not null
                constraint tasks_user__fk
                references users
                on update cascade on delete cascade
);

alter table tasks
    owner to postgres;

INSERT INTO public.users (id, login, password) VALUES ('user1', 'testUser1', 'testUser1');
INSERT INTO public.users (id, login, password) VALUES ('user2', 'testUser2', 'testUser2');
INSERT INTO public.users (id, login, password) VALUES ('user3', 'testUser3', 'testUser3');
INSERT INTO public.users (id, login, password) VALUES ('user4', 'testUser4', 'testUser4');

INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task1', 'Delo1', 'Some delo1', '2020-09-06 12:44:22.000000', false, 'user1');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task2User1', 'Create Api', null, '2020-09-06 13:45:20.000000', false, 'user1');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task3User1', 'Complete game', '', '2020-09-06 16:48:33.000000', true, 'user1');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task4User1', 'Drop school database', 'Drop database for create new and update deprecated system of school', '2020-09-14 12:48:08.000000', false, 'user1');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task1User2', 'Some task2', null, '2020-09-07 12:49:18.000000', true, 'user2');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task2User2', 'Make SSAU greate again!', 'Lol kek cheburek', '2020-09-11 12:50:24.000000', false, 'user2');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task3User2', 'Leaning English', null, '2020-09-14 16:51:31.000000', false, 'user2');
INSERT INTO public.tasks (id, name, description, date, complete, user_id) VALUES ('task4User2', 'Last task', 'last task of tests', '2020-09-06 20:52:31.000000', false, 'user2');
