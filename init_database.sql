create table public.companies
(
    id      serial      not null
        constraint companies_pk
            primary key,
    name    varchar(40) not null,
    address varchar(40) not null
);

alter table public.companies
    owner to postgres;

create unique index companies_id_uindex
    on public.companies (id);

create unique index companies_name_uindex
    on public.companies (name);

create table public.employees
(
    id         serial      not null
        constraint employees_pk
            primary key,
    name       varchar(40) not null,
    email      varchar(60) not null,
    company_id integer
        constraint employees_companies_id_fk
            references public.companies
);

alter table public.employees
    owner to postgres;

create table public.devices
(
    id            serial      not null
        constraint devices_pk
            primary key,
    serial_number varchar(60) not null,
    type          varchar(60),
    employee_id   integer
        constraint devices_employees_id_fk
            references public.employees
);

alter table public.devices
    owner to postgres;

create unique index devices_serial_number_uindex
    on public.devices (serial_number);

create unique index employees_email_uindex
    on public.employees (email);

