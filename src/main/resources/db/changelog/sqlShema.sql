create table public.location
(
    id              bigint           not null
        primary key,
    country         varchar(255),
    lat             double precision not null,
    localtime_epoch bigint,
    localtime_str   timestamp(6),
    lon             double precision not null,
    name            varchar(255),
    region          varchar(255),
    time_zone_id    varchar(255)
);

alter table public.location
    owner to postgres;

create table public.weather_info
(
    id                 bigint           not null
        primary key,
    humidity           double precision not null,
    pressure_mb        double precision not null,
    temperature        double precision not null,
    weather_conditions varchar(255),
    wind_speed         double precision not null,
    location_id        bigint
        constraint fkfudrwfr3497rnn2uec6nmgk80
            references public.location
);

alter table public.weather_info
    owner to postgres;

